package Tema3_Estructuras_lineales_y_no_lineales.Ejercicios_con_entrada_de_datos;
import java.util.Scanner;
/*
 * Ejercicio 14 — Ventas por sucursal
 * Tema: Estructuras lineales (arreglos)
 * Descripción: Solicitar al usuario el nombre y las ventas mensuales de
 * cinco sucursales de una cadena de tiendas y almacenarlas en arreglos.
 * Luego calcular el total de ventas de la cadena, identificar la sucursal
 * con la mayor y la menor venta, y finalmente mostrar el porcentaje que
 * representa cada sucursal respecto al total de ventas.
 */
public class Ejercicio14 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner (System.in);

        String[] sucursales = new String[5];
        double[] ventas = new double[5];

        double totalVentas = 0;
        int Mayor = 0;
        int Menor = 0;

        for (int i = 0; i < sucursales.length; i++) {
            System.out.print("Ingrese el nombre de la sucursal " + (i + 1) + ": ");
            sucursales[i] = scanner.nextLine();

            System.out.print("Ingrese las ventas mensuales de " + sucursales[i] + ": ");
            ventas[i] = scanner.nextDouble();
            scanner.nextLine(); 

            totalVentas += ventas[i];

            if (ventas[i] > ventas[Mayor]) {
                Mayor = i;
            }

            if (ventas[i] < ventas[Menor]) {
                Menor = i;
            }
        }

        System.out.println("\nTotal de ventas de la cadena: " + totalVentas);
        System.out.println("Sucursal con mayor venta: " + sucursales[Mayor] + "(" + ventas[Mayor] + ")");
        System.out.println("Sucursal con menor venta: " + sucursales[Menor] + "(" + ventas[Menor] + ")");

        System.out.println("\nPorcentaje de ventas por sucursal:");

        for (int i = 0; i < sucursales.length; i++) {
            double porcentaje = (ventas[i] / totalVentas) * 100;
            System.out.println(sucursales[i] + ": " + String.format("%.2f", porcentaje) + "%");
        }

        scanner.close();
    }
}
