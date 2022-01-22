/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 15.12.2021
 */

package ua.goit.controller.customerServlet;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.goit.model.Customers;
import ua.goit.service.CustomersService;
import ua.goit.service.HandleBodyUtil;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/customersJSP/*")
public class ViewCustomersServlet extends HttpServlet {

    private CustomersService service;

    public static final Logger LOGGER = LogManager.getLogger(ViewCustomersServlet.class);
    protected Gson jsonParser = new Gson();

    @Override
    public void init() {
        this.service = (CustomersService) getServletContext().getAttribute("customersService" );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String id = requestURI.substring(14);
        if ("new".equalsIgnoreCase(id)) {
            req.setAttribute("customers", new Customers());
            req.setAttribute("isNew", true);
            req.getRequestDispatcher("/jsp/viewCustomersJSP.jsp").forward(req, resp);
        }
        Optional<Customers> customersOptional = service.get(Long.parseLong(id));
        if (customersOptional.isPresent()) {
            Customers customers = customersOptional.get();
            req.setAttribute("customers", customers);
            req.getRequestDispatcher("/jsp/viewCustomersJSP.jsp").forward(req, resp);
        }
        resp.sendRedirect("/customersJSP");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      HandleBodyUtil.getModelFromStream(req.getInputStream(), Customers.class)
                      .ifPresent(customers -> {
                          service.update(customers);
                      });
        resp.sendRedirect("/customersJSP");
    }
}
