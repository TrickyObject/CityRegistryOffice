package mts.city.register.business;

import mts.city.register.dao.CityDao;
import mts.city.register.view.PersonRequest;
import mts.city.register.view.PersonResponse;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CityManager {

    private static final String HQL_REQUEST = "select ap.temporal from AdressPerson ap " +
            "inner join Person p on p.personId = ap.person " +
            "inner join Adress a on a.adressId = ap.adress " +
            "where " +
            "CURRENT_DATE >= ap.startDate and (CURRENT_DATE <= ap.endDate or ap.endDate is null)" +
            "and p.surName = ?1 " +
            "and p.givenName  = ?2 " +
            "and p.patronymic = ?3 " +
            "and p.dateOfBirth = ?4 " +
            "and a.streetCode = ?5 " +
            "and a.building = ?6 ";

    //возможно, тут должен быть экземпляр фабрики, у которой получаем менеджера
    private CityDao dao;

    public CityManager() {
        dao = new CityDao();
    }

//    public void viewAdressList() {
//
//        EntityManager entityManager = getEntityManager();
//        List list = entityManager.createQuery("FROM Adress").getResultList();
//        list.forEach(p1 -> System.out.println(p1));
//        entityManager.close();
//
//    }


    public PersonResponse checkPerson(PersonRequest request) {

        System.out.println(request.getSurName());
        System.out.println(request.getSurName());
        System.out.println(request.getPatronymicName());
        System.out.println(request.getDateOfBirth());
        System.out.println(request.getStreetCode());
        System.out.println(request.getBuilding());

        EntityManager entityManager = getEntityManager();
        PersonResponse response = new PersonResponse();
        String hql = HQL_REQUEST;

        if (request.getExtension() != null) {
            hql += " and a.extension = ?7 ";
        } else {
            hql += " and a.extension is null ";
        }

        if (request.getApartment() != null) {
            hql += " and a.apartment = ?8 ";
        } else {
            hql += " and a.apartment is null ";
        }

        int count = 1;
        Query query = entityManager.createQuery(hql);

        query.setParameter(count++, request.getSurName());
        query.setParameter(count++, request.getSurName());
        query.setParameter(count++, request.getPatronymicName());
        query.setParameter(count++, request.getDateOfBirth());
        query.setParameter(count++, request.getStreetCode());
        query.setParameter(count++, request.getBuilding());

        if (request.getExtension() != null) {
            query.setParameter(count++, request.getExtension());
        }
        if (request.getApartment() != null) {
            query.setParameter(count++, request.getApartment());
        }

        List resultList = query.getResultList();

        System.out.println(resultList);

        for (int i = 0; i < resultList.size(); i++) {
            response.setRegistered(true);
            response.setTemporal((Boolean) resultList.get(i));
        }

        entityManager.close();

        return response;
    }

    private EntityManager getEntityManager() {
        return dao.getEntityManager();
    }


}
