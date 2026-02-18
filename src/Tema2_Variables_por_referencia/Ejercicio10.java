package Tema2_Variables_por_referencia;
/*
 * Ejercicio 10 — Copiando configuración
 * Tema: Variables por referencia
 * Descripción: Crear una copia real de un arreglo copiando elemento por elemento
 * y demostrar la diferencia entre una copia real y una asignación directa.
 */
public class Ejercicio10 {

    public static void main(String[] args) {
        
        int[] configuracion = {1920, 1080, 60};
        int[]copia = new int[configuracion.length];

        for (int i = 0; i < configuracion.length; i++) {
            copia[i] = configuracion[i];
        }

        copia[2] = 120;

        System.out.println("Configuración original: ");
        for(int valor : configuracion) {
            System.out.print(valor + " ");
        }       
        
        System.out.println("\nCopia modificada: ");
        for(int valor : copia) {
            System.out.print(valor + " ");
        }
          /*
         * Explicación:
         * Aquí no hice una asignación directa como:
         * int[] copia = configuracion;
         *
         * Porque eso solo haría que ambas variables apunten
         * al mismo arreglo en memoria.
         *
         * En cambio, creé un nuevo arreglo y copié
         * cada elemento manualmente.
         *
         * Por eso, cuando modifiqué la copia,
         * el arreglo original no cambió.
         */
    }
    
}
