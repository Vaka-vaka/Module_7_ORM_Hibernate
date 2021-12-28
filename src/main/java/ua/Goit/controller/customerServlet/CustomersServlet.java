/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 15.12.2021
 */

package ua.goit.controller.customerServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.goit.model.Customers;
import ua.goit.service.CustomersService;
import ua.goit.service.HandleBodyUtil;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/customersJSP")
public class CustomersServlet extends HttpServlet {

    private CustomersService service;

    @Override
    public void init() throws ServletException {
        this.service = (CustomersService) getServletContext().getAttribute("customersService" );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteId = req.getParameter("deleteId");
        if (deleteId != null) {
            Customers customers = new Customers();
            customers.setId(Long.parseLong(deleteId));
            service.delete(customers);
            resp.sendRedirect("/customersJSP");
        } else {
            List<Customers> all = service.getAll();
            Object[] customersJSP = all.toArray();
            req.setAttribute("customersJSP", customersJSP);
            req.getRequestDispatcher("/jsp/customersJSP.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Optional<Customers> modelFromStream = HandleBodyUtil.getModelFromStream(req.getInputStream(), Customers.class);
        modelFromStream.ifPresent(customers -> service.create(customers));
        resp.sendRedirect("/customersJSP");
    }
}
