package Tema3_Estructuras_lineales_y_no_lineales.Ejercicios;
/*
 * Ejercicio 13 — Clasificación de residuos
 * Tema: Estructuras no lineales (Árbol binario)
 * Descripción: Crear una estructura de árbol utilizando nodos con referencias
 * izquierda y derecha para representar la jerarquía de tipos de residuos,
 * y recorrer el árbol imprimiendo cada nivel.
 */
public class Ejercicio13 {

    public static void main(String[] args) {
        Nodo raiz = new Nodo("Residuos");

        Nodo organicos = new Nodo("Orgánicos");
        Nodo inorganicos = new Nodo("Inorgánicos");

        raiz.izquierda = organicos;
        raiz.derecha = inorganicos;

        organicos.izquierda = new Nodo("Restos de comida");
        organicos.derecha = new Nodo("Residuos de jardín");

        inorganicos.izquierda = new Nodo("Plásticos");
        inorganicos.derecha = new Nodo("Metales");

        System.out.println("Clasificación de residuos:");
        imprimirArbol(raiz, 0);
    }
    
}
