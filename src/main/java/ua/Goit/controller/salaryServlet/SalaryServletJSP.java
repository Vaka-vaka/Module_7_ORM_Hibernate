/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 21.12.2021
 */

package ua.goit.controller.salaryServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.goit.model.Salary;
import ua.goit.service.SalaryService;

import java.io.IOException;
import java.util.List;


@WebServlet("/salaryJSP")
public class SalaryServletJSP extends HttpServlet {

    private SalaryService service;

    @Override
    public void init() {
        this.service = (SalaryService) getServletContext()
                .getAttribute("salaryService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            List<Salary> all = service.getAll();
            Object[] salaryJSP = all.toArray();
            req.setAttribute("salaryJSP", salaryJSP);
            req.getRequestDispatcher("/jsp/salaryJSP.jsp").forward(req, resp);
    }

}



