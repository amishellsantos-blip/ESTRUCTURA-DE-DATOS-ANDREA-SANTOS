package corte2.listas_enlazadas_dobles.Ejercicio3;

import java.util.Scanner;

/*
 * EJEMPLOS DE DATOS:
 * Pestaña 1: Google | https://google.com | 08:00
 * Pestaña 2: YouTube | https://youtube.com | 08:15
 * Pestaña 3: GitHub | https://github.com | 09:00
 * Pestaña 4: Netflix | https://netflix.com | 20:30
 * Pestaña 5: Canvas | https://canvas.edu.co | 07:00
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Navegador chrome = new Navegador();

        System.out.println("\n=== SIMULADOR DE NAVEGACIÓN - PESTAÑAS ABIERTAS ===");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ DE NAVEGACIÓN ---");
            System.out.println("1. Abrir nueva pestaña");
            System.out.println("2. Cerrar pestaña (por URL)");
            System.out.println("3. Ver pestañas abiertas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String seleccion = scanner.nextLine();

            switch (seleccion) {
                case "1":
                    boolean agregarMas = true;
                    while (agregarMas) {
                        System.out.print("\nIngrese el título de la página: ");
                        String titulo = scanner.nextLine();

                        System.out.print("Ingrese la URL: ");
                        String url = scanner.nextLine();

                        System.out.print("Ingrese la hora de apertura (ej: 14:00): ");
                        String hora = scanner.nextLine();

                        chrome.abrirPestana(titulo, url, hora);

                        while (true) {
                            System.out.print("\n¿Desea abrir otra pestaña? (si/no): ");
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
                    System.out.print("\nIngrese la URL de la pestaña que desea cerrar: ");
                    String urlCerrar = scanner.nextLine();
                    chrome.cerrarPestanaActual(urlCerrar);
                    break;

                case "3":
                    chrome.mostrarPestanas();
                    break;

                case "4":
                    salir = true;
                    System.out.println("Saliendo del navegador...");
                    break;

                default:
                    System.out.println("¡¡Opción no válida. Intente de nuevo.!!");
                    break;
            }
        }
        scanner.close();
    }
}
