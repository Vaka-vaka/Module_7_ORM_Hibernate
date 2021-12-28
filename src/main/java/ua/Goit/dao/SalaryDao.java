/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 21.12.2021
 */

package ua.goit.dao;

import ua.goit.model.Salary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class SalaryDao extends AbstractDao<Salary> {

    private static SalaryDao instance;

    private SalaryDao() {
    }

    public static SalaryDao getInstance() {
        if (instance == null) {
            instance = new SalaryDao();
        }
        return instance;
    }

    @Override
    String getTableName() {
        return "sum_salary_developers_project";
    }

    @Override
    Salary mapToEntity(ResultSet rs) throws SQLException {
        Salary salary = new Salary();
        salary.setName_(rs.getString("name_"));
        salary.setSumSalary(rs.getDouble("sum_salary"));
        return salary;
    }

    @Override
    public Optional<Salary> create(Salary entity) {
        return Optional.empty();
    }

    @Override
    public void update(Salary entity) {
    }


}
