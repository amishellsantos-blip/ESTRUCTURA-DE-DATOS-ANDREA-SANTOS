package corte3.arboles.Ejercicio1;

import java.util.Scanner;

/*
Datos de prueba sugeridos para ingresar manualmente:
- Temp: 28.5 | Fecha: 2023-11-01 | Estación: Norte | Humedad: 45.0
- Temp: 36.2 | Fecha: 2023-11-02 | Estación: Sur   | Humedad: 30.0
- Temp: 22.1 | Fecha: 2023-11-03 | Estación: Este  | Humedad: 55.0
- Temp: 38.0 | Fecha: 2023-11-04 | Estación: Oeste | Humedad: 20.0
*/
public class App {
    public static void main(String[] args) {
        ArbolRegistros arbol = new ArbolRegistros();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- ESTACIÓN METEOROLÓGICA (ÁRBOLES BST) ---");
            System.out.println("1. Ver todos los registros ordenados (InOrden)");
            System.out.println("2. Insertar nuevo registro");
            System.out.println("3. Contar registros sobre un umbral de temperatura");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\nRegistros ordenados por temperatura:");
                    arbol.imprimirInOrden();
                    break;
                case 2:
                    System.out.print("Temperatura (°C): "); 
                    double temperatura = scanner.nextDouble();
                    scanner.nextLine();
                    
                    System.out.print("Fecha (YYYY-MM-DD): "); 
                    String fecha = scanner.nextLine();
                    
                    System.out.print("Estación: "); 
                    String estacion = scanner.nextLine();
                    
                    System.out.print("Humedad (%): "); 
                    double humedad = scanner.nextDouble();
                    scanner.nextLine();
                    
                    arbol.insertar(temperatura, fecha, estacion, humedad);
                    System.out.println("Registro insertado en el BST correctamente.");
                    break;
                case 3:
                    System.out.print("Ingrese la temperatura umbral (°C): ");
                    double umbral = scanner.nextDouble();
                    scanner.nextLine();
                    
                    int total = arbol.contarSobre(umbral);
                    System.out.println("Resultado: Se detectaron " + total + " registros por encima de " + umbral + "°C.");
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
