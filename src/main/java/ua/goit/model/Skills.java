/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 30.12.2021
 */

package ua.goit.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "skills")
public class Skills {

    @Id
    @GeneratedValue(generator = "skills_id_seq")
    private Long id;
    @Column(name = "language")
    private String language;
    @Column(name = "level_skills")
    private String level_skills;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "developers_skills",
            joinColumns = { @JoinColumn(name = "skills_id") },
            inverseJoinColumns = { @JoinColumn(name = "dev_id") }
    )
    private List<Developers> developers = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLevel_skills() {
        return level_skills;
    }

    public void setLevel_skills(String level_skills) {
        this.level_skills = level_skills;
    }

    public List<Developers> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developers> developers) {
        this.developers = developers;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", level_skills='" + level_skills + '\'' +
                ", developers=" + developers +
                '}';
    }
}
