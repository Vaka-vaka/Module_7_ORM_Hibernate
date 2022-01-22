/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 30.12.2021
 */

package ua.goit.controller.skillsServlet;

import ua.goit.model.Skills;
import ua.goit.service.HandleBodyUtil;
import ua.goit.service.SkillsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/skillsJSP")
public class SkillsServlet extends HttpServlet {

    private SkillsService service;

    @Override
    public void init() {
        this.service = (SkillsService) getServletContext().getAttribute("skillsService" );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteId = req.getParameter("deleteId");
        if (deleteId != null) {
            Optional<Skills> skills = service.get(Long.parseLong(deleteId));
            skills.ifPresent(sk -> service.delete(sk));
            resp.sendRedirect("/skillsJSP");
        } else {
            List<Skills> all = service.getAll();
            Object[] skillsJSP = all.toArray();
            req.setAttribute("skillsJSP", skillsJSP);
            req.getRequestDispatcher("/jsp/skillsJSP.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Optional<Skills> modelFromStream = HandleBodyUtil.getModelFromStream(req.getInputStream(), Skills.class);
        modelFromStream.ifPresent(skills -> service.create(skills));
        resp.sendRedirect("/skillsJSP");
    }

}