package ua.goit.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceProvider {

       private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(
               "Module_7ORM_Hibernate");

       public  static EntityManager getEntityManager() {
              return  emf.createEntityManager();
       }
}
