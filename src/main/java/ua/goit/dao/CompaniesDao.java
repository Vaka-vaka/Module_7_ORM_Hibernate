/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 10.01.2022
 */

package ua.goit.dao;

import ua.goit.model.Companies;

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

}
