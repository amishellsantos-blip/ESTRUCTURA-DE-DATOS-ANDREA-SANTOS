package Tema3_Estructuras_lineales_y_no_lineales.Ejercicios;
/*
 * Ejercicio 11 — Lista de pasajeros
 * Tema: Estructuras lineales (Arreglos)
 * Descripción: Registrar los nombres de 6 pasajeros en un arreglo de tipo String,
 * recorrerlo con un ciclo for para mostrar el número de asiento y el nombre,
 * y calcular cuántos asientos están ocupados.
 */

public class Ejercicio11 {

    public static void main(String[] args){

        String[] pasajeros = {"Ana", "Luis", "Carlos", "Marta", "Sofía", "Jorge"};
        int asientosOcupados = 0;

        for (int i = 0; i < pasajeros.length; i++) {
            System.out.println("Asiento " + (i + 1) + ": " + pasajeros[i]);
            asientosOcupados++;
        }

        System.out.println("Total de asientos ocupados: " + asientosOcupados);
    }
    
}
