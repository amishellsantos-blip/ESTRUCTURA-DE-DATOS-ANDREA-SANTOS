package corte3.pilas.Ejercicio4;

public class TuboDispensador {
    private Medicamento tope;
    private int tamanio;

    public TuboDispensador() {
        this.tope = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void push(Medicamento nuevo) {
        nuevo.siguiente = tope;
        tope = nuevo;
        tamanio++;
    }

    public Medicamento pop() {
        if (estaVacia()) {
            return null;
        }
        Medicamento aux = tope;
        tope = tope.siguiente;
        tamanio--;
        aux.siguiente = null; // Limpiar referencia
        return aux;
    }

    public Medicamento peek() {
        return tope;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("El tubo dispensador está vacío.");
            return;
        }
        Medicamento actual = tope;
        System.out.println("=== TUBO DISPENSADOR (De Tope a Base) ===");
        while (actual != null) {
            if (actual == tope) {
                System.out.print("  TOPE -> ");
            } else {
                System.out.print("          ");
            }
            System.out.println(actual.toString());
            actual = actual.siguiente;
        }
        System.out.println("=========================================");
    }

    /**
     * Revisa el medicamento en el tope. Si tiene menos de 10 días para vencer, lo retira (descarta).
     * Repite hasta encontrar uno válido o vaciar la pila. Luego retorna (despacha) el válido.
     */
    public Medicamento validarDespacho() {
        if (estaVacia()) {
            System.out.println("Error: No hay medicamentos para despachar.");
            return null;
        }

        // Limpiar el tope de medicamentos a punto de vencer
        while (!estaVacia() && peek().diasParaVencer < 10) {
            Medicamento descartado = pop();
            System.out.println("ALERTA: Descartando medicamento por vencer pronto: " + descartado.nombre + " (Lote: " + descartado.lote + ") - Vence en " + descartado.diasParaVencer + " días.");
        }

        // Después de limpiar, verificamos si quedó algo para despachar
        if (estaVacia()) {
            System.out.println("Se descartaron medicamentos y ahora el tubo está vacío.");
            return null;
        }

        // Si llegó aquí, el tope tiene >= 10 días para vencer
        Medicamento despachado = pop();
        System.out.println("DESPACHO EXITOSO: " + despachado.nombre + " (Lote: " + despachado.lote + ") - Seguro para consumo.");
        return despachado;
    }
}
