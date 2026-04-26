package corte2.listas_enlazadas_dobles.Ejercicio2;

import java.util.Scanner;

/*
 * EJEMPLOS DE DATOS:
 * Foto 1: vacaciones_playa.jpg | 2.5 | 1920x1080
 * Foto 2: mascota.png | 1.8 | 1280x720
 * Foto 3: familia.webp | 3.2 | 4000x3000
 * Foto 4: oficina.jpg | 0.9 | 800x600
 * Foto 5: atardecer.png | 5.5 | 3840x2160
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Galeria miGaleria = new Galeria();

        System.out.println("\n=== CARRUSEL DE IMÁGENES - GALERÍA INTERACTIVA ===");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ DE GALERÍA ---");
            System.out.println("1. Agregar fotografía");
            System.out.println("2. Siguiente foto (Avanzar)");
            System.out.println("3. Foto anterior (Retroceder)");
            System.out.println("4. Reproducir galería (Ida y Vuelta)");
            System.out.println("5. Ver todas las fotos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            String seleccion = scanner.nextLine();

            switch (seleccion) {
                case "1":
                    boolean agregarMas = true;
                    while (agregarMas) {
                        System.out.print("\nIngrese el nombre del archivo (ej: foto.jpg): ");
                        String nombre = scanner.nextLine();

                        double tamano;
                        while (true) {
                            System.out.print("Ingrese el tamaño en MB: ");
                            try {
                                tamano = Double.parseDouble(scanner.nextLine());
                                if (tamano > 0)
                                    break;
                                System.out.println("¡¡El tamaño debe ser mayor a cero.!!");
                            } catch (NumberFormatException e) {
                                System.out.println("¡¡Entrada inválida. Ingrese un número válido.!!");
                            }
                        }

                        System.out.print("Ingrese la resolución (ej: 1920x1080): ");
                        String resolucion = scanner.nextLine();

                        miGaleria.agregarFoto(nombre, tamano, resolucion);
                        System.out.println("\n¡¡Fotografía agregada con éxito!!");

                        while (true) {
                            System.out.print("\n¿Desea agregar otra fotografía? (si/no): ");
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
                    miGaleria.avanzar();
                    break;

                case "3":
                    miGaleria.retroceder();
                    break;

                case "4":
                    miGaleria.reproducirGaleria();
                    break;

                case "5":
                    miGaleria.mostrarTabla();
                    break;

                case "6":
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
