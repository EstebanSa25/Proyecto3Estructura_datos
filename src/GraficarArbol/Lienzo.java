/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraficarArbol;


import proyecto_arboles.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import javax.swing.*;

/**
 *
 * @author Oscar
 */
public class Lienzo extends JPanel {

    private Arbol objArbol;
    public static final int DIAMETRO = 80;
    public static final int RADIO = DIAMETRO / 2;
    public static final int ANCHO = 80;

    public void setObjArbol(Arbol objArbol) {
        
        this.objArbol = objArbol;
        repaint();
    }
    

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString("Arbol Genealogico",  getWidth() / 2-20, 20);
         g.setFont(new Font("TimesRoman", Font.BOLD, 15));
                 g.drawString("Los circulos de color azul representan a las personas de genero masculino",  20, 20);
                 g.drawString("y los circulos de color rosado representan a las personas de genero femenino",  20, 43);
         g.setColor(Color.red);
      g.drawString("Puedes cerrar el grafico digitanto 8 en el Menu",  getWidth() / 2-70, 60);
       g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        pintar(g, getWidth() / 2, 90, objArbol.getRaiz());
        
    }

    private void pintar(Graphics g, int x, int y, Nodo n) {
        
        if (n == null) {
        } else {
            int EXTRA = n.nodosCompletos(n) * (ANCHO / 2);
           g.setColor(Color.BLACK);
           if(n.getGenero()=="F"){
                 g.setColor(Color.PINK);
            g.drawOval(x, y, DIAMETRO, ANCHO);
           }else{
              g.setColor(Color.BLUE);
            g.drawOval(x, y, DIAMETRO, ANCHO);
           }
            g.setColor(Color.BLACK);
           
            g.drawString(n.getDato().toString(), x + 20, y + 40);
            
            
            if (n.getDerecha() != null) {
                 g.setColor(Color.BLACK);
                g.drawLine(x + RADIO, y + RADIO, x + ANCHO + EXTRA + RADIO, y + ANCHO + RADIO);
            }
            
            if (n.getIzquierda() != null) {
                 g.setColor(Color.BLACK);
                g.drawLine(x + RADIO, y + RADIO, x - ANCHO - EXTRA + RADIO, y + ANCHO + RADIO);
            }
            

            pintar(g, x - ANCHO - EXTRA, y + ANCHO, n.getIzquierda());
            pintar(g, x + ANCHO + EXTRA, y + ANCHO, n.getDerecha());
        }
    }
    
  
}//class
