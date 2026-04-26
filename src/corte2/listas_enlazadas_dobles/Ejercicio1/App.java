package corte2.listas_enlazadas_dobles.Ejercicio1;

import java.util.Scanner;

/*
 * EJEMPLOS DE DATOS:
 * Cambio 1: "Hola Mundo" | Escribir
 * Cambio 2: "Hola Mundo, como estas?" | Escribir
 * Cambio 3: "Hola Mundo" | Borrar
 * Cambio 4: "Hola Mundo, Andrea" | Escribir
 * Cambio 5: "Andrea Santos" | Borrar
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Historial historial = new Historial();

        System.out.println("\n=== SISTEMA DE CONTROL DE VERSIONES (UNDO/REDO) ===");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ DE CONTROL ---");
            System.out.println("1. Agregar cambio (Escribir/Borrar)");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Ver historial completo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            String seleccion = scanner.nextLine();

            switch (seleccion) {
                case "1":
                    boolean agregarMas = true;
                    while (agregarMas) {
                        System.out.print("\nIngrese el texto del cambio: ");
                        String texto = scanner.nextLine();

                        String operacion;
                        while (true) {
                            System.out.print("Ingrese el tipo de operación (Escribir/Borrar): ");
                            operacion = scanner.nextLine();
                            if (!operacion.matches(".*\\d.*"))
                                break;
                            System.out.println("¡¡Entrada inválida. No se permiten números en el tipo de operación.!!");
                        }

                        historial.agregarCambio(texto, operacion);
                        System.out.println("\n¡¡Cambio guardado exitosamente!!");

                        while (true) {
                            System.out.print("\n¿Desea agregar otro cambio? (si/no): ");
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
                    historial.deshacer();
                    break;

                case "3":
                    historial.rehacer();
                    break;

                case "4":
                    historial.mostrarHistorial();
                    break;

                case "5":
                    salir = true;
                    System.out.println("Saliendo del sistema de control de versiones...");
                    break;

                default:
                    System.out.println("¡¡Opción no válida. Intente de nuevo.!!");
                    break;
            }
        }
        scanner.close();
    }
}
