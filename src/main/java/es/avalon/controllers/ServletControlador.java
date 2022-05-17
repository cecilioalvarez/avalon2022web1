package es.avalon.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.avalon.dominio.Persona;
import es.avalon.services.LibroPersonaService;
import es.avalon.springconfiguracion.ConfiguradorSpring;

// /controlador como url--->lista.jsp

public class ServletControlador extends HttpServlet {

    LibroPersonaService servicio ;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        ApplicationContext contexto= new AnnotationConfigApplicationContext(ConfiguradorSpring.class);
        servicio=contexto.getBean(LibroPersonaService.class);


        if (request.getParameter("accion") != null) {

            if (request.getParameter("accion").equals("formulariopersona")) {
                RequestDispatcher despachador = request.getRequestDispatcher("personas/formulario.jsp");
                despachador.forward(request, response);
            }else if (request.getParameter("accion").equals("borrarpersona")) {

                String dni=request.getParameter("dni");
                Persona p= new Persona(dni);
                
                servicio.borrarPersona(p);
                cargarLista(request, response);

            } 
            else if (request.getParameter("accion").equals("insertarpersona")) {

                String dni = request.getParameter("dni");
                String nombre = request.getParameter("nombre");
                int edad = Integer.parseInt(request.getParameter("edad"));
                Persona p = new Persona(dni, nombre, edad);
                servicio.insertarPersona(p);
                cargarLista(request, response);
            }

            else if (request.getParameter("accion").equals("detallepersona")) {

                String dni = request.getParameter("dni");
                Persona p= servicio.buscarUnaPersona(dni);
                request.setAttribute("persona", p);
                RequestDispatcher despachador = request.getRequestDispatcher("personas/detalle.jsp");
                despachador.forward(request, response);

            }

        } else {
            cargarLista(request, response);
        }

        // lista personas que podría ser tu lista de yogures

    }

    private void cargarLista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Persona> listaPersonas = servicio.buscarTodosConLibros();
        // oye a que tienda van a ir los yogures a que vista de la aplicacion
        RequestDispatcher despachador = request.getRequestDispatcher("personas/lista.jsp");
        // añadir datos para la vista
        request.setAttribute("lista", listaPersonas);
        despachador.forward(request, response);
    }
}
