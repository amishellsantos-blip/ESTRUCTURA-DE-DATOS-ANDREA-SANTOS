package Tema2_Variables_por_referencia;
/*
 * Ejercicio 6 — Turno en un banco
 * Tema: Variables por referencia
 * Descripción: Demostrar que los tipos primitivos en Java se comportan por valor,
 * es decir, al asignar una variable a otra se crea una copia independiente.
 */

public class Ejercicio6 {

    public static void main(String[] args) {
        
        int turnoActual = 25;
        int turnoEnPantalla = turnoActual;

        turnoEnPantalla = 26; 

        System.out.println("Turno actual: " + turnoActual);
        System.out.println("Turno en pantalla: " + turnoEnPantalla);

         /*
         * Explicación:
         * En Java, los tipos primitivos como int se copian por valor.
         * Esto significa que turnoEnPantalla recibe una copia del valor
         * de turnoActual. Al modificar turnoEnPantalla, no se afecta
         * la variable original.
         */
    }
    
}
