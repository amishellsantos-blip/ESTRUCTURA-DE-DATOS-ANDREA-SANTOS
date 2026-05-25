package corte3.colas.Ejercicio1;

import java.util.Scanner;

/*
Datos de prueba sugeridos para ingresar manualmente:
- ID: LLAM-001 | Cliente: Juan Perez    | Motivo: Facturación      | Duración: 5
- ID: LLAM-002 | Cliente: Maria Gomez   | Motivo: Soporte Técnico  | Duración: 15
- ID: LLAM-003 | Cliente: Carlos Lopez  | Motivo: Facturación      | Duración: 3
- ID: LLAM-004 | Cliente: Ana Martinez  | Motivo: Cancelación      | Duración: 10
*/
public class App {
    public static void main(String[] args) {
        ColaLlamadas centroLlamadas = new ColaLlamadas();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n--- CENTRO DE LLAMADAS (COLAS) ---");
            System.out.println("1. Ver estado de la cola de espera");
            System.out.println("2. Registrar nueva llamada (Enqueue)");
            System.out.println("3. Atender siguiente llamada (Dequeue)");
            System.out.println("4. Contar llamadas por motivo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\nEstado actual de la cola de llamadas:");
                    centroLlamadas.imprimir();
                    break;
                case 2:
                    System.out.print("ID de Llamada: "); String id = scanner.nextLine();
                    System.out.print("Nombre Cliente: "); String cliente = scanner.nextLine();
                    System.out.print("Motivo (Facturación/Soporte Técnico/Cancelación/Información): "); String motivo = scanner.nextLine();
                    System.out.print("Duración Estimada (min): "); int duracion = scanner.nextInt();
                    scanner.nextLine();
                    centroLlamadas.enqueue(new Llamada(id, cliente, motivo, duracion));
                    System.out.println("Llamada puesta en espera correctamente.");
                    break;
                case 3:
                    Llamada atendida = centroLlamadas.dequeue();
                    if (atendida != null) {
                        System.out.println("Atendiendo llamada: " + atendida);
                    } else {
                        System.out.println("No hay llamadas en espera para atender.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el motivo de consulta a contar: ");
                    String motivoBusqueda = scanner.nextLine();
                    int total = centroLlamadas.contarPorMotivo(motivoBusqueda);
                    System.out.println("Resultado: Se encontraron " + total + " llamadas en espera por '" + motivoBusqueda + "'.");
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
