/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 15.12.2021
 */

package ua.goit.controller.companiesServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.goit.model.Companies;
import ua.goit.service.CompaniesService;
import ua.goit.service.HandleBodyUtil;

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
            Companies companies = new Companies();
            companies.setId(Long.parseLong(deleteId));
            service.delete(companies);
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
