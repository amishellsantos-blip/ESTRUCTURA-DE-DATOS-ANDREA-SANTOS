package corte2.listas_circulares.Ejercicio5;

import java.util.Scanner;

/*
 * EJEMPLOS DE DATOS:
 * Equipo 1: Millonarios | Bogotá
 * Equipo 2: Nacional | Medellín
 * Equipo 3: Junior | Barranquilla
 * Equipo 4: America | Cali
 * Equipo 5: Bucaramanga | Bucaramanga
 * Equipo 6: Cúcuta | Cúcuta
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Torneo liga = new Torneo();

        System.out.println("\n=== TORNEO DE FÚTBOL - FIXTURE ROUND ROBIN ===");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ DEL TORNEO ---");
            System.out.println("1. Registrar equipo");
            System.out.println("2. Generar Fixture y Simular Torneo (Requiere # par)");
            System.out.println("3. Ver tabla de posiciones");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String seleccion = scanner.nextLine();

            switch (seleccion) {
                case "1":
                    boolean agregarMas = true;
                    while (agregarMas) {
                        System.out.print("\nIngrese el nombre del equipo: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Ingrese la ciudad: ");
                        String ciudad = scanner.nextLine();

                        liga.agregarEquipo(nombre, ciudad);
                        System.out.println("\n¡¡Equipo registrado exitosamente!!");

                        while (true) {
                            System.out.print("¿Desea registrar otro equipo? (si/no): ");
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
                    liga.generarFixture();
                    break;

                case "3":
                    liga.mostrarTablaPosiciones();
                    break;

                case "4":
                    salir = true;
                    System.out.println("Cerrando el sistema del torneo...");
                    break;

                default:
                    System.out.println("¡¡Opción no válida. Intente de nuevo.!!");
                    break;
            }
        }
        scanner.close();
    }
}
