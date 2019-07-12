/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegral;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author David
 */
public class VistaOrdenMesa extends JPanel implements ActionListener{
    private JLabel tipo,mesa;
    private TablaGenerica productos;
    private JButton finalizar;
    private VistaRecepcionOrdenes padre;
    private VistaOrdenMesa siguiente;
    private JScrollPane scroll;
    public VistaOrdenMesa(Producto [] comidas,String tipo,VistaRecepcionOrdenes padre){
        this.tipo=new JLabel(tipo);
        mesa=new JLabel("Mesa 0");
        String [] encabezado={"producto","Observaciones","Cantidad","Comenzal"};
        productos =new TablaGenerica(comidas,encabezado,1){
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        scroll=new JScrollPane();
        scroll.setViewportView(productos);
        finalizar=new JButton("Finalizar");
        finalizar.addActionListener(this);
        this.padre=padre;
        siguiente=null;
        
        setLayout(new GridBagLayout());
        GridBagConstraints conf= new GridBagConstraints();
        
        conf.insets=new Insets(10,5,10,5);
        conf.gridx=0;
        conf.gridy=0;
        conf.anchor=GridBagConstraints.LINE_START;
        add(mesa,conf);
        
        conf.gridy=1;
        add(this.tipo,conf);
        
        conf.gridy=4;
        conf.gridx=1;
        conf.anchor=GridBagConstraints.LINE_END;
        add(finalizar,conf);
        
        conf.gridx=0;
        conf.gridy=2;
        conf.gridwidth=2;
        conf.gridheight=2;
        conf.weightx=1;
        conf.weighty=1;
        conf.fill=GridBagConstraints.BOTH;
        //add(scroll,conf);
        add(productos,conf);
        
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //setExtendedState(MAXIMIZED_BOTH);
        setMaximumSize(new Dimension(240,290));
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setSiguiente(VistaOrdenMesa siguiente) {
        this.siguiente = siguiente;
    }

    public VistaOrdenMesa getSiguiente() {
        return siguiente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        padre.eliminar(this);
    }
}
