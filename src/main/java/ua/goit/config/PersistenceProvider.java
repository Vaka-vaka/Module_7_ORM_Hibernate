package ua.goit.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceProvider {

       private static final EntityManagerFactory emf;
       static {
              try {
                     emf = Persistence
                             .createEntityManagerFactory("Module_7ORM_Hibernate");

              } catch (Throwable t) {
                     t.printStackTrace();
                     throw t;
              }
       }

       public  static EntityManager getEntityManager() {
              return  emf.createEntityManager();
       }
}
