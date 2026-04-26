package Tema3_Estructuras_lineales_y_no_lineales.Ejercicios;
/*
 * Ejercicio 14 — Árbol de empleados
 * Tema: Estructuras no lineales (Árbol)
 * Descripción: Modelar la jerarquía de una empresa mediante nodos que
 * representan cargos, construir el árbol organizacional e imprimirlo
 * recorriéndolo nivel por nivel.
 */
class NodoEmpleado {
    String cargo;
    NodoEmpleado izquierdo;
    NodoEmpleado derecho;

    public NodoEmpleado(String cargo) {
        this.cargo = cargo;
    }
}

public class Ejercicio14 {
    
    public static void main(String[] args) {

        NodoEmpleado gerente = new NodoEmpleado("Gerente");

        NodoEmpleado supervisor1 = new NodoEmpleado("Supervisor 1");
        NodoEmpleado supervisor2 = new NodoEmpleado("Supervisor 2");

        NodoEmpleado analista1 = new NodoEmpleado("Analista 1");
        NodoEmpleado analista2 = new NodoEmpleado("Analista 2");

        gerente.izquierdo = supervisor1;
        gerente.derecho = supervisor2;

        supervisor1.izquierdo = analista1;
        supervisor1.derecho = analista2;

        System.out.println("Nivel 1: " + gerente.cargo);
        System.out.println("Nivel 2: " + gerente.izquierdo.cargo + ", " + gerente.derecho.cargo);
        System.out.println("Nivel 3: " + gerente.izquierdo.izquierdo.cargo + ", " + gerente.izquierdo.derecho.cargo);

        System.out.println("\n                " + gerente.cargo);
        System.out.println("              /         \\");
        System.out.println("      " + gerente.izquierdo.cargo + "   " + gerente.derecho.cargo);
        System.out.println("       /      \\        ");
        System.out.println(" " + gerente.izquierdo.izquierdo.cargo + "   " + gerente.izquierdo.derecho.cargo);
    }
    
}
