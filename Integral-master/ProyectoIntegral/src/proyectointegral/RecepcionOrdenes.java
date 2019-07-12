/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegral;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
public class RecepcionOrdenes extends JFrame{
    private ArrayList<Orden> mesas;
    private JPanel contenedor;
    public RecepcionOrdenes(){
        contenedor = new JPanel();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void agregarOrdenes(ArrayList<Orden> ordenes){
        
    }
}
