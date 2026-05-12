package corte2.Parcial2.Ejercicio1;

import java.util.Scanner;

/*Implementar una lista enlazada simple para logisitca.
Implemeta un switch con: 
a. Enganchar vagon: insertar al final con id, contenido y peso.
b. Buscar por ID: buscar un vagon y mostrar su contenido y peso.
c. Estado del tren: listar todos los vagones y mostrar el peso total acumulado.
d. Vagon pesado: método que identifique y muestre el vagon con mayor peso.
No permitir pesos negativos o IDs duplicados.*/
public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaTren tren = new ListaTren();

        System.out.println("\n=== SISTEMA DE GESTIÓN DE TREN DE CARGA ===");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Enganchar vagón.");
            System.out.println("2. Buscar vagón por ID.");
            System.out.println("3. Estado del tren.");
            System.out.println("3. Vagón con mayor peso.");
            System.out.println("4. Salir.");
            System.out.print("Seleccione una opción: ");

            String seleccion = scanner.nextLine();

            switch (seleccion) {
                case "1":
                    boolean agregarMas = true;
                    while (agregarMas) {

                        int id;
                        while (true) {
                            System.out.print("Ingrese el ID del vagón: ");
                            id = Integer.parseInt(scanner.nextLine());
                            break;

                        }
                        String contenido;
                        while (true) {
                            System.out.print("\nIngrese el contenido del vagón: ");
                            contenido = scanner.nextLine();
                            if (!contenido.matches(".*\\d.*"))
                                break;
                            System.out.println("¡¡Entrada inválida. No se permiten números.!!");
                        }

                        double pesoToneladas;
                        while (true) {
                            System.out.print("Ingrese el peso en toneladas: ");
                            try {
                                pesoToneladas = Double.parseDouble(scanner.nextLine());
                                if (pesoToneladas > 0)
                                    break;
                                System.out.println("¡¡El peso debe ser mayor a cero.!!");
                            } catch (NumberFormatException e) {
                                System.out.println("¡¡Entrada inválida. Ingrese un número válido.!!");
                            }
                        }

                        tren.engancharVagon(id, contenido, pesoToneladas);
                        System.out.println("\nVagón agregado exitosamente.");

                        while (true) {
                            System.out.print("\n¿Desea agregar otro vagón? (si/no): ");
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
                    System.out.print("Ingrese el ID del vagón: ");
                    int buscar = Integer.parseInt(scanner.nextLine());

                case "3":
                    tren.estadoTren();
                    break;

                case "4":
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("¡¡Opción no válida. Intente de nuevo.!!");
                    break;
            }
        }
        scanner.close();

    }

}
