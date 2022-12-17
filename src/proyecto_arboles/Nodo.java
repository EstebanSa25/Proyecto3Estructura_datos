/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_arboles;

/**
 *
 * @author Oscar
 */
import java.util.TreeMap;
import java.awt.*;
import javax.swing.*;
public class Nodo {

    private String dato;
    private String Genero;
    private Nodo izquierda, derecha;
    private int Num;

    public Nodo(String dato, String Genero) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
        this.Genero = Genero;
    }

    public String getDato() {
        return dato;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int Num) {
        this.Num = Num;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }



    public void imprimirDato() {
        System.out.println(this.getDato());
    }

    public int nodosCompletos(Nodo n) {
        if (n == null) {
            return 0;
        } else {
            if (n.izquierda != null && n.derecha != null) {
                return nodosCompletos(n.izquierda) + nodosCompletos(n.derecha) + 1;
            }
            return nodosCompletos(n.izquierda) + nodosCompletos(n.derecha);

        }
    }
    


    
}//class
