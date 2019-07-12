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


import java.util.*;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font; 
import java.awt.Color;

public class Ordenes extends JFrame implements ActionListener {
    Orden on= new Orden();
    private Color fondo;
    ArrayList<String> ordomicilio = on.getnombresDomicilio();
 ArrayList<JButton> ListadeOrdenes=new ArrayList<JButton>();
 ArrayList<String> Ordenesrest= on.getMesasOcupadas();
private JButton cerrar;
private JScrollPane scroll;
private JPanel panel,panel1,panel2,panel3,panel4,panel5;
private JTextField ordenes;
private JFrame frame;
private int contadordom=0;
private int contadormesa=0;
private  JButton botond;
private JButton boton;
String xa="";
  String nombrecomensal;
public Ordenes(){
   
    fondo=Color.decode("#F49F9F");
   
  //paneles
   panel=new JPanel();
   panel1=new JPanel();
   panel2 =new JPanel();
   
   panel.setBorder(null);
   panel1.setBorder(null);
   panel2.setBorder(null);
   
   panel.setBackground(fondo);
   panel1.setBackground(null);
   panel2.setBackground(null);
   
   //tipo y tamaño fuente
  Font fuente=new Font("Calibri",1,39);
//--------------------------------------------------------------------------------------------------------------------------------
   //JTextField Ordenes(Titulo)
    ordenes=new JTextField("Ordenes");
    ordenes.setFont(fuente);
    ordenes.setEditable(false);
    ordenes.setBackground(null);
//--------------------------------------------------------------------------------------------------------------------------------- 
    //Boton cerrar
    ImageIcon cerr = new ImageIcon(getClass().getResource("../iconos/close.png"));
    cerrar=new JButton(cerr);
    cerrar.setBorder(null);
     cerrar.setBackground(null);
    
     cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
   
   
   //_--------------------------------------------------------------------------------------------------------------------------
    panel.setLayout(new GridLayout(0,1));
    scroll=new JScrollPane(panel);
    scroll.setBorder(null);
    panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
    panel1.add(ordenes);
    panel2.setLayout(new BoxLayout(panel2,BoxLayout.X_AXIS));
    panel2.add(cerrar);
     cerrar.addActionListener(this); 
    
   //-----------------------------------------------------------------------------------------------------------
     frame=new JFrame("La Amuzgueñita");
    frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
    frame.add(panel1);
    frame.add(scroll);
    frame.add(panel2);
    frame.setSize(300,500);
    frame.setVisible(true);
    frame.getContentPane().setBackground(fondo);
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
   //----------------------------------------------------------------------------------------
     int n=Ordenesrest.size();  
      for(int i=0;i<n;i++){
        contadormesa++;
          boton=new JButton(Ordenesrest.get(i));
         ListadeOrdenes.add(boton);
          panel.add(boton);
          panel.add(Box.createVerticalGlue());
          boton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    String k = Ordenesrest.get(i);
          boton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					JOptionPane.showMessageDialog(null,"presionaste "+ k);
                                        Comensales v = new Comensales(k);
                                        v.setVisible(true);
				}
			});
      }     
       
      
 int x=ordomicilio.size();
 
 for(int a=0;a<x;a++){
     contadordom++;
     botond = new JButton(ordomicilio.get(a)+" (domicilio)");
     ListadeOrdenes.add(botond);
     panel.add(botond);
     panel.add(Box.createGlue());
     botond.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
      String b=ordomicilio.get(a);
        botond.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
                                  
					JOptionPane.showMessageDialog(null,b);
                                        //xa=botond.getActionCommand();
                                        //getNombre(xa);
                                         Alimentosllevar ventanaComensales = new Alimentosllevar(b);
                                        ventanaComensales.setVisible(true);
				}
                                
			});


 }


}

public String getNombre(String nombre){
    nombrecomensal=nombre;
    
    return nombrecomensal;
    
      }
@Override

public void actionPerformed(ActionEvent eve){
   
    
if(eve.getSource() == cerrar)
            frame.dispose();
}
public static void main(String args[]){
    new Ordenes();
}
}
