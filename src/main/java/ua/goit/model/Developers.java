/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 28.12.2021
 */

package ua.goit.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "developers")
//@NamedQueries({
//        @NamedQuery(name = "getAll", query = "from Developers")
//})
public class Developers {

    @Id
    @GeneratedValue(generator = "developers_id_seq")
    private long id;
    private String name_;
    private long age;
    private String gender;
    private int salary;

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

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developers that = (Developers) o;
        return id == that.id && age == that.age && salary == that.salary && Objects.equals(name_, that.name_) && Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name_, age, gender, salary);
    }

    @Override
    public String toString() {
        return "Developers{" +
                "id=" + id +
                ", name_='" + name_ + '\'' +
                ", Age=" + age +
                ", Gender='" + gender + '\'' +
                ", Salary=" + salary +
                '}';
    }
}
