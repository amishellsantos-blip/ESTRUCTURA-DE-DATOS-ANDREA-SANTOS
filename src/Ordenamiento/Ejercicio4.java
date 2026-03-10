package Ordenamiento;
import java.util.Scanner;
/*4. Registro Alfabético de Estudiantes

Algoritmo obligatorio: Ordenamiento por Inserción (Insertion Sort)

Contexto: El profesor necesita pasar asistencia y requiere que la lista de nombres ingresada 
en el sistema se ordene alfabéticamente de la A a la Z.
Detalle del ejercicio: El programa debe preguntar cuántos alumnos hay en clase y solicitar sus 
nombres (cadenas de texto).
Lógica de Texto: Se debe usar el método de Inserción adaptado para String.
Requisito técnico: El estudiante debe investigar y aplicar el método nombre1.compareToIgnoreCase(nombre2). 
Es vital explicar que si el resultado es mayor a 0, el primer nombre es alfabéticamente "mayor" que el segundo.
Resultado esperado: La lista de asistencia impresa en orden alfabético perfecto.
*/
public class Ejercicio4 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner (System.in);

        System.out.println("Ingrese la cantidad de alumnos: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        String[] alumnos = new String[n];

        System.out.println("Ingrese el nombre de cada alumno:");

        for (int i = 0; i < n; i++){
            System.out.println("Alumno N°" + (i+1) + ": ");
            alumnos[i] = scanner.nextLine();
        }

        // Implementación del algoritmo de inserción para Strings
        for (int i = 1; i < alumnos.length; i++) {
            String key = alumnos[i];
            int j = i - 1;

            while (j >= 0 && alumnos[j].compareToIgnoreCase(key) > 0) {
                alumnos[j + 1] = alumnos[j];
                j--;
            }
            alumnos[j + 1] = key;
        }

        System.out.println("Lista de asistencia ordenada alfabéticamente:");
        for (String alumno : alumnos) {
            System.out.println(alumno);
        }

    }
    
}
