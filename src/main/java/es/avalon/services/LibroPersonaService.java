package es.avalon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.avalon.dominio.Persona;
//import es.avalon.repository.LibroRepository;
import es.avalon.repository.PersonaRepository;
@Service
public class LibroPersonaService {

    @Autowired
    private PersonaRepository repoPersona;

    public List<Persona> buscarTodasLasPersonas() {

        return repoPersona.buscarTodos();
    }
    @Transactional
    public void insertarPersona(Persona persona) {

        repoPersona.insertar(persona);
    }
    @Transactional
    public void borrarPersona(Persona persona) {
        repoPersona.borrar(persona);
    }

    public Persona buscarUnaPersona(String dni) {
        return repoPersona.buscarUno(dni);
    }

    public List<Persona> buscarTodosConLibros() {
        return repoPersona.buscarTodosConLibros();
    }
    public void salvarPersona(Persona persona) {
        repoPersona.salvar(persona);
    }

 



    
}
