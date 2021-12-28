/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 21.12.2021
 */

package ua.goit.model;

import ua.goit.dao.to_interface.Identity;

import java.util.Objects;

public class Salary implements Identity {

    private String name_;
    private Double sumSalary;

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public Double getSumSalary() {
        return sumSalary;
    }

    public void setSumSalary(Double sumSalary) {
        this.sumSalary = sumSalary;
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salary salary = (Salary) o;
        return Objects.equals(name_, salary.name_) && Objects.equals(sumSalary, salary.sumSalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name_, sumSalary);
    }

    @Override
    public String toString() {
        return "Salary{" +
                "name_='" + name_ + '\'' +
                ", sumSalary=" + sumSalary +
                '}';
    }
}
