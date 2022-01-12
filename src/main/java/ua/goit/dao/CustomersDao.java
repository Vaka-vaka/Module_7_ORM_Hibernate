/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 11.01.2022
 */

package ua.goit.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.model.Customers;

public class CustomersDao extends AbstractDao<Customers> {

    private static final Logger LOGGER = LogManager.getLogger(CustomersDao.class);
    private static CustomersDao  instance;

    private CustomersDao() {
    }

    public static CustomersDao getInstance() {
        if (instance == null) {
            instance = new CustomersDao();
        }
        return instance;
    }

}

