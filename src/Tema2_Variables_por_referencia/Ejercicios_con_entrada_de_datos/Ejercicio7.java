package Tema2_Variables_por_referencia.Ejercicios_con_entrada_de_datos;
import java.util.Scanner;

/*
 * Ejercicio 7 — Arreglo compartido (inventario)
 * Tema: Variables por referencia
 * Descripción: Solicitar al usuario cuatro precios para llenar un arreglo
 * llamado precios[]. Luego crear otro arreglo llamado preciosAuditoria
 * asignándolo directamente a precios, para que ambos compartan la misma
 * referencia en memoria. Posteriormente pedir al usuario un índice y un
 * nuevo precio para modificar el arreglo desde preciosAuditoria.
 * Finalmente mostrar ambos arreglos para comprobar que el cambio se
 * refleja en los dos, demostrando cómo funcionan las variables por
 * referencia en los arreglos.
 */
public class Ejercicio7 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] precios = new double[4];

        for (int i = 0; i < precios.length; i++) {
            System.out.print("Ingrese el precio " + (i + 1) + ": ");
            precios[i] = scanner.nextDouble();
        }

        double[] preciosAuditoria = precios;

        System.out.print("\nIngrese el índice a modificar (0 a 3): ");
        int indice = scanner.nextInt();

        System.out.print("Ingrese el nuevo precio para el índice " + indice + ": ");
        preciosAuditoria[indice] = scanner.nextDouble();

        System.out.println("\nPrecios desde el arreglo original:");
        for (int i = 0; i < precios.length; i++) {
            System.out.println("Precio " + (i + 1) + ": " + precios[i]);
        }

        System.out.println("\nPrecios desde el arreglo de auditoría:");
        for (int i = 0; i < preciosAuditoria.length; i++) {
            System.out.println("Precio " + (i + 1) + ": " + preciosAuditoria[i]);
        }

        scanner.close();

    }

}
