package Tema2_Variables_por_referencia.Ejercicios_con_entrada_de_datos;
import java.util.Scanner;
/*
 * Ejercicio 10 — Intercambio de valores
 * Tema: Variables por referencia
 * Descripción: Pedir al usuario dos números enteros llamados x e y.
 * Luego mostrar los valores ingresados antes del intercambio.
 * Después intercambiar los valores de las variables usando una
 * variable auxiliar llamada temp.
 * Finalmente mostrar los valores después del intercambio para
 * comprobar que los valores fueron cambiados correctamente.
 */
public class Ejercicio10 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el valor de x: ");
        int x = scanner.nextInt();

        System.out.print("Ingrese el valor de y: ");
        int y = scanner.nextInt();

        System.out.println("\nValores antes del intercambio:");
        System.out.println("x: " + x);
        System.out.println("y: " + y);

        int temp = x; 
        x = y; 
        y = temp; 

        System.out.println("\nValores después del intercambio:");
        System.out.println("x: " + x);
        System.out.println("y: " + y);

        scanner.close();

    }
    
}
