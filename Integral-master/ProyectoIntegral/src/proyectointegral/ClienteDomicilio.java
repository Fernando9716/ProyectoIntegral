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
public class ClienteDomicilio{
    private int idCliente;
    private String nombre;
    private String direccion;
    
    public ClienteDomicilio(int idCliente, String nombre, String direccion)
    {
        setidCliente(idCliente);
        setnombre(nombre);
        setdireccion(direccion);
    }
    
    public void setidCliente(int idCliente)
    {
        this.idCliente = idCliente;
    }
    public int getidCliente()
    {
        return idCliente;
    }
    
    public void setnombre(String nombre)
    {
        this.nombre = nombre;
    }
    public String getnombre()
    {
        return nombre;
    }
    
    public void setdireccion(String direccion)
    {
        this.direccion = direccion;
    }
    public String getdireccion()
    {
        return direccion;
    }
}
