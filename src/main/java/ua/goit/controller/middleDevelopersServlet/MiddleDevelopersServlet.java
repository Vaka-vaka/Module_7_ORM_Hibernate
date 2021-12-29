///**
// * Module 6. Servlets
// *
// * @autor Valentin Mozul
// * @version of 24.12.2021
// */
//
//package ua.goit.controller.middleDevelopersServlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import ua.goit.model.MiddleDevelopers;
//import ua.goit.service.MiddleDevelopersService;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet("/middleDevelopersJSP")
//public class MiddleDevelopersServlet extends HttpServlet {
//
//    private MiddleDevelopersService service;
//
//    @Override
//    public void init() {
//        this.service = (MiddleDevelopersService) getServletContext()
//                .getAttribute("middleDevelopersService");
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            List<MiddleDevelopers> all = service.getAll();
//            Object[] middleDevelopersJSP = all.toArray();
//            req.setAttribute("middleDevelopersJSP", middleDevelopersJSP);
//            req.getRequestDispatcher("/jsp/middleDevelopersJSP.jsp").forward(req, resp);
//    }
//
//}
//
//
//
