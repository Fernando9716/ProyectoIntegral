/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegral;

/**
 *
 * @author Fernando
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class Alimentosllevar extends JFrame implements ActionListener{
    
    private  JFrame llev;
    private  Color mollevar;
    private JButton volverllevar,cobrarllevar;
    private Font sllevar,qllevar;
    private JPanel panelllevar, panel1llevar,panel2llevar,panel3llevar,panel4llevar;
    private ArrayList<String> alimentosllevar;
    private JScrollPane scrollalimllevar;
    Orden orden = new Orden();
    public Alimentosllevar( String h){
        
        alimentosllevar = orden.getProductosOrden(h);
       
     /*  alimentosllevar.add("s");
        alimentosllevar.add("s");
       alimentosllevar.add("s");
        alimentosllevar.add("s");
        alimentosllevar.add("s");
        alimentosllevar.add("s");
        alimentosllevar.add("s");
        alimentosllevar.add("s");
        alimentosllevar.add("s");
        alimentosllevar.add("s");
        alimentosllevar.add("s");*/
    
        
        
        
        panelllevar  = new JPanel();
        panel1llevar = new JPanel();
        panel2llevar = new JPanel();
        panel3llevar = new JPanel();
        panel4llevar = new JPanel();
        
        panelllevar.setBorder(null);
        panel1llevar.setBorder(null);
        panel2llevar.setBorder(null);
        panel3llevar.setBorder(null);
        panel4llevar.setBorder(null);
        
        panelllevar.setBackground(null);
        panel1llevar.setBackground(null);
        panel2llevar.setBackground(null);
        panel3llevar.setBackground(null);
        panel4llevar.setBackground(null);
        
        sllevar   = new Font("Agency FB",0,40);
        qllevar   = new Font("Agency FB",0,20);
        mollevar  = Color.decode("#F49F9F");
        
        JTextField tituloalllevar=new JTextField("Alimentos para llevar");
        tituloalllevar.setBorder(null);
        tituloalllevar.setEditable(false);
        tituloalllevar.setBackground(null);
        tituloalllevar.setFont(sllevar);
        tituloalllevar.setHorizontalAlignment(JTextField.CENTER);
        panel1llevar.add(tituloalllevar);
        
        JTextField subtituloalllevar = new JTextField(h);
        subtituloalllevar.setBorder(null);
        subtituloalllevar.setEditable(false);
        subtituloalllevar.setBackground(null);
        subtituloalllevar.setFont(qllevar);
        panel2llevar.add(subtituloalllevar);
        
        
        
        int ño=alimentosllevar.size();
        for (int llevar=0; llevar<ño; llevar++){
            panelesDinamicosalllevar(alimentosllevar.get(llevar));
            panel3llevar.setLayout(new BoxLayout(panel3llevar,BoxLayout.Y_AXIS));
        }
        
        ImageIcon cobllevar = new ImageIcon(getClass().getResource("../iconos/cobrar.png"));
        ImageIcon volllevar = new ImageIcon(getClass().getResource("../iconos/volver.png"));
        
        volverllevar= new JButton(volllevar);
        cobrarllevar= new JButton(cobllevar);
        volverllevar.setBorder(null);
        cobrarllevar.setBorder(null);
        volverllevar.setBackground(null);
        cobrarllevar.setBackground(null);
        volverllevar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cobrarllevar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cobrarllevar.addActionListener(this);
        volverllevar.addActionListener(this);
        
        panel4llevar.add(volverllevar);
        panel4llevar.add(cobrarllevar);
        
        panelllevar.add(panel1llevar);
        panelllevar.add(panel2llevar);
        panelllevar.add(scrollalimllevar);
        panelllevar.add(panel4llevar);
        panelllevar.setLayout(new BoxLayout(panelllevar,BoxLayout.Y_AXIS));
        
        llev = new JFrame();
        llev.setVisible(true);
        llev.setSize(500,600);
        llev.setLocationRelativeTo(null);
        llev.getContentPane().add(panelllevar);
        llev.getContentPane().setBackground(mollevar);
        llev.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     
        
        
     
    }
    public void panelesDinamicosalllevar(String nombre){
        
        JTextField productoalimentos = new JTextField(nombre);
        JPanel panelProdalllevar = new JPanel();
        scrollalimllevar= new JScrollPane(panel3llevar);
        scrollalimllevar.setBorder(null);
        panelProdalllevar.add(productoalimentos);
        
        productoalimentos.setBorder(null);
        productoalimentos.setEditable(false);
        productoalimentos.setBackground(null);
        
        panelProdalllevar.setBackground(null);
        panel3llevar.add(panelProdalllevar);
        panel3llevar.setBackground(mollevar);
        panel3llevar.updateUI();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource().equals(cobrarllevar))
        {
             Ticket t = new Ticket();
        t.setVisible(true);
        this.disable();
        }
        else
        {
             this.dispose();
        }
       
    }
    
    
    public static void main (String [] args){
        Alimentosllevar alimentosllevar = new Alimentosllevar("Risa Turner");
    }
    
}
