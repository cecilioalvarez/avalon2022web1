package es.avalon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.avalon.services.LibroPersonaService;

@Controller
public class PersonasController {

    @Autowired
    LibroPersonaService servicio;   
    @GetMapping("/lista")
    public String lista(Model modelo) {

        return "lista";
    }
    
}
