package corte2.listas_enlazadas_simples.Ejercicio3;

import java.util.Scanner;

/*
 * EJEMPLOS DE DATOS:
 * Vuelo 1: AV123 | Avianca | 25 | 150
 * Vuelo 2: LA456 | Latam | 8 | 120
 * Vuelo 3: AA789 | American Airlines | 40 | 200
 * Vuelo 4: IB101 | Iberia | 5 | 180 
 * Vuelo 5: CM202 | Copa Airlines | 15 | 90
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TorreControl torre = new TorreControl();

        System.out.println("\n=== SISTEMA DE TORRE DE CONTROL - GESTIÓN DE VUELOS ===");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Agregar un vuelo");
            System.out.println("2. Reportar emergencia");
            System.out.println("3. Mostrar lista de espera");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String seleccion = scanner.nextLine();

            switch (seleccion) {
                case "1":
                    boolean agregarMas = true;
                    while (agregarMas) {
                        String numeroVuelo;
                        while (true) {
                            System.out.print("\nIngrese el número de vuelo: ");
                            numeroVuelo = scanner.nextLine();
                            if (torre.buscarVuelo(numeroVuelo)) {
                                System.out.println("¡¡Este número de vuelo ya se encuentra en la cola.!!");
                                continue;
                            }
                            break;
                        }

                        String aerolinea;
                        while (true) {
                            System.out.print("Ingrese la aerolínea: ");
                            aerolinea = scanner.nextLine();
                            if (!aerolinea.matches(".*\\d.*")) {
                                break;
                            }
                            System.out.println("¡¡Entrada inválida. No se permiten números en la aerolínea.!!");
                        }

                        int combustible;
                        while (true) {
                            System.out.print("Ingrese el combustible restante (unidades): ");
                            try {
                                combustible = Integer.parseInt(scanner.nextLine());
                                if (combustible >= 0)
                                    break;
                                System.out.println("¡¡El combustible no puede ser negativo.!!");
                            } catch (NumberFormatException e) {
                                System.out.println("¡¡Entrada inválida. Ingrese un número entero.!!");
                            }
                        }

                        int pasajeros;
                        while (true) {
                            System.out.print("Ingrese el número de pasajeros: ");
                            try {
                                pasajeros = Integer.parseInt(scanner.nextLine());
                                if (pasajeros >= 0)
                                    break;
                                System.out.println("¡¡El número de pasajeros no puede ser negativo.!!");
                            } catch (NumberFormatException e) {
                                System.out.println("¡¡Entrada inválida. Ingrese un número entero.!!");
                            }
                        }

                        torre.insertarVuelo(numeroVuelo, aerolinea, combustible, pasajeros);
                        System.out.println("\nVuelo registrado exitosamente.");

                        while (true) {
                            System.out.print("\n¿Desea registrar otro vuelo? (si/no): ");
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
                    boolean seguirReportando = true;
                    while (seguirReportando) {
                        System.out.print("\nIngrese el número de vuelo en emergencia: ");
                        String vueloEmergencia = scanner.nextLine();
                        torre.reportarEmergencia(vueloEmergencia);
                        torre.mostrarCola();

                        while (true) {
                            System.out.print("¿Desea reportar otra emergencia o salir? (si/no): ");
                            String respuesta = scanner.nextLine().toLowerCase().trim();
                            if (respuesta.equals("si")) {
                                break;
                            } else if (respuesta.equals("no")) {
                                seguirReportando = false;
                                break;
                            }
                            System.out.println("¡¡Entrada no válida. Por favor, ingrese 'si' o 'no'.!!");
                        }
                    }
                    break;

                case "3":
                    torre.mostrarCola();
                    break;

                case "4":
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
