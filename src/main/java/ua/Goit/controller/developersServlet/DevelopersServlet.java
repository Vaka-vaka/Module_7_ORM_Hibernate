/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 14.12.2021
 */

package ua.goit.controller.developersServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.goit.model.Developers;
import ua.goit.service.DevelopersService;
import ua.goit.service.HandleBodyUtil;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/developersJSP")
public class DevelopersServlet extends HttpServlet {

    private DevelopersService service;

    @Override
    public void init() throws ServletException {
        this.service = (DevelopersService) getServletContext().getAttribute("developersService" );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleteId = req.getParameter("deleteId");
        if (deleteId != null) {
            Developers developers = new Developers();
            developers.setId(Long.parseLong(deleteId));
            service.delete(developers);
            resp.sendRedirect("/developersJSP");
        } else {
            List<Developers> all = service.getAll();
            Object[] developersJSP = all.toArray();
            req.setAttribute("developersJSP", developersJSP);
            req.getRequestDispatcher("/jsp/developersJSP.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<Developers> modelFromStream = HandleBodyUtil.getModelFromStream(req.getInputStream(), Developers.class);
        modelFromStream.ifPresent(developers -> service.create(developers));
        resp.sendRedirect("/developersJSP");
    }
}
