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
        System.out.println("Ingrese los productos que desea agregar al inventario.\n");
        
        int opcion = 1;
        while (opcion == 1) {
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Ingrese la cantidad disponible: ");
            int cantidad = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Ingrese los días para vencer: ");
            int diasParaVencer = Integer.parseInt(scanner.nextLine());
            
            inventario.insertarProducto(nombre, cantidad, diasParaVencer);
            System.out.println("✓ Producto agregado exitosamente.\n");
            
            System.out.print("¿Desea agregar otro producto? (sí/no): ");
            String respuesta = scanner.nextLine().toLowerCase().trim();
            
            if (respuesta.equals("si") || respuesta.equals("sí")) {
                opcion = 1;
            } else {
                opcion = 0;
            }
        }
        
        scanner.close();
        inventario.mostrarTodosProductos();
        inventario.mostrarProductosProximos();
    }
    
}
