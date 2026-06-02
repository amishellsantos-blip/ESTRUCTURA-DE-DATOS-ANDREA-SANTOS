package corte3.arboles.Ejercicio1;

public class ArbolRegistros {
    Registro raiz;

    public ArbolRegistros() {
        this.raiz = null;
    }

    public void insertar(double temperatura, String fecha, String estacion, double humedad) {
        Registro nuevo = new Registro(temperatura, fecha, estacion, humedad);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            insertarRecursivo(raiz, nuevo);
        }
    }

    private void insertarRecursivo(Registro actual, Registro nuevo) {
        if (nuevo.temperatura < actual.temperatura) {
            if (actual.izq == null) {
                actual.izq = nuevo;
            } else {
                insertarRecursivo(actual.izq, nuevo);
            }
        } else {
            if (actual.der == null) {
                actual.der = nuevo;
            } else {
                insertarRecursivo(actual.der, nuevo);
            }
        }
    }

    public int contarSobre(double umbral) {
        return contarSobreRecursivo(raiz, umbral);
    }

    private int contarSobreRecursivo(Registro actual, double umbral) {
        if (actual == null) {
            return 0;
        }

        if (actual.temperatura > umbral) {
            return 1 + contarSobreRecursivo(actual.izq, umbral) + contarSobreRecursivo(actual.der, umbral);
        } else {
            return contarSobreRecursivo(actual.der, umbral);
        }
    }

    public void imprimirInOrden() {
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
        } else {
            imprimirInOrdenRecursivo(raiz);
        }
    }

    private void imprimirInOrdenRecursivo(Registro actual) {
        if (actual != null) {
            imprimirInOrdenRecursivo(actual.izq);
            System.out.println(actual);
            imprimirInOrdenRecursivo(actual.der);
        }
    }
}
