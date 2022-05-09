<%@page import="java.util.List"%>
<%@page import="es.avalon.repository.*"%>
<%@page import="es.avalon.dominio.*"%>

<%
PersonaRepository repositorio= new PersonaRepository();
List<Persona> lista=repositorio.buscarTodos();
%>

<html>
  <body>

    <table>
        <tr>
            <th>
                dni
            </th>
            <th>
                nombre
            </th>
            <th>
                edad
            </th>
        </tr>
        <%for (Persona p:lista) { %>
        <tr>
            <td><%=p.getNombre()%></td>
        </tr>
        <%}%>
    </table>

  </body>
</html>