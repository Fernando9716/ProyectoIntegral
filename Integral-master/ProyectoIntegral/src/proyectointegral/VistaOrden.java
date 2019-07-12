/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegral;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author David
 */
public class VistaOrden extends JFrame implements ActionListener{
    private JPanel contenedor,botones_inf;
    private JScrollPane scroll;
    private /*static*/ Vector<OrdenComensal> ordenes; //= new ArrayList<>();
    private JButton agregar,cancelar,terminar;
    private int numMesa;
    private String desc;
    private MenuVentana menuV;
    private MesasVentana mesaV;
    private Vector<ProductoOrden> comensal; //= new Vector<>();
    public VistaOrden(Vector<ProductoOrden> comensal, int numMesa, String desc, MenuVentana menuV, MesasVentana mesaV/*Producto [] comensal*/){
        this.numMesa = numMesa;
        this.desc = desc;
        this.menuV = menuV;
        this.mesaV = mesaV;
        contenedor=new JPanel();
        scroll=new JScrollPane();
        scroll.setViewportView(contenedor);
        botones_inf=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        ordenes=new Vector<>(); 
        agregar=new JButton();
        agregar.setSize(20,20);
        ImageIcon imagen=new ImageIcon("src/icons/añadir.png");
        Icon icono=new ImageIcon(imagen.getImage().getScaledInstance(agregar.getWidth(),agregar.getHeight(),Image.SCALE_DEFAULT));
        agregar.setIcon(icono);             
        Color g=new Color(15658734);
        agregar.setBackground(g);
        agregar.setBorderPainted(false);
        agregar.addActionListener(this);
        cancelar=new JButton("cancelar");
        cancelar.addActionListener(this);
        terminar=new JButton("terminar");
        terminar.addActionListener(this);
        setLayout(new GridBagLayout());
        GridBagConstraints conf =new GridBagConstraints();
        conf.insets=new Insets(5,5,5,5);
        
        conf.gridx=0;
        conf.gridy=0;
        conf.gridheight=4;
        conf.gridwidth=3;
        conf.fill=GridBagConstraints.BOTH;
        conf.weightx=1;
        conf.weighty=1;
        add(scroll,conf);
        
        conf.gridy=4;
        conf.gridheight=1;
        conf.gridwidth=1;
        conf.fill=GridBagConstraints.NONE;
        conf.anchor=GridBagConstraints.LINE_START;
        conf.weightx=0;
        conf.weighty=0;
        add(agregar,conf);
        
        conf.gridx=2;
        conf.gridy=5;
        conf.anchor=GridBagConstraints.LINE_END;
        add(botones_inf,conf);
        
        botones_inf.add(cancelar);
        botones_inf.add(terminar);
        
        contenedor.setLayout(new GridLayout(0,1,10,10));
        this.comensal = comensal;
        agregaComensal(this.comensal);
        
        Dimension size= new Dimension(400, 350);
        setTitle("Orden Mesa "+numMesa);
        setMinimumSize(size);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    boolean bandera = true;
    
    public VistaOrden(Vector<ProductoOrden> comensal, int numMesa, String desc, MenuVentana menuV, MesasVentana mesaV,Vector<OrdenComensal> lalo){
        this.numMesa = numMesa;
        this.desc = desc;
        this.menuV = menuV;
        this.mesaV = mesaV;
        this.comensal = comensal;
        ordenes = lalo;
        contenedor=new JPanel();
        scroll=new JScrollPane();
        scroll.setViewportView(contenedor);
        botones_inf=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        //ordenes=new ArrayList<>(); 
        agregar=new JButton();
        agregar.setSize(20,20);
        ImageIcon imagen=new ImageIcon("src/icons/añadir.png");
        Icon icono=new ImageIcon(imagen.getImage().getScaledInstance(agregar.getWidth(),agregar.getHeight(),Image.SCALE_DEFAULT));
        agregar.setIcon(icono);             
        Color g=new Color(15658734);
        agregar.setBackground(g);
        agregar.setBorderPainted(false);
        agregar.addActionListener(this);
        cancelar=new JButton("cancelar");
        cancelar.addActionListener(this);
        terminar=new JButton("terminar");
        terminar.addActionListener(this);
        setLayout(new GridBagLayout());
        GridBagConstraints conf =new GridBagConstraints();
        conf.insets=new Insets(5,5,5,5);
        
        conf.gridx=0;
        conf.gridy=0;
        conf.gridheight=4;
        conf.gridwidth=3;
        conf.fill=GridBagConstraints.BOTH;
        conf.weightx=1;
        conf.weighty=1;
        add(scroll,conf);
        
        conf.gridy=4;
        conf.gridheight=1;
        conf.gridwidth=1;
        conf.fill=GridBagConstraints.NONE;
        conf.anchor=GridBagConstraints.LINE_START;
        conf.weightx=0;
        conf.weighty=0;
        add(agregar,conf);
        
        conf.gridx=2;
        conf.gridy=5;
        conf.anchor=GridBagConstraints.LINE_END;
        add(botones_inf,conf);
        
        botones_inf.add(cancelar);
        botones_inf.add(terminar);
        
        contenedor.setLayout(new GridLayout(0,1,10,10));
        //System.out.println("Perro");
        agregaComensalDinamicamente(this.comensal);
        
        Dimension size= new Dimension(400, 350);
        setTitle("Orden Mesa "+numMesa);
        setMinimumSize(size);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
    
    
    public /*ArrayList<OrdenComensal>*/void 
        agregaComensal(/*Orden comensal*/Vector<ProductoOrden> comensal){
        OrdenComensal panel=new OrdenComensal(comensal,desc,contenedor);
        contenedor.add(panel);
        this.validate();
        ordenes.add(panel);
        //return ordenes;
    }
        public /*ArrayList<OrdenComensal>*/void 
        agregaComensalDinamicamente(/*Orden comensal*/Vector<ProductoOrden> comensal){
            contenedor.setLayout(new GridLayout(0,1));
            OrdenComensal panel=new OrdenComensal(comensal,desc,contenedor);
        ordenes.add(panel);
        
        if (!ordenes.isEmpty()) {
            ordenes.forEach((im) -> {
                contenedor.add(im);
            });    }
            System.out.println("Ordenes comenzales");
           // contenedor.add(new JLabel("Este es el puto contenedor"));
        
        this.validate();
        
        //return ordenes;
    }
    //Corre el archivo main para probarlo
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==agregar){
            System.out.println("Perro Vista");
            DescripcionComenzalVentana obj1 = new DescripcionComenzalVentana(numMesa,mesaV,ordenes);
            //this.setVisible(false);
            this.dispose();
            menuV.dispose();
        }else if(e.getSource()==cancelar){
            this.dispose();
            menuV.dispose();
            mesaV.setEnabled(true);
        }
    }
}
