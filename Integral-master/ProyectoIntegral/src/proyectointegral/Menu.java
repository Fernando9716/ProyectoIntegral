/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegral;

import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author caleb
 */
public class Menu {
    private ArrayList<Producto> menu;
    Conexion con;
    int registros;
    
    public Menu()
    {
        menu = new ArrayList<>();
        con = new Conexion();
    }
    
    public void agregarProducto(Producto producto)
    {
        menu.add(producto);
    }
    
    public void eliminarProducto(int i)
    {
        menu.remove(i);
    }
    
    public ArrayList<Producto> getmenu()
    {
        return menu;
    }
    public void getDatosProducto(){
      registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT" +
            " idproducto, idmenu, nombre, descripcion, precio, cantidad, clasificacion, tipo" +
            " FROM producto" +
            " ORDER BY idproducto ");
         ResultSet res = pstm.executeQuery();
         //int i = 0;
         while(res.next()){
             System.out.println(res.getString("nombre"));
            int idProducto = Integer.parseInt(res.getString("idproducto"));
            int idMenu = Integer.parseInt(res.getString("idmenu"));
            String nombre = res.getString("nombre");
            String descripcion = res.getString("descripcion");
            float precio = Float.parseFloat(res.getString("precio"));
            int cantidad = Integer.parseInt(res.getString("cantidad"));
            String clasificacion = res.getString("clasificacion");
            String tipo = res.getString("tipo");
            
            Producto tmp = new Producto(idProducto,
                                        idMenu,
                                        nombre,
                                        descripcion,
                                        precio,
                                        cantidad,
                                        clasificacion,
                                        tipo);
             agregarProducto(tmp);
           // i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
         }
    }
   public String getTipoMenu(String nombre)
    {
        for(Producto item : menu)
        {
            if (item.getNombre().equals(nombre))
                if(item.getIdMenu()==2)return "A la carta";
                else return "Menu del dia";
        }
        return "NO EXISTE";
    }
}
