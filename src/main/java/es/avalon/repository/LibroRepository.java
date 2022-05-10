package es.avalon.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.avalon.activerecord.DataBaseHelper;
import es.avalon.dominio.Libro;

public class LibroRepository {

    public List<Libro> buscarTodos() {

        List<Libro> lista = new ArrayList<>();
        try (
                Connection con = DataBaseHelper.getConexion();
                PreparedStatement sentencia = con.prepareStatement("select * from Libros");) {
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {

                lista.add(new Libro(rs.getString("isbn"),
                        rs.getString("titulo"), rs.getString("autor")));
            }
            return lista;

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void borrar(Libro libro) {

        try (
                Connection con = DataBaseHelper.getConexion();
                PreparedStatement sentencia = con.prepareStatement(" delete from Libros where isbn=?");) {
            sentencia.setString(1, libro.getIsbn());
            sentencia.executeUpdate();

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }

}