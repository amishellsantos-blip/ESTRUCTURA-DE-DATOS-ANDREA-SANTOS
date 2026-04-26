package corte2.listas_enlazadas_simples.Ejercicio1;
import java.util.Scanner;
/*
* EJEMPLOS DE DATOS:
* Vagón 1: Mineral de Hierro | 50.0 | Puerto A | Fábrica B
* Vagón 2: Carbón | 30.5 | Puerto de Cartagena | Cali
* Vagón 3: Granos | 20.0 | Barranquilla | Medellín
* Vagón 4: Acero | 100.75 | Santa Marta | Bogotá
* Vagón 5: Cemento | 45.5 | Puerto C | Bucaramanga
*/
public class App {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Tren tren = new Tren();
        
        System.out.println("\n=== SISTEMA DE GESTIÓN DE TREN DE CARGA ===");
        System.out.println("Ingrese los vagones que desea agregar al tren.\n");
        
        int opcion = 1;
        while (opcion == 1) {
            System.out.print("Ingrese el contenido del vagón: ");
            String contenido = scanner.nextLine();
            
            System.out.print("Ingrese el peso en toneladas: ");
            double pesoToneladas = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Ingrese el puerto de origen: ");
            String origen = scanner.nextLine();
            
            System.out.print("Ingrese el destino: ");
            String destino = scanner.nextLine();
            
            tren.engancharVagon(contenido, pesoToneladas, origen, destino);
            System.out.println("Vagón agregado exitosamente.\n");
            
            System.out.print("¿Desea agregar otro vagón? (sí/no): ");
            String respuesta = scanner.nextLine().toLowerCase().trim();
            
            if (respuesta.equals("si") || respuesta.equals("sí")) {
                opcion = 1;
            } else {
                opcion = 0;
            }
        }
        
        scanner.close();
        tren.mostrarTabla();
    }
    
}
