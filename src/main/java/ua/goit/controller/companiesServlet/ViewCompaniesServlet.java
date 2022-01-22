/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 15.12.2021
 */

package ua.goit.controller.companiesServlet;

import com.google.gson.Gson;
import ua.goit.model.Companies;
import ua.goit.service.CompaniesService;
import ua.goit.service.HandleBodyUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/companiesJSP/*")
public class ViewCompaniesServlet extends HttpServlet {

    private CompaniesService service;

    protected Gson jsonParser = new Gson();

    @Override
    public void init() {
        this.service = (CompaniesService) getServletContext().getAttribute("companiesService" );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String id = requestURI.substring(14);
        if ("new".equalsIgnoreCase(id)) {
            req.setAttribute("companies", new Companies());
            req.setAttribute("isNew", true);
            req.getRequestDispatcher("/jsp/viewCompaniesJSP.jsp").forward(req, resp);
        }
        Optional<Companies> companiesOptional = service.get(Long.parseLong(id));
        if (companiesOptional.isPresent()) {
            Companies companies = companiesOptional.get();
            req.setAttribute("companies", companies);
            req.getRequestDispatcher("/jsp/viewCompaniesJSP.jsp").forward(req, resp);
        }
        resp.sendRedirect("/companiesJSP");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      HandleBodyUtil.getModelFromStream(req.getInputStream(), Companies.class)
                      .ifPresent(companies -> {
                          service.update(companies);
                      });
        resp.sendRedirect("/companiesJSP");
    }
}
