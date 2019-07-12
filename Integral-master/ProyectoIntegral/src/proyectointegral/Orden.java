/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegral;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 *
 * @author caleb
 */
public class Orden {
    private ArrayList<ObjOrden> ordenes;    
    Conexion con;
    
    public Orden(){
        ordenes = new ArrayList<>();
       con = new Conexion(); 
    }
    
    //regresa la lista con Strings de productos de una orden
     public Object [] getProductos(int numeroorden){
      
         int registros = 0;
         String idorden = Integer.toString(numeroorden);
      try{         
         PreparedStatement pstm = con.getConnection().prepareStatement("select count(p.nombre) as total \n" +
        "from orden_producto o\n" +
        "inner join producto p\n" +
        "on o.idproducto = p.idproducto\n" +
        "where idorden= ?");
         pstm.setString(1, idorden);
          try (ResultSet res = pstm.executeQuery()) {
              res.next();
              registros = res.getInt("total");
          }
      }catch(SQLException e){
         System.out.println(e);
      }  

      Object[] data = new String[registros];  

      try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("select p.nombre \n" +
        "from orden_producto o\n" +
        "inner join producto p\n" +
        "on o.idproducto = p.idproducto\n" +
        "where idorden= ?");
         pstm.setString(1, idorden);
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
             String nombre = res.getString("nombre");
             data[i] = nombre;            
             i++; 
         }
         res.close();
         }catch(SQLException e){
         System.out.println(e);
         }
    return data;
    }  
    
     
    //regresa una listaBidi de los productos su descripcion y cantidad de una sola orden
     public Object [][] getProductosconDescripcion(int numeroorden){
      int registros = 0;
      String idorden = Integer.toString(numeroorden);
     try{         
         PreparedStatement pstm = con.getConnection().prepareStatement("select count(p.nombre) as total \n" +
        "from orden_producto o\n" +
        "inner join producto p\n" +
        "on o.idproducto = p.idproducto\n" +
        "where idorden= ?");
         pstm.setString(1, idorden);
          try (ResultSet res = pstm.executeQuery()) {
              res.next();
              registros = res.getInt("total");
          }
      }catch(SQLException e){
         System.out.println(e);
      }  

      Object[][] data = new String[registros][3];  

      try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("select p.nombre, o.observacion, o.cantidad \n" +
        "from orden_producto o\n" +
        "inner join producto p\n" +
        "on o.idproducto = p.idproducto\n" +
        "where idorden= ?");
         pstm.setString(1, idorden);
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
             String nombre = res.getString("nombre");
             String observacion = res.getString("observacion");
             String cantidad = res.getString("cantidad");
             data[i][0] = nombre;            
             data[i][1] = observacion;
             data[i][2] = cantidad;
             
             i++;
             
         }
         res.close();
         }catch(SQLException e){
         System.out.println(e);
         }
    return data;
    }
    
    public String getFecha(int numeroorden)
    {
        String fecha= "";
        String idorden = Integer.toString(numeroorden);
        try{
  
            PreparedStatement pstm = con.getConnection().prepareStatement("select fecha from orden where idorden = ?");
            pstm.setString(1, idorden);   
            ResultSet res = pstm.executeQuery();
            res.next();
            fecha = res.getString("fecha");
            
        }catch(SQLException e)
        {
            System.out.println(e);
        }
        
        return fecha;      
    }
    
    public String gettipo(int numeroorden)
    {
        String tipo= "";
        String idorden = Integer.toString(numeroorden);
        try{
  
            PreparedStatement pstm = con.getConnection().prepareStatement("select tipo from orden where idorden = ?");
            pstm.setString(1, idorden);   
            ResultSet res = pstm.executeQuery();
            res.next();
            tipo = res.getString("tipo");
            
        }catch(SQLException e)
        {
            System.out.println(e);
        }
        
        return tipo;      
    }
    
    public String getestadoOrden(int numeroorden)
    {
        String estado= "";
        String idorden = Integer.toString(numeroorden);
        try{
  
            PreparedStatement pstm = con.getConnection().prepareStatement("select estadoOrden from orden where idorden = ?");
            pstm.setString(1, idorden);   
            ResultSet res = pstm.executeQuery();
            res.next();
            estado = res.getString("estadoOrden");
            
        }catch(SQLException e)
        {
            System.out.println(e);
        }
        
        return estado;      
    }
    
    //cambia el estado de la orden de tomado a atendido o de atendido a pagado
    public void setEstadoOrden(int numeroorden)
    {
        String idorden = Integer.toString(numeroorden);
        String estado="";
        if(getestadoOrden(numeroorden).equalsIgnoreCase("tomado"))
        {
            estado = "atendido";
        }
        if(getestadoOrden(numeroorden).equalsIgnoreCase("atendido"))
        {
            estado = "pagado";
        }
        
        try{
  
            PreparedStatement pstm = con.getConnection().prepareStatement("update orden set estadoOrden = '?' where idorden=?");
            pstm.setString(1, estado);
            pstm.setString(2, idorden);
            pstm.execute();
            pstm.close();
            
        }catch(SQLException e)
        {
            System.out.println(e);
        }
        
        
    }
            
    
     // regresa los datos de la entidad como una tabla
     public Object [][] getDatosOrdenmesa(){
      int registros = 0;

      try{         
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT  count(idorden) as total FROM orden ");
          try (ResultSet res = pstm.executeQuery()) {
              res.next();
              registros = res.getInt("total");
          }
      }catch(SQLException e){
         System.out.println(e);
      }  

      Object[][] data = new String[registros][4];  

      try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT * FROM orden order by idorden;");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
             int idorden = res.getInt("idorden");
             String fecha = res.getString("fecha");
             String tipo = res.getString("tipo");
             String estadoOrden = res.getString("estadoOrden");
             data[i][0] = idorden;            
             data[i][1] = fecha;
             data[i][2] = tipo;
             data[i][3] = estadoOrden;
             
             i++;
             
         }
         res.close();
         }catch(SQLException e){
         System.out.println(e);
         }
    return data;
    }
     
     //regreso lista de nombres que han pedido una orden
   
     public ArrayList<String> getnombresDomicilio()
     {
         ArrayList<String> dom = new ArrayList<String>();

         try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("select cd.nombre\n" +
"from orden o \n" +
"inner join cliente_ordendomicilio c\n" +
"on o.idorden = c.idorden\n" +
"inner join clientedomicilio cd\n" +
"on c.idCliente = cd.idCliente;");
         ResultSet res = pstm.executeQuery();
         //int i = 0;
         
         while(res.next()){
             System.out.println(res.getString("nombre"));
             String nombre = res.getString("nombre");
             dom.add(nombre);
            }
         res.close();
         }catch(SQLException e){
         System.out.println(e);
         }
         return dom;
     }
     //devuelve una lista de mesas con ordenes atendidas
