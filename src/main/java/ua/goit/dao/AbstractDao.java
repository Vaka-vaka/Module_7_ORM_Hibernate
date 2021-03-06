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
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

abstract public class AbstractDao<T> implements Dao<T> {
    private final Class<T> entityType;
    protected EntityManager em = PersistenceProvider.getEntityManager();

    public AbstractDao(Class<T> entityType) {
        this.entityType = entityType;
    }

    public AbstractDao() {
        Type daoType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) daoType).getActualTypeArguments();
        this.entityType = ((Class<T>) params[0]);
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

    @Override
    public List<T> getAll() {
        TypedQuery<T> getAll = em.createQuery(
                "from " + entityType.getSimpleName(), entityType);
        return getAll.getResultList();
    }

    @Override
    public Optional<T> get(long id) {
        T entity = em.find(entityType, id);
        return Optional.of(entity);
    }

}
