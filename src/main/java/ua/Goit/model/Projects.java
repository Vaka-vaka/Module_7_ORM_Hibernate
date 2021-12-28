/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 13.11.2021
 */

package ua.goit.model;

import ua.goit.dao.to_interface.Identity;
import java.util.*;

public class Projects implements Identity {

    private long id;
    private String name_;
    private String language;
    private int cost;
    private String creation_date;

    @Override
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projects projects = (Projects) o;
        return id == projects.id && cost == projects.cost && Objects.equals(name_, projects.name_) && Objects.equals(language, projects.language) && Objects.equals(creation_date, projects.creation_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name_, language, cost, creation_date);
    }

    @Override
    public String toString() {
        return "Projects{" +
                "id=" + id +
                ", name_='" + name_ + '\'' +
                ", language='" + language + '\'' +
                ", cost=" + cost +
                ", creation_date=" + creation_date +
                '}';
    }
}
