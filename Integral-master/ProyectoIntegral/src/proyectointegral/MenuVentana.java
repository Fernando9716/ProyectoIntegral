/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectointegral;

import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


/**
 *
 * @author achec
 */
public class MenuVentana extends JFrame implements ActionListener{
    private JButton ordenes, busquedaMenu, busquedaCarta;
    private Vector<ProductoOrden> productosOrden;
    private Vector<OrdenComensal> comensal;
    private String descripcionComen;
    private int num_mesa;
    private MesasVentana mesaV;
    VistaOrden vo1; 
    boolean bandera = true;
    MenuVentana(Menu producto, int num_mesa, String descripcionComen, int idUltimoCliente, MesasVentana mesaV){
        this.num_mesa = num_mesa;
        this.descripcionComen = descripcionComen;
        this.mesaV = mesaV;
        iniciarGraficos(producto);
        setSize(500, 500);
        setVisible(true);
        paintComponents(getGraphics());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        productosOrden = new Vector<>();
    }
    MenuVentana(Menu producto, int num_mesa, String descripcionComen, int idUltimoCliente, MesasVentana mesaV,Vector<OrdenComensal> perro){
        this.num_mesa = num_mesa;
        this.descripcionComen = descripcionComen;
        this.mesaV = mesaV;
        iniciarGraficos(producto);
        setSize(500, 500);
        setVisible(true);
        paintComponents(getGraphics());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        productosOrden = new Vector<>();
        comensal = perro;
        bandera = false;
    }
    public static void main(String[] args) {
        Menu menu = new Menu();
        //menu.getDatosProducto();
        //MenuVentana ventana = new MenuVentana(menu ,12, "gordo", 21, MesasVentana);
    }
    private void iniciarGraficos(Menu menu){
        //linea 1
        JPanel linea1 = new JPanel();
        ordenes = new JButton("Ordenes>>");
        //ordenes.setActionCommand("botonOrdenes");
        ordenes.addActionListener(this);
        linea1.add(ordenes);
        //linea 2
        JPanel linea2 = new JPanel();
        JLabel titulo1 = new JLabel("Menu del dia");
        busquedaMenu = new JButton("Q");//JButton(new ImageIcon("src/iconos/buscar.png"));
        linea2.add(titulo1);
        linea2.add(busquedaMenu);
        //linea3
        GridLayout gridMenuDia = new GridLayout(0,5);
        gridMenuDia.setVgap(10);
        gridMenuDia.setHgap(10);
        JPanel panelMenuDelDia = new JPanel(gridMenuDia);
        JScrollPane menuDelDia = new JScrollPane(panelMenuDelDia);
        //linea4
        JPanel linea4 = new JPanel();
        JLabel titulo2 = new JLabel("La carta");
        busquedaCarta = new JButton("Q");////JButton(new ImageIcon("src/iconos/buscar.png"));
        linea4.add(titulo2);
        linea4.add(busquedaCarta);
        
        GridLayout gridLaCarta = new GridLayout(0,5);
        gridLaCarta.setHgap(10);
        gridLaCarta.setVgap(10);
        JPanel panelLaCarta = new JPanel(gridLaCarta);   
        JScrollPane laCarta = new JScrollPane(panelLaCarta);
        //for (Producto item: menu.getmenu(){})
        menu.getDatosProducto();
        menu.getmenu().forEach((item) -> {
            JButton btnItem = new JButton(item.getNombre() + "");//JButton(new ImageIcon("src/iconos/"+item.getnombre()));
            btnItem.setActionCommand(item.getNombre() + "");
            btnItem.addActionListener(this);
            btnItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            if(item.getIdMenu()==2)
            {
                panelLaCarta.add(btnItem);
                System.out.println("Agrega a la carta");
            }
            else if(item.getIdMenu()==1)
            {
                panelMenuDelDia.add(btnItem);
                System.out.println("Agrega al menu");
            }
        });
                
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);
         c.insets = new Insets(5,0,5,0);//Margin de Css top, left botton rigth
        
         c.gridx=0; //Columna
         c.gridy=0; //fila
         c.weightx=5;
         c.anchor = GridBagConstraints.LINE_END;
         add(linea1,c);
                      
         c.gridy=1; //fila
         c.weightx = 2.0;
         c.anchor = GridBagConstraints.LINE_START;
         add(linea2,c);
          
         c.gridy=3; //fila
         add(linea4,c);
         
         c.fill=GridBagConstraints.BOTH;
         c.anchor = GridBagConstraints.CENTER;
         c.weighty = 1;                //reset to the default
         c.weightx = 3;
         
         c.gridy=2; //fila
         add(menuDelDia,c);
         
         c.gridy=4; //fila
         add(laCarta,c);
         
    }
    /*metodo que llama al reescribir dispose()*/
    public JFrame getFrame(){
        return this;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       String nombreProducto = ae.getActionCommand();
       if(ae.getSource() != ordenes){
           ProductoOrden pseleccionado = new ProductoOrden(nombreProducto,"Sin observaciones","1");
           System.out.println("pseleccionado "+pseleccionado.getNombre()+"\t"+pseleccionado.getObservacion()+"\t"+pseleccionado.getCantidad());
           /*Aqui llamo a ObservacionesVentana y reescribo el metodo dispose para que pueda cerrar la venta a la que llamo y me regrese a esta(MenuVentana)*/
           ObservacionesVentana obj = new ObservacionesVentana(this, pseleccionado)
           {
               public void dispose(){
               getFrame().setEnabled(true);
               super.dispose();
               }
           };
           this.setEnabled(false);
           obj.setVisible(true);
           System.out.println("pseleccionado "+pseleccionado.getNombre()+"\t"+pseleccionado.getObservacion()+"\t"+pseleccionado.getCantidad());
           productosOrden.add(pseleccionado);
       }else
           if(ae.getSource()== ordenes){
               if(bandera)vo1 = new VistaOrden(productosOrden, num_mesa, descripcionComen, this, mesaV);
               else {System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiii");vo1 = new VistaOrden(productosOrden, num_mesa, descripcionComen, this, mesaV,comensal);}
           }
      // System.out.println(ae.getActionCommand());
    }
    
}
