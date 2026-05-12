package corte3.pilas.Ejercicio3;

import java.util.Scanner;

/*
Datos de prueba sugeridos para ingresar manualmente:
- Placa: ABC-123 | Conductor: Juan Perez   | Carga: 10.5
- Placa: DEF-456 | Conductor: Maria Gomez  | Carga: 15.0
- Placa: GHI-789 | Conductor: Carlos Ruiz  | Carga: 8.2
- Placa: JKL-012 | Conductor: Ana Martinez | Carga: 20.0
*/
public class App {
    public static void main(String[] args) {
        PilaCamiones callejon = new PilaCamiones();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- LOGÍSTICA DE DISTRIBUCIÓN (CALLEJÓN SIN SALIDA) ---");
            System.out.println("1. Ver camiones en el callejón");
            System.out.println("2. Ingresar nuevo camión (Push)");
            System.out.println("3. Retirar camión de la salida (Pop)");
            System.out.println("4. Calcular carga total en el callejón");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\nEstado actual del callejón:");
                    callejon.imprimir();
                    break;
                case 2:
                    System.out.print("Placa del camión: "); 
                    String placa = scanner.nextLine();
                    
                    System.out.print("Nombre del conductor: "); 
                    String conductor = scanner.nextLine();
                    
                    System.out.print("Carga (toneladas): "); 
                    double carga = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar buffer
                    
                    callejon.push(new Camion(placa, conductor, carga));
                    System.out.println("Camión ingresado al callejón.");
                    break;
                case 3:
                    Camion retirado = callejon.pop();
                    if (retirado != null) {
                        System.out.println("Se ha retirado el camión de la salida: " + retirado);
                    } else {
                        System.out.println("El callejón está vacío, no hay camiones para retirar.");
                    }
                    break;
                case 4:
                    double total = callejon.calcularCargaTotal();
                    System.out.println("Calculando... La carga total en el callejón es: " + total + " toneladas.");
                    break;
                case 5:
                    System.out.println("Cerrando sistema de logística...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
