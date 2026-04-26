package corte2.listas_enlazadas_dobles.Ejercicio5;

import java.util.Scanner;

/*
 * EJEMPLOS DE DATOS:
 * Canción 1: Sweet Child O Mine | Guns N Roses | 356
 * Canción 2: Smooth Criminal | Michael Jackson | 257
 * Canción 3: Hells Bells | AC/DC | 312
 * Canción 4: Lose Yourself | Eminem | 326
 * Canción 5: Don't Stop Me Now | Queen | 209
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReproductorPremium spotify = new ReproductorPremium();

        System.out.println("\n=== SPOTIFY PREMIUM - REPRODUCTOR BIDIRECCIONAL ===");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ DE REPRODUCCIÓN ---");
            System.out.println("1. Agregar canción a la cola");
            System.out.println("2. Siguiente canción (Saltar adelante)");
            System.out.println("3. Canción anterior (Saltar atrás)");
            System.out.println("4. Ver lista y canción actual");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            String seleccion = scanner.nextLine();

            switch (seleccion) {
                case "1":
                    boolean agregarMas = true;
                    while (agregarMas) {
                        System.out.print("\nIngrese el título de la canción: ");
                        String titulo = scanner.nextLine();

                        String artista;
                        while (true) {
                            System.out.print("Ingrese el nombre del artista: ");
                            artista = scanner.nextLine();
                            if (!artista.matches(".*\\d.*"))
                                break;
                            System.out.println("¡¡Entrada inválida. El artista no debe contener números.!!");
                        }

                        int duracion;
                        while (true) {
                            System.out.print("Ingrese la duración en segundos: ");
                            try {
                                duracion = Integer.parseInt(scanner.nextLine());
                                if (duracion > 0)
                                    break;
                                System.out.println("¡¡La duración debe ser mayor a cero.!!");
                            } catch (NumberFormatException e) {
                                System.out.println("¡¡Entrada inválida. Ingrese un número entero.!!");
                            }
                        }

                        spotify.agregarCancion(titulo, artista, duracion);
                        System.out.println("\n¡¡Canción añadida exitosamente!!");

                        while (true) {
                            System.out.print("\n¿Desea añadir otra canción? (si/no): ");
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
                    spotify.saltarAdelante();
                    break;

                case "3":
                    spotify.saltarAtras();
                    break;

                case "4":
                    spotify.mostrarLista();
                    spotify.mostrarEstadoActual();
                    break;

                case "5":
                    salir = true;
                    System.out.println("Saliendo del reproductor premium...");
                    break;

                default:
                    System.out.println("¡¡Opción no válida. Intente de nuevo.!!");
                    break;
            }
        }
        scanner.close();
    }
}
