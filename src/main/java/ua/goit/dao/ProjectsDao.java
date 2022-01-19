/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 30.12.2021
 */

package ua.goit.dao;

import ua.goit.model.Companies;
import ua.goit.model.Customers;
import ua.goit.model.Developers;
import ua.goit.model.Projects;

import javax.persistence.Tuple;
import java.util.Map;
import java.util.stream.Collectors;

public class ProjectsDao extends AbstractDao<Projects> {

    private static ProjectsDao  instance;

    private ProjectsDao() {
    }

    public static ProjectsDao getInstance() {
        if (instance == null) {
            instance = new ProjectsDao();
        }
        return instance;
    }

    @Override
    public void delete(Projects entity) {
        entity = em.merge(entity);
        em.getTransaction().begin();
        for (Developers developers : entity.getDevelopers()) {
                developers.getProjects().remove(entity);
            }
        for (Companies companies : entity.getCompanies()) {
                companies.getProjects().remove(entity);
        }
        for (Customers customers : entity.getCustomers()) {
                customers.getProjects().remove(entity);
        }
        em.remove(entity);
        em.getTransaction().commit();
    }
}
