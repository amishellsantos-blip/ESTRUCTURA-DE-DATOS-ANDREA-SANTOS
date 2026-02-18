package Tema2_Variables_por_referencia;
/*
 * Ejercicio 7 — Inventario compartido
 * Tema: Variables por referencia
 * Descripción: Demostrar que los arreglos en Java se comportan por referencia,
 * es decir, dos variables pueden apuntar al mismo arreglo en memoria.
 */

public class Ejercicio7 {
    
    public static void main(String[] args) {
        
        int[] stockAlmacen = {10, 20, 15, 8, 12};
        int[] stockReportes = stockAlmacen;

        stockReportes[2] = stockReportes[2] - 5;

        System.out.println("Stock en Almacén: ");
        for (int i = 0; i < stockAlmacen.length; i++) {
            System.out.println("Producto " + (i + 1) + ": " + stockAlmacen[i]);
        }

        System.out.println("\nStock en Reportes: ");
        for (int i = 0; i < stockReportes.length; i++) {
            System.out.println("Producto " + (i + 1) + ": " + stockReportes[i]);
        }
        /*
         * Explicación:
         * En este caso no se hizo una copia del arreglo.
         * Cuando igualé stockReportes = stockAlmacen,
         * ambas variables quedaron apuntando al mismo arreglo en memoria.
         * Por eso, cuando modifiqué un valor desde stockReportes,
         * también cambió en stockAlmacen.
         * Los arreglos son objetos y los objetos trabajan por referencia.
         */
    }
}
