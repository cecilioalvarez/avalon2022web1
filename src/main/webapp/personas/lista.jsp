<%@page import="java.util.List"%>
<%@page import="es.avalon.dominio.*"%>
<%List<Persona> lista=(List<Persona>)request.getAttribute("lista");%>

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
            <td><%=p.getDni()%></td>
            <td><%=p.getNombre()%></td>
            <td><%=p.getEdad()%></td>
            <td><a href="/web1/controlador?accion=borrarpersona&dni=<%=p.getDni()%>">borrar</a></td>
        </tr>
        <%}%>
    </table>
    <a href="/web1/controlador?accion=formulariopersona">Insertar</a>
  </body>
</html>