<%@page import="java.util.List"%>
<%@page import="es.avalon.repository.*"%>
<%@page import="es.avalon.dominio.*"%>

<%
LibroRepository repositorio= new LibroRepository();
List<Libro> lista=repositorio.buscarTodos();
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
        <%for (Libro l:lista) { %>
        <tr>
            <td><%=l.getIsbn()%></td>
            <td><%=l.getTitulo()%></td>
            <td><%=l.getAutor()%></td>
            <td><a href="borrar.jsp?isbn=<%=l.getIsbn()%>">borrar</a></td>
        </tr>
        <%}%>
    </table>
    <a href="formulario.jsp">Insertar</a>
  </body>
</html>