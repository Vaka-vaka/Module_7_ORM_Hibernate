/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 24.12.2021
 */

package ua.goit.service;

import ua.goit.dao.ListProjectsDao;
import ua.goit.model.ListProjects;

import java.util.List;

public class ListProjectsService {

    private static ListProjectsService instance;

    private static final ListProjectsDao listProjectsDao
            = ListProjectsDao.getInstance();

    private ListProjectsService() {
    }

    public static ListProjectsService getInstance() {
        if (instance == null) {
            instance = new ListProjectsService();
        }
        return instance;
    }

    public List<ListProjects> getAll() {
        return listProjectsDao.getAll();
    }
}
