/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegral;

//import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;
//import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Cheko-Ivan
 */
public class MesasVentana extends JFrame implements ActionListener{
    OrdenMesa om = new OrdenMesa();
    JButton mesas[];
    int contador = 1;
    public MesasVentana(){
        super("Tomar Orden");
        int cantMesas = om.getNumerodeMesas();
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        JPanel container = new JPanel(new GridLayout(0,3));
        mesas = new JButton[cantMesas];
        
        for (JButton mesa : mesas)
        {
            mesa = new JButton("Mesa "+contador, new ImageIcon("src/iconos/mesa.png"));
            mesa.setBackground(Color.WHITE);
            //mesa.setContentAreaFilled(false);
            mesa.setRolloverIcon(new ImageIcon("src/iconos/mesaHover.png"));
            mesa.setBorderPainted(false);
            mesa.setPressedIcon(new ImageIcon("src/iconos/mesaPress.png"));
            
            mesa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            mesa.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
            mesa.setActionCommand(""+contador);
            mesa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            
            container.add(mesa);
            mesa.addActionListener(this);
            contador++;
        }
        JButton ordenDomicilio = new JButton("Orden a Domicilio",new ImageIcon("src/iconos/listaDom.png"));
        ordenDomicilio.setBackground(Color.WHITE);
        ordenDomicilio.setRolloverIcon(new ImageIcon("src/iconos/listaHover.png"));
        ordenDomicilio.setBorderPainted(false);
        ordenDomicilio.setPressedIcon(new ImageIcon("src/iconos/listaPress.png"));
        ordenDomicilio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ordenDomicilio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ordenDomicilio.setActionCommand("ordenDomicilio");
        ordenDomicilio.addActionListener(this);
        container.add(ordenDomicilio);
        
        add(container);
        setSize(900, 500);
        setVisible(true);
        paintComponents(getGraphics());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        int mesa = Integer.parseInt(ae.getActionCommand());
       
        if(!ae.getActionCommand().equals("ordenDomicilio"))
        {
             DescripcionComenzalVentana ob1 = new DescripcionComenzalVentana(mesa,this);
             ob1.setVisible(true);  
             this.disable();
        }else
        {
            Menu menu = new Menu();
            //menu.getDatosProducto();//si este metodo lo colocamos antes del foreach en Menu Ventana ya no es necesario llamarlo en los main
            //MenuVentana ventana = new MenuVentana(menu, mesa, "Domicilio", 300);
            //setVisible(false); Esta línea no se usa
        }
  
        System.out.println(ae.getActionCommand());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public static void main(String[] args) {
        MesasVentana ob = new MesasVentana();
    }
}
