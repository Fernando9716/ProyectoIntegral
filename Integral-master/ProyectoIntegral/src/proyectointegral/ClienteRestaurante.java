/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegral;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author caleb
 */
public class ClienteRestaurante {
    Conexion con;
    private String sexo;
    private String color;
    private String edadBiologica;

    
    
    public ClienteRestaurante(String sexo, String color, String edadBiologica)
    {
        con = new Conexion();
        agregarClienteRes(sexo,color,edadBiologica);
    }
    
    /*Agrega un cliente a la base de datos, este método se utiliza cuando se selecciona Aceptar en DescripcionComenzalVentana*/
    public void agregarClienteRes(String sexo, String color, String edadBiologica){
       try {            
           try (PreparedStatement pstm = con.getConnection().prepareStatement
        ("insert into clienterestaurante(sexo, color, edadBiologica) values(?,?,?)")) {
               pstm.setString(1, sexo);
               pstm.setString(2, color);
               pstm.setString(3, edadBiologica);                                                
               pstm.execute();
               pstm.close();
           }            
         }catch(SQLException e){
         System.out.println(e);
       }
       
       
   }
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEdadBiologica() {
        return edadBiologica;
    }

    public void setEdadBiologica(String edadBiologica) {
        this.edadBiologica = edadBiologica;
    }
    
    public int getUltimoCliente()
    {
        int idCliente = 0;
         try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("select idclienteRes\n" +
"from clienterestaurante\n" +
"order by idclienteRes\n" +
"desc limit 1;");
         ResultSet res = pstm.executeQuery();
         //int i = 0;
         while(res.next()){
             
             idCliente = res.getInt("idclienteRes");
             
            }
         res.close();
         }catch(SQLException e){
         System.out.println(e);
         }
         
         return idCliente;    
    }
}
