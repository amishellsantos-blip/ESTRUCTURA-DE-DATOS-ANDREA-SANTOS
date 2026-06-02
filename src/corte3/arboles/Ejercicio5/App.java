package corte3.arboles.Ejercicio5;

import java.util.Scanner;

/*
Datos de prueba sugeridos para ingresar manualmente (Insertarlos en este orden para armar el árbol):
1. Código: 50 | Desc: Filtro de Aceite | Marca: Bosch    | Stock: 15
2. Código: 30 | Desc: Bujías (Set)     | Marca: NGK      | Stock: 40
3. Código: 70 | Desc: Pastillas Freno  | Marca: Brembo   | Stock: 25
4. Código: 20 | Desc: Correa Alt.      | Marca: Gates    | Stock: 10
5. Código: 40 | Desc: Batería 12V      | Marca: Mac      | Stock: 5
*/
public class App {
    public static void main(String[] args) {
        ArbolAlmacen almacen = new ArbolAlmacen();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- CONTROL DE INVENTARIO (ALMACÉN DE REPUESTOS) ---");
            System.out.println("1. Ver inventario completo (InOrden)");
            System.out.println("2. Registrar nuevo repuesto");
            System.out.println("3. Generar Backup del árbol (PreOrden)");
            System.out.println("4. Reportar Repuestos Únicos (Nodos Hoja)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\nInventario de Repuestos (Ordenado por Código):");
                    almacen.imprimirInventario();
                    break;
                case 2:
                    System.out.print("Código de Referencia (Número entero): "); 
                    int codigo = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Descripción del repuesto: "); 
                    String descripcion = scanner.nextLine();
                    
                    System.out.print("Marca: "); 
                    String marca = scanner.nextLine();
                    
                    System.out.print("Cantidad en Stock: "); 
                    int stock = scanner.nextInt();
                    scanner.nextLine();
                    
                    almacen.insertar(codigo, descripcion, marca, stock);
                    System.out.println("Repuesto registrado exitosamente en el árbol BST.");
                    break;
                case 3:
                    System.out.println("\nGenerando copia de seguridad del árbol (Formato PreOrden)...");
                    almacen.backupPreOrden();
                    System.out.println("Tip: Insertar los nodos en este mismo orden en un árbol nuevo restaurará la estructura exacta original.");
                    break;
                case 4:
                    System.out.println("\nBuscando repuestos sin variantes...");
                    almacen.reporteRepuestosUnicos();
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
