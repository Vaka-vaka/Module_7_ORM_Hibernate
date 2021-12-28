/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 14.12.2021
 */

package ua.goit.controller.projectsServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.goit.model.Projects;
import ua.goit.service.HandleBodyUtil;
import ua.goit.service.ProjectsService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/projectsJSP")
public class ProjectsServlet extends HttpServlet{

    private ProjectsService service;

    @Override
    public void init() {
        this.service = (ProjectsService) getServletContext().getAttribute("projectsService" );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteId = req.getParameter("deleteId");
        if (deleteId != null) {
            Projects projects = new Projects();
            projects.setId(Long.parseLong(deleteId));
            service.delete(projects);
            resp.sendRedirect("/projectsJSP");
        } else {
            List<Projects> all = service.getAll();
            Object[] projectsJSP = all.toArray();
            req.setAttribute("projectsJSP", projectsJSP);
            req.getRequestDispatcher("/jsp/projectsJSP.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Optional<Projects> modelFromStream = HandleBodyUtil.getModelFromStream(req.getInputStream(), Projects.class);
        modelFromStream.ifPresent(projects -> service.create(projects));
        System.out.println("Created project with status code:" + resp.getStatus());
        resp.sendRedirect("/projectsJSP");
    }
}
