package Tema3_Estructuras_lineales_y_no_lineales.Ejercicios_con_entrada_de_datos;
import java.util.Scanner;
/*
 * Ejercicio 11 — Lista de pasajeros
 * Tema: Estructuras lineales (arreglos)
 * Descripción: Solicitar al usuario la cantidad de pasajeros de un vuelo
 * con un máximo de 8 asientos disponibles. Luego pedir el nombre de cada
 * pasajero y almacenarlo en un arreglo. Finalmente mostrar la lista
 * numerada con el número de asiento y el nombre del pasajero, e indicar
 * cuántos asientos quedaron disponibles del total.
 */
public class Ejercicio11 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner (System.in);

        String[] pasajeros = new String[8];

        System.out.println("¿Cuántos pasajeros hay en el vuelo? (máximo 8)");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese el nombre del pasajero " + (i + 1) + ": ");
            pasajeros[i] = scanner.nextLine();
        }

        System.out.println("\nLista de pasajeros:");

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Asiento " + (i + 1) + ": " + pasajeros[i]);
        }

        int disponibles = pasajeros.length - cantidad;
        System.out.println("\nAsientos disponibles: " + disponibles);

        scanner.close();
    }
    
}
