/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 30.12.2021
 */

package ua.goit.dao;

import ua.goit.model.Projects;

import javax.persistence.Tuple;
import java.util.Map;
import java.util.stream.Collectors;

public class ProjectsDao extends AbstractDao<Projects> {

    private static ProjectsDao  instance;

    private ProjectsDao() {
    }

    public static ProjectsDao getInstance() {
        if (instance == null) {
            instance = new ProjectsDao();
        }
        return instance;
    }

    public Map<String, Double> getSumProjectSalary(String projectName) {
        Map<String, Double> projectDeveloper = em.createQuery("select p.name as project_name, sum(d.salary) as salary_sum" +
                        " from Project p join p.developers d  GROUP BY p.name", Tuple.class)
                .getResultList()
                .stream()
                .collect(
                        Collectors.toMap(
                                tuple -> ((String) tuple.get("project_name")),
                                tuple -> (Double) tuple.get("salary_sum")
                        )
                );
        Map<String, Double> sumProject = projectDeveloper.entrySet().stream()
                .filter(m -> m.getKey().equals(projectName))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return sumProject;
    }
}
