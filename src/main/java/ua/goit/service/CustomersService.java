/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 11.01.2022
 */

package ua.goit.service;

import ua.goit.dao.CustomersDao;
import ua.goit.model.Customers;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public class CustomersService {

    private static CustomersService instance;

    private final CustomersDao customersDao = CustomersDao.getInstance();

    private CustomersService() {
    }

    public static CustomersService getInstance() {
        if (instance == null) {
            instance = new CustomersService();
        }
        return instance;
    }

    public List<Customers> getAll() {
        return customersDao.getAll();
    }

    public Optional<Customers> get(long id) {
        return customersDao.get(id);
    }

    public void update(Customers customers) {
        customersDao.update(customers);
    }

    public void create(Customers customers) {
        customersDao.create(customers);
    }

    public void delete(Customers customers) {
        customersDao.delete(customers);
    }
}
