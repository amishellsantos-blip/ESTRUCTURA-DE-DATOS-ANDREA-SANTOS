package Tema1_Variables_y_tipos_de_datos.Ejercicios_con_entrada_de_datos;
import java.util.Scanner;
/*
 * Ejercicio 3 — Promedio de notas
 * Tema: Variables y tipos de datos
 * Descripción: Solicitar el nombre del estudiante y cuatro notas
 * de tipo double, calcular el promedio y determinar mediante
 * una variable boolean si el estudiante aprobó (promedio >= 3.0).
 * Mostrar el nombre, el promedio y el estado final.
 */
public class Ejercicio3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();

        double[] notas = new double[4];
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Ingrese la nota " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
        }

        double promedio = (notas[0] + notas[1] + notas[2] + notas[3]) / 4;
        boolean aprobado = promedio >= 3.0;

        System.out.println("\nEstudiante: " + nombre);
        System.out.println("Promedio  : " + promedio);
        System.out.println("Estado    : " + (aprobado ? "Aprobado" : "Reprobado"));

        scanner.close();
    }
}
