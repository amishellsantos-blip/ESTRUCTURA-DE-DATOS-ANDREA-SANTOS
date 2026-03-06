package Tema3_Estructuras_lineales_y_no_lineales.Ejercicios_con_entrada_de_datos;
import java.util.Scanner;
/*
 * Ejercicio 15 — Árbol de decisiones
 * Tema: Estructuras no lineales (árboles)
 * Descripción: Construir un árbol de decisiones utilizando nodos para
 * clasificar un número ingresado por el usuario. Cada nodo contiene una
 * descripción de la condición a evaluar y referencias a sus hijos
 * izquierdo y derecho. El programa navega el árbol evaluando las
 * condiciones hasta determinar si el número es par positivo, impar
 * positivo, cero o negativo.
 */
class Nodo{
    String descripcion;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(String descripcion) {
        this.descripcion = descripcion;
    }
}
public class Ejercicio15 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner (System.in);

        Nodo raiz = new Nodo("¿El número es mayor que cero?");
        Nodo parImpar = new Nodo("¿El número es par o impar?");
        Nodo esCero = new Nodo("¿El número es cero?");

        Nodo par = new Nodo("El número es par positivo.");
        Nodo impar = new Nodo("El número es impar positivo.");
        Nodo negativo = new Nodo("El número es negativo.");
        Nodo cero = new Nodo("El número es cero.");

        raiz.izquierdo = parImpar;
        raiz.derecho = esCero;

        parImpar.izquierdo = par;
        parImpar.derecho = impar;

        esCero.izquierdo = cero;
        esCero.derecho = negativo;

        System.out.print("Ingrese un número entero: ");
        int numero = scanner.nextInt();

        if (numero > 0) {
            if (numero % 2 == 0) {
                System.out.println(par.descripcion);
            } else {
                System.out.println(impar.descripcion);
            }
        } else if (numero < 0) {
            System.out.println(negativo.descripcion);
        } else {
            System.out.println(cero.descripcion);
        }

        scanner.close();
    }


    
}
