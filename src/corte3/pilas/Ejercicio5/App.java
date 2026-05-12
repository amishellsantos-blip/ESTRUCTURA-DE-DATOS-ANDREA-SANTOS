package corte3.pilas.Ejercicio5;

import java.util.Scanner;

/*
Datos de prueba sugeridos para ingresar manualmente:
- Punto: Entrada Cueva   | Prof: 10  | O2: 21.0
- Punto: Zona Húmeda     | Prof: 50  | O2: 19.5
- Punto: Caverna de Gas  | Prof: 120 | O2: 15.2 (Lanzará alerta al volver)
- Punto: Fondo Abisal    | Prof: 200 | O2: 17.8 (Lanzará alerta al volver)
*/
public class App {
    public static void main(String[] args) {
        PilaEstaciones ruta = new PilaEstaciones();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- RUTA DE RESCATE (ESPELEOLOGÍA GEOLÓGICA) ---");
            System.out.println("1. Ver estaciones de la ruta actual");
            System.out.println("2. Avanzar y dejar estación (Push)");
            System.out.println("3. Retroceder a la superficie (Pop completo)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\nEstado actual de la ruta:");
                    ruta.imprimir();
                    break;
                case 2:
                    System.out.print("Nombre de la estación: "); 
                    String nombre = scanner.nextLine();
                    
                    System.out.print("Profundidad (metros): "); 
                    int prof = scanner.nextInt();
                    
                    System.out.print("Nivel de Oxígeno (%): "); 
                    double o2 = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar buffer
                    
                    ruta.push(new Estacion(nombre, prof, o2));
                    System.out.println("Estación colocada exitosamente.");
                    break;
                case 3:
                    ruta.retrocederASuperficie();
                    break;
                case 4:
                    System.out.println("Cerrando sistema de rescate...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
