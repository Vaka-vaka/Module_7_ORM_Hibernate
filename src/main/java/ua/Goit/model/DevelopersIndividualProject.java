/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 23.12.2021
 */

package ua.goit.model;

import ua.goit.dao.to_interface.Identity;

public class DevelopersIndividualProject implements Identity {

        private String name_;
        private String developers;

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public String getDevelopers() {
        return developers;
    }

    public void setDevelopers(String developers) {
        this.developers = developers;
    }

    @Override
    public String toString() {
        return "DevelopersIndividualProject{" +
                "name_='" + name_ + '\'' +
                ", developers='" + developers + '\'' +
                '}';
    }

    @Override
    public Long getId() {
        return null;
    }
}


