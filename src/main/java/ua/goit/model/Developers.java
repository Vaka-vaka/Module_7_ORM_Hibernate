/**
 * Module_7_ORM_Hibernate
 *
 * @autor Valentin Mozul
 * @version of 28.12.2021
 */

package ua.goit.model;

import javax.persistence.*;

@Entity
@Table(name = "developers")
public class Developers {

    @Id
    @GeneratedValue(generator = "developers_id_seq")
    private long id;
    @Column(name = "name")
    private String name_;
    @Column(name = "age")
    private long age;
    @Column(name = "gender")
    private String gender;
    @Column(name = "salary")
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
