package Tema1_Variables_y_tipos_de_datos;
/*
 * Ejercicio 2 — Calculadora de una tienda
 * Tema: Variables y tipos de datos
 * Descripción: Calcular el total a pagar aplicando un descuento porcentual.
 */

public class Ejercicio2 {

    public static void main(String[] args) {

        double precioUnitario = 3400.0;
        int cantidad = 3;
        double descuentoPorcentaje = 15.0;

        double subtotal = precioUnitario * cantidad;
        double descuento = subtotal * (descuentoPorcentaje/100);
        double totalPagar = subtotal - descuento;

        System.out.println("=== Calculadora de Tienda ===");
        System.out.println("Precio Unitario: $" + precioUnitario);
        System.out.println("Cantidad: " + cantidad);            
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Descuento aplicado: $" + descuento);
        System.out.println("Total a pagar: $" + totalPagar);
    }
 
}
