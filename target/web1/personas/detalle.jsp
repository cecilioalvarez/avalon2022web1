<%@page import="es.avalon.dominio.*"%>
<% 
Persona p= (Persona)request.getAttribute("persona");

%>
<%=p.getDni()%>
<%=p.getNombre()%>
<%=p.getEdad()%>