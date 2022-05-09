package es.avalon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.avalon.dominio.Persona;

import es.avalon.repository.PersonaRepository;

public class HolaServlet extends HttpServlet {
    

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

            PrintWriter pw= response.getWriter();
            PersonaRepository repositorio= new PersonaRepository();
            List<Persona> lista=repositorio.buscarTodos();
            for (Persona persona:lista) {

                pw.println("<p>"+persona.getDni()+"</p>");
                pw.println("<p>"+persona.getNombre()+"</p>");
                pw.println("<p>"+persona.getEdad()+"</p>");
              
            }
         


        
    }
}
