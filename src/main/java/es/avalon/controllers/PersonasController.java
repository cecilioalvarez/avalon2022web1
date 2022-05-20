package es.avalon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.avalon.dominio.Persona;
import es.avalon.services.LibroPersonaService;

@Controller
@RequestMapping("/personas")
public class PersonasController {

    
    @Autowired
    LibroPersonaService servicio;   
    @GetMapping("/lista")
    public String lista(Model modelo) {
        // pasa a la vista el listado de personas con sus libros
        modelo.addAttribute("lista", servicio.buscarTodasLasPersonas());
        return "personas/lista";
    }

    @GetMapping("/lista/orden")
    public String listaOrdenada(Model modelo, String campo) {
        // pasa a la vista el listado de personas con sus libros
        modelo.addAttribute("lista", servicio.buscarTodosConLibrosOrdenados(campo));
        return "personas/lista";
    }

    @PostMapping("/nueva")
    public String nueva(Persona persona) {
        // pasa a la vista el listado de personas con sus libros
        return "personas/nueva";
    }

    @PostMapping("/insertar")
    public String insertar(Model modelo,Persona persona) {
        
       servicio.insertarPersona(persona);
       //cargo datos que se muestran en la vista
       modelo.addAttribute("lista", servicio.buscarTodasLasPersonas());

        return "personas/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Model modelo,Persona persona) {
        
       servicio.salvarPersona(persona);
       //cargo datos que se muestran en la vista
       modelo.addAttribute("lista", servicio.buscarTodasLasPersonas());

        return "personas/lista";
    }


    @GetMapping("/borrar")
    public String borrar(Model modelo,String dni) {
        
       servicio.borrarPersona(new Persona(dni));
       //cargo datos que se muestran en la vista
       modelo.addAttribute("lista", servicio.buscarTodasLasPersonas());

        return "personas/lista";
    }

    @GetMapping("/detalle")
    public String detalle(Model modelo,String dni) {
        
       Persona persona=servicio.buscarUnaPersona(dni);
       //cargo datos que se muestran en la vista
       modelo.addAttribute("persona", persona);

        return "personas/detalle";
    }

    @GetMapping("/editar")
    public String editar (Model modelo,String dni) {
        
       Persona persona=servicio.buscarUnaPersona(dni);
       //cargo datos que se muestran en la vista
       modelo.addAttribute("persona", persona);

        return "personas/editar";
    }



    
}
