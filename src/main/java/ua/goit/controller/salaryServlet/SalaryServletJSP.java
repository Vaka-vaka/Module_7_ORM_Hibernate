///**
// * Module 6. Servlets
// *
// * @autor Valentin Mozul
// * @version of 21.12.2021
// */
//
//package ua.goit.controller.salaryServlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import ua.goit.service.ProjectsService;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//@WebServlet("/salaryJSP")
//public class SalaryServletJSP extends HttpServlet {
//
//    private ProjectsService service;
//    private Map<String, Double> salary = new HashMap<>();
//
//    @Override
//    public void init() {
//        this.service = (ProjectsService) getServletContext()
//                .getAttribute("projectsService");
//    }
//
////    @Override
////    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////            List<Salary> all = service.getAll();
////            Object[] salaryJSP = all.toArray();
////            req.setAttribute("salaryJSP", salaryJSP);
////            req.getRequestDispatcher("/jsp/salaryJSP.jsp").forward(req, resp);
////    }
//
//}
//
//

