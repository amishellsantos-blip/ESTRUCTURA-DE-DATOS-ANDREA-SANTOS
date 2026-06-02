package corte3.arboles.Ejercicio3;

public class ArbolNomina {
    Empleado raiz;

    public ArbolNomina() {
        this.raiz = null;
    }

    public void insertar(long cedula, String nombreCompleto, String cargo, double salario) {
        Empleado nuevo = new Empleado(cedula, nombreCompleto, cargo, salario);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            insertarRecursivo(raiz, nuevo);
        }
    }

    private void insertarRecursivo(Empleado actual, Empleado nuevo) {
        if (nuevo.cedula < actual.cedula) {
            if (actual.izq == null) {
                actual.izq = nuevo;
            } else {
                insertarRecursivo(actual.izq, nuevo);
            }
        } else if (nuevo.cedula > actual.cedula) {
            if (actual.der == null) {
                actual.der = nuevo;
            } else {
                insertarRecursivo(actual.der, nuevo);
            }
        }
    }

    public void imprimirNomina() {
        if (raiz == null) {
            System.out.println("La nómina está vacía.");
        } else {
            imprimirInOrden(raiz);
        }
    }

    private void imprimirInOrden(Empleado actual) {
        if (actual != null) {
            imprimirInOrden(actual.izq);
            System.out.println(actual);
            imprimirInOrden(actual.der);
        }
    }

    public void buscarMinimo() {
        if (raiz == null) {
            System.out.println("No hay empleados en la nómina.");
            return;
        }
        Empleado actual = raiz;
        // Navegar siempre hacia la izquierda para encontrar el menor
        while (actual.izq != null) {
            actual = actual.izq;
        }
        System.out.println("Empleado con menor cédula (Mínimo): " + actual);
    }

    public void buscarMaximo() {
        if (raiz == null) {
            System.out.println("No hay empleados en la nómina.");
            return;
        }
        Empleado actual = raiz;
        // Navegar siempre hacia la derecha para encontrar el mayor
        while (actual.der != null) {
            actual = actual.der;
        }
        System.out.println("Empleado con mayor cédula (Máximo): " + actual);
    }

    public void reporteEficiencia() {
        if (raiz == null) {
            System.out.println("El árbol está vacío. Altura: 0, Hojas: 0.");
            return;
        }
        int altura = calcularAltura(raiz);
        int hojas = contarHojas(raiz);
        System.out.println("=== REPORTE DE EFICIENCIA DEL ÁRBOL ===");
        System.out.println("Altura del árbol: " + altura);
        System.out.println("Número total de hojas: " + hojas);
    }

    private int calcularAltura(Empleado actual) {
        if (actual == null) {
            return 0; 
        }
        int alturaIzq = calcularAltura(actual.izq);
        int alturaDer = calcularAltura(actual.der);
        return 1 + Math.max(alturaIzq, alturaDer);
    }

    private int contarHojas(Empleado actual) {
        if (actual == null) {
            return 0;
        }
        // Es una hoja si no tiene hijos
        if (actual.izq == null && actual.der == null) {
            return 1;
        }
        return contarHojas(actual.izq) + contarHojas(actual.der);
    }
}
