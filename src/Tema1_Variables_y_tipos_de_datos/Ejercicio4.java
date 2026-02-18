package Tema1_Variables_y_tipos_de_datos;
/*
 * Ejercicio 4 — Placa de un vehículo
 * Tema: Variables y tipos de datos
 * Descripción: Modelar la información básica de un vehículo
 * y mostrarla en consola.
 */

public class Ejercicio4 {
    public static void main(String[] args) {
        
        String placa = "KLM123";
        int añoFabricacion = 2015;
        int cilindraje = 2000;
        double precioCompra = 58000000.0;
        char inicialColor = 'R';
        boolean soatVigente = true;

        System.out.println("=== Información del Vehículo");
        System.out.println("Placa:" + placa);
        System.out.println("Año de Fabricación: " + añoFabricacion);
        System.out.println("Cilindraje: " + cilindraje + " cc");
        System.out.println("Precio de Compra: $" + precioCompra);
        System.out.println("Inicial del Color: " + inicialColor);
        System.out.println("SOAT vigente: " + (soatVigente ? "Sí" : "No"));
    }
    
}
