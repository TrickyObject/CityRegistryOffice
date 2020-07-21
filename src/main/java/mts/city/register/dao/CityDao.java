package mts.city.register.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CityDao {

    private EntityManagerFactory emf;

    public CityDao() {
        emf = Persistence
                .createEntityManagerFactory("persistence");

    }

    public EntityManager getEntityManager() {
        return this.emf.createEntityManager();
    }


}
