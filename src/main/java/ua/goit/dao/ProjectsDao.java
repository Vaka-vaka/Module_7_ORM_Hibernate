/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 30.12.2021
 */

package ua.goit.dao;

import ua.goit.model.Projects;



public class ProjectsDao extends AbstractDao<Projects> {



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
