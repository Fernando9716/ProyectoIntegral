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
public class ClienteFactura {
    private int idFactura;
    private int idCliente;
    private String rfc;
    private String razonSocial;
    private String direccion;
    private String correo;
    private int telefono;
    
    public ClienteFactura(int idFactura, int idCliente, String rfc, String razonSocial, String direccion, String correo, int telefono)
    {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.rfc = rfc;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;       
    }
    
    public void setidFactura(int idFactura)
    {
        this.idFactura = idFactura;
    }
    public int getidFactura()
    {
        return idFactura;
    }
    
    public void setidCliente(int idCliente)
    {
        this.idCliente = idCliente;
    }
    public int getidClinete()
    {
        return idCliente;
    }
    
    public void setrfc(String rfc)
    {
        this.rfc = rfc;
    }
    public String getrfc()
    {
        return rfc;
    }
    
    public void setrazonSocial(String razonSocial)
    {
        this.razonSocial = razonSocial;
    }
    public String getrazonSocial()
    {
        return razonSocial;
    }
    
    public void setdireccion(String direccion)
    {
        this.direccion = direccion;
    }
    public String getdireccion()
    {
        return direccion;
    }
    
    public void setcorreo(String correo)
    {
        this.correo = correo;
    }
    public String getcorreo()
    {
        return correo;
    }
    
    public void settelefono(int telefono)
    {
        this.telefono = telefono;
    }
    public int gettelefono()
    {
        return telefono;
    }
    
}
