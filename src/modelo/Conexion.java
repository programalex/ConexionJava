/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
/**
 *
 * @author alexander
 */
public class Conexion {
    private static com.mysql.jdbc.Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String passwore = "artealex123";
    private static final String url = "jdbc:mysql://localhost:3306/alex";

    public static PreparedStatement PreparedStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Conexion(){
    conn = null;
    try {
        Class.forName (driver);
        conn = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, user, passwore);
        if (conn != null){
            System.out.println("Conexion establecida...");
        }
    }catch (ClassNotFoundException | SQLException e){
      System.out.println("error al conectar" + e);
    }
    }
    // metodo que retorna conexion
    public com.mysql.jdbc.Connection getConnection(){
        return conn;
    }
    // metodo que desconecta db
     public void desconectar (){
    conn = null;
    if (conn == null){
        System.out.println("Conexion terminada");
    }
}
}
