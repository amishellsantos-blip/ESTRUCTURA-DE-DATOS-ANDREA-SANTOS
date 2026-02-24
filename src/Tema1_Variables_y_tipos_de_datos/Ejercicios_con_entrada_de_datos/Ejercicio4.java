package Tema1_Variables_y_tipos_de_datos.Ejercicios_con_entrada_de_datos;
import java.util.Scanner;
/*
 * Ejercicio 4 — Perfil de usuario
 * Tema: Variables y tipos de datos
 * Descripción: Pedir al usuario información personal como nombre,
 * edad, ciudad, correo electrónico y aceptación de términos,
 * utilizando los tipos de datos String, int y boolean.
 * Mostrar un resumen indicando el valor ingresado y el tipo
 * de dato usado en cada campo.
 */
public class Ejercicio4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese su ciudad: ");
        String ciudad = scanner.nextLine();

        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();

        System.out.print("¿Acepta los términos y condiciones? (true/false): ");
        boolean aceptaTerminos = scanner.nextBoolean();

        System.out.println("\n==== Perfil de usuario ====");
        System.out.println("Nombre            : " + nombre + " (String)");
        System.out.println("Edad              : " + edad + " (int)");
        System.out.println("Ciudad            : " + ciudad + " (String)");
        System.out.println("Correo electrónico: " + correo + " (String)");
        System.out.println("Acepta términos   : " + (aceptaTerminos ? "Sí" : "No") + " (boolean)");

        scanner.close();
    }
    
}
