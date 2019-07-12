/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegral;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author achec
 */
public class DescripcionComenzalVentana extends JFrame implements ActionListener{
    ButtonGroup generoGrupo;
    JRadioButton hombre;
    JComboBox color;
   JComboBox edadCB;
   boolean bandera;
   MenuVentana ventana;
  
   int num_mesa;
   MesasVentana mesaV;
   Vector<OrdenComensal> comensal;

    public DescripcionComenzalVentana(int num_mesa, MesasVentana mesaV) {
        this.num_mesa = num_mesa;
        this.mesaV = mesaV;
        bandera =true;
    JPanel contenedor = new JPanel(new GridLayout(0, 1));
    
    JPanel linea1 = new JPanel(new GridLayout(0,2));
    linea1.add(new JLabel("Descripción del comenzal:"));
    comensal = null;
    JPanel linea2 = new JPanel(new GridLayout(0,4));
    linea2.add(new JPanel());
    linea2.add(new JLabel("Genero:"));
        generoGrupo = new ButtonGroup();
        hombre = new JRadioButton("H");
        hombre.setSelected(true);
        generoGrupo.add(hombre);
        JRadioButton mujer = new JRadioButton("M");
        generoGrupo.add(mujer);
    linea2.add(hombre);
    linea2.add(mujer);
    
    JPanel linea3 = new JPanel(new GridLayout(0,4));
        linea3.add(new JPanel());
        linea3.add(new JLabel("Color distintivo:"));
    JPanel panelColor = new JPanel();
       color = new JComboBox(new DefaultComboBoxModel(new String[]{"Rojo","Azul","Amarillo","Negro","Blanco","Verde","Rosa"}));
        panelColor.add(color);
        linea3.add(panelColor);
        
    JPanel linea4 = new JPanel(new GridLayout(0,4));    
    linea4.add(new JPanel());
    linea4.add(new JLabel("Rango edad aprox:"));    
    JPanel panelEdad = new JPanel();
        edadCB = new JComboBox(new DefaultComboBoxModel(new String[]{"0-10","11-20","21-30","31-40","41-50","51-60","Mas de 60"}));
        panelEdad.add(edadCB);
    linea4.add(panelEdad);
    
    JPanel linea5 = new JPanel(new GridLayout(0,4));
    linea5.add(new JPanel());
    linea5.add(new JPanel());
    linea5.add(new JPanel());
    JButton aceptar = new JButton("Aceptar");
        aceptar.setActionCommand("Aceptar");
        aceptar.addActionListener(this);
        aceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FlowLayout paraInterno = new FlowLayout();
        JPanel interno = new JPanel(paraInterno);
        interno.add(aceptar);
    linea5.add(interno);                       
    
    contenedor.add(linea1);
    contenedor.add(linea2);
    contenedor.add(linea3);
    contenedor.add(linea4);
    contenedor.add(linea5);
    add(contenedor);
     setSize(500, 250);
        setVisible(true);
        paintComponents(getGraphics());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public DescripcionComenzalVentana(int num_mesa, MesasVentana mesaV,Vector<OrdenComensal> lalo) {
        this.num_mesa = num_mesa;
        this.mesaV = mesaV;
        comensal = lalo;
        bandera = false;
    JPanel contenedor = new JPanel(new GridLayout(0, 1));
    
    
    JPanel linea1 = new JPanel(new GridLayout(0,2));
    linea1.add(new JLabel("Descripción del comenzal:"));
    
    JPanel linea2 = new JPanel(new GridLayout(0,4));
    linea2.add(new JPanel());
    linea2.add(new JLabel("Genero:"));
        generoGrupo = new ButtonGroup();
        hombre = new JRadioButton("H");
        hombre.setSelected(true);
        generoGrupo.add(hombre);
        JRadioButton mujer = new JRadioButton("M");
        generoGrupo.add(mujer);
    linea2.add(hombre);
    linea2.add(mujer);
    
    JPanel linea3 = new JPanel(new GridLayout(0,4));
        linea3.add(new JPanel());
        linea3.add(new JLabel("Color distintivo:"));
    JPanel panelColor = new JPanel();
       color = new JComboBox(new DefaultComboBoxModel(new String[]{"Rojo","Azul","Amarillo","Negro","Blanco","Verde","Rosa"}));
        panelColor.add(color);
        linea3.add(panelColor);
        
    JPanel linea4 = new JPanel(new GridLayout(0,4));    
    linea4.add(new JPanel());
    linea4.add(new JLabel("Rango edad aprox:"));    
    JPanel panelEdad = new JPanel();
        edadCB = new JComboBox(new DefaultComboBoxModel(new String[]{"0-10","11-20","21-30","31-40","41-50","51-60","Mas de 60"}));
        panelEdad.add(edadCB);
    linea4.add(panelEdad);
    
    JPanel linea5 = new JPanel(new GridLayout(0,4));
    linea5.add(new JPanel());
    linea5.add(new JPanel());
    linea5.add(new JPanel());
    JButton aceptar = new JButton("Aceptar");
        aceptar.setActionCommand("Aceptar");
        aceptar.addActionListener(this);
        aceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FlowLayout paraInterno = new FlowLayout();
        JPanel interno = new JPanel(paraInterno);
        interno.add(aceptar);
    linea5.add(interno);                       
    
    contenedor.add(linea1);
    contenedor.add(linea2);
    contenedor.add(linea3);
    contenedor.add(linea4);
    contenedor.add(linea5);
    add(contenedor);
     setSize(500, 250);
        setVisible(true);
        paintComponents(getGraphics());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String sexo;
        String color2;
        String edad;
        System.out.println(ae.getActionCommand());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Menu menu = new Menu();
        //menu.getDatosProducto(); //Fue comentado porque hice cambio en MenuVentana y funciona
       
       
        if(hombre.isSelected()){
            sexo = "hombre";
        }else
        {
            sexo ="mujer";
        }
        color2 = (String) color.getSelectedItem();
        edad = "" + edadCB.getSelectedItem();
        
        String desc = "" + sexo + color2 + edad;
        
        ClienteRestaurante cl = new ClienteRestaurante(sexo,color2,edad);
        int id = cl.getUltimoCliente();
        if(bandera) ventana = new MenuVentana(menu, num_mesa, desc, id, mesaV);
        else {System.out.println("---------------------------------------"); ventana = new MenuVentana(menu, num_mesa, desc, id, mesaV,comensal);}
        setVisible(false);
        this.dispose();
        
    }
    
    public static void main(String[] args) {
        //DescripcionComenzalVentana ob = new DescripcionComenzalVentana(12);
    }
}
