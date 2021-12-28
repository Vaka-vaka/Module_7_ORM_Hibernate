/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 24.12.2021
 */

package ua.goit.dao;

import ua.goit.model.MiddleDevelopers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class MiddleDevelopersDao extends AbstractDao<MiddleDevelopers> {

    private static MiddleDevelopersDao instance;

    private MiddleDevelopersDao() {
    }

    public static MiddleDevelopersDao getInstance() {
        if (instance == null) {
            instance = new MiddleDevelopersDao();
        }
        return instance;
    }

    @Override
    String getTableName() {
        return "list_middleDevelopers";
    }

    @Override
    MiddleDevelopers mapToEntity(ResultSet rs) throws SQLException {
        MiddleDevelopers middleDevelopers = new MiddleDevelopers();
        middleDevelopers.setDevelopersName(rs.getString("developer_name"));
        return middleDevelopers;
    }

    @Override
    public Optional<MiddleDevelopers> create(MiddleDevelopers entity) {
        return Optional.empty();
    }

    @Override
    public void update(MiddleDevelopers entity) {
    }
}
