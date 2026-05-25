package corte3.colas.Ejercicio2;

import java.util.Scanner;

/*
Datos de prueba sugeridos para ingresar manualmente:
- CC: 1001 | Nombre: Pedro Martinez  | Edad: 45 | Síntoma: Dolor de cabeza fuerte
- CC: 1002 | Nombre: Lucia Fernandez | Edad: 23 | Síntoma: Fiebre y malestar general
- CC: 1003 | Nombre: Roberto Gomez   | Edad: 60 | Síntoma: Dificultad para respirar
*/
public class App {
    public static void main(String[] args) {
        ColaPacientes urgencias = new ColaPacientes();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n--- URGENCIAS HOSPITALARIAS (TRIAJE) ---");
            System.out.println("1. Ver fila de espera");
            System.out.println("2. Registrar nuevo paciente (Enqueue)");
            System.out.println("3. Atender siguiente paciente (Dequeue)");
            System.out.println("4. Finalizar turno (Atender a todos)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\nEstado actual de la sala de urgencias:");
                    urgencias.imprimir();
                    break;
                case 2:
                    System.out.print("Cédula: "); String cedula = scanner.nextLine();
                    System.out.print("Nombre Completo: "); String nombre = scanner.nextLine();
                    System.out.print("Edad: "); int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Síntoma Principal: "); String sintoma = scanner.nextLine();
                    urgencias.enqueue(new Paciente(cedula, nombre, edad, sintoma));
                    System.out.println("Paciente registrado en la fila.");
                    break;
                case 3:
                    Paciente atendido = urgencias.dequeue();
                    if (atendido != null) {
                        System.out.println("Atendiendo en consultorio a: " + atendido);
                    } else {
                        System.out.println("No hay pacientes esperando.");
                    }
                    break;
                case 4:
                    urgencias.atenderTodos();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
