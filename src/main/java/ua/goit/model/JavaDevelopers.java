/**
 * Module 6. Servlets
 *
 * @autor Valentin Mozul
 * @version of 23.12.2021
 */

package ua.goit.model;

import ua.goit.dao.to_interface.Identity;

public class JavaDevelopers implements Identity {

    private String developersName;

    public String getDevelopersName() {
        return developersName;
    }

    public void setDevelopersName(String developersName) {
        this.developersName = developersName;
    }

    @Override
    public String toString() {
        return "JavaDevelopers{" +
                "developersName='" + developersName + '\'' +
                '}';
    }

    @Override
    public Long getId() {
        return null;
    }
}
