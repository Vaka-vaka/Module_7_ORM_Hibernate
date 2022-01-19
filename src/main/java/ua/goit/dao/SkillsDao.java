/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 30.12.2021
 */

package ua.goit.dao;

import ua.goit.model.Developers;
import ua.goit.model.Skills;

public class SkillsDao extends AbstractDao<Skills> {

    private static SkillsDao  instance;

    private SkillsDao() {
        super(Skills.class);
    }

    public static SkillsDao getInstance() {
        if (instance == null) {
            instance = new SkillsDao();
        }
        return instance;
    }

    @Override
    public void delete(Skills entity) {
        entity = em.merge(entity);
        em.getTransaction().begin();
        for (Developers developer : entity.getDevelopers()) {
            if (!developer.getSkills().isEmpty()) {
                developer.getSkills().remove(entity);
            }
        }
        em.remove(entity);
        em.getTransaction().commit();
    }
}
