package Variables_y_tipos_de_datos;
/*
 * Ejercicio 5 — Conversor de unidades
 * Tema: Variables y tipos de datos
 * Descripción: Convertir una cantidad en tazas a mililitros y litros.
 */

public class Ejercicio5 {
    
    public static void main(String[] args) {
        
        double tazas = 2.5;
        double mililitros = tazas * 236.588;
        double litros = mililitros / 1000;

        System.out.println("=== Conversor de Unidades ===");
        System.out.println("Cantidad en tazas: " + tazas);
        System.out.println("Cantidad en mililitros: " + mililitros + " ml");
        System.out.println("Cantidad en litros: " + litros + " L");
    }
    
}
