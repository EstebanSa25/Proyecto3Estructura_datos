/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_arboles;

import javafx.scene.shape.Ellipse;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Esteban
 */
public class Arbol {

    private Nodo raiz;
    private String Nombres_generos;
    private String inorden = "", preorden = "", postorden = "";
    private int cant;
    private int Altura;
    private int Contador;

    public Arbol() {

    }

    public boolean existe(String busqueda) {
        return existe(this.raiz, busqueda);
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    private boolean existe(Nodo n, String busqueda) {
        if (n == null) {
            return false;
        }
        if (n.getDato().equals(busqueda)) {
            return true;
        } else if (busqueda.compareTo(n.getDato()) < 0) {
            return existe(n.getIzquierda(), busqueda);
        } else {
            return existe(n.getDerecha(), busqueda);
        }

    }

    public void Genero_buscar(String buscar) {
        if (this.raiz != null) {
            switch (buscar) {
                case "F":
                    Nombres_generos = "Lista de personas de genero femenino:\n";
                    this.Genero_buscar(this.raiz, buscar);
                    JOptionPane.showMessageDialog(null, Nombres_generos, "Genero Femenino", 0, icono("/imagenes/Femenino.png", 40, 40));
                    break;
                case "M":
                    Nombres_generos = "Lista de personas de genero Masculino\n";
                    this.Genero_buscar(this.raiz, buscar);
                    JOptionPane.showMessageDialog(null, Nombres_generos, "Genero Masculino", 0, icono("/imagenes/masculino3.png", 40, 40));
                    break;
            }

        } else {
            JOptionPane.showMessageDialog(null, "El arbol esta vacio", "Error", 0, icono("/imagenes/error.png", 40, 40));
        }
    }

    public void Genero_buscar(Nodo n, String busqueda) {
        if (n == null) {

        } else {
            if (n.getGenero().equals(busqueda)) {
                Nombres_generos += n.getDato() + "\n";
                //se utiliza una variable de local y no en el metodo 
                //por que se necesita imprimir en JOptionPane y para mostrarlo en 1 sola ventana se guarda en esta variable aparte que esta misma variable sirve para genero masculino y femenino
                //Si se imprimera por consola no habria problema y se podria imprimir sin necesidad de almacenar los datos en una variable
            } else {

            }
            Genero_buscar(n.getIzquierda(), busqueda);
            Genero_buscar(n.getDerecha(), busqueda);
        }

    }

    private void Cantidad_hojas(Nodo reco) {
        if (reco != null) {
            if (reco.getIzquierda() == null && reco.getDerecha() == null) {
                cant++;
            }
            Cantidad_hojas(reco.getIzquierda());
            Cantidad_hojas(reco.getDerecha());
        }
    }

    public int Cantidad_hojas() {
        cant = 0;
        Cantidad_hojas(raiz);
        return cant;
    }

    public int Ver_Altura() {
        if (raiz != null) {
            Altura = 0;
            Ver_Altura(raiz, 0);
            return Altura;
        } else {
            JOptionPane.showMessageDialog(null, "El arbol esta vacio", "Error", 0, icono("/imagenes/error.png", 40, 40));
            return 0;
        }
    }

    private void Ver_Altura(Nodo padre, int nivel) {
        if (padre != null) {
            Ver_Altura(padre.getIzquierda(), nivel + 1);
            if (nivel > Altura) {
                Altura = nivel;
            }
            Ver_Altura(padre.getDerecha(), nivel + 1);
        }
    }

    public void insertar(String dato, String Genero) {
        if (this.raiz == null) {
            this.raiz = new Nodo(dato, Genero);
        } else {
            this.insertar(this.raiz, dato, Genero);
        }
        if(existe(dato)==false){
         JOptionPane.showMessageDialog(null, "El nombre no se pudo insertar por orden alfabetico o por genero", "Error", 0, icono("/imagenes/error.png", 40, 40));
        }
    }

    public void insertar(Nodo padre, String Nombre, String Genero) {

        if (Nombre.compareTo(padre.getDato()) > 0) {
            if (padre.getDerecha() == null) {
                if(Genero=="M"){
                padre.setDerecha(new Nodo(Nombre, Genero));
                }
            } else {
                this.insertar(padre.getDerecha(), Nombre, Genero);
            }
        } else {
            if (padre.getIzquierda() == null) {
            if( Genero=="F"){
                padre.setIzquierda(new Nodo(Nombre, Genero));
            }
            } else {
                this.insertar(padre.getIzquierda(), Nombre, Genero);
            }
        }
        
    }

    private void preorden(Nodo n) {
        if (n != null) {
            preorden += n.getDato() + "\n";
            preorden(n.getIzquierda());
            preorden(n.getDerecha());
        }
    }

    private void inorden(Nodo n) {

        if (n != null) {
            inorden(n.getIzquierda());
            inorden += n.getDato() + "\n";
            inorden(n.getDerecha());
        }
    }

    private void postorden(Nodo n) {
        if (n != null) {
            postorden(n.getIzquierda());
            postorden(n.getDerecha());
            postorden += n.getDato() + "\n";
        }
    }

    public void preorden() {
        preorden = "";
        if (raiz != null) {
            this.preorden(this.raiz);
            JOptionPane.showMessageDialog(null, preorden, "Pre-orden", 0, icono("/imagenes/tree.png", 40, 40));
        } else {
            JOptionPane.showMessageDialog(null, "El arbol esta vacio", "Error", 0, icono("/imagenes/error.png", 40, 40));
        }
    }

    public void inorden() {
        inorden = "";
        if (raiz != null) {
            this.inorden(this.raiz);
            JOptionPane.showMessageDialog(null, inorden, "In-orden", 0, icono("/imagenes/tree.png", 40, 40));
        } else {
            JOptionPane.showMessageDialog(null, "El arbol esta vacio", "Error", 0, icono("/imagenes/error.png", 40, 40));
        }
    }

    public void postorden() {
        postorden = "";
        if (raiz != null) {
            this.postorden(this.raiz);
            JOptionPane.showMessageDialog(null, postorden, "Post-orden", 0, icono("/imagenes/tree.png", 40, 40));
        } else {
            JOptionPane.showMessageDialog(null, "El arbol esta vacio", "Error", 0, icono("/imagenes/error.png", 40, 40));
        }
    }

    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }

   
 

}
