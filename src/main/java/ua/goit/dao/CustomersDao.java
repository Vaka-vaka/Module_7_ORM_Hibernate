/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 11.01.2022
 */

package ua.goit.dao;

import ua.goit.model.Customers;
import ua.goit.model.Projects;

public class CustomersDao extends AbstractDao<Customers> {

    private static CustomersDao  instance;

    private CustomersDao() {
    }

    public static CustomersDao getInstance() {
        if (instance == null) {
            instance = new CustomersDao();
        }
        return instance;
    }

    @Override
    public void delete(Customers entity) {
        entity = em.merge(entity);
        em.getTransaction().begin();
        for (Projects projects : entity.getProjects()) {
                projects.getCustomers().remove(entity);
        }
        em.remove(entity);
        em.getTransaction().commit();
    }
}

