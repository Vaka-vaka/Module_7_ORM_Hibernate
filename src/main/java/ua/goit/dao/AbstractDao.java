/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 28.12.2021
 */

package ua.goit.dao;

import ua.goit.config.PersistenceProvider;
import ua.goit.dao.to_interface.Dao;

import javax.persistence.EntityManager;
import java.util.*;

public class AbstractDao<T> implements Dao<T> {

    protected EntityManager em = PersistenceProvider.getEntityManager();

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public Optional<T> get(long id) {
        return Optional.empty();
    }

    @Override
    public void create(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void update(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public void delete(T entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }
}
