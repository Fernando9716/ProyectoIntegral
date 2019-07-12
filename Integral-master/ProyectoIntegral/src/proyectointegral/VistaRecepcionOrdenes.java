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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author David
 */
public class VistaRecepcionOrdenes extends JFrame{
    private VistaOrdenMesa raiz;
    private GridBagConstraints conf;
    private JScrollPane scroll;
    private JPanel contenedor;
    public VistaRecepcionOrdenes(){
        raiz=null;
        conf=new GridBagConstraints();
        conf.insets= new Insets(5,5,5,5);
        conf.fill=GridBagConstraints.BOTH;
        scroll =new JScrollPane();
        contenedor=new JPanel();
        contenedor.setLayout(new GridBagLayout());
        scroll.setViewportView(contenedor);
        //conf.weightx=1;
         //conf.weighty=1;
        
        add(scroll);
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(700,500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void agregarOrden(Producto[] comida){
        VistaOrdenMesa nuevo=new VistaOrdenMesa(comida, "tipo", this);
        if(raiz==null){
            conf.gridx=0;
            conf.gridy=0;
            raiz=nuevo;
            contenedor.add(nuevo,conf);
        }else{
            int x=1,y=0;
            VistaOrdenMesa aux=raiz;
            while(aux.getSiguiente()!=null){
                aux=aux.getSiguiente();
                if(x<4)
                    x++;
                else{
                    x=0;
                    y++;
                }
            }
            aux.setSiguiente(nuevo);
            conf.gridx=x;
            conf.gridy=y;
            contenedor.add(nuevo,conf);
            validate();
        }
    }
    public void eliminar(JPanel com){
        contenedor.remove(com);
        if(com==raiz){
            raiz=raiz.getSiguiente();
        }else{
            VistaOrdenMesa aux=raiz;
            while(aux.getSiguiente()!=null){
                if(aux.getSiguiente()==com)
                    break;
                aux=aux.getSiguiente();
            }
            aux.setSiguiente(aux.getSiguiente().getSiguiente());
        }
        VistaOrdenMesa aux=raiz;
        aux=raiz;
        int x=0,y=0;
        while(aux!=null){
            conf.gridx=x;
            conf.gridy=y;
            contenedor.add(aux,conf);
            if(x<4)
                x++;
            else{
                x=0;
                y++;
            }
            aux=aux.getSiguiente();
        }
        if(x<4)
                x++;
            else{
                x=0;
                y++;
            }
        conf.gridx=x;
            conf.gridy=y;
            contenedor.add(new JPanel(),conf);
        validate();
    }
         /*   contenedor.remove(com);
        if(com==raiz){
            raiz=raiz.getSiguiente();
            acomodarComponentes(0,0, raiz);
        }else{
            int x=1,y=0;
            VistaOrdenMesa aux=raiz;
            while(aux.getSiguiente()!=null){
                if(com==aux.getSiguiente())
                    break;
                aux=aux.getSiguiente();
                if(x<4)
                    x++;
                else{
                    x=0;
                    y++;
                }
            }
            aux.setSiguiente(aux.getSiguiente().getSiguiente());
            acomodarComponentes(x, y, aux.getSiguiente());
        }
    }
    private void acomodarComponentes(int x, int y,VistaOrdenMesa inicio){
        while(inicio!=null){
            conf.gridx=x;
            conf.gridy=y;
            contenedor.add(inicio,conf);
            inicio.getSiguiente();
        }
    }*/
}
