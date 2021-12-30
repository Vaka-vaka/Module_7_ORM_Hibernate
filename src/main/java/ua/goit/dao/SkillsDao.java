/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 30.12.2021
 */

package ua.goit.dao;

import ua.goit.model.Skills;

public class SkillsDao extends AbstractDao<Skills> {

    private static SkillsDao  instance;

    private SkillsDao() {
    }

    public static SkillsDao getInstance() {
        if (instance == null) {
            instance = new SkillsDao();
        }
        return instance;
    }

}
