package Tema1_Variables_y_tipos_de_datos.Ejercicios_con_entrada_de_datos;
import java.util.Scanner;
/*
 * Ejercicio 2 — Conversor de temperatura
 * Tema: Variables y tipos de datos
 * Descripción: Pedir al usuario una temperatura en grados Celsius
 * (double), convertirla a Fahrenheit y Kelvin utilizando
 * las fórmulas correspondientes y mostrar los resultados
 * en una sola línea.
 */
public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la temperatura en grados Celsius: ");
        double celsius = scanner.nextDouble();

        double fahrenheit = (celsius * 9/5) + 32;
        double kelvin = celsius + 273.15;

        System.out.print("\nTemperatura: " + celsius + " °C = " + fahrenheit + " °F = " + kelvin + " K");

        scanner.close();
    }
    
}
