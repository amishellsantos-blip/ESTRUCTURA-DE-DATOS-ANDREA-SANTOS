package corte3.pilas.Ejercicio2;

import java.util.Scanner;

/*
Datos de prueba sugeridos para ingresar manualmente (en este orden, desde la primera hasta la última para que la defectuosa quede abajo o en medio):
- Pieza: Piston A | Serie: SN-001 | Defectuosa: false
- Pieza: Biela B  | Serie: SN-002 | Defectuosa: true
- Pieza: Valvula  | Serie: SN-003 | Defectuosa: false
- Pieza: Piston C | Serie: SN-004 | Defectuosa: false
*/
public class App {
    public static void main(String[] args) {
        PilaPiezas lineaEnsamblaje = new PilaPiezas();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- CONTROL DE CALIDAD (LÍNEA DE ENSAMBLAJE) ---");
            System.out.println("1. Ver piezas en la línea");
            System.out.println("2. Agregar nueva pieza (Push)");
            System.out.println("3. Ejecutar protocolo 'Limpiar hasta defecto'");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\nEstado actual de la pila:");
                    lineaEnsamblaje.imprimir();
                    break;
                case 2:
                    System.out.print("Nombre de pieza: "); 
                    String nombre = scanner.nextLine();
                    
                    System.out.print("Número de serie: "); 
                    String serie = scanner.nextLine();
                    
                    System.out.print("¿Es defectuosa? (true/false): "); 
                    boolean defecto = scanner.nextBoolean();
                    scanner.nextLine(); // Limpiar buffer
                    
                    lineaEnsamblaje.push(new Pieza(nombre, serie, defecto));
                    System.out.println("Pieza apilada en la línea.");
                    break;
                case 3:
                    lineaEnsamblaje.limpiarHastaDefecto();
                    break;
                case 4:
                    System.out.println("Apagando sistema de control de calidad...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
