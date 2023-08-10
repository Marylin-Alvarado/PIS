/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cobos
 */
public class ConexionB {
    //https://www.codejava.net/java-se/jdbc/connect-to-oracle-database-via-jdbc
    private Connection connection;
    // Librería de MySQL
    public String driver = "oracle.jdbc.driver.OracleDriver";//oracle.jdbc.driver.OracleDriver

    // Nombre de la base de datos
    public String database = "xe";

    // Host
    public String hostname = "localhost";

    // Puerto
    public String port = "1521";//1521

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    //String aux = "jdbc:oracle:thin:@"+hostname+":"+port+":"+database;
    public String url = "jdbc:oracle:thin:@"+hostname+":"+port+":"+database;//"jdbc:oracle:thin:@"+hostname+":"+port+":"+database;

    // Nombre de usuario
    public String username = "pis_base";

    // Clave de usuario
    public String password = "123456789";

    private Connection conectar() {
        Connection conn = null;

        try {
            Class.forName(driver);


            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conected!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
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
        new ConexionB().conectar();
    }
    
    /*private XStream xstream;
    public static String URL = "data/";
    private void conectar() {         
        xstream = new XStream(new JettisonMappedXmlDriver());        
         xstream.setMode(XStream.NO_REFERENCES);
         xstream.addPermission(AnyTypePermission.ANY);
    }
    public XStream getXstream() {
        if(xstream == null)
            conectar();
        return xstream;
    }
    public void setXstream(XStream xstream) {
        this.xstream = xstream;
    }*/    

}
