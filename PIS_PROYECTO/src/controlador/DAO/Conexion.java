/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cobos
 */
public class Conexion {
      //https://www.codejava.net/java-se/jdbc/connect-to-oracle-database-via-jdbc
    private Connection connection;
    // Librería de MySQL
    public String driver = "com.mysql.cj.jdbc.Driver";//oracle.jdbc.driver.OracleDriver

    // Nombre de la base de datos
    public String database = "pis";

    // Host
    public String hostname = "localhost";

    // Puerto
    public String port = "3306";//1521

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    //String aux = "jdbc:oracle:thin:@"+hostname+":"+port+":"+database;
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";//"jdbc:oracle:thin:@"+hostname+":"+port+":"+database;

    // Nombre de usuario
    public String username = "root";

    // Clave de usuario
    public String password = "123456789";

    private Connection conectar() {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conected!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public Connection getConnection() {
        if(connection == null)
            connection = conectar();
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public static void main(String[] args) {
        new Conexion().conectar();
    }
}
