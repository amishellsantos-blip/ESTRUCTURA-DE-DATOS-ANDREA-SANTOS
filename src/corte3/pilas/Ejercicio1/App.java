package corte3.pilas.Ejercicio1;

import java.util.Scanner;

/*
Datos de prueba sugeridos para ingresar manualmente:
- ID: CONT-001 | Empresa: Maersk      | Peso: 25.5 | Tipo: Electrónicos
- ID: CONT-002 | Empresa: Evergreen   | Peso: 30.0 | Tipo: Textiles
- ID: CONT-003 | Empresa: MSC         | Peso: 18.2 | Tipo: Alimentos
- ID: CONT-004 | Empresa: Hapag-Lloyd | Peso: 22.1 | Tipo: Maquinaria
*/
public class App {
    public static void main(String[] args) {
        PilaContenedores muelle = new PilaContenedores();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE GESTIÓN DE PUERTO (PILAS) ---");
            System.out.println("1. Ver contenedores en el muelle");
            System.out.println("2. Registrar nuevo contenedor (Push)");
            System.out.println("3. Retirar contenedor del tope (Pop)");
            System.out.println("4. Contar contenedores por empresa");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\nEstado actual de la pila:");
                    muelle.imprimir();
                    break;
                case 2:
                    System.out.print("ID: "); String id = scanner.nextLine();
                    System.out.print("Empresa: "); String emp = scanner.nextLine();
                    System.out.print("Peso (t): "); double peso = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Tipo de Carga: "); String tipo = scanner.nextLine();
                    muelle.push(new Contenedor(id, emp, peso, tipo));
                    System.out.println("Contenedor apilado correctamente.");
                    break;
                case 3:
                    Contenedor retirado = muelle.pop();
                    if (retirado != null) {
                        System.out.println("Se ha retirado: " + retirado);
                    } else {
                        System.out.println("El muelle está vacío.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre de la empresa a consultar: ");
                    String empresaBusqueda = scanner.nextLine();
                    int total = muelle.contarPorEmpresa(empresaBusqueda);
                    System.out.println("Resultado: Se encontraron " + total + " contenedores de la empresa " + empresaBusqueda);
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
