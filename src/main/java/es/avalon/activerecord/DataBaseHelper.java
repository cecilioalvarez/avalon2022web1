package es.avalon.activerecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseHelper {

    public static Connection getConexion() throws SQLException, IOException {

        Properties propiedades = new Properties();
        InputStream in= DataBaseHelper.class.getClassLoader().getResourceAsStream("database.properties");
        propiedades.load(in);
        return DriverManager.getConnection(propiedades.getProperty("url"), propiedades.getProperty("usuario"), propiedades.getProperty("clave"));

    }
}
