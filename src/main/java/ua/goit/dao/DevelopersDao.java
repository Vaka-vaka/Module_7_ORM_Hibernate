/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 28.12.2021
 */

package ua.goit.dao;

import ua.goit.config.PersistenceProvider;
import ua.goit.dao.to_interface.Dao;
import ua.goit.model.Developers;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

public class DevelopersDao implements Dao<Developers> {

    protected EntityManager em = PersistenceProvider.getEntityManager();

    private static DevelopersDao  instance;

    private DevelopersDao() {
    }

    public static DevelopersDao getInstance() {
        if (instance == null) {
            instance = new DevelopersDao();
        }
        return instance;
    }


    @Override
    public List<Developers> getAll() {
        Query getAll = em.createNamedQuery("getAll");
        return getAll.getResultList();
    }

    @Override
    public Optional<Developers> get(long id) {
        Developers developers = em.find(Developers.class, id);
        return Optional.of(developers);
    }

    @Override
    public void create(Developers entity) {
       em.getTransaction().begin();
       em.persist(entity);
       em.getTransaction().commit();
    }

    @Override
    public void update(Developers entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Developers entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }
}
