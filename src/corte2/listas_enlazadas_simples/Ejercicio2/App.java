package corte2.listas_enlazadas_simples.Ejercicio2;

import java.util.Scanner;

/*
 * EJEMPLOS DE DATOS:
 * Producto 1: Yogurt | 10 | 2
 * Producto 2: Queso | 5 | 5
 * Producto 3: Leche | 15 | 7
 * Producto 4: Mantequilla | 8 | 1
 * Producto 5: Crema | 6 | 10
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();

        System.out.println("\n=== SISTEMA DE GESTIÓN DE INVENTARIO DE LÁCTEOS ===");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Agregar un producto");
            System.out.println("2. Mostrar productos que vencen en menos de 5 días");
            System.out.println("3. Mostrar todos los productos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String seleccion = scanner.nextLine();

            switch (seleccion) {
                case "1":
                    boolean agregarMas = true;
                    while (agregarMas) {
                        String nombre;
                        while (true) {
                            System.out.print("\nIngrese el nombre del producto: ");
                            nombre = scanner.nextLine();
                            if (!nombre.matches(".*\\d.*")) {
                                if (inventario.buscarProducto(nombre)) {
                                    System.out.println("¡¡Este producto ya existe en el inventario.!!");
                                    continue;
                                }
                                break;
                            }
                            System.out.println("¡¡Entrada inválida. No se permiten números.!!");
                        }

                        int cantidad;
                        while (true) {
                            System.out.print("Ingrese la cantidad disponible: ");
                            try {
                                cantidad = Integer.parseInt(scanner.nextLine());
                                if (cantidad >= 0)
                                    break;
                                System.out.println("¡¡La cantidad no puede ser negativa.!!");
                            } catch (NumberFormatException e) {
                                System.out.println("¡¡Entrada inválida. Ingrese un número entero.!!");
                            }
                        }

                        int diasParaVencer;
                        while (true) {
                            System.out.print("Ingrese los días para vencer: ");
                            try {
                                diasParaVencer = Integer.parseInt(scanner.nextLine());
                                if (diasParaVencer >= 0)
                                    break;
                                System.out.println("¡¡Los días para vencer no pueden ser negativos.!!");
                            } catch (NumberFormatException e) {
                                System.out.println("¡¡Entrada inválida. Ingrese un número entero.!!");
                            }
                        }

                        inventario.insertarProducto(nombre, cantidad, diasParaVencer);
                        System.out.println("\nProducto agregado exitosamente.");

                        while (true) {
                            System.out.print("\n¿Desea agregar otro producto? (si/no): ");
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
                    inventario.mostrarProductosProximos();
                    break;

                case "3":
                    inventario.mostrarTodosProductos();
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
