///**
// * Module 6. Servlets
// *
// * @autor Valentin Mozul
// * @version of 24.12.2021
// */
//
//package ua.goit.controller.listProjectsServlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import ua.goit.model.ListProjects;
//import ua.goit.service.ListProjectsService;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet("/listProjectsJSP")
//public class ListProjectsServlet extends HttpServlet {
//
//    private ListProjectsService service;
//
//    @Override
//    public void init() {
//        this.service = (ListProjectsService) getServletContext()
//                .getAttribute("listProjectsService");
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<ListProjects> all = service.getAll();
//        Object[] listProjectsJSP = all.toArray();
//        req.setAttribute("listProjectsJSP", listProjectsJSP);
//        req.getRequestDispatcher("/jsp/listProjectsJSP.jsp").forward(req, resp);
//    }
//
//}
//
//
//
