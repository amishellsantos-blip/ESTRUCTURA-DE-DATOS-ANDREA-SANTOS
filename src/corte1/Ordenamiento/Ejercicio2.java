package Ordenamiento;
import java.util.Scanner;
/*2. Organización de Biblioteca Dinámica

Algoritmo obligatorio: Ordenamiento por Inserción (Insertion Sort)

Contexto: Un bibliotecario recibe una caja de libros y los va colocando uno a uno en el estante 
en su posición correcta.
Detalle del ejercicio: El usuario debe ingresar la cantidad de libros y luego el código ISBN 
(número entero) de cada uno.
Lógica de Inserción: A medida que el usuario ingresa un número, o una vez llenado el arreglo, 
el algoritmo debe simular el proceso de "insertar" el elemento comparándolo con los que ya están
 a su izquierda.
Visualización Paso a Paso: En cada ciclo del ordenamiento, el programa debe imprimir cómo va 
quedando el arreglo (ej: [10, 25, 5, 30] -> [5, 10, 25, 30]). Esto permite al estudiante ver cómo 
los elementos se desplazan para abrir espacio al nuevo valor.
*/
public class Ejercicio2 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de libros: ");
        int n = scanner.nextInt();

        int[] isbn = new int[n]; 

        for (int i = 0; i < n; i++) {

            System.out.print("Ingrese el ISBN del libro " + (i + 1) + ": ");
            isbn[i] = scanner.nextInt();

            for (int j = 1; j <= i; j++) {

                int clave = isbn[j];
                int k = j - 1;

                while (k >= 0 && isbn[k] > clave) {
                    isbn[k + 1] = isbn[k];
                    k--;
                }

                isbn[k + 1] = clave;
            }

            System.out.print("Estado del estante: [");

            for (int k = 0; k < isbn.length; k++) {
                System.out.print(isbn[k]);

                if (k < isbn.length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println("]");
        }

        scanner.close();
    }
}
