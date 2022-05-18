package es.avalon.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.avalon.dominio.Persona;
@Repository
public class PersonaRepository {

    @PersistenceContext
    EntityManager em;

    public List<Persona> buscarTodos() {
        TypedQuery<Persona> consulta = em.createQuery("select p from Persona p", Persona.class);
        return consulta.getResultList();
    }

    public Persona buscarUno(String dni) {
        return em.find(Persona.class, dni);
    }

    @Transactional
    public void insertar(Persona p) {
        em.persist(p);
    }
    @Transactional
    public void borrar(Persona persona) {       
        em.remove(em.merge(persona));
    }

    public List<Persona> buscarTodosConLibros() {
        TypedQuery<Persona> consulta = em.createQuery("select p from Persona p join fetch p.libros", Persona.class);
        List<Persona> lista=consulta.getResultList();
        return lista;

    }

}