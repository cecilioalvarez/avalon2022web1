package es.avalon.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import es.avalon.dominio.Persona;

public class PersonaRepository {

    public List<Persona> buscarTodos() {

       
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("UnidadCursos");
        EntityManager em= emf.createEntityManager();
        // no es una consulta de SQL es una consulta de JPA QL 
        TypedQuery<Persona> consulta=em.createQuery("select p from Persona p",Persona.class);
        return consulta.getResultList();
    }


    public Persona buscarUno(String dni) {

      return null;
       
    }

    public void insertar(Persona p) {

       EntityManagerFactory emf= Persistence.createEntityManagerFactory("UnidadCursos");
       EntityManager em= emf.createEntityManager();
       em.getTransaction().begin();
       em.persist(p);
       em.getTransaction().commit();
    }

    public void borrar(Persona persona) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("UnidadCursos");
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(persona);
        em.getTransaction().commit();
       
       
    }

}