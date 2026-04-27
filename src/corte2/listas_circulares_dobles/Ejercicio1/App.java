package corte2.listas_circulares_dobles.Ejercicio1;

import java.util.Scanner;

/*
 * EJEMPLOS DE DATOS (Simulación de 6 estaciones):
 * Estación 1: San Antonio | 1 | 50000
 * Estación 2: Alpujarra | 1 | 35000
 * Estación 3: Exposiciones | 1 | 42000
 * Estación 4: Industriales | 2 | 28000
 * Estación 5: Poblado | 2 | 60000
 * Estación 6: Aguacatala | 3 | 15000
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MetroCircular lineaA = new MetroCircular();

        System.out.println("\n=== SISTEMA DE METRO CIRCULAR - PLANIFICADOR DE RUTAS ===");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ DE OPERACIONES ---");
            System.out.println("1. Registrar nueva estación");
            System.out.println("2. Planificar ruta más corta");
            System.out.println("3. Ver mapa completo de la red");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String seleccion = scanner.nextLine();

            switch (seleccion) {
                case "1":
                    boolean agregarMas = true;
                    while (agregarMas) {
                        System.out.print("\nIngrese el nombre de la estación: ");
                        String nombre = scanner.nextLine();

                        int zona;
                        while (true) {
                            System.out.print("Ingrese la zona (1 al 3): ");
                            try {
                                zona = Integer.parseInt(scanner.nextLine());
                                if (zona >= 1 && zona <= 3)
                                    break;
                                System.out.println("¡¡La zona debe estar entre 1 y 3.!!");
                            } catch (NumberFormatException e) {
                                System.out.println("¡¡Entrada inválida. Ingrese un número entero.!!");
                            }
                        }

                        int pasajeros;
                        while (true) {
                            System.out.print("Ingrese el promedio de pasajeros diarios: ");
                            try {
                                pasajeros = Integer.parseInt(scanner.nextLine());
                                if (pasajeros >= 0)
                                    break;
                                System.out.println("¡¡El número de pasajeros no puede ser negativo.!!");
                            } catch (NumberFormatException e) {
                                System.out.println("¡¡Entrada inválida. Ingrese un número entero.!!");
                            }
                        }

                        lineaA.agregarEstacion(nombre, zona, pasajeros);
                        System.out.println("\n¡¡Estación registrada en la red!!");

                        while (true) {
                            System.out.print("\n¿Desea registrar otra estación? (si/no): ");
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
                    System.out.print("\nIngrese la estación de ORIGEN: ");
                    String origen = scanner.nextLine();
                    System.out.print("Ingrese la estación de DESTINO: ");
                    String destino = scanner.nextLine();
                    lineaA.rutaMasCorta(origen, destino);
                    break;

                case "3":
                    lineaA.mostrarEstaciones();
                    break;

                case "4":
                    salir = true;
                    System.out.println("Saliendo del sistema de metro...");
                    break;

                default:
                    System.out.println("¡¡Opción no válida. Intente de nuevo.!!");
                    break;
            }
        }
        scanner.close();
    }
}
