package es.avalon.services;

import java.util.List;

import es.avalon.dominio.Persona;
import es.avalon.repository.LibroRepository;
import es.avalon.repository.PersonaRepository;

public class LibroPersonaService {

    private LibroRepository repoLibro= new LibroRepository();
    private PersonaRepository repoPersona= new PersonaRepository();

    public List<Persona> buscarTodasLasPersonas() {

        return repoPersona.buscarTodos();
    }

    public void insertarPersona(Persona persona) {

        repoPersona.insertar(persona);
    }

    public void borrarPersona(Persona persona) {
        repoPersona.borrar(persona);
    }

 



    
}
