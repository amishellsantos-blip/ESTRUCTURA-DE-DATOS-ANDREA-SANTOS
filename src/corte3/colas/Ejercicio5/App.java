package corte3.colas.Ejercicio5;

import java.util.Scanner;

/*
Datos de prueba sugeridos para ingresar manualmente:
- Pedido: P001 | Cliente: Juan Perez   | Total: 150000.0 | Cancelado: false
- Pedido: P002 | Cliente: Maria Gomez  | Total: 85000.0  | Cancelado: true
- Pedido: P003 | Cliente: Carlos Lopez | Total: 200000.0 | Cancelado: false
- Pedido: P004 | Cliente: Ana Martinez | Total: 50000.0  | Cancelado: true
*/
public class App {
    public static void main(String[] args) {
        ColaPedidos bodega = new ColaPedidos();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n--- FÁBRICA DE PEDIDOS (E-COMMERCE) ---");
            System.out.println("1. Ver pedidos en espera (Bodega)");
            System.out.println("2. Registrar nuevo pedido (Enqueue)");
            System.out.println("3. Extraer siguiente pedido manualmente (Dequeue)");
            System.out.println("4. Procesar toda la bodega (Despachar/Descartar)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\nEstado actual de la bodega:");
                    bodega.imprimir();
                    break;
                case 2:
                    System.out.print("Número de Pedido: "); String num = scanner.nextLine();
                    System.out.print("Nombre del Cliente: "); String cliente = scanner.nextLine();
                    System.out.print("Total a Pagar: "); double total = scanner.nextDouble();
                    System.out.print("¿El cliente lo canceló? (true/false): "); boolean cancelado = scanner.nextBoolean();
                    scanner.nextLine();
                    bodega.enqueue(new Pedido(num, cliente, total, cancelado));
                    System.out.println("Pedido agregado a la bodega.");
                    break;
                case 3:
                    Pedido extraido = bodega.dequeue();
                    if (extraido != null) {
                        System.out.println("Pedido extraído de la bodega: " + extraido);
                    } else {
                        System.out.println("No hay pedidos en la bodega.");
                    }
                    break;
                case 4:
                    bodega.procesarPedidos();
                    break;
                case 5:
                    System.out.println("Cerrando sistema de E-commerce...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
