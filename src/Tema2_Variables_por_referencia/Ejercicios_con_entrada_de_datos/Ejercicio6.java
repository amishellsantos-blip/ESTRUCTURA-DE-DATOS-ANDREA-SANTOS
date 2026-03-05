package Tema2_Variables_por_referencia.Ejercicios_con_entrada_de_datos;
import java.util.Scanner;
/*
 * Ejercicio 6 — Demostración por valor
 * Tema: Variables por referencia
 * Descripción: Solicitar al usuario dos números enteros (a y b). Luego asignar
 * el valor de a a la variable b (b = a). Después pedir un nuevo valor para b
 * y mostrar en pantalla los valores de a y b. El objetivo es demostrar que
 * al copiar un valor entre variables primitivas, cada una guarda su propio
 * valor en memoria, por lo que cambiar b no afecta a la variable a.
 */
public class Ejercicio6{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el valor de a: ");
        int a = scanner.nextInt();

        int b = a; 
        System.out.println("Valor de b después de asignar b = a: " + b);

        System.out.print("\nIngrese un nuevo valor para b: ");
        b = scanner.nextInt();

        System.out.println("\nValor de a: " + a);
        System.out.println("Valor de b: " + b);

        scanner.close();
    }
}