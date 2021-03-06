/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 30.12.2021
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
    }
}
