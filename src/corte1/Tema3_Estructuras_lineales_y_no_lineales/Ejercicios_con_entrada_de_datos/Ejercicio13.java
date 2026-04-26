package Tema3_Estructuras_lineales_y_no_lineales.Ejercicios_con_entrada_de_datos;
import java.util.Scanner;
/*
 * Ejercicio 13 — Buscar en lista
 * Tema: Estructuras lineales (búsqueda lineal en arreglos)
 * Descripción: Solicitar al usuario cinco nombres de empleados y
 * almacenarlos en un arreglo. Luego pedir un nombre para buscarlo
 * dentro de la lista. Recorrer el arreglo utilizando una búsqueda
 * lineal para verificar si el empleado existe e indicar la posición
 * en la que fue encontrado.
 */
public class Ejercicio13 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner (System.in);

        String[] empleados = new String[5];

        for (int i = 0; i < empleados.length; i++) {
            System.out.print("Ingrese el nombre del empleado " + (i + 1) + ": ");
            empleados[i] = scanner.nextLine();
        }

        System.out.print("\nIngrese el nombre del empleado a buscar: ");
        String Buscar = scanner.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i].equalsIgnoreCase(Buscar)) {
                System.out.println("Empleado encontrado en la posición: " + (i + 1));
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Empleado no encontrado en la lista.");
        }

        scanner.close(); 
    }
    
}
