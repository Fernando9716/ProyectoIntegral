package proyectointegral;

import java.awt.Color;
import java.awt.Font;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Comensales extends JFrame implements ActionListener{
   // Ordenes lf= new Ordenes();
     Orden on= new Orden();
    private JFrame v;
    private Color azul,morado;
    private JButton volver, cobrar;
    private Font bahnschriftCondensed,agencyFB,agencyFB2,agencyFB3;
    private JPanel panel,panel1,panel2,panel3,panel4;
    private ArrayList<String> nombre;
    private JScrollPane scroll;
   // private String titulo =lf.getNombre(nombre) ;
    public Comensales(String m){
        nombre=on.getComensalesmesa(Integer.parseInt(m));
        otros();
        paneles();
        
      /*  nombre =new ArrayList();
        nombre.add("Fer");
        nombre.add("Fer");
        nombre.add("Fer");
        nombre.add("Fer");
        nombre.add("Fer");
        nombre.add("Fer");
        nombre.add("Fer");
        nombre.add("Fer");
        nombre.add("Fer");
        nombre.add("Fer");
        nombre.add("Fer");
        nombre.add("Fer");
        nombre.add("Fer");*/
        
        
        //Panel COMENSALES
            JTextField titulo = new JTextField("Comensales");
            titulo.setBorder(null);
            titulo.setEditable(false);
            titulo.setBackground(null);
            titulo.setFont(agencyFB2);
            titulo.setHorizontalAlignment(JTextField.CENTER);
            panel1.add(titulo);
            
        //Panel subtitulo
            JTextField subTitulo = new JTextField(m);
            subTitulo.setBorder(null);
            subTitulo.setEditable(false);
            subTitulo.setBackground(null);
            subTitulo.setFont(agencyFB);
            panel2.add(subTitulo);
            
            
        //Panel donde van a ir los paneles dinámicos
        int k=nombre.size();
            for(int i=0; i<k; i++){
                panelesDinamicos(nombre.get(i));
            panel3.setLayout(new BoxLayout(panel3,BoxLayout.Y_AXIS));
            }
        //Panel de botones
        
            ImageIcon cob = new ImageIcon(getClass().getResource("../iconos/cobrar.png"));
            ImageIcon vol = new ImageIcon(getClass().getResource("../iconos/volver.png"));
            
            volver = new JButton(vol);
            cobrar = new JButton(cob);
            volver.setBorder(null);
            cobrar.setBorder(null);
            volver.setBackground(null);
            cobrar.setBackground(null);
            cobrar.addActionListener(this);
            volver.addActionListener(this);
            
            panel4.add(volver);
            panel4.add(cobrar);
            //panel4.setLayout(new BoxLayout(panel4,BoxLayout.X_AXIS));
            
        //Panel segundo principal  
            panel.add(panel1);
            panel.add(panel2);
            panel.add(scroll);
            panel.add(panel4);
            panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
            
        //Frame, ventana principal
            v = new JFrame();
            v.setVisible(true);
            v.setSize(500,600);
            v.setLocationRelativeTo(null);
            v.getContentPane().add(panel);
            v.getContentPane().setBackground(morado);
            v.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            //panel.setBorder(BorderFactory.createMatteBorder(5,5,5,5, Color.black));
        
    }
    
    public void otros(){
        bahnschriftCondensed = new Font("Bahnschrift Condensed",0,30);
        agencyFB  = new Font("Agency FB",0,20);
        agencyFB2 = new Font("Agency FB",0,40);
        agencyFB3 = new Font("Agency FB",0,15);
        azul      = Color.decode("#6284C4");
        morado    = Color.decode("#F49F9F");
    }
    
    public void paneles(){
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
    }
    
    public void panelesDinamicos (String nombre){
        nombre.getClass();
        
        
        ImageIcon ver1     = new ImageIcon(getClass().getResource("../iconos/ver.png"));
        JButton ver        = new JButton(ver1);
        JCheckBox checkBox = new JCheckBox();
        JTextField persona = new JTextField(nombre);
        JPanel panelProv   = new JPanel();
        scroll = new JScrollPane(panel3);
        scroll.setBorder(null);
        
        ver.setBorder(null);
        ver.setBackground(null);
        
        checkBox.setBackground(null);
        
        persona.setBorder(null);
        persona.setFont(agencyFB3);
        persona.setBackground(null);
        
        panelProv.add(checkBox);
        panelProv.add(persona);
        panelProv.add(ver);
        panelProv.setBorder(null);
        panelProv.setBackground(null);
        
        panel3.add(panelProv);
        panel3.setBackground(morado);
        panel3.updateUI();
    }
    
    public static void main(String[] args) {
        Comensales mnmnj = new Comensales("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(cobrar))
        {
            Ticket t;
         t = new Ticket();
        t.setVisible(true);
        this.disable();
        
        }
        else
        {
            this.dispose();
        }
        
    }
    
}
