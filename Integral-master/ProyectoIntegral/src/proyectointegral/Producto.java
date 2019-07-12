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
public class Producto {
    private int idProducto;
    private String nombre;
    private String descripcion;
    private float precio;
    private int cantidad;
    private String clasificacion;
    private String tipo;
    private int idMenu;
   
    public Producto(int idProducto,int idMenu, String nombre,String descripcion,float precio,int cantidad,String clasificacion,String tipo)
    {
        this.idProducto= idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio= precio;
        this.cantidad = cantidad;
        this.clasificacion = clasificacion;
        this.tipo = tipo;
        this.idMenu = idMenu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    } 

    public int getIdProducto() {
        return idProducto;
    }

    public int getIdMenu() {
        return idMenu;
    }
    
}