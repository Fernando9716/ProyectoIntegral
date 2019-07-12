/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegral;
import java.sql.*;
/**
 *
 * @author Fabiola Vasquez
 */
public class Conexion {
    String db_url = "jdbc:mysql://localhost/comedor";
    String user = "root";
    String pass = "fava26";

    Connection connection = null;
    
    
    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
           
        }catch (ClassNotFoundException e) {
            System.err.println("El controlador MySQL JDBC no se encuentra. Incluirlo en la ruta de tu biblioteca");
        }
        try {
            connection = DriverManager.getConnection(db_url, user, pass);
            if (connection != null) {
            System.out.println("Se ha conectado con éxito a la base de datos");
            } else { System.out.println("Error al hacer conexión a la base de datos");}
        }
        catch (SQLException e) {
            System.err.println("La conexión falló");
        }
        
        
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    public void desconectar(){ 
       connection = null; 
   } 
    
    public static void main(String[] args) {
        Conexion c = new Conexion();
  }
   
}
