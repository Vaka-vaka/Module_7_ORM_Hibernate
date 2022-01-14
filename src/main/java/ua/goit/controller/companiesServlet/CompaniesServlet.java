/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 15.12.2021
 */

package ua.goit.controller.companiesServlet;

import ua.goit.model.Companies;
import ua.goit.service.CompaniesService;
import ua.goit.service.HandleBodyUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/companiesJSP")
public class CompaniesServlet extends HttpServlet {

    private CompaniesService service;

    @Override
    public void init() throws ServletException {
        this.service = (CompaniesService) getServletContext().getAttribute("companiesService" );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteId = req.getParameter("deleteId");
        if (deleteId != null) {
            Optional<Companies> companies = service.get(Long.parseLong(deleteId));
            companies.ifPresent(companies1 -> service.delete(companies1));
            resp.sendRedirect("/companiesJSP");
        } else {
            List<Companies> all = service.getAll();
            Object[] companiesJSP = all.toArray();
            req.setAttribute("companiesJSP", companiesJSP);
            req.getRequestDispatcher("/jsp/companiesJSP.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Optional<Companies> modelFromStream = HandleBodyUtil.getModelFromStream(req.getInputStream(), Companies.class);
        modelFromStream.ifPresent(companies -> service.create(companies));
        resp.sendRedirect("/companiesJSP");
    }
}
