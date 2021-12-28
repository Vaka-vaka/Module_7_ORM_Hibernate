/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 23.12.2021
 */

package ua.goit.service;

import ua.goit.dao.DevelopersIndividualProjectDao;
import ua.goit.model.DevelopersIndividualProject;

import java.util.List;


public class DevelopersIndividualProjectService {

    private static DevelopersIndividualProjectService instance;

    private static final DevelopersIndividualProjectDao developerIndividualProjectDao =
            DevelopersIndividualProjectDao.getInstance();

    private DevelopersIndividualProjectService() {
    }

    public static DevelopersIndividualProjectService getInstance() {
        if (instance == null) {
            instance = new DevelopersIndividualProjectService();
        }
        return instance;
    }

    public List<DevelopersIndividualProject> getAll() {
        return developerIndividualProjectDao.getAll();
    }
}
