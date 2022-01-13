/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 28.12.2021
 */

package ua.goit.dao;

import ua.goit.model.Developers;
import ua.goit.model.Projects;
import ua.goit.model.Skills;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

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
    @Override
    public void delete(Developers entity) {
        entity = em.merge(entity);
        em.getTransaction().begin();
        for (Projects project : entity.getProjects()) {
            project.getDevelopers().remove(entity);
        }
        for (Skills skill : entity.getSkills()) {
            skill.getDevelopers().remove(entity);
        }
        em.remove(entity);
        em.getTransaction().commit();
    }

    public List<Developers> developersOfIndustry(String industry) {
        TypedQuery<Developers> developersOfIndustry = em.createNamedQuery("getDevelopersOfIndustry", Developers.class);
        developersOfIndustry.setParameter("industry", industry);
        return developersOfIndustry.getResultStream().collect(Collectors.toList());
    }

    public List<Developers> developersOfLevel(String level) {
        TypedQuery<Developers> developersOfLevel = em.createNamedQuery("getDevelopersOfLevel", Developers.class);
        developersOfLevel.setParameter("level", level);
        return developersOfLevel.getResultStream().collect(Collectors.toList());
    }
}
