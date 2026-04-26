package Arrays_y_Busqueda;

import java.util.Scanner;

/*1. El Cajero del Supermercado (Inventario)
Un cajero escanea un producto con el código de barras 770123. El sistema tiene un arreglo 
desordenado con los códigos de los productos disponibles en la estantería actual.

El Problema: Debes recorrer la lista para verificar si el producto existe y en qué posición 
de la estantería se encuentra. Algoritmo a usar: Búsqueda Lineal. Es el ideal porque los 
productos en la estantería no tienen un orden numérico específico.
 */
public class Ejercicio1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] productos = { 123456, 654321, 770123, 111111, 222222 };

        System.out.print("Ingrese el código de barras del producto a buscar: ");
        int buscar = scanner.nextInt();

        int posicion = -1;

        for (int i = 0; i < productos.length; i++) {
            if (productos[i] == buscar) {
                posicion = i;
                break;
            }
        }

        if (posicion != -1) {
            System.out.println("Producto encontrado en la posición: " + posicion);
        } else {
            System.out.println("Producto no encontrado en la estantería.");
        }

        scanner.close();

    }

}
