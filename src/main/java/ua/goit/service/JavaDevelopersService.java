/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 23.12.2021
 */

package ua.goit.service;

import ua.goit.dao.JavaDevelopersDao;
import ua.goit.model.JavaDevelopers;

import java.util.List;


public class JavaDevelopersService {

    private static JavaDevelopersService instance;

    private static final JavaDevelopersDao javaDevelopersDao = JavaDevelopersDao.getInstance();

    private JavaDevelopersService() {
    }

    public static JavaDevelopersService getInstance() {
        if (instance == null) {
            instance = new JavaDevelopersService();
        }
        return instance;
    }

    public List<JavaDevelopers> getAll() {
        return javaDevelopersDao.getAll();
    }
}
