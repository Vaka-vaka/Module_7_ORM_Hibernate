/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 13.11.2021
 */

package ua.goit.console.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.console.Command;
import ua.goit.dao.CustomersDao;
import ua.goit.model.Customers;
import ua.goit.service.CustomersService;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class CustomersCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(CustomersCommand.class);

    private final CustomersService customersService = CustomersService.getInstance();

    @Override
    public void handle(String params, Consumer<Command> setActive) {
        String[] paramsArray = params.split(" ");
        String subParams = String.join(" "
                , params.replace(paramsArray[0] + " ", ""));
        switch (paramsArray[0]) {
            case "create":
                create(subParams);
                break;
            case "get":
                get(subParams);
                break;
            case "getAll":
                getAll();
                break;
            case "delete":
                delete(subParams);
                break;
            case "update":
                update(subParams);
                break;
        }
    }

    private void getAll() {
        List<Customers> all = customersService.getAll();
        System.out.println("Returned " + all.size() + " companies");
        for (Customers customers : all) {
            System.out.println(customers);
        }
    }

    private void update(String params) {
        String[] paramsArray = params.split(" ");
        Optional<Customers> optionalCustomers = customersService
                .get(Long.parseLong(paramsArray[0]));
        if (optionalCustomers.isPresent()) {
            Customers customers = optionalCustomers.get();
            customers.setName_(paramsArray[1]);
            customers.setCity(paramsArray[2]);
            customersService.update(customers);
        } else {
            System.out.println("Customers with id " + paramsArray[0] + " not found");
        }
    }

    private void create(String params) {
        String[] paramsArray = params.split(" ");
        Customers customers = new Customers();
        customers.setId(Long.parseLong(paramsArray[0]));
        customers.setName_(paramsArray[1]);
        customers.setCity(paramsArray[2]);
        customersService.create(customers);
    }

    private void get(String params) {
        String[] paramsArray = params.split(" ");
        Optional<Customers> customers = customersService
                .get(Long.parseLong(paramsArray[0]));
        if (customers.isPresent()) {
            System.out.println(customers.get());
        } else {
            System.out.println("Customers with id " + paramsArray[0] + " not found");
        }
    }

    private void delete(String params) {
        String[] paramsArray = params.split(" ");
        Optional<Customers> customers = customersService
                .get(Long.parseLong(paramsArray[0]));
        if (customers.isPresent()) {
            customersService.delete(customers.get());
        } else {
            System.out.println("Customers with id " + paramsArray[0] + " not found");
        }
    }

    @Override
    public void printActiveMenu() {
        LOGGER.info("---------------------Customers menu---------------------");
        LOGGER.info("Customers command list: ");
        LOGGER.info("create [name_] [city]");
        LOGGER.info("get [id]");
        LOGGER.info("getAll");
        LOGGER.info("update [name_] [city]");
        LOGGER.info("delete [id]");
    }
}
