package corte2.listas_circulares.Ejercicio4;

import java.util.Scanner;

/*
 * EJEMPLOS DE DATOS:
 * Grupo 1: Familia Santos | 5 | true | 10
 * Grupo 2: Juan y amigos | 3 | false | 20
 * Grupo 3: Pareja Real | 2 | true | 5
 * Grupo 4: Los Colegas | 8 | false | 15
 * Grupo 5: Cumpleaños | 12 | false | 30
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurante gourmet = new Restaurante();

        System.out.println("\n=== GESTIÓN DE RESTAURANTE - LISTA DE ESPERA CIRCULAR ===");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ DE ATENCIÓN ---");
            System.out.println("1. Registrar grupo en espera");
            System.out.println("2. Atender siguiente turno");
            System.out.println("3. Simular 6 turnos (Reto)");
            System.out.println("4. Ver lista de espera completa");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            String seleccion = scanner.nextLine();

            switch (seleccion) {
                case "1":
                    boolean agregarMas = true;
                    while (agregarMas) {
                        System.out.print("\nIngrese el nombre de la reserva: ");
                        String nombre = scanner.nextLine();

                        int personas;
                        while (true) {
                            System.out.print("¿Cuántas personas son?: ");
                            try {
                                personas = Integer.parseInt(scanner.nextLine());
                                if (personas > 0)
                                    break;
                                System.out.println("¡¡Debe ser al menos 1 persona.!!");
                            } catch (NumberFormatException e) {
                                System.out.println("¡¡Entrada inválida. Ingrese un número entero.!!");
                            }
                        }

                        boolean vip = false;
                        while (true) {
                            System.out.print("¿Es cliente VIP? (si/no): ");
                            String respVip = scanner.nextLine().toLowerCase().trim();
                            if (respVip.equals("si")) {
                                vip = true;
                                break;
                            } else if (respVip.equals("no")) {
                                vip = false;
                                break;
                            }
                            System.out.println("¡¡Responda 'si' o 'no'.!!");
                        }

                        int minutos;
                        while (true) {
                            System.out.print("¿Cuántos minutos lleva esperando?: ");
                            try {
                                minutos = Integer.parseInt(scanner.nextLine());
                                if (minutos >= 0)
                                    break;
                                System.out.println("¡¡El tiempo no puede ser negativo.!!");
                            } catch (NumberFormatException e) {
                                System.out.println("¡¡Entrada inválida. Ingrese un número entero.!!");
                            }
                        }

                        gourmet.agregarGrupo(nombre, personas, vip, minutos);
                        System.out.println("\n¡¡Grupo registrado en la fila!!");

                        while (true) {
                            System.out.print("\n¿Desea registrar otro grupo? (si/no): ");
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
                    gourmet.atenderSiguiente();
                    break;

                case "3":
                    System.out.println("\n>>> INICIANDO SIMULACIÓN DE 6 TURNOS <<<");
                    for (int i = 1; i <= 6; i++) {
                        System.out.println("\n--- ATENCIÓN #" + i + " ---");
                        gourmet.atenderSiguiente();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                        }
                    }
                    break;

                case "4":
                    gourmet.mostrarLista();
                    break;

                case "5":
                    salir = true;
                    System.out.println("Saliendo del sistema del restaurante...");
                    break;

                default:
                    System.out.println("¡¡Opción no válida. Intente de nuevo.!!");
                    break;
            }
        }
        scanner.close();
    }
}
