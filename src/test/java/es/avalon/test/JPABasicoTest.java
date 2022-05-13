package es.avalon.test;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;

import es.avalon.dominio.Persona;
import es.avalon.repository.PersonaRepository;
import es.avalon.repository.helper.JPAHelper;

public class JPABasicoTest {

    @Test
    public void testPersona() {

       Persona p= new Persona("1","pepe",30);
    
        assertEquals("1", p.getDni());
        assertEquals("pepe", p.getNombre());
        assertEquals(30, p.getEdad());
        
    }

    @Test
    public void testBuscarPersonaPorDNI() {

       PersonaRepository repo= new PersonaRepository();
       Persona p=repo.buscarUno("1");
    
        assertEquals("1", p.getDni());
        assertEquals("juan", p.getNombre());
        assertEquals(20, p.getEdad());
        
    }

    @Test
    public void testJPAConsultaSeleccionarNombre() {

        EntityManager em= JPAHelper.getEntityManager();
        TypedQuery<Persona> consulta=em.createQuery("select p from Persona p where p.nombre=:nombre",Persona.class);
        consulta.setParameter("nombre", "maria");
        Persona maria= consulta.getResultList().get(0);
        assertEquals("maria", maria.getNombre());
        assertEquals("2", maria.getDni());
        assertEquals(40, maria.getEdad());
        



        
    }
    
}
