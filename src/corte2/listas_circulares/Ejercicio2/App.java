package corte2.listas_circulares.Ejercicio2;

import java.util.Scanner;

/*
 * EJEMPLOS DE DATOS:
 * Anuncio 1: Oferta Zapatos | 15 | Oferta
 * Anuncio 2: Coca Cola | 30 | Marca
 * Anuncio 3: Concierto Rock | 20 | Evento
 * Anuncio 4: Burger King | 25 | Marca
 * Anuncio 5: Black Friday | 10 | Oferta
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pantalla carrusel = new Pantalla();

        System.out.println("\n=== PANTALLA DIGITAL - CARRUSEL DE ANUNCIOS ===");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ DE CONTROL ---");
            System.out.println("1. Agregar anuncio a la rotación");
            System.out.println("2. Iniciar carrusel (Reproducir por ciclos)");
            System.out.println("3. Ver lista de anuncios y estadísticas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String seleccion = scanner.nextLine();

            switch (seleccion) {
                case "1":
                    boolean agregarMas = true;
                    while (agregarMas) {
                        System.out.print("\nIngrese el título del anuncio: ");
                        String titulo = scanner.nextLine();

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

                        System.out.print("Ingrese la categoría (Oferta, Marca, Evento): ");
                        String categoria = scanner.nextLine();

                        carrusel.agregarAnuncio(titulo, duracion, categoria);
                        System.out.println("\n¡¡Anuncio agregado exitosamente!!");

                        while (true) {
                            System.out.print("\n¿Desea agregar otro anuncio? (si/no): ");
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
                    int ciclos;
                    while (true) {
                        System.out.print("\n¿Cuántos ciclos completos desea reproducir?: ");
                        try {
                            ciclos = Integer.parseInt(scanner.nextLine());
                            if (ciclos > 0)
                                break;
                            System.out.println("¡¡Debe ingresar al menos 1 ciclo.!!");
                        } catch (NumberFormatException e) {
                            System.out.println("¡¡Entrada inválida. Ingrese un número entero.!!");
                        }
                    }
                    carrusel.reproducir(ciclos);
                    break;

                case "3":
                    carrusel.mostrarAnuncios();
                    break;

                case "4":
                    salir = true;
                    System.out.println("Saliendo del sistema de pantalla digital...");
                    break;

                default:
                    System.out.println("¡¡Opción no válida. Intente de nuevo.!!");
                    break;
            }
        }
        scanner.close();
    }
}
