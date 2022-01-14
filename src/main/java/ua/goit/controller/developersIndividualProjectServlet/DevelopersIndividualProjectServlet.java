/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 23.12.2021
 */

package ua.goit.controller.developersIndividualProjectServlet;

import ua.goit.model.Developers;
import ua.goit.model.Skills;
import ua.goit.service.DevelopersService;
import ua.goit.service.HandleBodyUtil;
import ua.goit.service.SkillsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet("/developersIndividualProjectJSP")
public class DevelopersIndividualProjectServlet extends HttpServlet {

    private SkillsService service;
    private List<Developers> developersIndustry = new ArrayList<>();

    @Override
    public void init() {
        this.service = (SkillsService) getServletContext()
                .getAttribute("skillService");
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            List<DevelopersIndividualProject> all = service.getAll();
//            Object[] developersIndividualProjectJSP = all.toArray();
//            req.setAttribute("developersIndividualProjectJSP", developersIndividualProjectJSP);
//            req.getRequestDispatcher("/jsp/developersIndividualProjectJSP.jsp").forward(req, resp);
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Object[] developersIndividualProjectJSP = service.getAll().toArray();
        req.setAttribute("listSkill", developersIndividualProjectJSP);
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("developersIndustry", developersIndustry);
        req.getRequestDispatcher("/jsp/developersIndividualProjectJSP.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Optional<Skills> modelFromStream = HandleBodyUtil.
                getModelFromStream(req.getInputStream(), Skills.class);
        modelFromStream.ifPresent(skill -> {
            developersIndustry = DevelopersService.getInstance().developersOfIndustry(skill.getLanguage());
            System.out.println("Developer level = " + DevelopersService.getInstance().developersOfIndustry(skill.getLanguage()));
        });
        resp.sendRedirect("/developersIndividualProjectJSP");
    }
}



