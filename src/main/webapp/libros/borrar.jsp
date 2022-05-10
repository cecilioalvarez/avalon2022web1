<%@page import="java.util.List"%>
<%@page import="es.avalon.services.*"%>
<%@page import="es.avalon.dominio.*"%>

<% 
// crear un repositorio
LibroPersonaService servicio= new LibroPersonaService();
// leer de la web los datos de la persona
String isbn=request.getParameter("isbn");


// crear una persona en memoria
Libro l= new Libro(isbn);
// usar el repositorio para acceder a la base de datos e insertar
servicio.borrar(l);
// volver a cargar el listado con los datos nuevos
response.sendRedirect("lista.jsp");


%>