/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegral;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author caleb
 */
public class OrdenMesa {
    Conexion con;
    
    public OrdenMesa(){
       con = new Conexion(); 
    }
      
    //inserta una mesa con idconsecutivo y estado desocupado, regresa un true si se logro
    public boolean insertarmesa()
    {
         try{         
           PreparedStatement pstm = con.getConnection().prepareStatement("insert into ordenmesa (estado) values ('desocupado')");
           pstm.execute();
           pstm.close();
           return true;
          }catch(SQLException e){
         System.out.println(e);
        }
         
         return false;
    }
    
    //devuelve un true si funciona
    public boolean eliminarmesa(int numeromesa)
    {
        String mesa = Integer.toString(numeromesa);
         try {                
                PreparedStatement pstm = con.getConnection().prepareStatement("delete from ordenmesa where num_mesa= ?");
                //"delete from asiento where id_asiento = ? and id_sala = ? and num_fila = ? and estado = ?"
                pstm.setString(1, mesa);                   
                pstm.execute();
                pstm.close();  
                return true;
            }catch(SQLException e){
            System.out.println(e);
            }   

        return false;
    }
    
    //regresa un entero numero de mesas
    public int getNumerodeMesas()
    {
        int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(num_mesa) as total FROM ordenmesa ");
         
         try (ResultSet res = pstm.executeQuery()) {
              res.next();
              registros = res.getInt("total");
          }
          }catch(SQLException e){
         System.out.println(e);
        }
      
      return registros;
    }
    
    
    //regresa un true si esta desocupado 
    //regresa un false si esta ocupado
    public boolean getestado(int numeromesa)
    {
        
        String mesa = Integer.toString(numeromesa);
        try{
  
            PreparedStatement pstm = con.getConnection().prepareStatement("select estado from ordenmesa where num_mesa= ?");
            pstm.setString(1, mesa);   
            ResultSet res = pstm.executeQuery();
            res.next();
            return res.getString("estado").equalsIgnoreCase("desocupado");
            
        }catch(SQLException e)
        {
            System.out.println(e);
        }
        
        return false;        
    }
    
    
    //cambia de estado no importa cual sea
    public void setestado(int numeromesa)
    {
        String estado = "";
        String mesa = Integer.toString(numeromesa);
        if(getestado(numeromesa))
        {
           estado = "ocupado";
        }else
        {
            estado = "desocupado";
        }
         try{
            PreparedStatement pstm = con.getConnection().prepareStatement("update ordenmesa\n" +
            "set estado = '?'\n" +
            "where num_mesa = ?");
            pstm.setString(1, estado);
            pstm.setString(2, mesa);
            pstm.execute();
            pstm.close();
            
        }catch(SQLException e)
        {
            System.out.println(e);
        }
        
    }
    
    
    //devuelve la tabla entera en un arreglo vidimencional
     public Object [][] getDatosOrdenmesa(){
      int registros = 0;
      
      try{         
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(num_mesa) as total FROM ordenmesa ");
          try (ResultSet res = pstm.executeQuery()) {
              res.next();
              registros = res.getInt("total");
          }
      }catch(SQLException e){
         System.out.println(e);
      }  
       
      Object[][] data = new String[registros][2];  
    
      try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT" +
            " num_mesa, estado" +
            " FROM ordenmesa" +
            " ORDER BY num_mesa ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
             int numMesa = res.getInt("num_mesa");
             String estado = res.getString("estado");
             data[i][0] = numMesa;            
             data[i][1] = estado;
             i++;
         }
         res.close();
         }catch(SQLException e){
         System.out.println(e);
         }
    return data;
   }
    
   //devuelve los datos de los cliente que estan en una mesa
   public ArrayList<String> getDatosmesa(int num_mesa)
   {
       ArrayList<String> dom = new ArrayList<String>();

         try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("select c.sexo, c.color, c.edadBiologica\n" +
"from clienterestaurante c\n" +
"inner join cliente_ordenrestaurante cor\n" +
"on c.idclienteRes = cor.idclienteRes\n" +
"inner join cliente_ordenmesa o\n" +
"on cor.idorden = o.idorden\n" +
"where o.num_mesa = ?;");
         pstm.setInt(1, num_mesa );
         ResultSet res = pstm.executeQuery();
         //int i = 0;
         
         while(res.next()){
             
             String sexo = res.getString("sexo");
             String color = res.getString("color");
             String edad = res.getString("edadBiologica");
             String Datos = sexo + color + edad;
             dom.add(Datos);
            }
         res.close();
         }catch(SQLException e){
         System.out.println(e);
         }
         return dom;
   }
}
