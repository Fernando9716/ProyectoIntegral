/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegral;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author David
 */
public class Main {
    public static void main(String []args){
        ArrayList<Producto> productos=new ArrayList();
        Producto []comida={new Producto(0,0, "algo", "descripcion", 5, 5, "adssad", "asd"),
        new Producto(0,0, "algo", "descripcion", 1, 1, "adssad", "asd"),
        new Producto(0,0, "algo", "descripcion", 2, 2, "adssad", "asd"),
        new Producto(0,0, "algo", "descripcion", 3, 3, "adssad", "asd"),
        new Producto(0,0, "algo", "descripcion", 4, 4, "adssad", "asd"),
        new Producto(0,0, "algo", "descripcion", 5, 5, "adssad", "asd"),
        new Producto(0,0, "algo", "descripcion", 6, 6, "adssad", "asd"),
        new Producto(0,0, "algo", "descripcion", 7, 7, "adssad", "asd"),
        new Producto(0,0, "algo", "descripcion", 8, 8, "adssad", "asd"),
        new Producto(0,0, "algo", "descripcion", 9, 9, "adssad", "asd"),
        new Producto(0,0, "algo", "descripcion", 0, 0, "adssad", "asd")};
        /*VistaOrden prueba=new VistaOrden(comida);
        prueba.agregaComensal(comida);
        prueba.agregaComensal(comida);
        prueba.agregaComensal(comida);prueba.agregaComensal(comida);*/
        VistaOrdenDomicilio prueba2=new VistaOrdenDomicilio(comida);
        VistaRecepcionOrdenes prueba3 =new VistaRecepcionOrdenes();
        prueba3.agregarOrden(comida);
        prueba3.agregarOrden(comida);
        prueba3.agregarOrden(comida);
        prueba3.agregarOrden(comida);
        prueba3.agregarOrden(comida);
        prueba3.agregarOrden(comida);
        prueba3.agregarOrden(comida);
        prueba3.agregarOrden(comida);
        prueba3.agregarOrden(comida);
        prueba3.agregarOrden(comida);
        prueba3.agregarOrden(comida);
        prueba3.agregarOrden(comida);
        prueba3.agregarOrden(comida);
        
    }
}
