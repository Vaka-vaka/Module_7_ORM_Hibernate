/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 05.11.2021
 */

package ua.goit.dao.to_interface;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public interface Identity {

    default Gson jsonObject() {
        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat("yyyy-MM-dd");
        return builder.create();
    }

}
