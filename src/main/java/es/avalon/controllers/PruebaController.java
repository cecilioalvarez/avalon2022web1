package es.avalon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pruebas")
public class PruebaController {

    @GetMapping("/001")
    public String pagina1() {

        return "jspruebas/001";

    }
    @GetMapping("/002")
    public String pagina2() {

        return "jspruebas/002";

    }
    
}
