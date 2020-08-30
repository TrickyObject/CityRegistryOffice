package mts.city.register.business;

import mts.city.register.dao.CityDao;
import mts.city.register.view.PersonRequest;
import mts.city.register.view.PersonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CityManager {

    private static final Logger logger =
            LoggerFactory.getLogger(CityManager.class);

    private static final String HQL_REQUEST = "select ap.temporal from AdressPerson ap " +
                "inner join Person p on p.personId = ap.person " +
                "inner join Adress a on a.adressId = ap.adress " +
            "where " +
                "CURRENT_DATE >= ap.startDate and (CURRENT_DATE <= ap.endDate or ap.endDate is null) " +
                "and p.surName = ?1 " +
                "and p.firstName  = ?2 " +
                "and p.patronymicName = ?3 " +
                "and p.dateOfBirth = ?4 " +
                "and a.streetCode = ?5 " +
                "and a.building = ?6 ";

    //возможно, тут должен быть экземпляр фабрики, у которой получаем менеджера
    private CityDao dao;

    public CityManager() {
        dao = new CityDao();
    }


    public PersonResponse checkPerson(PersonRequest request) {

        logger.info("checkPerson: " + request.toString());

        EntityManager entityManager = getEntityManager();
        PersonResponse response = new PersonResponse();
        String hql = HQL_REQUEST;

        if (request.getExtension() != null && request.getExtension() != "null" && request.getExtension() != "") {
            hql += " and a.extension = ?7 ";

        } else {
            hql += " and a.extension is null ";
        }

        if (request.getApartment() != null && request.getApartment() != "null" && request.getApartment() != "") {
            hql += " and a.apartment = ?8 ";
        } else {
            hql += " and a.apartment is null ";
        }

        logger.info("hql: " + hql);

        int count = 1;
        logger.info("--------------> Creating HQL");

        Query query = entityManager.createQuery(hql);
        logger.info("--------------> Setting 1 " + count);
        query.setParameter(count++, request.getSurName());
        logger.info("--------------> Setting 2 " + count);
        query.setParameter(count++, request.getFirstName());
        logger.info("--------------> Setting 3 " + count);
        query.setParameter(count++, request.getPatronymicName());
        logger.info("--------------> Setting 4 " + count);
        query.setParameter(count++, request.getDateOfBirth());
        logger.info("--------------> Setting 5 " + count);
        query.setParameter(count++, request.getStreetCode());
        logger.info("--------------> Setting 6 " + count);
        query.setParameter(count++, request.getBuilding());

        if (request.getExtension() != null && request.getExtension() != "null" && request.getExtension() != "") {
            logger.info("--------------> Setting 7 " + count);
            query.setParameter(count++, request.getExtension());
        }

        if (request.getApartment() != null && request.getApartment() != "null" && request.getApartment() != "") {
            logger.info("--------------> Setting 8 " + count);
            query.setParameter(8, request.getApartment());
        }

        logger.info("Final hql: " + hql);

        List resultList = query.getResultList();

        logger.info("Data result: " + resultList);


        for (int i = 0; i < resultList.size(); i++) {
            response.setRegistered(true);
            response.setTemporal((Boolean) resultList.get(i));
        }

        entityManager.close();

        logger.info("Response: " + response);

        return response;
    }

    private EntityManager getEntityManager() {
        return dao.getEntityManager();
    }


}
