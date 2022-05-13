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
        TypedQuery<Persona> consulta=em.
        createQuery("select p from Persona p where p.nombre=:nombre",Persona.class);
        consulta.setParameter("nombre", "maria");
        Persona maria= consulta.getResultList().get(0);
       
        assertEquals("maria", maria.getNombre());
        assertEquals("2", maria.getDni());
        assertEquals(40, maria.getEdad());
                
    }
    
    @Test
    public void testJPAConsultaSeleccionarNombreAndEdad() {

        EntityManager em= JPAHelper.getEntityManager();
        TypedQuery<Persona> consulta=em.
        createQuery("select p from Persona p where"+
          " p.nombre=:nombre and p.edad=:edad",Persona.class);
        consulta.setParameter("nombre", "maria");
        consulta.setParameter("edad", 40);
        Persona maria= consulta.getSingleResult();
       
        assertEquals("maria", maria.getNombre());
        assertEquals("2", maria.getDni());
        assertEquals(40, maria.getEdad());
                
    }

    @Test
    public void testJPAConsultaRangoPersonas() {

        EntityManager em= JPAHelper.getEntityManager();
        TypedQuery<Persona> consulta=em.
        createQuery("select p from Persona p where"+
          " p.edad between 10 and 50 ",Persona.class);
        assertEquals(3,consulta.getResultList().size());
       
      
                
    }

     
    @Test
    public void testJPAEdadPersona() {

        EntityManager em= JPAHelper.getEntityManager();
        TypedQuery<Integer> consulta=em.
        createQuery("select p.edad from Persona p where p.nombre='maria' ",Integer.class);
        Integer numero=consulta.getSingleResult();
        assertEquals(40, numero.intValue());
       
    
                
    }

    @Test
    public void testJPANombrePersonaMayusculas() {

        EntityManager em= JPAHelper.getEntityManager();
        TypedQuery<String> consulta=em.
        createQuery("select upper(p.nombre) from Persona p where p.edad=40 ",String.class);
        String nombre=consulta.getSingleResult();
        assertEquals("MARIA", nombre);
       
    
                
    }
   
    @Test
    public void testJPAEdadSumaPersona() {

        EntityManager em= JPAHelper.getEntityManager();
        TypedQuery<Long> consulta=em.
        createQuery("select sum(p.edad) from Persona p ",Long.class);
        Long numero=consulta.getSingleResult();
        assertEquals(110, numero.intValue());
       
    
                
    }


    @Test
    public void testJPAORdenadoPorEdad() {

        EntityManager em= JPAHelper.getEntityManager();
        TypedQuery<Persona> consulta=em.
        createQuery("select p from Persona p order by p.edad",Persona.class);
        List<Persona> lista= consulta.getResultList();

        assertEquals("juan", lista.get(0).getNombre());
        assertEquals("maria", lista.get(1).getNombre());
       
    
                
    }
 
}
