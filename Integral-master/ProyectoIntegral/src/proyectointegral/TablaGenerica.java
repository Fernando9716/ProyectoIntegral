/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegral;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David
 */
public class TablaGenerica extends JTable{
    private DefaultTableModel modelo;
    
    public TablaGenerica(/*ArrayList<Producto> productos*/Vector<ProductoOrden> productos){
        modelo=new DefaultTableModel(0,3);
        for(ProductoOrden producto:productos){
            String [] datos={producto.getNombre(),producto.getObservacion(),producto.getCantidad()+""};
            modelo.addRow(datos);
        }
        this.setModel(modelo);
        this.setPreferredScrollableViewportSize(new Dimension(500,500));
    }
    public TablaGenerica(/*ArrayList<Producto> productos*/Producto [] productos,String []encabezado){
        modelo=new DefaultTableModel(encabezado,0);
        for(Producto producto:productos){
            String [] datos={producto.getNombre(),/*producto.getObservaciones()*/"Observaciones",producto.getCantidad()+""};
            modelo.addRow(datos);
        }
        this.setModel(modelo);
        this.setPreferredScrollableViewportSize(new Dimension(500,500));
    }
    public TablaGenerica(/*ArrayList<Producto> productos*/Producto [] productos,String []encabezado,int i){
        modelo=new DefaultTableModel(encabezado,0);
        for(Producto producto:productos){
            String [] datos={producto.getNombre(),/*producto.getObservaciones()*/"Observaciones",producto.getCantidad()+"","comensal"};
            modelo.addRow(datos);
        }
        this.setModel(modelo);
        this.setPreferredScrollableViewportSize(new Dimension(500,500));
    }
    //orden contendra a los productos modificar**
    /*public TablaGenerica(String datos[][],Producto[]productos,String[] encabezados){
        String datos[][]=new String[productos.length][encabezados.length];
        for(int i=0;i<productos.length;i++){
            String
        }
    }*/
}
