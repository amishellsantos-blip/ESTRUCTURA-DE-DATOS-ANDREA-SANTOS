package corte3.colas.Ejercicio3;

public class ColaImpresion {
    private Documento salida; // Frente de la cola (dequeue)
    private Documento entrada; // Final de la cola (enqueue)
    private int tamanio;

    public ColaImpresion() {
        this.salida = null;
        this.entrada = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return salida == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void enqueue(Documento nuevo) {
        if (estaVacia()) {
            salida = nuevo;
            entrada = nuevo;
        } else {
            entrada.siguiente = nuevo;
            entrada = nuevo;
        }
        tamanio++;
    }

    public Documento dequeue() {
        if (estaVacia()) {
            return null;
        }
        Documento aux = salida;
        salida = salida.siguiente;
        tamanio--;
        
        if (salida == null) {
            entrada = null;
        }
        
        aux.siguiente = null;
        return aux;
    }

    public Documento peek() {
        return salida;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("La cola de impresión está vacía.");
            return;
        }
        Documento actual = salida;
        System.out.print("PRÓXIMO EN IMPRIMIR -> ");
        while (actual != null) {
            System.out.print(actual.toString());
            if (actual.siguiente != null) {
                System.out.print(" -> ");
            }
            actual = actual.siguiente;
        }
        System.out.println(" -> ÚLTIMO EN LLEGAR");
    }

    /**
     * Reto: Recorre la cola sin alterarla sumando las páginas de todos los documentos.
     */
    public int calcularPaginasTotales() {
        int totalPaginas = 0;
        Documento actual = salida;
        while (actual != null) {
            totalPaginas += actual.numeroPaginas;
            actual = actual.siguiente;
        }
        return totalPaginas;
    }
}
