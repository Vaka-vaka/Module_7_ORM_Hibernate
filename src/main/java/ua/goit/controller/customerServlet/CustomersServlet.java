/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 11.01.2022
 */

package ua.goit.controller.customerServlet;

import ua.goit.model.Customers;
import ua.goit.service.CustomersService;
import ua.goit.service.HandleBodyUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        String deleteId = req.getParameter("deleteId");
        if (deleteId != null) {
            Optional<Customers> customers = service.get(Long.parseLong(deleteId));
            customers.ifPresent(customers1 -> service.delete(customers1));
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
