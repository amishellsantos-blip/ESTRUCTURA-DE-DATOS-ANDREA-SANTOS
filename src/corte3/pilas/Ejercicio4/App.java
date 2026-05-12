package corte3.pilas.Ejercicio4;

import java.util.Scanner;

/*
Datos de prueba sugeridos para ingresar manualmente:
- Medicamento: Paracetamol | Lote: L100 | Días p/vencer: 15
- Medicamento: Ibuprofeno  | Lote: L101 | Días p/vencer: 5  (Se descartará)
- Medicamento: Amoxicilina | Lote: L102 | Días p/vencer: 2  (Se descartará)
- Medicamento: Loratadina  | Lote: L103 | Días p/vencer: 30
*/
public class App {
    public static void main(String[] args) {
        TuboDispensador tubo = new TuboDispensador();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- FARMACIA AUTOMATIZADA (TUBO DISPENSADOR) ---");
            System.out.println("1. Ver estado del tubo dispensador");
            System.out.println("2. Ingresar nuevo medicamento (Push)");
            System.out.println("3. Solicitar despacho seguro (Validar y Pop)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\nEstado actual del tubo:");
                    tubo.imprimir();
                    break;
                case 2:
                    System.out.print("Nombre del medicamento: "); 
                    String nombre = scanner.nextLine();
                    
                    System.out.print("Lote: "); 
                    String lote = scanner.nextLine();
                    
                    System.out.print("Días para vencer: "); 
                    int dias = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    
                    tubo.push(new Medicamento(nombre, lote, dias));
                    System.out.println("Medicamento ingresado al tubo.");
                    break;
                case 3:
                    System.out.println("Solicitando medicamento...");
                    tubo.validarDespacho();
                    break;
                case 4:
                    System.out.println("Cerrando sistema de farmacia...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
