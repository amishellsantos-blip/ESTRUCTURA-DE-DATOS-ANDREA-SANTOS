package Ordenamiento;
import java.util.Scanner;
/*1. El Podio de la Competencia

Algoritmo obligatorio: Ordenamiento por Selección (Selection Sort)

Contexto: Se ha realizado una carrera de 100 metros planos y el comité olímpico 
necesita determinar quiénes ganaron las medallas.
Detalle del ejercicio: El programa debe solicitar primero cuántos corredores participaron 
(ej. 5 a 10). 
Luego, debe pedir el tiempo en segundos (con decimales) de cada corredor.
Lógica de Selección: El algoritmo debe buscar el tiempo más bajo (el más rápido) en cada 
iteración y colocarlo al inicio.
Resultado esperado: El programa debe imprimir el arreglo totalmente ordenado y, adicionalmente, 
mostrar un mensaje claro indicando quién obtuvo el Oro (1er lugar), Plata (2do lugar) y Bronce (3er lugar).
*/
public class Ejercicio1 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Cuántos corredores participaron?: ");
        int num = scanner.nextInt();

        double[] tiempos = new double[num];

        System.out.println("Ingresa los tiempos de los corredores en segundos: ");

        for (int i = 0; i < num; i++) {
            System.out.print("Corredor N°" + (i + 1) + ": ");
            tiempos[i] = scanner.nextDouble();
        }


        for (int i = 0; i < tiempos.length - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < tiempos.length; j++) {
                if (tiempos[j] < tiempos[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            
            double temp = tiempos[indiceMinimo];
            tiempos[indiceMinimo] = tiempos[i];
            tiempos[i] = temp;
        }

        System.out.println("Tiempos ordenados:");
        for (double tiempo : tiempos) {
            System.out.println(tiempo);
        }

        
        System.out.println("\nMedallas:");
        System.out.println("Oro: " + tiempos[0] + " segundos");
        System.out.println("Plata: " + tiempos[1] + " segundos");
        System.out.println("Bronce: " + tiempos[2] + " segundos");
    
        scanner.close();
    }
    
}
