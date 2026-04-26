package corte2.listas_enlazadas_simples.Ejercicio2;

public class Inventario {
    Producto cabeza;

    public Inventario() {
        this.cabeza = null;
    }

    public void insertarProducto(String nombre, int cantidad, int diasParaVencer) {
        Producto nuevoProducto = new Producto(nombre, cantidad, diasParaVencer);

        // Si vence en menos de 3 días, insertar al inicio
        if (diasParaVencer < 3) {
            nuevoProducto.siguiente = cabeza;
            cabeza = nuevoProducto;
        } else {
            // Si vence en 3 días o más, insertar al final
            if (cabeza == null) {
                cabeza = nuevoProducto;
            } else {
                Producto actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevoProducto;
            }
        }
    }

    public void mostrarTodosProductos() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("TABLA DE TODOS LOS PRODUCTOS DEL INVENTARIO");
        System.out.println("=".repeat(80));
        System.out.printf("%-30s | %-15s | %-20s%n", "Producto", "Cantidad", "Días para Vencer");
        System.out.println("-".repeat(80));

        Producto actual = cabeza;
        
        while (actual != null) {
            System.out.printf("%-30s | %-15d | %-20d%n", 
                actual.nombre, actual.cantidad, actual.diasParaVencer);
            actual = actual.siguiente;
        }
        
        System.out.println("=".repeat(80) + "\n");
    }

    public void mostrarProductosProximos() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("PRODUCTOS QUE VENCEN EN MENOS DE 5 DÍAS (PRIORIDAD)");
        System.out.println("=".repeat(80));
        System.out.printf("%-30s | %-15s | %-20s%n", "Producto", "Cantidad", "Días para Vencer");
        System.out.println("-".repeat(80));

        Producto actual = cabeza;
        boolean encontrado = false;
        
        while (actual != null) {
            if (actual.diasParaVencer < 5) {
                System.out.printf("%-30s | %-15d | %-20d%n", 
                    actual.nombre, actual.cantidad, actual.diasParaVencer);
                encontrado = true;
            }
            actual = actual.siguiente;
        }
        
        if (!encontrado) {
            System.out.println("No hay productos con menos de 5 días para vencer.");
        }
        
        System.out.println("=".repeat(80) + "\n");
    }
}
