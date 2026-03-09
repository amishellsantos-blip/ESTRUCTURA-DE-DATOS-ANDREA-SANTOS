package Arrays_y_Busqueda;
import java.util.Scanner;
/*4. Un gimnasio tiene una lista de códigos de acceso de los socios que pagaron la mensualidad.
 La lista está ordenada de menor a mayor.

El Problema: Cuando un socio digita su código, el sistema debe validar si el código está en la lista 
de "pagos al día". Si no está, se le niega la entrada.
Algoritmo a usar: Búsqueda Binaria. Es eficiente para buscar códigos numéricos en una lista que ya está 
organizada. */
public class Ejercicio4 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner (System.in);

        int[] codigos = {1010, 1020, 1030, 1040, 1050, 1060, 1070, 1080, 1090, 1100};

        System.out.print("Ingrese su código de acceso: ");
        int buscar = scanner.nextInt();

        int inicio = 0;
        int fin = codigos.length - 1;
        int posicion = -1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (codigos[medio] == buscar) {
                posicion = medio;
                break;
            } else if (codigos[medio] < buscar) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        if (posicion != -1) {
            System.out.println("Código válido. Bienvenido al gimnasio.");
        } else {
            System.out.println("Código no válido. Acceso denegado.");
        }

        scanner.close();

    }
    
}
