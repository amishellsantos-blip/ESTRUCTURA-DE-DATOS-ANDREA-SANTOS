package corte3.arboles.Ejercicio5;

public class ArbolAlmacen {
    Repuesto raiz;

    public ArbolAlmacen() {
        this.raiz = null;
    }

    public void insertar(int codigoRef, String descripcion, String marca, int stock) {
        Repuesto nuevo = new Repuesto(codigoRef, descripcion, marca, stock);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            insertarRecursivo(raiz, nuevo);
        }
    }

    private void insertarRecursivo(Repuesto actual, Repuesto nuevo) {
        if (nuevo.codigoRef < actual.codigoRef) {
            if (actual.izq == null) {
                actual.izq = nuevo;
            } else {
                insertarRecursivo(actual.izq, nuevo);
            }
        } else if (nuevo.codigoRef > actual.codigoRef) {
            if (actual.der == null) {
                actual.der = nuevo;
            } else {
                insertarRecursivo(actual.der, nuevo);
            }
        }
    }

    // InOrden (Izquierda, Raíz, Derecha)
    public void imprimirInventario() {
        if (raiz == null) {
            System.out.println("El inventario está vacío.");
        } else {
            imprimirInOrden(raiz);
        }
    }

    private void imprimirInOrden(Repuesto actual) {
        if (actual != null) {
            imprimirInOrden(actual.izq);
            System.out.println(actual);
            imprimirInOrden(actual.der);
        }
    }

    // Reto: Backup en PreOrden (Raíz, Izquierda, Derecha)
    public void backupPreOrden() {
        if (raiz == null) {
            System.out.println("El inventario está vacío.");
            return;
        }
        System.out.println("--- INICIANDO BACKUP PRE-ORDEN ---");
        imprimirPreOrden(raiz);
        System.out.println("--- FIN DEL BACKUP ---");
    }

    private void imprimirPreOrden(Repuesto actual) {
        if (actual != null) {
            System.out.println(actual);          // 1. Visitar Raíz
            imprimirPreOrden(actual.izq);        // 2. Visitar Izquierda
            imprimirPreOrden(actual.der);        // 3. Visitar Derecha
        }
    }

    // Reto: Reporte de Repuestos Únicos (Contar Hojas)
    public void reporteRepuestosUnicos() {
        if (raiz == null) {
            System.out.println("El inventario está vacío. No hay repuestos únicos.");
            return;
        }
        int totalHojas = contarHojas(raiz);
        System.out.println("Resultado: Existen " + totalHojas + " repuestos únicos (hojas del árbol) sin variantes relacionadas en el catálogo.");
    }

    private int contarHojas(Repuesto actual) {
        if (actual == null) {
            return 0;
        }
        if (actual.izq == null && actual.der == null) {
            return 1; // Es una hoja
        }
        return contarHojas(actual.izq) + contarHojas(actual.der);
    }
}
