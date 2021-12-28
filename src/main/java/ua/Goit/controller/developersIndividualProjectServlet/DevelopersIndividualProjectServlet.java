/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 23.12.2021
 */

package ua.goit.controller.developersIndividualProjectServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.goit.model.DevelopersIndividualProject;
import ua.goit.service.DevelopersIndividualProjectService;


import java.io.IOException;
import java.util.List;


@WebServlet("/developersIndividualProjectJSP")
public class DevelopersIndividualProjectServlet extends HttpServlet {

    private DevelopersIndividualProjectService service;

    @Override
    public void init() {
        this.service = (DevelopersIndividualProjectService) getServletContext()
                .getAttribute("developersIndividualProjectService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            List<DevelopersIndividualProject> all = service.getAll();
            Object[] developersIndividualProjectJSP = all.toArray();
            req.setAttribute("developersIndividualProjectJSP", developersIndividualProjectJSP);
            req.getRequestDispatcher("/jsp/developersIndividualProjectJSP.jsp").forward(req, resp);
    }

}



