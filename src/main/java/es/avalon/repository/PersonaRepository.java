package es.avalon.repository;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.avalon.activerecord.DataBaseHelper;
import es.avalon.dominio.Persona;

public class PersonaRepository {


    public List<Persona> buscarTodos() {

        List<Persona> lista = new ArrayList<>();
        try (
                Connection con = DataBaseHelper.getConexion();
                PreparedStatement sentencia = con.prepareStatement("select * from Personas");) {
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {

                lista.add(new Persona(rs.getString("dni"),
                        rs.getString("nombre"), rs.getInt("edad")));
            }
            return lista;

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

        
    }
}