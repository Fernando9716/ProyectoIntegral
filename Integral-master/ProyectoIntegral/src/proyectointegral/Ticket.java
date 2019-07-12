/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegral;

/**
 *
 * @author luis9
 */
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.*;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ticket extends JFrame implements ActionListener{
    private JFrame ticket;
    private Font fuenteticket,fuenteticket2;
    private Color moradoticket;
    private JButton finalizar , volverticket;
    private JTextField ticke,factura,total,cantidad,cambio,total2,cantidad2,cambio2;
    private JCheckBox facturacheck;
    private JPanel panelticket, panelticket1,panelticket2,panelticket3,panelticket4,panelticket5;
    public Ticket(){
        //paneles
        panelticket  = new JPanel();
        panelticket1 = new JPanel();
        panelticket2 = new JPanel();
        panelticket3 = new JPanel();
        panelticket4 = new JPanel();
        panelticket5 = new JPanel();
       
        panelticket.setBorder(null);
        panelticket1.setBorder(null);
        panelticket2.setBorder(null);
        panelticket3.setBorder(null);
        panelticket4.setBorder(null);
        panelticket5.setBorder(null);
        
        panelticket.setBackground(null);
        panelticket1.setBackground(null);
        panelticket2.setBackground(null);
        panelticket3.setBackground(null);
        panelticket4.setBackground(null);
        panelticket5.setBackground(null);
        
         //fuente
        fuenteticket = new Font("Agency FB",0,40);
        fuenteticket2= new Font("Agency Fb",0,20);
        //color
        moradoticket=Color.decode("#F49F9F");
        
        //checkbox
        facturacheck=new JCheckBox();
        facturacheck.setBackground(null);
       
       //JTextField
       ticke = new JTextField("Ticket");
       ticke.setBorder(null);
       ticke.setEditable(false);
       ticke.setBackground(null);
       ticke.setFont(fuenteticket);
       ticke.setHorizontalAlignment(JTextField.CENTER);
       panelticket1.add(ticke);
       //panelticket1.setLayout(new BoxLayout(panelticket1,BoxLayout.X_AXIS));
       
       factura = new JTextField("Factura");
       factura.setBorder(null);
       factura.setEditable(false);
       factura.setBackground(null);
       factura.setFont(fuenteticket2);
       factura.setHorizontalAlignment(JTextField.RIGHT);
       panelticket2.add(facturacheck);
       panelticket2.add(factura);
       panelticket2.setLayout(new FlowLayout(FlowLayout.LEFT));
      
     //  panelticket2.setLayout(new BoxLayout(panelticket2,BoxLayout.X_AXIS));
       
       total = new JTextField("Total $ ");
       total.setBorder(null);
       total.setEditable(false);
       total.setBackground(null);
       total.setFont(fuenteticket2);
       panelticket3.add(total);
       
       total2=new JTextField("W");
       total2.setBorder(null);
       total2.setEditable(false);
       total2.setBackground(null);
       panelticket3.add(total2);
       
       cantidad=new JTextField("Cantidad: ");
       cantidad.setBorder(null);
       cantidad.setEditable(false);
       cantidad.setBackground(null);
       cantidad.setFont(fuenteticket2);
       panelticket3.add(cantidad);
       
       cantidad2=new JTextField("St");
       //cantidad2.setBorder(null);
       cantidad2.setBackground(null);
       cantidad2.setFont(fuenteticket2);
       panelticket3.add(cantidad2);
       
       cambio=new JTextField("Cambio $ ");
       cambio.setBorder(null);
       cambio.setEditable(false);
       cambio.setBackground(null);
       cambio.setFont(fuenteticket2);
       panelticket3.add(cambio);
         
       cambio2=new JTextField("S");
       cambio2.setBorder(null);
       cambio2.setEditable(false);
       cambio2.setBackground(null);
       panelticket3.add(cambio2);
       
      panelticket3.setLayout(new GridLayout(3,3,8,8));
      panelticket5.add(panelticket3);
      panelticket5.setLayout(new FlowLayout(FlowLayout.LEFT));
       //iconos
        ImageIcon fin = new ImageIcon(getClass().getResource("../iconos/dinero.png"));
        ImageIcon dinero = new ImageIcon(getClass().getResource("../iconos/atras.png"));
        
        //botones
       finalizar    = new JButton(dinero);
       volverticket = new JButton(fin);
       finalizar.setBorder(null);
       volverticket.setBorder(null);
       finalizar.setBackground(null);
       volverticket.setBackground(null);
       panelticket4.add(finalizar);
       panelticket4.add(volverticket);
       panelticket4.setLayout(new FlowLayout(FlowLayout.CENTER));
       volverticket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
       finalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
       volverticket.addActionListener(this);
       finalizar.addActionListener(this);
       //ventana mas o menos principal
       panelticket.add(panelticket1);
       panelticket.add(panelticket2);
       panelticket.add(panelticket5);
       panelticket.add(panelticket4);
       panelticket.setLayout(new BoxLayout(panelticket,BoxLayout.Y_AXIS));
       
       //Ventana principal papu:v
       ticket = new JFrame();
       ticket.setVisible(true);
       ticket.setSize(500,600);
       ticket.setLocationRelativeTo(null);
       ticket.getContentPane().add(panelticket);
       ticket.getContentPane().setBackground(moradoticket);
       ticket.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
    }
    public static void main(String [] args){
        Ticket t= new Ticket();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(volverticket))
        {
            JOptionPane.showMessageDialog(null,"El cobro se resalizo exitosamente");
            volverticket.setEnabled(false);
        }
        if(e.getSource().equals(finalizar))
        {
           this.dispose();
        }
        
        
    }
}