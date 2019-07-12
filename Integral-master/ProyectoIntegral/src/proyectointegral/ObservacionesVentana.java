/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegral;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author achec
 */
public class ObservacionesVentana extends JDialog implements ActionListener{
    private String observaciones = null;
    private JTextArea observacion;
    private JButton aceptar;
    private JTextField cantidad;
    ProductoOrden seleccionado;
    
    public ObservacionesVentana(JFrame padre,ProductoOrden seleccionado){
        super(padre,"ObservacionesVentana",true);
        this.seleccionado = seleccionado;
        iniciarComponentes();
    }
    
    void iniciarComponentes(){
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
         c.insets = new Insets(5,10,5,10);//Margin de Css top, left botton rigth
        
         c.gridx=0;
         c.gridy=0;
         c.gridwidth=1;
         c.anchor = GridBagConstraints.LINE_START;
         add(new JLabel("Observaciones:"),c);
         
         c.gridy=1;
         c.gridwidth=3;
         c.gridheight=1;
         c.weighty=1;
         c.weightx=1;
         c.fill = GridBagConstraints.BOTH;
         observacion = new JTextArea("Sin observación",5, 40);
         add(new JScrollPane(observacion),c);
         
         c.weighty=0;
         c.weightx=0;
         c.fill = GridBagConstraints.NONE;
         c.gridheight=1;
         
         c.gridy = 3;
         c.gridwidth = 1;
         c.anchor = GridBagConstraints.LINE_END;
         add(new JLabel("Cantidad:"),c);
         
         c.gridy = 3;
         c.gridx = 1;
         c.fill = GridBagConstraints.HORIZONTAL;
         c.weightx=1;
         c.anchor = GridBagConstraints.LINE_START;
         cantidad = new JTextField("1",10);
         add(cantidad,c);
        
         c.fill = GridBagConstraints.NONE;
         
         c.gridy = 4;
         c.gridx = 2;
         c.anchor = GridBagConstraints.LINE_END;
         aceptar = new JButton("Aceptar");
         add(aceptar,c);
         aceptar.addActionListener(this);
         
         pack();
         setMinimumSize(new Dimension(300,200));
         setLocationRelativeTo(null);
        // setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        //Vector<ProductoOrden> ProductosOrden = new Vector<ProductoOrden>();
        String observacionPro = observacion.getText();
        String cantidadPro = cantidad.getText();
        seleccionado.setCantidad(cantidadPro);
        seleccionado.setObservacion(observacionPro);
        this.dispose();
    }
    
    /*public static void main(String[] args) {
        ObservacionesVentana ob = new ObservacionesVentana();
    }*/
}
