package corte3.arboles.Ejercicio3;

import java.util.Scanner;

/*
Datos de prueba sugeridos para ingresar manualmente:
- Cédula: 101010 | Nombre: Ana Rojas      | Cargo: Gerente      | Salario: 5000.0
- Cédula: 050505 | Nombre: Carlos Gomez   | Cargo: Analista     | Salario: 2500.0
- Cédula: 202020 | Nombre: Maria Silva    | Cargo: Directora    | Salario: 6000.0
- Cédula: 010101 | Nombre: Juan Perez     | Cargo: Asistente    | Salario: 1500.0
*/
public class App {
    public static void main(String[] args) {
        ArbolNomina nomina = new ArbolNomina();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- SISTEMA DE NÓMINA (RRHH) ---");
            System.out.println("1. Ver nómina completa (InOrden)");
            System.out.println("2. Registrar nuevo empleado");
            System.out.println("3. Buscar empleado con cédula más baja (Mínimo)");
            System.out.println("4. Buscar empleado con cédula más alta (Máximo)");
            System.out.println("5. Generar reporte de eficiencia (Altura y Hojas)");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\nNómina ordenada por cédula:");
                    nomina.imprimirNomina();
                    break;
                case 2:
                    System.out.print("Cédula (número largo): "); 
                    long cedula = scanner.nextLong();
                    scanner.nextLine();
                    
                    System.out.print("Nombre Completo: "); 
                    String nombre = scanner.nextLine();
                    
                    System.out.print("Cargo: "); 
                    String cargo = scanner.nextLine();
                    
                    System.out.print("Salario mensual: "); 
                    double salario = scanner.nextDouble();
                    scanner.nextLine();
                    
                    nomina.insertar(cedula, nombre, cargo, salario);
                    System.out.println("Empleado registrado exitosamente en el árbol BST.");
                    break;
                case 3:
                    System.out.println("\nBuscando en el extremo izquierdo...");
                    nomina.buscarMinimo();
                    break;
                case 4:
                    System.out.println("\nBuscando en el extremo derecho...");
                    nomina.buscarMaximo();
                    break;
                case 5:
                    System.out.println("\nAnalizando estructura del árbol...");
                    nomina.reporteEficiencia();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
