/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegral;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author caleb
 */
public class ObjOrden {
    private int idOrden;
    private Date fecha;
    private String tipo;
    private String estado;
   
    
    public ObjOrden(int idOrden, Date fecha, String tipo, String estado)
    {
        this.idOrden = idOrden;
        this.fecha = fecha;
        this.tipo = tipo;
        this.estado = estado;
        
    }
    
    public void setidOrden(int idOrden)
    {
        this.idOrden = idOrden;
    }
    public int getidOrden()
    {
        return idOrden;
    }
    
    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }
    public String getTipo(){
        return tipo;
    }
    public void setestado(String estado)
    {
        this.estado = estado;
    }
    public String getEstado(){
        return estado;
    }
    
    public String getFechatoString() {  
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(fecha);
    }
    public Date getfecha()
    {
        return fecha;
    }
    
}
