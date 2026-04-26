package Repaso_primer_corte;
import java.util.Scanner;
/*Ejercicio 3: Control de Notas (Selección)
Objetivo: Gestionar las notas de un grupo, encontrar los valores extremos y ordenar la lista.
¿Qué debes hacer?
1. Entrada: Pide al usuario 5 notas (números decimales) por teclado.
2. Estadísticas: Recorre el arreglo para encontrar cuál es la nota más alta y cuál la más baja del grupo.
3. Ordenamiento: Ordena las notas de menor a mayor usando Selección (Selection Sort).
Ejemplo de lo que se debe ver en consola:--- REGISTRO DE NOTAS --
Ingrese nota del Estudiante 1: 3.5
Ingrese nota del Estudiante 2: 4.8
Ingrese nota del Estudiante 3: 2.0
... (hasta completar las 5) ...--- INFORME ACADÉMICO --
La nota más ALTA del grupo es: 4.8
La nota más BAJA del grupo es: 2.0--- LISTA DE NOTAS ORDENADA (Menor a Mayor) --
[2.0, 3.0, 3.5, 4.2, 4.8] */
public class Ejercicio3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] notas = new double[5];

        for (int i = 0; i < notas.length; i++) {
            System.out.print("Ingrese nota del Estudiante " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
        }

        double notaMaxima = notas[0];
        double notaMinima = notas[0];

        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > notaMaxima) {
                notaMaxima = notas[i];
            }
            if (notas[i] < notaMinima) {
                notaMinima = notas[i];
            }
        }
        
        for (int i = 0; i < notas.length - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < notas.length; j++) {
                if (notas[j] < notas[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            
            double temp = notas[indiceMinimo];
            notas[indiceMinimo] = notas[i];
            notas[i] = temp;
        }
        
        System.out.println("\n--- INFORME ACADÉMICO --");
        System.out.println("La nota más ALTA del grupo es: " + notaMaxima);
        System.out.println("La nota más BAJA del grupo es: " + notaMinima);

        System.out.println("\n--- LISTA DE NOTAS ORDENADA (Menor a Mayor) --");
        System.out.print("[");
        for (int i = 0; i < notas.length; i++) {
            System.out.print(notas[i]);
            if (i < notas.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        scanner.close();
    }
    
}
