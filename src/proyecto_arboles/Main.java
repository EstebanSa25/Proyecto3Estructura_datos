/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_arboles;

import GraficarArbol.Lienzo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.runtime.JSType.isString;
import static proyecto_arboles.Controlador.Url_imagen;
import sun.security.validator.ValidatorException;

/**
 *
 * @author Oscar
 */
public class Main {



    public static void main(String[] args) {

        Controlador objControlador = new Controlador();//se encargara de controlar todo para no sobrecargar el Main
      
       

        String Nombre;
        String Genero;
        int opcion = 0;
        String[] Genero_solicitar = {
            "Femenino",
            "Masculino"
        };
        boolean validacion;
        objControlador.Pantalla_Inicial();
        objControlador.JoptionMessage_icon("alerta.png","RECORDATORIO\nLos nombres se insertarán por orden alfabético y por género","Recordatorio");
        objControlador.InsertarValores_Carlos();
        do {

            try {

                opcion = Integer.parseInt(objControlador.JOptionInput_Generico_normal("Arbol.png",
                        "1--Insertar\n"
                        + "2--Pre-orden\n"
                        + "3--In-orden\n"
                        + "4--Post-orden\n"
                        + "5--Buscar personas de un genero\n"
                        + "6--Ver datos adicionales del arbol\n"
                        + "7--Graficar arbol\n"
                        + "8--Cerrar Grafico\n"
                        + "9--Salir",
                        "Menu"));

            } catch (Exception e) {
            }
            switch (opcion) {
                case 1:
                    objControlador.CerrarGrafico();
                    Nombre = objControlador.JOptionInput_Generico_normal("add_icon.png", "Digite un Nombre", "Nombre de persona");
                    validacion = objControlador.ValidarNombre(Nombre);
                    if (validacion == false) {
                        if (!Nombre.equals("")) {
                            Genero = objControlador.JOptionInput_Genero_Opciones("Genero.png", "Selecciona el genero", "Genero", Genero_solicitar);
                            switch (Genero) {
                                case "Femenino":
                                    Genero = "F";
                                    break;
                                case "Masculino":
                                    Genero = "M";
                                    break;
                            }
                            objControlador.InsertarDatos(Nombre, Genero);
                        } else {

                            objControlador.Mensaje_error("No se ingreso ningun nombre");

                        }
                    } else {

                        objControlador.Mensaje_error("Nombre invalido\nno puede contener numeros");

                    }

                    break;
                case 2:
                    objControlador.CerrarGrafico();
                    objControlador.Preorden();
                    break;
                case 3:
                    objControlador.CerrarGrafico();
                    objControlador.Inorden();
                    break;
                case 4:
                    objControlador.CerrarGrafico();
                    objControlador.PostOrden();
                    break;
                case 5:
                    objControlador.CerrarGrafico();
                    String Generos_buscar;
                    if (objControlador.Vacio() != false) {
                        objControlador.Mensaje_error("El arbol esta vacio");
                    } else {
                        Genero = objControlador.JOptionInput_Genero_Opciones("Genero.png", "Selecciona el genero", "Tipo de genero", Genero_solicitar);
                        switch (Genero) {
                            case "Femenino":
                                Genero = "F";
                                break;
                            case "Masculino":
                                Genero = "M";
                                break;
                        }
                        objControlador.BuscarGenero(Genero);
                    }
                    break;
                case 6:
                    objControlador.Opcion_seis();
                    break;
                case 7:

                    objControlador.MostrarGrafico();

                
                    break;
                case 8:
                    objControlador.CerrarGrafico();
                    break;
                case 9:
                    System.exit(0);
                    break;

            }
        } while (opcion != 9);

    } //main

} //class
