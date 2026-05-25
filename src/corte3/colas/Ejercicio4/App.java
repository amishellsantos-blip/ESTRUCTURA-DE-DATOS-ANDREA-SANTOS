package corte3.colas.Ejercicio4;

import java.util.Scanner;

/*
Datos de prueba sugeridos para ingresar manualmente:
- Placa: ABC-123 | Tipo: Automóvil   | Tarifa: 15000.0 | Exento: false
- Placa: AMB-001 | Tipo: Ambulancia  | Tarifa: 15000.0 | Exento: true
- Placa: XYZ-987 | Tipo: Camión      | Tarifa: 45000.0 | Exento: false
*/
public class App {
    public static void main(String[] args) {
        ColaPeaje peaje = new ColaPeaje();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n--- PEAJE INTELIGENTE (CONTROL DE TRÁFICO) ---");
            System.out.println("1. Ver fila de vehículos en el peaje");
            System.out.println("2. Registrar nuevo vehículo (Enqueue)");
            System.out.println("3. Cobrar a siguiente vehículo (Dequeue)");
            System.out.println("4. Cerrar turno (Procesar todos y calcular total)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\nEstado actual de la fila del peaje:");
                    peaje.imprimir();
                    break;
                case 2:
                    System.out.print("Placa: "); String placa = scanner.nextLine();
                    System.out.print("Tipo de Vehículo: "); String tipo = scanner.nextLine();
                    System.out.print("Tarifa: "); double tarifa = scanner.nextDouble();
                    System.out.print("¿Es exento de pago? (true/false): "); boolean exento = scanner.nextBoolean();
                    scanner.nextLine();
                    peaje.enqueue(new Vehiculo(placa, tipo, tarifa, exento));
                    System.out.println("Vehículo registrado en la fila.");
                    break;
                case 3:
                    Vehiculo atendido = peaje.dequeue();
                    if (atendido != null) {
                        System.out.println("Vehículo que pasa por la cabina: " + atendido);
                        if (!atendido.esExento) {
                            System.out.println("Cobro realizado: $" + atendido.tarifa);
                        } else {
                            System.out.println("Vehículo exento. Paso libre.");
                        }
                    } else {
                        System.out.println("No hay vehículos en la fila.");
                    }
                    break;
                case 4:
                    peaje.cerrarTurno();
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
