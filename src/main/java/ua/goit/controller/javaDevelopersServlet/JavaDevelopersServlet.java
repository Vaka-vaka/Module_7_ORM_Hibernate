///**
// * Module 6. Servlets
// *
// * @autor Valentin Mozul
// * @version of 23.12.2021
// */
//
//package ua.goit.controller.javaDevelopersServlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import ua.goit.model.JavaDevelopers;
//import ua.goit.service.JavaDevelopersService;
//
//import java.io.IOException;
//import java.util.List;
//
//
//@WebServlet("/javaDevelopersJSP")
//public class JavaDevelopersServlet extends HttpServlet {
//
//    private JavaDevelopersService service;
//
//    @Override
//    public void init() {
//        this.service = (JavaDevelopersService) getServletContext()
//                .getAttribute("javaDevelopersService");
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            List<JavaDevelopers> all = service.getAll();
//            Object[] javaDevelopersJSP = all.toArray();
//            req.setAttribute("javaDevelopersJSP", javaDevelopersJSP);
//            req.getRequestDispatcher("/jsp/javaDevelopersJSP.jsp").forward(req, resp);
//    }
//
//}
//
//
//
