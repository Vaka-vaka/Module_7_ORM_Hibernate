/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 24.12.2021
 */

package ua.goit.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import ua.goit.config.DbMigration;
import ua.goit.service.*;

@WebListener
public class LoadListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DbMigration.migrate();
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("developersService", DevelopersService.getInstance());
        servletContext.setAttribute("skillsService", SkillsService.getInstance());
        servletContext.setAttribute("projectsService", ProjectsService.getInstance());
        servletContext.setAttribute("companiesService", CompaniesService.getInstance());
        servletContext.setAttribute("customersService", CustomersService.getInstance());
        servletContext.setAttribute("salaryService", SalaryService.getInstance());
        servletContext.setAttribute("developersIndividualProjectService",
                DevelopersIndividualProjectService.getInstance());
        servletContext.setAttribute("javaDevelopersService", JavaDevelopersService.getInstance());
        servletContext.setAttribute("middleDevelopersService", MiddleDevelopersService.getInstance());
        servletContext.setAttribute("listProjectsService", ListProjectsService.getInstance());
    }
}
