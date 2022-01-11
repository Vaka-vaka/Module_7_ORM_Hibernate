/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 10.01.2022
 */

package ua.goit.model;

import javax.persistence.*;

import com.google.gson.annotations.SerializedName;
import ua.goit.dao.to_interface.Identity;

@Entity
@Table(name = "companies")
public class Companies implements Identity {

    @Id
    @GeneratedValue(generator = "companies_id_seq")
    @SerializedName("id")
    private long id;
    @Column(name = "name_")
    @SerializedName("name_")
    private String name_;
    @Column(name = "city")
    @SerializedName("city")
    private String city;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Companies{" +
                "id=" + id +
                ", name_='" + name_ + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
