/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 14.12.2021
 */

package ua.goit.controller.projectsServlet;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.model.Projects;
import ua.goit.service.HandleBodyUtil;
import ua.goit.service.ProjectsService;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/projectsJSP/*")
public class ViewProjectsServlet extends HttpServlet {

    private ProjectsService service;

    public static final Logger LOGGER = LogManager.getLogger(ViewProjectsServlet.class);
    protected Gson jsonParser = new Gson();

    @Override
    public void init() {
        this.service = (ProjectsService) getServletContext().getAttribute("projectsService" );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String id = requestURI.substring(13);
        if ("new".equalsIgnoreCase(id)) {
            req.setAttribute("projects", new Projects());
            req.setAttribute("isNew", true);
            req.getRequestDispatcher("/jsp/viewProjectsJSP.jsp").forward(req, resp);
        }
        Optional<Projects> projectsOptional = service.get(Long.parseLong(id));
        if (projectsOptional.isPresent()) {
            Projects projects = projectsOptional.get();
            req.setAttribute("projects", projects);
            req.getRequestDispatcher("/jsp/viewProjectsJSP.jsp").forward(req, resp);
        }
        resp.sendRedirect("/projectsJSP");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      HandleBodyUtil.getModelFromStream(req.getInputStream(), Projects.class)
                      .ifPresent(projects -> {
                          service.update(projects);
                      });
        resp.sendRedirect("/projectsJSP");
    }
}
