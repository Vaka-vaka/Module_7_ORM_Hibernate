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
import ua.goit.dao.ProjectsDao;
import ua.goit.model.Projects;
import ua.goit.service.ProjectsService;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class ProjectsCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(ProjectsCommand.class);

    private final ProjectsService projectsService = ProjectsService.getInstance();

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
        List<Projects> all = projectsService.getAll();
        System.out.println("Returned " + all.size() + " projects");
        for (Projects projects : all) {
            System.out.println(projects);
        }
    }

    private void update(String params) {
        String[] paramsArray = params.split(" ");
        Optional<Projects> optionalProjects = projectsService
                .get(Long.parseLong(paramsArray[0]));
        if (optionalProjects.isPresent()) {
            Projects projects = optionalProjects.get();
            projects.setName_(paramsArray[1]);
            projects.setLanguage(paramsArray[2]);
            projects.setCost(Integer.parseInt(paramsArray[3]));
            projects.setCreation_date(paramsArray[4]);
            projectsService.update(projects);
        } else {
            System.out.println("Projects with id " + paramsArray[0] + " not found");
        }
    }

    private void create(String params) {
        String[] paramsArray = params.split(" ");
        Projects projects = new Projects();
        projects.setId(Long.parseLong(paramsArray[0]));
        projects.setName_(paramsArray[1]);
        projects.setLanguage(paramsArray[2]);
        projects.setCost(Integer.parseInt(paramsArray[3]));
        projects.setCreation_date(paramsArray[4]);
        projectsService.create(projects);
    }

    private void get(String params) {
        String[] paramsArray = params.split(" ");
        Optional<Projects> projects = projectsService
                .get(Long.parseLong(paramsArray[0]));
        if (projects.isPresent()) {
            System.out.println(projects.get());
        } else {
            System.out.println("Projects with id " + paramsArray[0] + " not found");
        }
    }

    private void delete(String params) {
        String[] paramsArray = params.split(" ");
        Optional<Projects> projects = projectsService
                .get(Long.parseLong(paramsArray[0]));
        if (projects.isPresent()) {
            projectsService.delete(projects.get());
        } else {
            System.out.println("Projects with id " + paramsArray[0] + " not found");
        }
    }

    @Override
    public void printActiveMenu() {
        LOGGER.info("---------------------Projects menu---------------------");
        LOGGER.info("Projects command list:");
        LOGGER.info("create [id] [name_] [language] [creation_date(format dd-MM-yyyy)] [cost]");
        LOGGER.info("get [id]");
        LOGGER.info("getAll");
        LOGGER.info("update [id] [name_] [language] [creation_date(format dd-MM-yyyy)] [cost]");
        LOGGER.info("delete [id]");
    }
}
