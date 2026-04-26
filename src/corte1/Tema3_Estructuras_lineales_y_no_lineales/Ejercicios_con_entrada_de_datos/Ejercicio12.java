package Tema3_Estructuras_lineales_y_no_lineales.Ejercicios_con_entrada_de_datos;
import java.util.Scanner;
/*
 * Ejercicio 12 — Registro de temperaturas
 * Tema: Estructuras lineales (arreglos)
 * Descripción: Solicitar al usuario las temperaturas máximas registradas
 * durante los 7 días de la semana y almacenarlas en un arreglo. Luego
 * calcular el promedio semanal, identificar el día con la temperatura
 * más alta y el día con la temperatura más baja, y finalmente indicar
 * cuáles días tuvieron temperaturas por encima del promedio.
 */
public class Ejercicio12 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner (System.in);

        double[] temperaturas = new double[7];

        double suma = 0;
        int diacalorMax = 0;
        int diacalorMin = 0;

        for (int i = 0; i < temperaturas.length; i++) {
            System.out.print("Ingrese la temperatura máxima del día " + (i + 1) + ": ");
            temperaturas[i] = scanner.nextDouble();
            suma += temperaturas[i];

            if (temperaturas[i] > temperaturas[diacalorMax]) {
                diacalorMax = i;
            }

            if (temperaturas[i] < temperaturas[diacalorMin]) {
                diacalorMin = i;
            }
        }

        double promedio = suma / temperaturas.length;

        System.out.println("\nPromedio semanal: " + promedio);
        System.out.println("Dia con temperatura más alta: Día " + (diacalorMax + 1) + " con " + temperaturas[diacalorMax] + "°");
        System.out.println("Dia con temperatura más baja: Día " + (diacalorMin + 1) + " con " + temperaturas[diacalorMin] + "°");

        System.out.println("\nDías con temperatura por encima del promedio:");
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] > promedio) {
                System.out.println("Día " + (i + 1) + ": " + temperaturas[i] + "°");
            }
        }

        scanner.close();
    }
}
