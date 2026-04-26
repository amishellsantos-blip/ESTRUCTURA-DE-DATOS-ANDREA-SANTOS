package Tema3_Estructuras_lineales_y_no_lineales.Ejercicios;
/*
 * Ejercicio 13 — Clasificación de residuos
 * Tema: Estructuras no lineales (Árbol binario)
 * Descripción: Crear una estructura de árbol utilizando nodos con referencias
 * izquierda y derecha para representar la jerarquía de tipos de residuos,
 * y recorrer el árbol imprimiendo cada nivel.
 */
class NodoResiduo { 
    String nombre;
    NodoResiduo izquierdo;
    NodoResiduo derecho;
    
    public NodoResiduo(String nombre) {
        this.nombre = nombre;
    }
}
public class Ejercicio13 {

    public static void main(String[] args) {
        
        NodoResiduo raiz = new NodoResiduo("Residuos");

        NodoResiduo organicos = new NodoResiduo("Orgánicos");
        NodoResiduo inorganicos = new NodoResiduo("Inorgánicos");
        
        NodoResiduo comida = new NodoResiduo("Comida");
        NodoResiduo jardin = new NodoResiduo("Jardín");

        NodoResiduo plastico = new NodoResiduo("Plástico");
        NodoResiduo papel = new NodoResiduo("Papel");

        raiz.izquierdo = organicos;
        raiz.derecho = inorganicos;

        organicos.izquierdo = comida;
        organicos.derecho = jardin;

        inorganicos.izquierdo = plastico;
        inorganicos.derecho = papel;

        System.out.println("Nivel 1: " + raiz.nombre);
        System.out.println("Nivel 2: " + raiz.izquierdo.nombre + ", " + raiz.derecho.nombre);
        System.out.println("Nivel 3: " + raiz.izquierdo.izquierdo.nombre + ", " + raiz.izquierdo.derecho.nombre + ", " + raiz.derecho.izquierdo.nombre + ", " + raiz.derecho.derecho.nombre);   

        System.out.println("\n              " + raiz.nombre);
        System.out.println("             /        \\");
        System.out.println("       " + raiz.izquierdo.nombre + "     " + raiz.derecho.nombre);
        System.out.println("       /    \\          /      \\");   
        System.out.println("  " + raiz.izquierdo.izquierdo.nombre + "  " + raiz.izquierdo.derecho.nombre + "   " + raiz.derecho.izquierdo.nombre + "   " + raiz.derecho.derecho.nombre);
    }
    
}
