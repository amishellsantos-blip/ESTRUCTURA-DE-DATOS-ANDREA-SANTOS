package corte2.listas_enlazadas_simples.Ejercicio5;

import java.util.Scanner;

/*
 * EJEMPLOS DE DATOS:
 * Canción 1: Bohemian Rhapsody | Queen | 354 | Rock
 * Canción 2: Stayin Alive | Bee Gees | 284 | Disco
 * Canción 3: Billie Jean | Michael Jackson | 294 | Pop
 * Canción 4: Shape of You | Ed Sheeran | 233 | Pop
 * Canción 5: Thunderstruck | AC/DC | 292 | Hard Rock
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Reproductor spotify = new Reproductor();

        System.out.println("\n=== SPOTIFY LITE - GESTIÓN DE LISTA DE REPRODUCCIÓN ===");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Agregar canción 'A continuación'");
            System.out.println("2. Agregar canción 'Al final de la cola'");
            System.out.println("3. Ver lista y tiempo total");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String seleccion = scanner.nextLine();

            if (seleccion.equals("1") || seleccion.equals("2")) {
                boolean agregarMas = true;
                while (agregarMas) {
                    System.out.print("\nIngrese el título de la canción: ");
                    String titulo = scanner.nextLine();

                    String artista;
                    while (true) {
                        System.out.print("Ingrese el nombre del artista: ");
                        artista = scanner.nextLine();
                        if (!artista.matches(".*\\d.*")) break;
                        System.out.println("¡¡Entrada inválida. El nombre del artista no debe contener números.!!");
                    }

                    int duracion;
                    while (true) {
                        System.out.print("Ingrese la duración en segundos: ");
                        try {
                            duracion = Integer.parseInt(scanner.nextLine());
                            if (duracion > 0) break;
                            System.out.println("¡¡La duración debe ser mayor a cero.!!");
                        } catch (NumberFormatException e) {
                            System.out.println("¡¡Entrada inválida. Ingrese un número entero.!!");
                        }
                    }

                    String genero;
                    while (true) {
                        System.out.print("Ingrese el género musical: ");
                        genero = scanner.nextLine();
                        if (!genero.matches(".*\\d.*")) break;
                        System.out.println("¡¡Entrada inválida. El género no debe contener números.!!");
                    }

                    if (seleccion.equals("1")) {
                        spotify.agregarSiguiente(titulo, artista, duracion, genero);
                    } else {
                        spotify.agregarAlFinal(titulo, artista, duracion, genero);
                    }

                    System.out.println("\n¡¡Canción agregada con éxito!!");

                    while (true) {
                        System.out.print("¿Desea agregar otra canción? (si/no): ");
                        String respuesta = scanner.nextLine().toLowerCase().trim();
                        if (respuesta.equals("si")) break;
                        if (respuesta.equals("no")) {
                            agregarMas = false;
                            break;
                        }
                        System.out.println("¡¡Entrada no válida. Por favor, ingrese 'si' o 'no'.!!");
                    }
                }
            } else if (seleccion.equals("3")) {
                spotify.mostrarLista();
            } else if (seleccion.equals("4")) {
                salir = true;
                System.out.println("Saliendo del reproductor...");
            } else {
                System.out.println("¡¡Opción no válida. Intente de nuevo.!!");
            }
        }
        scanner.close();
    }
}
