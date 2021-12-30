/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 28.12.2021
 */

package ua.goit.dao;

import ua.goit.model.Developers;
import ua.goit.model.Projects;

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

//    @Override
//    public void delete(Developers entity) {
////        entity = em.merge(entity);
//        em.getTransaction().begin();
////        for (Projects group : entity.getGroups()) {
////            group.getUsers().remove(entity);
////        }
//        em.remove(entity);
//        em.getTransaction().commit();
//    }
}
