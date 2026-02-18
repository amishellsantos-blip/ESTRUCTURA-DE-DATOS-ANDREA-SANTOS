package Variables_y_tipos_de_datos;
/*
 * Ejercicio 1 — Ficha de un estudiante
 * Tema: Variables y tipos de datos
 * Descripción: Declarar variables para almacenar información
 * de un estudiante e imprimir un reporte en consola.
 */

public class Ejercicio1 {
    public static void main(String[] args) {

        String nombre = "Andrea Santos";
        int codigo = 20261001;
        int semestre = 5;
        double promedio = 3.9;
        boolean matriculado = true;

        System.out.println("===Ficha del Estudiante===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Código: " + codigo);            
        System.out.println("Semestre: " + semestre);
        System.out.println("Promedio: " + promedio);
        System.out.println("Matriculado: " + (matriculado ? "Sí" : "No"));
    }
    
}
