package corte2.listas_circulares.Ejercicio3;

import java.util.Scanner;

/*
 * EJEMPLOS DE DATOS:
 * Proceso 1: Chrome.exe | 1024 | 500 | 1
 * Proceso 2: Spotify.exe | 2048 | 300 | 2
 * Proceso 3: VSCode.exe | 3072 | 800 | 1
 * Proceso 4: Zoom.exe | 4096 | 400 | 3
 * Proceso 5: Antivirus.exe | 5120 | 150 | 1
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Planificador cpu = new Planificador();

        System.out.println("\n=== PLANIFICADOR DE CPU - ALGORITMO ROUND ROBIN ===");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ DEL SISTEMA ---");
            System.out.println("1. Cargar proceso a la cola");
            System.out.println("2. Ejecutar planificación (Round Robin)");
            System.out.println("3. Ver procesos pendientes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String seleccion = scanner.nextLine();

            switch (seleccion) {
                case "1":
                    boolean agregarMas = true;
                    while (agregarMas) {
                        System.out.print("\nIngrese el nombre del proceso (ej: chrome.exe): ");
                        String nombre = scanner.nextLine();

                        int pid;
                        while (true) {
                            System.out.print("Ingrese el PID: ");
                            try {
                                pid = Integer.parseInt(scanner.nextLine());
                                if (pid > 0)
                                    break;
                                System.out.println("¡¡El PID debe ser un número positivo.!!");
                            } catch (NumberFormatException e) {
                                System.out.println("¡¡Entrada inválida. Ingrese un número entero.!!");
                            }
                        }

                        int tiempo;
                        while (true) {
                            System.out.print("Ingrese el tiempo de ejecución requerido (ms): ");
                            try {
                                tiempo = Integer.parseInt(scanner.nextLine());
                                if (tiempo > 0)
                                    break;
                                System.out.println("¡¡El tiempo debe ser mayor a cero.!!");
                            } catch (NumberFormatException e) {
                                System.out.println("¡¡Entrada inválida. Ingrese un número entero.!!");
                            }
                        }

                        int prioridad;
                        while (true) {
                            System.out.print("Ingrese la prioridad (1 al 3): ");
                            try {
                                prioridad = Integer.parseInt(scanner.nextLine());
                                if (prioridad >= 1 && prioridad <= 3)
                                    break;
                                System.out.println("¡¡La prioridad debe estar entre 1 y 3.!!");
                            } catch (NumberFormatException e) {
                                System.out.println("¡¡Entrada inválida. Ingrese 1, 2 o 3.!!");
                            }
                        }

                        cpu.agregarProceso(nombre, pid, tiempo, prioridad);
                        System.out.println("\n¡¡Proceso cargado en la memoria!!");

                        while (true) {
                            System.out.print("\n¿Desea cargar otro proceso? (si/no): ");
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
                    int quantum;
                    while (true) {
                        System.out.print("\nIngrese el quantum de tiempo (ms): ");
                        try {
                            quantum = Integer.parseInt(scanner.nextLine());
                            if (quantum > 0)
                                break;
                            System.out.println("¡¡El quantum debe ser mayor a cero.!!");
                        } catch (NumberFormatException e) {
                            System.out.println("¡¡Entrada inválida. Ingrese un número entero.!!");
                        }
                    }
                    cpu.ejecutar(quantum);
                    break;

                case "3":
                    cpu.mostrarCola();
                    break;

                case "4":
                    salir = true;
                    System.out.println("Cerrando el planificador de CPU...");
                    break;

                default:
                    System.out.println("¡¡Opción no válida. Intente de nuevo.!!");
                    break;
            }
        }
        scanner.close();
    }
}
