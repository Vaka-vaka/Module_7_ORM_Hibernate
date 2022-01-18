/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 30.12.2021
 */

package ua.goit.controller.skillsServlet;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.goit.model.Skills;
import ua.goit.service.HandleBodyUtil;
import ua.goit.service.SkillsService;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/skillsJSP/*")
public class ViewSkillsServlet extends HttpServlet {

    private SkillsService service;

    protected Gson jsonParser = new Gson();

    @Override
    public void init() {
        this.service = (SkillsService) getServletContext().getAttribute("skillsService" );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String id = requestURI.substring(11);
        if ("new".equalsIgnoreCase(id)) {
            req.setAttribute("skills", new Skills());
            req.setAttribute("isNew", true);
            req.getRequestDispatcher("/jsp/viewSkillsJSP.jsp").forward(req, resp);
        }
        Optional<Skills> skillsOptional = service.get(Long.parseLong(id));
        if (skillsOptional.isPresent()) {
            Skills skills = skillsOptional.get();
            req.setAttribute("skills", skills);
            req.getRequestDispatcher("/jsp/viewSkillsJSP.jsp").forward(req, resp);
        }
        resp.sendRedirect("/skillsJSP");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      HandleBodyUtil.getModelFromStream(req.getInputStream(), Skills.class)
                      .ifPresent(skills -> {
                          service.update(skills);
                      });
        resp.sendRedirect("/skillsJSP");
    }
}
