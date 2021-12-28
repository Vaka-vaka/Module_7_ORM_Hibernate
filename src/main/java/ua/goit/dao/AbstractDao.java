/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 05.11.2021
 */

package ua.goit.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.config.PersistenceProvider;
import ua.goit.dao.to_interface.Dao;
import ua.goit.dao.to_interface.Identity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

abstract public class AbstractDao<T extends Identity> implements Dao<T> {

    private static final Logger LOGGER = LogManager.getLogger(AbstractDao.class);
    protected EntityManager entityManager = PersistenceProvider.getEntityManager();

    @Override
    public void delete(T entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        LOGGER.debug("Deleted records from " + this.getClass().getSimpleName());
    }

    @Override
    public Optional<T> get(long id) {
       AbstractDao entity = entityManager.find(this.getClass(), id);
        return Optional.empty();
    }

    @Override
    public List<T> getAll() {
        Query query = entityManager.createQuery("from " + this.getClass().getSimpleName());
        List<T> resultList = query.getResultList();
        return resultList;
    }
}
