/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 23.12.2021
 */

package ua.goit.dao;

import ua.goit.model.DevelopersIndividualProject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DevelopersIndividualProjectDao extends AbstractDao<DevelopersIndividualProject> {

    private static DevelopersIndividualProjectDao instance;

    private DevelopersIndividualProjectDao() {
    }

    public static DevelopersIndividualProjectDao getInstance() {
        if (instance == null) {
            instance = new DevelopersIndividualProjectDao();
        }
        return instance;
    }

    @Override
    String getTableName() {
        return "list_developers_project";
    }

    @Override
    DevelopersIndividualProject mapToEntity(ResultSet rs) throws SQLException {
        DevelopersIndividualProject developersIndividualProject = new DevelopersIndividualProject();
        developersIndividualProject.setName_(rs.getString("name_"));
        developersIndividualProject.setDevelopers(rs.getString("d_name_"));
        return developersIndividualProject;
    }

    @Override
    public Optional<DevelopersIndividualProject> create(DevelopersIndividualProject entity) {
        return Optional.empty();
    }

    @Override
    public void update(DevelopersIndividualProject entity) {
    }

}
