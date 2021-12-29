///**
// * Module 6. Servlets
// *
// * @autor Valentin Mozul
// * @version of 15.12.2021
// */
//
//package ua.goit.service;
//
//import ua.goit.dao.CompaniesDao;
//import ua.goit.model.Companies;
//
//import java.util.List;
//import java.util.Optional;
//
//public class CompaniesService {
//
//    private static CompaniesService instance;
//
//    private final CompaniesDao companiesDao = CompaniesDao.getInstance();
//
//    private CompaniesService() {
//    }
//
//    public static CompaniesService getInstance() {
//        if (instance == null) {
//            instance = new CompaniesService();
//        }
//        return instance;
//    }
//
//    public List<Companies> getAll() {
//        return companiesDao.getAll();
//    }
//
//    public Optional<Companies> get(long id) {
//        return companiesDao.get(id);
//    }
//
//    public void update(Companies companies) {
//        companiesDao.update(companies);
//    }
//
//    public void create(Companies companies) {
//        companiesDao.create(companies);
//    }
//
//    public void delete(Companies companies) {
//        companiesDao.delete(companies);
//    }
//}
