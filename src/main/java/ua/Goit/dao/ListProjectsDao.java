/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 24.12.2021
 */

package ua.goit.dao;

import ua.goit.model.ListProjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ListProjectsDao extends AbstractDao<ListProjects> {

    private static ListProjectsDao instance;

    private ListProjectsDao() {
    }

    public static ListProjectsDao getInstance() {
        if (instance == null) {
            instance = new ListProjectsDao();
        }
        return instance;
    }

    @Override
    String getTableName() {
        return "list_projects";
    }

    @Override
    ListProjects mapToEntity(ResultSet rs) throws SQLException {
        ListProjects listProjects = new ListProjects();
        listProjects.setListProjects(rs.getString("list_project"));
        return listProjects;
    }

    @Override
    public Optional<ListProjects> create(ListProjects entity) {
        return Optional.empty();
    }

    @Override
    public void update(ListProjects entity) {
    }
}
