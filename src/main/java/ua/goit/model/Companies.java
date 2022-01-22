/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 10.01.2022
 */

package ua.goit.model;

import javax.persistence.*;

import com.google.gson.annotations.SerializedName;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import ua.goit.dao.to_interface.Identity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
public class Companies implements Identity {

    @Id
    @GeneratedValue(generator = "companies_id_seq")
    @SerializedName("id")
    private Long id;
    @Column(name = "name_")
    @SerializedName("name_")
    private String name_;
    @Column(name = "city")
    @SerializedName("city")
    private String city;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
            name = "companies_projects",
            joinColumns = { @JoinColumn(name = "companies_id") },
            inverseJoinColumns = { @JoinColumn(name = "projects_id") }
    )
    private transient List<Projects> projects = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Projects> getProjects() {
        return projects;
    }

    public void setProjects(List<Projects> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return jsonObject().toJson(this);
    }
}
