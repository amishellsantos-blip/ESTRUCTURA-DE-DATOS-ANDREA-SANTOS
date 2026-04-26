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

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Agregar un vagón");
            System.out.println("2. Calcular peso total de carga (Ver Tren)");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            String seleccion = scanner.nextLine();

            switch (seleccion) {
                case "1":
                    boolean agregarMas = true;
                    while (agregarMas) {
                        String contenido;
                        while (true) {
                            System.out.print("\nIngrese el contenido del vagón: ");
                            contenido = scanner.nextLine();
                            if (!contenido.matches(".*\\d.*"))
                                break;
                            System.out.println("¡¡Entrada inválida. No se permiten números.!!");
                        }

                        double pesoToneladas;
                        while (true) {
                            System.out.print("Ingrese el peso en toneladas: ");
                            try {
                                pesoToneladas = Double.parseDouble(scanner.nextLine());
                                if (pesoToneladas > 0)
                                    break;
                                System.out.println("¡¡El peso debe ser mayor a cero.!!");
                            } catch (NumberFormatException e) {
                                System.out.println("¡¡Entrada inválida. Ingrese un número válido.!!");
                            }
                        }

                        String origen;
                        while (true) {
                            System.out.print("Ingrese el puerto de origen: ");
                            origen = scanner.nextLine();
                            if (!origen.matches(".*\\d.*"))
                                break;
                            System.out.println("¡¡Entrada inválida. No se permiten números.!!");
                        }

                        String destino;
                        while (true) {
                            System.out.print("Ingrese el destino: ");
                            destino = scanner.nextLine();
                            if (!destino.matches(".*\\d.*"))
                                break;
                            System.out.println("¡¡Entrada inválida. No se permiten números.!!");
                        }

                        tren.engancharVagon(contenido, pesoToneladas, origen, destino);
                        System.out.println("\nVagón agregado exitosamente.");

                        while (true) {
                            System.out.print("\n¿Desea agregar otro vagón? (si/no): ");
                            String respuesta = scanner.nextLine().toLowerCase().trim();
                            if (respuesta.equals("si")) {
                                break;
                            } else if (respuesta.equals("no")) {
                                agregarMas = false;
                                break;
                            }
                            System.out.println("¡¡Entrada no válida. Por favor, ingrese 'si' o 'no'.!!");
                        }
                    }
                    break;

                case "2":
                    tren.mostrarTabla();
                    break;

                case "3":
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("¡¡Opción no válida. Intente de nuevo.!!");
                    break;
            }
        }
        scanner.close();
    }
}
