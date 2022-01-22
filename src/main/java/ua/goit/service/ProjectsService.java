/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 30.12.2021
 */

package ua.goit.service;

import ua.goit.dao.ProjectsDao;
import ua.goit.model.Projects;


import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ProjectsService {

    private static ProjectsService instance;

    private final ProjectsDao projectsDao = ProjectsDao.getInstance();

    private ProjectsService() {
    }

    public static ProjectsService getInstance() {
        if (instance == null) {
            instance = new ProjectsService();
        }
        return instance;
    }

    public List<Projects> getAll() {
        return projectsDao.getAll();
    }

    public Optional<Projects> get(long id) {
        return projectsDao.get(id);
    }

    public void update(Projects projects) {
        projectsDao.update(projects);
    }

    public void create(Projects projects) {
        projectsDao.create(projects);
    }

    public void delete(Projects projects) {
        projectsDao.delete(projects);
    }

//    public Map<String, Double> getSumProjectSalary(String projectName) {
//        return projectsDao.getSumProjectSalary(projectName);
//    }

}
