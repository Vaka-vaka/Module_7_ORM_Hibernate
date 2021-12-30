/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 28.12.2021
 */

package ua.goit.dao;

import ua.goit.model.Developers;

public class DevelopersDao extends AbstractDao<Developers> {

    private static DevelopersDao  instance;

    private DevelopersDao() {
        super(Developers.class);
    }

    public static DevelopersDao getInstance() {
        if (instance == null) {
            instance = new DevelopersDao();
        }
        return instance;
    }

}
