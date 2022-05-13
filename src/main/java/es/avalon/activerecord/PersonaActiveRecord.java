package es.avalon.activerecord;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaActiveRecord {

    private String dni;
    private String nombre;
    private int edad;

    public PersonaActiveRecord(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }



    public void insertar() {

        try (
                Connection con = DataBaseHelper.getConexion();
                PreparedStatement sentencia = con
                        .prepareStatement("insert into Personas (dni,nombre,edad) values (?,?,?)");) {
            sentencia.setString(1, getDni());
            sentencia.setString(2, getNombre());
            sentencia.setInt(3, getEdad());
            sentencia
                    .executeUpdate();

        } catch (SQLException | IOException e) {
           throw new RuntimeException(e);
        }
    }

    public void borrar() {

        try (
                Connection con = DataBaseHelper.getConexion();
                PreparedStatement sentencia = con.prepareStatement(" delete from Personas where dni=?");) {
            sentencia.setString(1, getDni());
            sentencia.executeUpdate();

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void actualizar() {
        try (
                Connection con = DataBaseHelper.getConexion();
                PreparedStatement sentencia = con.prepareStatement("update Persona set nombre=?,edad=? where dni=?");) {
            sentencia.setString(1, getNombre());
            sentencia.setInt(2, getEdad());
            sentencia.setString(3, getDni());


        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static PersonaActiveRecord buscarUno(String dni) {

        try (
                Connection con = DataBaseHelper.getConexion();
                PreparedStatement sentencia = con.prepareStatement("select * from Personas  where dni=?");) {
            sentencia.setString(1, dni);
            ResultSet rs = sentencia.executeQuery();
            rs.next();
            return new PersonaActiveRecord(rs.getString("dni"),
                    rs.getString("nombre"), rs.getInt("edad"));

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<PersonaActiveRecord> buscarTodos() {
        List<PersonaActiveRecord> lista = new ArrayList<>();
        try (
                Connection con = DataBaseHelper.getConexion();
                PreparedStatement sentencia = con.prepareStatement("select * from Personas");) {
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {

                lista.add(new PersonaActiveRecord(rs.getString("dni"),
                        rs.getString("nombre"), rs.getInt("edad")));
            }
            return lista;

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }


    }

}
