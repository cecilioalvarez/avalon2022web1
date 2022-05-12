package es.avalon.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import es.avalon.dominio.Persona;
import es.avalon.repository.helper.JPAHelper;

public class PersonaRepository {

    public List<Persona> buscarTodos() {

        EntityManager em =JPAHelper.getEntityManager();
        TypedQuery<Persona> consulta = em.createQuery("select p from Persona p", Persona.class);
        return consulta.getResultList();
    }

    public Persona buscarUno(String dni) {
        return JPAHelper.getEntityManager().find(Persona.class, dni);
    }

    public void insertar(Persona p) {
        EntityManager em = JPAHelper.getEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    public void borrar(Persona persona) { 
        EntityManager em = JPAHelper.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(persona));
        em.getTransaction().commit();

    }

}