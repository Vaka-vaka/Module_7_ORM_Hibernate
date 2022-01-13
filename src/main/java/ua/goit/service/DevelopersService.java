/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 29.12.2021
 */

package ua.goit.service;

import ua.goit.model.Developers;
import ua.goit.dao.DevelopersDao;

import java.util.List;
import java.util.Optional;

public class DevelopersService {

    private static DevelopersService instance;

    private final DevelopersDao developersDao = DevelopersDao.getInstance();
    CompaniesService companyDao = CompaniesService.getInstance();

    private DevelopersService() {
    }

    public static DevelopersService getInstance() {
        if (instance == null) {
            instance = new DevelopersService();
        }
        return instance;
    }

    public List<Developers> getAll() {
        companyDao.getAll();
        return developersDao.getAll();
    }

//    public List<Developers> getAll() {
//        return developersDao.getAll();
//    }

    public Optional<Developers> get(long id) {
        return developersDao.get(id);
    }

    public void update(Developers developers) {
        developersDao.update(developers);
    }

    public void create(Developers developers) {
        developersDao.create(developers);
    }

    public void delete(Developers developers) {
        developersDao.delete(developers);
    }

    public List<Developers> developersOfIndustry(String industry) {
        return developersDao.developersOfIndustry(industry);
    }

    public List<Developers> developersOfLevel(String level) {
        return developersDao.developersOfLevel(level);
    }
}
