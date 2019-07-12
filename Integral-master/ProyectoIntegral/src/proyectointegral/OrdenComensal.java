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
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
//import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author David
 */
public class OrdenComensal extends JPanel implements ActionListener{
    private JLabel descripcion;
    private JButton eliminar, ajustes;
    private TablaGenerica productos;
    private JPanel botones_sup;
    private JPanel padre;
    //private String desc;
    private Vector<ProductoOrden> orden;//Orden orden.getProductos()
    public OrdenComensal(/*Orden orden*/Vector<ProductoOrden> orden,String desc, JPanel padre){
        this.orden=orden;
        //this.desc = desc;
        this.padre=padre;
        descripcion=new JLabel(desc);
        Color g=new Color(15658734);
        eliminar=new JButton();
        eliminar.setSize(20,20);
        eliminar.setBackground(g);
        eliminar.setBorderPainted(false);
        ImageIcon imagen=new ImageIcon("src/icons/eliminar.png");
        Icon icono=new ImageIcon(imagen.getImage().getScaledInstance(eliminar.getWidth(),eliminar.getHeight(),Image.SCALE_DEFAULT));
        eliminar.setIcon(icono);
        eliminar.addActionListener(this);
        ajustes=new JButton();
        ajustes.setSize(20,20);
        ajustes.setBackground(g);
        ajustes.setBorderPainted(false);
        ajustes.addActionListener(this);
        imagen=new ImageIcon("src/icons/ajustes.png");
        icono=new ImageIcon(imagen.getImage().getScaledInstance(ajustes.getWidth(),ajustes.getHeight(),Image.SCALE_DEFAULT));
        ajustes.setIcon(icono);
        productos=new TablaGenerica(/*new ArrayList<Producto>()*/orden){
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        botones_sup=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        GridBagConstraints conf=new GridBagConstraints();
        conf.insets=new Insets(10, 5, 10, 5);
        setLayout(new GridBagLayout());
        
        conf.gridx=0;
        conf.gridy=0;
        conf.anchor=GridBagConstraints.LINE_START;
        add(descripcion,conf);
        
        conf.gridx=2;
        conf.anchor=GridBagConstraints.LINE_END;
        add(botones_sup,conf);
        
        botones_sup.add(ajustes);
        botones_sup.add(eliminar);
        
        conf.gridx=0;
        conf.gridy=1;
        conf.fill=GridBagConstraints.BOTH;
        conf.gridwidth=3;
        conf.gridheight=1;
        conf.weightx=1;
        conf.weighty=1;
        add(productos,conf);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setMaximumSize(new Dimension(400,400));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== eliminar){
            setVisible(false);
            padre.remove(this);
        }else if(e.getSource()== ajustes){
            int aux=productos.getSelectedRow();
            String [] datos=new String [2];
            if(aux==-1)
                return;
            else{
                //aqui mandaran los ajustes
                datos [0]=productos.getModel().getValueAt(aux, 1).toString();
                datos [1]=productos.getModel().getValueAt(aux, 2).toString();
                System.out.println(datos[0]+"\n"+datos[1]);
                //System.out.println(orden[aux].getCantidad());
            }
        }
    }
    public void modificarTabla(String [] datos,int row){
        productos.getModel().setValueAt(datos[0], row, 1);
        productos.getModel().setValueAt(datos[1], row, 2);
        orden.get(row).setCantidad(datos[2]);
    }
    
}
