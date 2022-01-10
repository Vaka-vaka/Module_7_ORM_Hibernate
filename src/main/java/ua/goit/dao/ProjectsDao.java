/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 30.12.2021
 */

package ua.goit.dao;

import ua.goit.model.Projects;

import java.text.SimpleDateFormat;


public class ProjectsDao extends AbstractDao<Projects> {

    java.util.Date date = new java.util.Date();
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    private static ProjectsDao  instance;

    private ProjectsDao() {
    }

    public static ProjectsDao getInstance() {
        if (instance == null) {
            instance = new ProjectsDao();
        }
        return instance;
    }
}
