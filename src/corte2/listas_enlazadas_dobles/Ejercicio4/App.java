package corte2.listas_enlazadas_dobles.Ejercicio4;

import java.util.Scanner;

/*
 * EJEMPLOS DE DATOS:
 * Paciente 1: Andrea Santos | 20 | 1
 * Paciente 2: Juan Perez | 85 | 3
 * Paciente 3: Martha Lucia | 45 | 5
 * Paciente 4: Carlos Ruiz | 60 | 2
 * Paciente 5: Sofia Castro | 12 | 5
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consultorio clinica = new Consultorio();

        System.out.println("\n=== SISTEMA DE TURNOS - CONSULTORIO MÉDICO ===");

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ DE TURNOS ---");
            System.out.println("1. Agregar paciente a la fila");
            System.out.println("2. Buscar paciente de mayor edad (Recorrido desde atrás)");
            System.out.println("3. Ver lista completa de turnos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String seleccion = scanner.nextLine();

            switch (seleccion) {
                case "1":
                    boolean agregarMas = true;
                    while (agregarMas) {
                        String nombre;
                        while (true) {
                            System.out.print("\nIngrese el nombre del paciente: ");
                            nombre = scanner.nextLine();
                            if (!nombre.matches(".*\\d.*"))
                                break;
                            System.out.println("¡¡Entrada inválida. El nombre no debe contener números.!!");
                        }

                        int edad;
                        while (true) {
                            System.out.print("Ingrese la edad: ");
                            try {
                                edad = Integer.parseInt(scanner.nextLine());
                                if (edad >= 0)
                                    break;
                                System.out.println("¡¡La edad no puede ser negativa.!!");
                            } catch (NumberFormatException e) {
                                System.out.println("¡¡Entrada inválida. Ingrese un número entero.!!");
                            }
                        }

                        int urgencia;
                        while (true) {
                            System.out.print("Ingrese el nivel de urgencia (1-5): ");
                            try {
                                urgencia = Integer.parseInt(scanner.nextLine());
                                if (urgencia >= 1 && urgencia <= 5)
                                    break;
                                System.out.println("¡¡El nivel de urgencia debe estar entre 1 y 5.!!");
                            } catch (NumberFormatException e) {
                                System.out.println("¡¡Entrada inválida. Ingrese un número del 1 al 5.!!");
                            }
                        }

                        clinica.agregarPaciente(nombre, edad, urgencia);
                        System.out.println("\n¡¡Paciente registrado con éxito!!");

                        while (true) {
                            System.out.print("\n¿Desea registrar otro paciente? (si/no): ");
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
                    clinica.buscarMayorEdadDesdeAtras();
                    break;

                case "3":
                    clinica.mostrarTurnos();
                    break;

                case "4":
                    salir = true;
                    System.out.println("Saliendo del sistema de turnos...");
                    break;

                default:
                    System.out.println("¡¡Opción no válida. Intente de nuevo.!!");
                    break;
            }
        }
        scanner.close();
    }
}
