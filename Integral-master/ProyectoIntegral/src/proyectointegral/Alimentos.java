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
import java.util.*;
import javax.swing.*;

public class Alimentos {
    private  JFrame a;
    private  Color mo;
    private JButton volveral,cobraral;
    private Font s,q;
    private JPanel panel, panel1,panel2,panel3,panel4;
    private ArrayList<String> alimentos=new ArrayList();
    private JScrollPane scrollalim;
    public Alimentos(){
        alimentos= new ArrayList();
        
        alimentos.add("s");
        alimentos.add("s");
        alimentos.add("s");
        alimentos.add("s");
        alimentos.add("s");
        alimentos.add("s");
        alimentos.add("s");
        alimentos.add("s");
        alimentos.add("s");
        alimentos.add("s");
        alimentos.add("s");
        alimentos.add("s");
        alimentos.add("s");
        alimentos.add("s");alimentos.add("s");
        alimentos.add("s");
        alimentos.add("s");
        alimentos.add("s");
        alimentos.add("s");
        alimentos.add("s");
        
        
        
        panel  = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        
        panel.setBorder(null);
        panel1.setBorder(null);
        panel2.setBorder(null);
        panel3.setBorder(null);
        panel4.setBorder(null);
        
        panel.setBackground(null);
        panel1.setBackground(null);
        panel2.setBackground(null);
        panel3.setBackground(null);
        panel4.setBackground(null);
        
        s   = new Font("Agency FB",0,40);
        q   = new Font("Agency FB",0,20);
        mo  = Color.decode("#F49F9F");
        
        JTextField tituloal=new JTextField("Alimentos");
        tituloal.setBorder(null);
        tituloal.setEditable(false);
        tituloal.setBackground(null);
        tituloal.setFont(s);
        tituloal.setHorizontalAlignment(JTextField.CENTER);
        panel1.add(tituloal);
        
        JTextField subtituloal = new JTextField("Persona");
        subtituloal.setBorder(null);
        subtituloal.setEditable(false);
        subtituloal.setBackground(null);
        subtituloal.setFont(q);
        panel2.add(subtituloal);
        
        
        
        int ñ=alimentos.size();
        for (int al=0; al<ñ; al++){
            panelesDinamicosal(alimentos.get(al));
            panel3.setLayout(new BoxLayout(panel3,BoxLayout.Y_AXIS));
        }
        
        ImageIcon cobal = new ImageIcon(getClass().getResource("../iconos/cobrar.png"));
        ImageIcon volal = new ImageIcon(getClass().getResource("../iconos/volver.png"));
        
        volveral= new JButton(volal);
        cobraral= new JButton(cobal);
        volveral.setBorder(null);
        cobraral.setBorder(null);
        volveral.setBackground(null);
        cobraral.setBackground(null);
        volveral.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cobraral.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        panel4.add(volveral);
        panel4.add(cobraral);
        
        panel.add(panel1);
        panel.add(panel2);
        panel.add(scrollalim);
        panel.add(panel4);
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        
        a = new JFrame();
        a.setVisible(true);
        a.setSize(500,600);
        a.setLocationRelativeTo(null);
        a.getContentPane().add(panel);
        a.getContentPane().setBackground(mo);
        a.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     
        
        
     
    }
    public void panelesDinamicosal(String nombre){
        
        JTextField productoalimentos = new JTextField(nombre);
        JPanel panelProval = new JPanel();
        scrollalim= new JScrollPane(panel3);
        scrollalim.setBorder(null);
        panelProval.add(productoalimentos);
        
        productoalimentos.setBorder(null);
        productoalimentos.setEditable(false);
        productoalimentos.setBackground(null);
        
        panelProval.setBackground(null);
        panel3.add(panelProval);
        panel3.setBackground(mo);
        panel3.updateUI();
        
    }
    public static void main (String [] args){
        Alimentos alimentoscomensal = new Alimentos();
    }
    
}
