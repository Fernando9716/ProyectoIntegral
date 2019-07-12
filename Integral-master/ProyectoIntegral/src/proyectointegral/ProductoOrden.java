/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegral;

import java.util.Vector;

/**
 *
 * @author Fabiola Vasquez
 */
public class ProductoOrden {
    private String nombre;
    private String observacion;
    private String cantidad;
    
    
    public ProductoOrden(String nombre, String observacion, String cantidad){
        this.nombre = nombre;
        this.observacion = observacion;
        this.cantidad = cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getObservacion() {
        return observacion;
    }

    public String getCantidad() {
        return cantidad;
    }   
}
