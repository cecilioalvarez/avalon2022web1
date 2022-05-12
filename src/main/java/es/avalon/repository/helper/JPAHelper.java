package es.avalon.repository.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAHelper {
    
    private static EntityManagerFactory factoria;
    static {

        factoria=
         Persistence
         .createEntityManagerFactory("UnidadCursos");
    }

    public static EntityManager getEntityManager() {

        return factoria.createEntityManager();
    }
}
