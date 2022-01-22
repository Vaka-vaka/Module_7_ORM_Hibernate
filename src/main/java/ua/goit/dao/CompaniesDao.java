/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 10.01.2022
 */

package ua.goit.dao;

import ua.goit.model.Companies;
import ua.goit.model.Projects;

public class CompaniesDao extends AbstractDao<Companies>{

    private static CompaniesDao  instance;

    private CompaniesDao() {
        super(Companies.class);
    }

    public static CompaniesDao getInstance() {
        if (instance == null) {
            instance = new CompaniesDao();
        }
        return instance;
    }

    @Override
    public void delete(Companies entity) {
        entity = em.merge(entity);
        em.getTransaction().begin();
        for (Projects project : entity.getProjects()) {
                project.getCompanies().remove(entity);
        }
        em.remove(entity);
        em.getTransaction().commit();
    }
}
