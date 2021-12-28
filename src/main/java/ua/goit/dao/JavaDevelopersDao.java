///**
// * Module 6. Servlets
// *
// * @autor Valentin Mozul
// * @version of 23.12.2021
// */
//
//package ua.goit.dao;
//
//import ua.goit.model.JavaDevelopers;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Optional;
//
//public class JavaDevelopersDao extends AbstractDao<JavaDevelopers> {
//
//    private static JavaDevelopersDao instance;
//
//    private JavaDevelopersDao() {
//    }
//
//    public static JavaDevelopersDao getInstance() {
//        if (instance == null) {
//            instance = new JavaDevelopersDao();
//        }
//        return instance;
//    }
//
//    @Override
//    String getTableName() {
//        return "list_java_developers";
//    }
//
//    @Override
//    JavaDevelopers mapToEntity(ResultSet rs) throws SQLException {
//        JavaDevelopers javaDevelopers = new JavaDevelopers();
//        javaDevelopers.setDevelopersName(rs.getString("developer_name"));
//        return javaDevelopers;
//    }
//
//    @Override
//    public Optional<JavaDevelopers> create(JavaDevelopers entity) {
//        return Optional.empty();
//    }
//
//    @Override
//    public void update(JavaDevelopers entity) {
//    }
//}
