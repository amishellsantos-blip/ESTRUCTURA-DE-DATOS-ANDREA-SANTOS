package Tema2_Variables_por_referencia;
/*
 * Ejercicio 9 — Notas de un curso
 * Tema: Variables por referencia
 * Descripción: Demostrar que cuando dos variables apuntan al mismo arreglo,
 * cualquier cambio realizado desde una de ellas afecta al mismo espacio en memoria.
 */

public class Ejercicio9 {

    public static void main(String[] args) {
        double[] notasProfesor = {4.0, 2.5, 3.8, 4.5};
        double[] notasCoordinador = notasProfesor; 

        notasCoordinador[1] = 3.0;

        System.out.println("Notas del profesor:");
        for (int i = 0; i < notasProfesor.length; i++) {
            System.out.println("Estudiante " + (i + 1) + ": " + notasProfesor[i]);
        }       

        System.out.println("Notas del coordinador:");
        for (int i = 0; i < notasCoordinador.length; i++) {
            System.out.println("Estudiante " + (i + 1) + ": " + notasCoordinador[i]);
        }
        /*
            * Explicación:
            * Cuando el coordinador recibió el arreglo,
            * no se creó una copia nueva.
            * Ambas variables apuntan al mismo arreglo en memoria.
            * Por eso, al cambiar la nota desde notasCoordinador,
            * el arreglo del profesor también muestra el cambio.
            * Esto pasa porque los arreglos son objetos
            * y los objetos en Java trabajan por referencia.
            */
    }
    
}
