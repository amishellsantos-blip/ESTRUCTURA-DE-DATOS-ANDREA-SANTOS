package Arrays_y_Busqueda;
import java.util.Scanner;
/*2. Buscador de Cédulas (Base de Datos Bancaria)
Un banco tiene una lista de 1.000 clientes organizados de forma estricta y ascendente por su 
número de cédula o ID.

El Problema: Un cliente llega a la ventanilla y da su número. El sistema debe encontrar sus datos
 de la manera más rápida posible (en pocos pasos).
Algoritmo a usar: Búsqueda Binaria. Como los datos ya están ordenados, este algoritmo permitirá 
encontrar al cliente dividiendo la lista a la mitad en cada paso. */
public class Ejercicio2 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner (System.in);

        int[] cedulas = {100001, 100002, 100003, 100004, 100005, 100006, 100007, 100008, 100009, 100010};

        System.out.print("Ingrese el número de cédula del cliente a buscar: ");
        int buscar = scanner.nextInt();

        int inicio = 0;
        int fin = cedulas.length - 1;
        int posicion = -1;

        while (inicio <= fin) {

            int medio = inicio + (fin - inicio) / 2;

            if (cedulas[medio] == buscar) {
                posicion = medio;
                break;

            } else if (cedulas[medio] < buscar) {
                inicio = medio + 1;
                
            } else {
                fin = medio - 1;
            }
        }

        if (posicion != -1) {
            System.out.println("Cliente  con cédula " + buscar + " encontrado en la posición: " + posicion);
        } else {
            System.out.println("Cliente no encontrado en la base de datos.");
        }

        scanner.close();
    }
    
}
