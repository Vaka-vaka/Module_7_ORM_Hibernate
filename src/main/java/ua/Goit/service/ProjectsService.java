/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 14.12.2021
 */

package ua.goit.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.dao.ProjectsDao;
import ua.goit.model.Projects;


import java.util.List;
import java.util.Optional;

public class ProjectsService {

    private static ProjectsService instance;

    private static final Logger LOGGER = LogManager.getLogger(ProjectsService.class);

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
}
