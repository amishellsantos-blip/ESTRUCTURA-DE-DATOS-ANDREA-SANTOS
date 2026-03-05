package Tema2_Variables_por_referencia.Ejercicios_con_entrada_de_datos;
import java.util.Scanner;
/*
 * Ejercicio 8 — Copia real vs referencia
 * Tema: Variables por referencia
 * Descripción: Pedir al usuario 3 calificaciones para llenar un arreglo llamado notas[].
 * Luego crear un arreglo notasRespaldo[] realizando una copia real de los datos,
 * copiando cada elemento uno por uno. Después el usuario ingresa un nuevo valor
 * para modificar notas[0]. Finalmente se muestran ambos arreglos para demostrar
 * que notasRespaldo no cambió, ya que es una copia independiente y no una referencia.
 */
public class Ejercicio8 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] notas = new double[3];
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Ingrese la calificación " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
        }

        double[] notasRespaldo = new double[notas.length];
        for (int i = 0; i < notas.length; i++) {
            notasRespaldo[i] = notas[i];
        }

        System.out.print("\nIngrese una nueva calificación para modificar notas[0]: ");
        notas[0] = scanner.nextDouble();

        System.out.println("\nCalificaciones en el arreglo original:");
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Calificación " + (i + 1) + ": " + notas[i]);
        }

        System.out.println("\nCalificaciones en el arreglo de respaldo:");
        for (int i = 0; i < notasRespaldo.length; i++) {
            System.out.println("Calificación " + (i + 1) + ": " + notasRespaldo[i]);
        }

        scanner.close();
    }
}
