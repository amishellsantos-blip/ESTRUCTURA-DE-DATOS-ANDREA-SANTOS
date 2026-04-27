package corte2.listas_circulares_dobles.Ejercicio2;

import java.util.Scanner;

/*
 * EJEMPLOS DE DATOS:
 * Comando 1: git status | true | /c/proyectos/java
 * Comando 2: npm start | false | /c/web/app
 * Comando 3: cd .. | true | /home/user
 * Comando 4: ls -la | true | /usr/bin
 * Comando 5: java -jar app.jar | false | /desktop
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HistorialTerminal terminal = new HistorialTerminal();

        System.out.println("\n=== SIMULADOR DE HISTORIAL DE TERMINAL ===");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ DE HISTORIAL ---");
            System.out.println("1. Registrar nuevo comando");
            System.out.println("2. Flecha ARRIBA (Anterior)");
            System.out.println("3. Flecha ABAJO (Siguiente)");
            System.out.println("4. Eliminar comando actual (Cursor)");
            System.out.println("5. Ver historial completo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            String seleccion = scanner.nextLine();

            switch (seleccion) {
                case "1":
                    boolean agregarMas = true;
                    while (agregarMas) {
                        System.out.print("\nIngrese el texto del comando: ");
                        String texto = scanner.nextLine();

                        boolean exitoso = false;
                        while (true) {
                            System.out.print("¿Fue exitoso? (si/no): ");
                            String resp = scanner.nextLine().toLowerCase().trim();
                            if (resp.equals("si")) {
                                exitoso = true;
                                break;
                            } else if (resp.equals("no")) {
                                exitoso = false;
                                break;
                            }
                            System.out.println("¡¡Responda 'si' o 'no'.!!");
                        }

                        System.out.print("Ingrese el directorio de ejecución: ");
                        String dir = scanner.nextLine();

                        terminal.agregarComando(texto, exitoso, dir);

                        while (true) {
                            System.out.print("¿Desea registrar otro comando? (si/no): ");
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
                    terminal.arriba();
                    break;

                case "3":
                    terminal.abajo();
                    break;

                case "4":
                    terminal.eliminarActual();
                    break;

                case "5":
                    terminal.mostrarHistorial();
                    terminal.mostrarCursor();
                    break;

                case "6":
                    salir = true;
                    System.out.println("Saliendo del simulador...");
                    break;

                default:
                    System.out.println("¡¡Opción no válida. Intente de nuevo.!!");
                    break;
            }
        }
        scanner.close();
    }
}
