<%@page import="java.util.List"%>
<%@page import="es.avalon.services.*"%>
<%@page import="es.avalon.dominio.*"%>

<% 
// crear un repositorio
LibroPersonaService servicio= new LibroPersonaService();
// leer de la web los datos de la persona
String dni=request.getParameter("isbn");
String nombre=request.getParameter("titulo");
int edad=Integer.parseInt(request.getParameter("autor"));

// crear una persona en memoria
Libro l= new Libro(isbn,titulo,autor);
// usar el repositorio para acceder a la base de datos e insertar
servicio.insertarLibro(l);
// volver a cargar el listado con los datos nuevos
response.sendRedirect("lista.jsp");


%>