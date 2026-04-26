package Ordenamiento;
import java.util.Scanner;
/*3. El Salto de Shell (Optimización de Datos)

Algoritmo obligatorio: Ordenamiento Shell (Shell Sort)

Contexto: Una empresa de logística maneja paquetes con diferentes pesos y necesita ordenarlos
 de forma más eficiente que el método de burbuja o inserción simple.
Detalle del ejercicio: Solicita al usuario el peso de N paquetes (se recomienda probar con al
 menos 10 para notar el efecto).
Lógica de Shell: Implementa el algoritmo usando el salto (gap) inicial de N / 2 . El estudiante 
debe explicar en comentarios por qué este método es generalmente más rápido que la inserción simple
 al trabajar con elementos que están muy lejos de su posición final.
Resultado esperado: Mostrar el arreglo original y el arreglo final ordenado después de aplicar 
todas las fases de reducción de saltos.
*/
public class Ejercicio3 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner (System.in);

        System.out.println("Ingrese la cantidad de paquetes: ");
        int n = scanner.nextInt();

        double[] paquetes = new double[n];

        System.out.println("Ingrese el peso de cada paquete:");

        for (int i = 0; i < n; i++){
            System.out.println("Paquete N°" + (i+1) + ": ");
            paquetes[i] = scanner.nextDouble();
        }

        System.out.println("Arreglo original:");
        for (double paquete : paquetes) {
            System.out.print(paquete + " ");
        }

        // Implementación del algoritmo Shell Sort
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                double temp = paquetes[i];
                int j;
                for (j = i; j >= gap && paquetes[j - gap] > temp; j -= gap) {
                    paquetes[j] = paquetes[j - gap];
                }
                paquetes[j] = temp;
            }
        }

        System.out.println("\nArreglo ordenado:");
        for (double paquete : paquetes) {
            System.out.print(paquete + " ");
        }

        scanner.close();

        /*
         * El algoritmo Shell Sort es generalmente más rápido que la inserción simple porque 
         * reduce significativamente el número de movimientos necesarios para colocar un elemento
         * en su posición correcta. Al usar un salto (gap) inicial grande, los elementos que están
         * muy lejos de su posición final pueden ser movidos más rápidamente hacia su destino, lo que
         * disminuye el número total de comparaciones y movimientos en comparación con la inserción
         * simple, que solo mueve elementos adyacentes.
         */

    }
    
}
