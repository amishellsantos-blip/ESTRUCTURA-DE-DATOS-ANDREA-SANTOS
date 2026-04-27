package corte2.listas_circulares_dobles.Ejercicio3;

import java.util.Scanner;

/*
 * EJEMPLOS DE DATOS:
 * Capa 1: Paisaje de Fondo | Fondo
 * Capa 2: Personaje Principal | Objeto
 * Capa 3: Cuadro de Diálogo | Texto
 * Capa 4: Efectos de Brillo | Objeto
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EditorCapas editor = new EditorCapas();

        System.out.println("\n=== SIMULADOR DE EDITOR DE CAPAS GRÁFICAS ===");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ DE EDICIÓN ---");
            System.out.println("1. Crear nueva capa");
            System.out.println("2. Subir a capa superior (Siguiente)");
            System.out.println("3. Bajar a capa inferior (Anterior)");
            System.out.println("4. Mostrar/Ocultar capa activa");
            System.out.println("5. Eliminar capa activa");
            System.out.println("6. Ver panel de capas");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            String seleccion = scanner.nextLine();

            switch (seleccion) {
                case "1":
                    boolean agregarMas = true;
                    while (agregarMas) {
                        System.out.print("\nIngrese el nombre de la capa: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Ingrese el tipo (Fondo, Objeto, Texto): ");
                        String tipo = scanner.nextLine();

                        editor.agregarCapa(nombre, tipo);

                        while (true) {
                            System.out.print("¿Desea crear otra capa? (si/no): ");
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
                    editor.subirCapa();
                    break;

                case "3":
                    editor.bajarCapa();
                    break;

                case "4":
                    editor.toggleVisibilidad();
                    break;

                case "5":
                    editor.eliminarActiva();
                    break;

                case "6":
                    editor.mostrarCapas();
                    break;

                case "7":
                    salir = true;
                    System.out.println("Cerrando editor de capas...");
                    break;

                default:
                    System.out.println("¡¡Opción no válida. Intente de nuevo.!!");
                    break;
            }
        }
        scanner.close();
    }
}
