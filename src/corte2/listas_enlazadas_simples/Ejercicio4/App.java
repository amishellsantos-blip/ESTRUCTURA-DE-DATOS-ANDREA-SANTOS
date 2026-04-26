package corte2.listas_enlazadas_simples.Ejercicio4;

import java.util.Scanner;

/*
 * EJEMPLOS DE DATOS:
 * Lectura 1: 101 | 25.5 | 14.7 | 08:00
 * Lectura 2: 102 | 30.2 | 15.1 | 09:00
 * Lectura 3: 101 | 45.8 | 16.5 | 10:00 (Alerta: Temp Alta)
 * Lectura 4: 103 | 22.1 | 14.2 | 11:00
 * Lectura 5: 102 | 28.9 | 14.9 | 12:00
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Monitoreo sistema = new Monitoreo();

        System.out.println("\n=== SISTEMA DE MONITOREO INDUSTRIAL - TANQUES QUÍMICOS ===");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Agregar lectura de sensor");
            System.out.println("2. Ver lectura con temperatura más alta");
            System.out.println("3. Mostrar historial completo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String seleccion = scanner.nextLine();

            switch (seleccion) {
                case "1":
                    boolean agregarMas = true;
                    while (agregarMas) {
                        int idSensor;
                        while (true) {
                            System.out.print("\nIngrese el ID del sensor: ");
                            try {
                                idSensor = Integer.parseInt(scanner.nextLine());
                                if (idSensor > 0) break;
                                System.out.println("¡¡El ID debe ser un número positivo.!!");
                            } catch (NumberFormatException e) {
                                System.out.println("¡¡Entrada inválida. Ingrese un número entero.!!");
                            }
                        }

                        double temperatura;
                        while (true) {
                            System.out.print("Ingrese la temperatura (°C): ");
                            try {
                                temperatura = Double.parseDouble(scanner.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("¡¡Entrada inválida. Ingrese un valor numérico.!!");
                            }
                        }

                        double presion;
                        while (true) {
                            System.out.print("Ingrese la presión (PSI): ");
                            try {
                                presion = Double.parseDouble(scanner.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("¡¡Entrada inválida. Ingrese un valor numérico.!!");
                            }
                        }

                        System.out.print("Ingrese la hora de la lectura (ej: 14:00): ");
                        String hora = scanner.nextLine();

                        sistema.agregarLectura(idSensor, temperatura, presion, hora);
                        System.out.println("\n¡¡Lectura registrada exitosamente!!");

                        while (true) {
                            System.out.print("¿Desea registrar otra lectura? (si/no): ");
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
                    sistema.obtenerTemperaturaAlta();
                    break;

                case "3":
                    sistema.mostrarHistorial();
                    break;

                case "4":
                    salir = true;
                    System.out.println("Saliendo del sistema de monitoreo...");
                    break;

                default:
                    System.out.println("¡¡Opción no válida. Intente de nuevo.!!");
                    break;
            }
        }
        scanner.close();
    }
}
