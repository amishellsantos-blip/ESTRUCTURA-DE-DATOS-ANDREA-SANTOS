package Tema1_Variables_y_tipos_de_datos.Ejercicios_con_entrada_de_datos;
import java.util.Scanner;
/*
 * Ejercicio 5 — Calculadora de IMC
 * Tema: Variables y tipos de datos
 * Descripción: Solicitar el nombre, el peso en kilogramos y la altura
 * en metros (double), calcular el Índice de Masa Corporal (IMC)
 * usando la fórmula peso / (altura * altura) y clasificar el resultado
 * según los rangos establecidos.
 */
public class Ejercicio5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su peso en kilogramos: ");
        double peso = scanner.nextDouble();

        System.out.print("Ingrese su altura en metros: ");
        double altura = scanner.nextDouble();

        double imc = peso / (altura * altura);
        String clasificacion;

        if (imc < 18.5) {
            clasificacion = "Bajo peso";
        } else if (imc < 25) {
            clasificacion = "Peso normal";
        } else if (imc < 30) {
            clasificacion = "Sobrepeso";
        } else {
            clasificacion = "Obesidad";
        }

        System.out.println("\n" + nombre + ", su IMC es: " + imc + " (" + clasificacion + ")");

        scanner.close();
        
    }
}
