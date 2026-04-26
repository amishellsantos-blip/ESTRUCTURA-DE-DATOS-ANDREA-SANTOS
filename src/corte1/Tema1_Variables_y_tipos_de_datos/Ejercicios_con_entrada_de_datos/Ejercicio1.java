package Tema1_Variables_y_tipos_de_datos.Ejercicios_con_entrada_de_datos;
import java.util.Scanner;
/*
 * Ejercicio 1 — Recibo de compra
 * Tema: Variables y tipos de datos
 * Descripción: Solicitar al usuario el nombre del producto, la cantidad
 * y el precio unitario utilizando los tipos String, int y double.
 * Calcular el subtotal multiplicando cantidad por precio,
 * aplicar un IVA del 19% y mostrar en pantalla el recibo
 * con el total a pagar.
 */
public class Ejercicio1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del producto: ");
        String Producto = scanner.nextLine();

        System.out.print("Ingrese la cantidad: ");
        int Cantidad = scanner.nextInt();

        System.out.print("Ingrese el precio unitario: ");
        double PrecioUnitario = scanner.nextDouble();

        double Subtotal = Cantidad * PrecioUnitario;
        double IVA = Subtotal * 0.19;
        double Total = Subtotal + IVA;

        System.out.println("\n==== Recibo de compra ====");
        System.out.println("Producto  : " + Producto);    
        System.out.println("Cantidad  : " + Cantidad);
        System.out.println("Precio c/u: $" + PrecioUnitario);
        System.out.println("Subtotal  : $" + Subtotal);
        System.out.println("IVA (19%) : $" + IVA);
        System.out.println("Total     : $" + Total);

        scanner.close();
    }
    
}
