package Tema2_Variables_por_referencia.Ejercicios_con_entrada_de_datos;
import java.util.Scanner;
/*
 * Ejercicio 9 — String inmutable
 * Tema: Variables por referencia
 * Descripción: Pedir al usuario su nombre y guardarlo en la variable nombre.
 * Luego crear otra variable llamada alias y asignarle el valor de nombre.
 * Después pedir al usuario que ingrese un nuevo alias.
 * Finalmente mostrar en pantalla el valor de nombre y el nuevo alias,
 * demostrando que la variable nombre no cambió porque los objetos String
 * en Java son inmutables, es decir, su valor no se puede modificar después
 * de ser creado.
 */
public class Ejercicio9 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        String alias = nombre;

        System.out.print("\nIngrese un nuevo alias: ");
        alias = scanner.nextLine();

        System.out.println("\nNombre original: " + nombre);
        System.out.println("Nuevo alias: " + alias);

        scanner.close();
        
    }
    
}
