package corte2.listas_circulares.Ejercicio1;

import java.util.Scanner;
import java.util.Random;

/*
 * EJEMPLOS DE DATOS:
 * Participante 1: Andrea Santos | 1001 | Cúcuta
 * Participante 2: Carlos Gomez | 1002 | Bogotá
 * Participante 3: Maria Lopez | 1003 | Medellín
 * Participante 4: Juan Rodriguez | 1004 | Cali
 * Participante 5: Lucia Mendez | 1005 | Bucaramanga
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ruleta rifa = new Ruleta();
        Random random = new Random();

        System.out.println("\n=== SISTEMA DE RIFA DIGITAL - LA RULETA ===");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ DE SORTEO ---");
            System.out.println("1. Registrar nuevo participante");
            System.out.println("2. Girar la ruleta (Realizar sorteo)");
            System.out.println("3. Ver participantes actuales");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String seleccion = scanner.nextLine();

            switch (seleccion) {
                case "1":
                    boolean agregarMas = true;
                    while (agregarMas) {
                        String nombre;
                        while (true) {
                            System.out.print("\nIngrese el nombre del participante: ");
                            nombre = scanner.nextLine();
                            if (!nombre.matches(".*\\d.*"))
                                break;
                            System.out.println("¡¡Entrada inválida. El nombre no debe contener números.!!");
                        }

                        int numero;
                        while (true) {
                            System.out.print("Ingrese el número de boleta: ");
                            try {
                                numero = Integer.parseInt(scanner.nextLine());
                                if (numero > 0)
                                    break;
                                System.out.println("¡¡El número debe ser positivo.!!");
                            } catch (NumberFormatException e) {
                                System.out.println("¡¡Entrada inválida. Ingrese un número entero.!!");
                            }
                        }

                        String ciudad;
                        while (true) {
                            System.out.print("Ingrese la ciudad de origen: ");
                            ciudad = scanner.nextLine();
                            if (!ciudad.matches(".*\\d.*"))
                                break;
                            System.out.println("¡¡Entrada inválida. La ciudad no debe contener números.!!");
                        }

                        rifa.registrarParticipante(nombre, numero, ciudad);
                        System.out.println("\n¡¡Participante registrado exitosamente!!");

                        while (true) {
                            System.out.print("\n¿Desea registrar a alguien más? (si/no): ");
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
                    // Generamos un número aleatorio de pasos entre 5 y 50 para simular el giro
                    int pasos = random.nextInt(46) + 5;
                    rifa.realizarSorteo(pasos);
                    break;

                case "3":
                    rifa.mostrarParticipantes();
                    break;

                case "4":
                    salir = true;
                    System.out.println("Saliendo del sistema de rifa...");
                    break;

                default:
                    System.out.println("¡¡Opción no válida. Intente de nuevo.!!");
                    break;
            }
        }
        scanner.close();
    }
}
