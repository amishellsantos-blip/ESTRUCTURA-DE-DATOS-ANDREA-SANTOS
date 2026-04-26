package Ordenamiento;
import java.util.Scanner;
/*5. El Inspector de Eficiencia (Duelo de Métodos)

Algoritmos obligatorios: Selección vs Inserción

Contexto: Un analista de sistemas quiere saber cuál algoritmo es más "pesado" en términos de operaciones 
para un caso específico.
Detalle del ejercicio: El usuario debe ingresar 6 números enteros desordenados. El programa aplicará AMBOS 
métodos al mismo conjunto de datos (puedes usar una copia del arreglo original).
Lógica de Conteo:
    En Selección: Cuenta cada vez que ocurre un swap (intercambio físico de posiciones).
    En Inserción: Cuenta cada vez que un elemento se "mueve" hacia la izquierda dentro del bucle interno.
Resultado esperado: El programa debe imprimir cuántos intercambios hizo Selección y cuántos movimientos hizo Inserción. 
El estudiante debe concluir cuál fue más eficiente para esos datos ingresados por el teclado.
*/
public class Ejercicio5 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner (System.in);

        System.out.println("Ingrese 6 números enteros desordenados:");

        int[] numeros = new int[6];

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        // Copia del arreglo original para ambos métodos
        int[] numerosSeleccion = numeros.clone();
        int[] numerosInsercion = numeros.clone();

        // Conteo de intercambios para Selección
        int intercambiosSeleccion = 0;
        for (int i = 0; i < numerosSeleccion.length - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < numerosSeleccion.length; j++) {
                if (numerosSeleccion[j] < numerosSeleccion[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            if (indiceMinimo != i) {
                int temp = numerosSeleccion[indiceMinimo];
                numerosSeleccion[indiceMinimo] = numerosSeleccion[i];
                numerosSeleccion[i] = temp;
                intercambiosSeleccion++;
            }
        }

        // Conteo de movimientos para Inserción
        int movimientosInsercion = 0;
        for (int i = 1; i < numerosInsercion.length; i++) {
            int key = numerosInsercion[i];
            int j = i - 1;
            while (j >= 0 && numerosInsercion[j] > key) {
                numerosInsercion[j + 1] = numerosInsercion[j];
                j--;
                movimientosInsercion++;
            }
            numerosInsercion[j + 1] = key;
        }

        System.out.println("Intercambios en Selección: " + intercambiosSeleccion);
        System.out.println("Movimientos en Inserción: " + movimientosInsercion);

        if (intercambiosSeleccion < movimientosInsercion) {
            System.out.println("Selección fue más eficiente para estos datos.");
        } else if (movimientosInsercion < intercambiosSeleccion) {
            System.out.println("Inserción fue más eficiente para estos datos.");
        } else {
            System.out.println("Ambos métodos tuvieron la misma eficiencia para estos datos.");
        }

        scanner.close();
    }
}
