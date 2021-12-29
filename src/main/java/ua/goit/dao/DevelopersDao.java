/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 28.12.2021
 */

package ua.goit.dao;

import ua.goit.config.PersistenceProvider;
import ua.goit.model.Developers;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.*;

public class DevelopersDao extends AbstractDao<Developers> {

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
        TypedQuery<Developers> query = em.createQuery("from Developers", Developers.class);
        return query.getResultList();
    }

    @Override
    public Optional<Developers> get(long id) {
        Developers developers = em.find(Developers.class, id);
        return Optional.of(developers);
    }

}