public ArrayList<String> getMesasOcupadas()
     {
         ArrayList<String> dom = new ArrayList<String>();

         try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("select c.num_mesa\n" +
"from orden o\n" +
"inner join cliente_ordenrestaurante co\n" +
"on o.idorden = co.idorden\n" +
"inner join cliente_ordenmesa c\n" +
"on co.idorden = c.idorden\n" +
"where o.estadoOrden = 'atendido'; ");
         ResultSet res = pstm.executeQuery();
         //int i = 0;
         
         while(res.next()){
             //System.out.println(res.getString("nombre"));
             String num_mesa = res.getString("num_mesa");
             dom.add(num_mesa);
            }
         res.close();
         }catch(SQLException e){
         System.out.println(e);
         }
         
         return dom;
         
     }

public ArrayList<String> getProductosOrden(String nombre)
     {
         ArrayList<String> dom = new ArrayList<String>();

         try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("select p.nombre as nombre\n" +
"from producto p \n" +
"inner join orden_producto op \n" +
"on p.idproducto = op.idproducto\n" +
"inner join orden o \n" +
"on op.idorden = o.idorden \n" +
"inner join cliente_ordendomicilio co \n" +
"on o.idorden = co.idorden \n" +
"inner join clientedomicilio cd \n" +
"on co.idCliente = cd.idCliente\n" +
"where cd.nombre = ? ");
         pstm.setString(1 , nombre);
         ResultSet res = pstm.executeQuery();
         
         while(res.next()){
             System.out.println(res.getString("nombre"));
             String nom = res.getString("nombre");
             dom.add(nom);
            }
         res.close();
         }catch(SQLException e){
         System.out.println(e);
         }
         
         return dom;
         
     }


     public ArrayList<String> getComensalesmesa(int mesa)
     {
         ArrayList<String> dom = new ArrayList<String>();

         try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("select sexo, color, edadBiologica\n" +
"from clienterestaurante cr\n" +
"inner join cliente_ordenrestaurante cor\n" +
"on cr.idclienteRes = cor.idclienteRes\n" +
"inner join cliente_ordenmesa com\n" +
"on cor.idorden = com.idorden\n" +
"inner join ordenmesa o\n" +
"on com.num_mesa = o.num_mesa\n" +
"where o.num_mesa = ?;");
         pstm.setInt(1 , mesa);
         ResultSet res = pstm.executeQuery();
         
         while(res.next()){
             String sexo = res.getString("sexo");
             String color = res.getString("color");
             String nom = res.getString("edadBiologica");
             String desc = sexo + " " + color +  " " + nom ;
             dom.add(desc);
            }
         res.close();
         }catch(SQLException e){
         System.out.println(e);
         }
         
         return dom;
         
     }
    
             public static void main(String[] args) {
        Orden o = new Orden();
       // o.getProductosOrden("Risa Turner");
        
    }
}
