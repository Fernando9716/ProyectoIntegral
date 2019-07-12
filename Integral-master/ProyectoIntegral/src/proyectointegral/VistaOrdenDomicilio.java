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
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author David
 */
public class VistaOrdenDomicilio extends JFrame{
    private JLabel eProductos,eDomicilio,eEmpaque,
            eDireccion,eReferencia,eNombre;
    private JTextField tfDireccion,tfReferencia,tfNombre;
    private TablaGenerica productos;
    private JPanel pDomicilio,botones_inf;
    private JRadioButton desechable,cubierto;
    private ButtonGroup seleccion;
    private JButton cancelar,terminar;
    private JScrollPane scroll;
    public VistaOrdenDomicilio (Producto[]orden){
        eProductos=new JLabel("Productos");
        eDomicilio=new JLabel("Domicilio");
        eEmpaque= new JLabel("Empaque");
        eDireccion=new JLabel("Direccion:");
        eReferencia=new JLabel("Referencia:");
        eNombre=new JLabel("Nombre:");
        tfDireccion=new JTextField(10);
        tfReferencia=new JTextField(10);
        tfNombre=new JTextField(10);
        String[] encabezado={"productos","Observaciones","cantidad"};
        productos=new TablaGenerica(orden,encabezado){
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        //productos.
        scroll=new JScrollPane();
        scroll.setViewportView(productos);
        pDomicilio=new JPanel(new GridLayout(0,2));
        botones_inf=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        desechable=new JRadioButton("Desechable");
        cubierto=new JRadioButton("Cubiertos");
        seleccion=new ButtonGroup();
        seleccion.add(desechable);
        seleccion.add(cubierto);
        cancelar=new JButton("cancelar");
        terminar=new JButton("terminar");
        
        GridBagConstraints conf=new GridBagConstraints();
        setLayout(new GridBagLayout());
        
        conf.insets=new Insets(5, 10,5,10);
        conf.gridx=0;
        conf.gridy=0;
        conf.anchor=GridBagConstraints.LINE_START;
        add(eProductos,conf);
        
        conf.gridy=3;
        add(eDomicilio,conf);
        
        conf.gridy=6;
        add(eEmpaque,conf);
        
        conf.gridy=1;
        conf.gridheight=2;
        conf.gridwidth=3;
        conf.fill=GridBagConstraints.BOTH;
        conf.weightx=1;
        conf.weighty=1;
        add(scroll,conf);
        
        conf.gridy=4;
        add(pDomicilio,conf);
        
        pDomicilio.setLayout(new GridBagLayout());
        pDomicilio.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        conf.gridx=0;
        conf.gridy=0;
        conf.gridheight=1;
        conf.gridwidth=1;
        //conf.weightx=0;
        //conf.weighty=0;
        conf.fill=GridBagConstraints.NONE;
        conf.anchor=GridBagConstraints.LINE_END;
        pDomicilio.add(eDireccion,conf);
        
        conf.gridy=1;
        pDomicilio.add(eReferencia,conf);
        
        conf.gridy=2;
        pDomicilio.add(eNombre,conf);
        
        conf.gridx=1;
        conf.anchor=GridBagConstraints.LINE_START;
        pDomicilio.add(tfNombre,conf);
        
        conf.gridy=1;
        pDomicilio.add(tfReferencia,conf);
        
        conf.gridy=0;
        pDomicilio.add(tfDireccion,conf);
        
        conf.gridy=7;
        add(cubierto,conf);
        
        conf.gridx=0;
        conf.anchor=GridBagConstraints.LINE_END;
        add(desechable,conf);
        
        conf.gridy=8;
        conf.gridx=2;
        add(botones_inf,conf);
        
        botones_inf.add(cancelar);
        botones_inf.add(terminar);
        
        setTitle("Orden a domicilio");
        setMinimumSize(new Dimension(450,550));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
