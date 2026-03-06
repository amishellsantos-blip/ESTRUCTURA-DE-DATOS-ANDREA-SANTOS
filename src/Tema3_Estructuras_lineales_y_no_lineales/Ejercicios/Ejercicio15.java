package Tema3_Estructuras_lineales_y_no_lineales.Ejercicios;
import java.util.Scanner;
/*
 * Ejercicio 15 — Registro de temperaturas semanales
 * Tema: Estructuras lineales (Arreglos)
 * Descripción: Guardar la temperatura máxima de cada día en un arreglo,
 * calcular el promedio semanal y determinar qué días estuvieron
 * por encima del promedio.
 */
public class Ejercicio15 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);

        double[] temperaturas = new double[7];
        double suma = 0;
        double promedio;

        for (int i = 0; i < temperaturas.length; i++) {
            System.out.print("Ingrese la temperatura máxima del día " + (i + 1) + ": ");
            temperaturas[i] = scanner.nextDouble();
            suma += temperaturas[i];
        }

        promedio = suma / temperaturas.length;

        System.out.println("\nPromedio semanal: " + promedio);

        System.out.println("\nDías con temperatura por encima del promedio:");

        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] > promedio) {
                System.out.println("Día " + (i + 1) + ": " + temperaturas[i]);
            }
        }
        
        scanner.close();
    }
    
}
