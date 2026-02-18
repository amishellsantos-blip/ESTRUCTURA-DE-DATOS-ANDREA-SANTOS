package Tema2_Variables_por_referencia;
/*
 * Ejercicio 8 — Historial de mensajes
 * Tema: Variables por referencia
 * Descripción: Demostrar que los objetos String son inmutables,
 * es decir, cuando se modifican realmente se crea un nuevo objeto
 * en memoria y no se cambia el original.
 */

public class Ejercicio8 {
    
    public static void main(String[] args) {
        
        String ultimoMensaje = "Hola";
        String copiaTexto = ultimoMensaje; 
        copiaTexto = "¿Cómo estás?"; 

        System.out.println("Último mensaje: " + ultimoMensaje);
        System.out.println("Copia del texto: " + copiaTexto);
        /*
         * Explicación:
         * Cuando igualé copiaTexto a ultimoMensaje,
         * ambas variables apuntaban al mismo texto.
         * Pero los String en Java son inmutables,
         * eso significa que no se pueden modificar.
         * Entonces, cuando cambié copiaTexto,
         * realmente se creó un nuevo String en memoria.
         * Por eso ultimoMensaje sigue siendo "Hola".
         */
    }
}
