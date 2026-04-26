package Repaso_primer_corte;
import java.util.Scanner;
/*Ejercicio 1: Inventario "TecnoStore" (Shell Sort)
Objetivo: Registrar productos y ordenarlos por su ID para realizar búsquedas rápidas.
¿Qué debes hacer?
1. Clase: Crea una clase Producto con: id (int), nombre (String), precio (double) y stock (int).
2. Entrada de Datos: Pide al usuario que ingrese los datos de 5 productos por teclado y guárdalos en un arreglo
Producto[] .
3. Ordenamiento: Usa Shell Sort para ordenar los productos de menor a mayor según su id .
4. Búsqueda: Pide un id al usuario y búscalo usando Búsqueda Binaria.
Ejemplo de lo que se debe ver en consola:--- REGISTRO DE PRODUCTOS --
Producto 1:
Ingrese ID: 105
Ingrese Nombre: Mouse
Ingrese Precio: 25.50
Ingrese Stock: 10
... (se repite hasta completar los 5 productos) ...--- INVENTARIO ORDENADO POR ID (Shell Sort) --
ID: 101 | Nombre: Laptop | Precio: 850.0 | Stock: 5
ID: 102 | Nombre: Teclado | Precio: 45.0  | Stock: 12
ID: 105 | Nombre: Mouse   | Precio: 25.5  | Stock: 10
...--- BÚSQUEDA DE PRODUCTO --
Ingrese el ID a buscar: 102
>> PRODUCTO ENCONTRADO: Teclado - Precio: $45.0 - Stock: 12 
*/

class Producto {
    int id;
    String nombre;
    double precio;
    int stock;

    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
}

public class Ejercicio1{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Producto[] productos = new Producto[5];

        for (int i = 0; i < productos.length; i++) {
            System.out.println("Producto " + (i + 1) );
            System.out.print("Ingrese ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Ingrese Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese Precio: ");
            double precio = scanner.nextDouble();
            System.out.print("Ingrese Stock: ");
            int stock = scanner.nextInt();

            System.out.println(" ");
            productos[i] = new Producto(id, nombre, precio, stock);
        }

        int n = productos.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i++) {

                Producto temp = productos[i];
                int j;

                for (j = i; j >= gap && productos[j - gap].id > temp.id; j -= gap) {

                    productos[j] = productos[j - gap];
                }

                productos[j] = temp;
            }
        }

        System.out.println("--- INVENTARIO ORDENADO POR ID (Shell Sort) ---");

        for (Producto producto : productos) {

            System.out.println("ID: " + producto.id + " | Nombre: " + producto.nombre + " | Precio: " + producto.precio + " | Stock: " + producto.stock);
        }

        System.out.println("\n--- BÚSQUEDA DE PRODUCTO ---");
        System.out.print("Ingrese el ID a buscar: ");
        int buscar = scanner.nextInt();

        int inicio = 0;
        int fin = productos.length - 1;
        int posición = -1;

        while (inicio <= fin) {

            int medio = inicio + (fin - inicio) / 2;

            if (productos[medio].id == buscar) {
                posición = medio;
                break;

            } else if (productos[medio].id < buscar) {
                inicio = medio + 1;

            } else {
                fin = medio - 1;
            }
        }

        if (posición != -1) {
            Producto encontrado = productos[posición];
            System.out.println(">> PRODUCTO ENCONTRADO: " + encontrado.nombre + " - Precio: $" + encontrado.precio + " - Stock: " + encontrado.stock);
        } else {
            System.out.println("Producto no encontrado.");
        }

        scanner.close();
    }

}