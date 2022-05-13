<%@page import="java.util.List"%>
<%@page import="es.avalon.repository.*"%>
<%@page import="es.avalon.dominio.*"%>

<% 
// crear un repositorio
PersonaRepository repo= new PersonaRepository();
// leer de la web los datos de la persona
String dni=request.getParameter("dni");


// crear una persona en memoria
Persona p= new Persona(dni);
// usar el repositorio para acceder a la base de datos e insertar
repo.borrar(p);
// volver a cargar el listado con los datos nuevos
response.sendRedirect("lista.jsp");


%>