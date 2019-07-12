/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegral;

/**
 *
 * @author caleb
 */
public class Utensilio {
    private int idUtensilio;
    private String nombre;
    private int cantidad;
    
    public Utensilio(int idUtensilio, String nombre, int cantidad)
    {
        this.idUtensilio = idUtensilio;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    
    public void setidUtensilio(int idUtensilio)
    {
        this.idUtensilio = idUtensilio;
    }
    public int getidUtensilio()
    {
        return idUtensilio;
    }
    
    public void setnombre(String nombre)
    {
        this.nombre = nombre;
    }
    public String geetnombre()
    {
        return nombre;
    }
    
    public void setcantidad(int cantidad)
    {
        this.cantidad = cantidad;
    }
    public int getcantidad()
    {
        return cantidad;
    }
}
