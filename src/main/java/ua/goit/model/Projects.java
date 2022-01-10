/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 30.12.2021
 */

package ua.goit.model;

import com.google.gson.annotations.SerializedName;
import ua.goit.dao.to_interface.Identity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "projects")
public class Projects implements Identity {

    @Id
    @GeneratedValue(generator = "projects_id_seq")
    @SerializedName("id")
    private Long id;
    @Column(name = "name_")
    @SerializedName("name_")
    private String name_;
    @Column(name = "language")
    @SerializedName("language")
    private String language;
    @Column(name = "cost")
    @SerializedName("cost")
    private int cost;
//    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date")
    @SerializedName("creation_date")
    private String creation_date;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "developers_projects",
            joinColumns = { @JoinColumn(name = "projects_id") },
            inverseJoinColumns = { @JoinColumn(name = "dev_id") }
    )
    private List<Developers> developers = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public List<Developers> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developers> developers) {
        this.developers = developers;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "id=" + id +
                ", name_='" + name_ + '\'' +
                ", language='" + language + '\'' +
                ", cost=" + cost +
                ", creation_date='" + creation_date + '\'' +
                ", developers=" + developers +
                '}';
    }
}
