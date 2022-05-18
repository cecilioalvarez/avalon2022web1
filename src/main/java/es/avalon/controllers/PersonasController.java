package es.avalon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "lista";
    }
    
}
