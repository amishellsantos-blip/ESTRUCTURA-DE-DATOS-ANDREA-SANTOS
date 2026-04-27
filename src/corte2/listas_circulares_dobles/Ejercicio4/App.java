package corte2.listas_circulares_dobles.Ejercicio4;

import java.util.Scanner;

/*
 * EJEMPLOS DE DATOS:
 * Foto 1: Cumpleaños Andrea | 2024-04-10
 * Foto 2: Paseo a la Montaña | 2024-01-15
 * Foto 3: Graduación | 2023-12-05
 * Foto 4: Cena Familiar | 2024-03-22
 * Foto 5: Playa Santa Marta | 2024-02-14
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GaleriaFotos album = new GaleriaFotos();

        System.out.println("\n=== SIMULADOR DE GALERÍA DE FOTOS DIGITAL ===");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ DE GALERÍA ---");
            System.out.println("1. Cargar nueva foto");
            System.out.println("2. Siguiente foto");
            System.out.println("3. Foto anterior");
            System.out.println("4. Marcar/Desmarcar favorita");
            System.out.println("5. Eliminar foto actual");
            System.out.println("6. Ver álbum completo");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            String seleccion = scanner.nextLine();

            switch (seleccion) {
                case "1":
                    boolean agregarMas = true;
                    while (agregarMas) {
                        System.out.print("\nIngrese el título de la foto: ");
                        String titulo = scanner.nextLine();

                        System.out.print("Ingrese la fecha (AAAA-MM-DD): ");
                        String fecha = scanner.nextLine();

                        album.agregarFoto(titulo, fecha);

                        while (true) {
                            System.out.print("¿Desea cargar otra foto? (si/no): ");
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
                    album.siguiente();
                    break;

                case "3":
                    album.anterior();
                    break;

                case "4":
                    album.toggleFavorita();
                    break;

                case "5":
                    album.eliminarActual();
                    break;

                case "6":
                    album.mostrarGaleria();
                    break;

                case "7":
                    salir = true;
                    System.out.println("Saliendo de la galería...");
                    break;

                default:
                    System.out.println("¡¡Opción no válida. Intente de nuevo.!!");
                    break;
            }
        }
        scanner.close();
    }
}
