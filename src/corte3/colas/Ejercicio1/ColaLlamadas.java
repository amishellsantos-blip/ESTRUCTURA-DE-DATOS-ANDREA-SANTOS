package corte3.colas.Ejercicio1;

public class ColaLlamadas {
    private Llamada salida; // Frente de la cola (dequeue)
    private Llamada entrada; // Final de la cola (enqueue)
    private int tamanio;

    public ColaLlamadas() {
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

    public void enqueue(Llamada nueva) {
        if (estaVacia()) {
            salida = nueva;
            entrada = nueva;
        } else {
            entrada.siguiente = nueva;
            entrada = nueva;
        }
        tamanio++;
    }

    public Llamada dequeue() {
        if (estaVacia()) {
            return null;
        }
        Llamada aux = salida;
        salida = salida.siguiente;
        tamanio--;
        
        if (salida == null) {
            entrada = null; // Si se vacía, la entrada también debe ser null
        }
        
        aux.siguiente = null; // Limpiar referencia
        return aux;
    }

    public Llamada peek() {
        return salida;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("No hay llamadas en espera.");
            return;
        }
        Llamada actual = salida;
        System.out.print("SALIDA -> ");
        while (actual != null) {
            System.out.print(actual.toString());
            if (actual.siguiente != null) {
                System.out.print(" -> ");
            }
            actual = actual.siguiente;
        }
        System.out.println(" -> ENTRADA");
    }

    /**
     * Cuenta cuántas llamadas corresponden a un motivo específico recorriendo la cola sin modificarla.
     */
    public int contarPorMotivo(String motivo) {
        int contador = 0;
        Llamada actual = salida;
        while (actual != null) {
            if (actual.motivoConsulta.equalsIgnoreCase(motivo)) {
                contador++;
            }
            actual = actual.siguiente;
        }
        return contador;
    }
}
