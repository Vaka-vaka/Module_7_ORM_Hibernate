/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 30.12.2021
 */

package ua.goit.model;

import com.google.gson.annotations.SerializedName;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ua.goit.dao.to_interface.Identity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "projects")
@NamedQueries({
        @NamedQuery(name = "getAllProjects", query = "from Projects"),
        @NamedQuery(name = "developersByProjectId", query = "select p from Projects p where p.id = :id")
})
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
    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date")
    @SerializedName("creation_date")
    private java.util.Date creation_date;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
            name = "developers_projects",
            joinColumns = { @JoinColumn(name = "projects_id") },
            inverseJoinColumns = { @JoinColumn(name = "dev_id") }
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Developers> developers;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
            name = "customers_projects",
            joinColumns = { @JoinColumn(name = "projects_id") },
            inverseJoinColumns = { @JoinColumn(name = "customers_id") }
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Customers> customers;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
            name = "companies_projects",
            joinColumns = { @JoinColumn(name = "projects_id") },
            inverseJoinColumns = { @JoinColumn(name = "companies_id") }
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Companies> companies;

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

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public List<Developers> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developers> developers) {
        this.developers = developers;
    }

    public List<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customers> customers) {
        this.customers = customers;
    }

    public List<Companies> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Companies> companies) {
        this.companies = companies;
    }

    @Override
    public String toString() {
        return jsonObject().toJson(this);
    }
}
