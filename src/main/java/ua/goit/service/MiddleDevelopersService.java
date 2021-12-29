///**
// * Module 6. Servlets
// *
// * @autor Valentin Mozul
// * @version of 24.12.2021
// */
//
//package ua.goit.service;
//
//import ua.goit.dao.MiddleDevelopersDao;
//import ua.goit.model.MiddleDevelopers;
//
//import java.util.List;
//
//public class MiddleDevelopersService {
//
//    private static MiddleDevelopersService instance;
//
//    private static final MiddleDevelopersDao middleDevelopersDao
//            = MiddleDevelopersDao.getInstance();
//
//    private MiddleDevelopersService() {
//    }
//
//    public static MiddleDevelopersService getInstance() {
//        if (instance == null) {
//            instance = new MiddleDevelopersService();
//        }
//        return instance;
//    }
//
//    public List<MiddleDevelopers> getAll() {
//        return middleDevelopersDao.getAll();
//    }
//}
