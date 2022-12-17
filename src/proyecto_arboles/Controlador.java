/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_arboles;

import GraficarArbol.Lienzo;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.Color;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Oscar
 */
public class Controlador {

    Arbol objArbol = new Arbol();
    Lienzo objLienzo = new Lienzo();
    static String Url_imagen = "/imagenes/";
    JFrame ventana = new JFrame();

    public Controlador() {

    }

    public void iniciar() {

        objLienzo.setObjArbol(objArbol);

    }

    public boolean Vacio() {
        if (objArbol.getRaiz() == null) {
            return true;
        } else {
            return false;
        }
    }

    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }

    public String JOptionInput_Generico_normal(String EndPoint, String Message, String Titulo) {
        return (String) JOptionPane.showInputDialog(null, Message, Titulo,
                JOptionPane.DEFAULT_OPTION, icono(Url_imagen + EndPoint, 40, 40), null, null);
    }

    public String JOptionInput_Genero_Opciones(String EndPoint, String Message, String Titulo, String Opciones[]) {
        return (String) JOptionPane.showInputDialog(null, Message, Titulo,
                JOptionPane.DEFAULT_OPTION, icono(Url_imagen + EndPoint, 40, 40), Opciones, Opciones[0]);
    }

    public void Pantalla_Inicial() {
        // cf5b2a
        UIManager UI = new UIManager();
        UIManager.put("Button.background", Color.decode("#744700"));
        UIManager.put("Button.foreground", Color.white);
        UI.put("OptionPane.background", Color.decode("#cf5b2a"));
        UI.put("Panel.background", Color.decode("#cf5b2a"));
        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.BOLD, 30));
        JOptionPane.showMessageDialog(null, "", "", JOptionPane.PLAIN_MESSAGE, icono(Url_imagen + "PantallaInicial.png", 477, 355));
        UIManager.put("Button.background", new Color(62, 68, 74));
        UIManager.put("Button.foreground", Color.white);
        UI.put("OptionPane.background", Color.decode("#ededed"));
        UI.put("OptionPane.messageForeground", Color.black);
        UI.put("Panel.background", Color.decode("#ededed"));
        UIManager.put("OptionPane.messageFont", new Font("Gadugi", Font.BOLD, 14));
        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.BOLD, 14));
    }

    public void MostrarGrafico() {
        if (Vacio() == false) {
            iniciar();
            ventana.getContentPane().add(objLienzo);
            ventana.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            ventana.setExtendedState(MAXIMIZED_BOTH);
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);

        } else {
            Mensaje_error("El arbol esta vacio");
        }
    }

    public void JoptionMessage_icon(String endpoint, String Mensaje, String Titulo) {
        JOptionPane.showMessageDialog(null, Mensaje, Titulo, 0, icono(Url_imagen + endpoint, 40, 40));
    }

    public void CerrarGrafico() {
        ventana.setVisible(false);
    }

    public void Mensaje_error(String Mensaje) {
        JOptionPane.showMessageDialog(null, Mensaje, "Error", 0, icono(Url_imagen + "error.png", 40, 40));
    }

    public void InsertarDatos(String Nombre, String Genero) {
        objArbol.insertar(Nombre, Genero);
    }

    public void BuscarGenero(String Genero) {

        objArbol.Genero_buscar(Genero);

    }

    public void Opcion_seis() {
         if (Vacio() == false) {
           String Opciones[] = {"Ver cantidad de nodos hoja", "Ver altura del arbol"};
        String Opcion = JOptionInput_Genero_Opciones("tree.png", "", "", Opciones);
        switch (Opcion) {
            case "Ver cantidad de nodos hoja":
                JoptionMessage_icon("tree.png","La cantidad de hojas son: " + objArbol.Cantidad_hojas(),"Cantidad de hojas");
                break;
            case "Ver altura del arbol":
              int Altura=  objArbol.Ver_Altura()+1;
                JoptionMessage_icon("tree.png","La altura del arbol es: " + Altura,"Altura del arbol");
                break;
        }

        } else {
            Mensaje_error("El arbol esta vacio");
        }

       

    }

    public void Inorden() {
        objArbol.inorden();
    }

    public void PostOrden() {
        objArbol.postorden();
    }

    public void Preorden() {
        objArbol.preorden();
    }

    public boolean ValidarNombre(String Nombre) {
        if (Nombre.contains("0") || Nombre.contains("1") || Nombre.contains("2") || Nombre.contains("3") || Nombre.contains("4") || Nombre.contains("5") || Nombre.contains("6") || Nombre.contains("7") || Nombre.contains("8") || Nombre.contains("9")) {
            return true;
        } else {
            return false;
        }
    }

    public void InsertarValores_Carlos() {
        int n =
 JOptionPane.showConfirmDialog(null, "Te gustaria insertar valores por default?", "Arbol de Carlos", JOptionPane.YES_NO_OPTION, 0, icono(Url_imagen+"pregunta.png", 40, 40));
        if (n == 0) {
            objArbol.insertar("Carlos", "M");
            objArbol.insertar("Belén", "F");
            objArbol.insertar("Mauricio", "M");
            objArbol.insertar("Jennifer", "F");
            objArbol.insertar("Nicolás", "M");
            objArbol.insertar("Alicia", "F");
            objArbol.insertar("Benjamín", "M");
            
            JoptionMessage_icon("cheque.png", "Se inserto valores por default", "Valores default");
        } else {
            JoptionMessage_icon("alerta.png", "No se insertaron valores por default", "Alerta");
        }

    }

}
