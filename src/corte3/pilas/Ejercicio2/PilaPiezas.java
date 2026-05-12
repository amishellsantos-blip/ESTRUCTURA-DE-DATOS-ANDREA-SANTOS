package corte3.pilas.Ejercicio2;

public class PilaPiezas {
    private Pieza tope;
    private int tamanio;

    public PilaPiezas() {
        this.tope = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void push(Pieza nueva) {
        nueva.siguiente = tope;
        tope = nueva;
        tamanio++;
    }

    public Pieza pop() {
        if (estaVacia()) {
            return null;
        }
        Pieza aux = tope;
        tope = tope.siguiente;
        tamanio--;
        aux.siguiente = null; // Limpiar referencia
        return aux;
    }

    public Pieza peek() {
        return tope;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("Pila vacía. No hay piezas en la línea.");
            return;
        }
        Pieza actual = tope;
        System.out.println("=== LÍNEA DE ENSAMBLAJE (De Tope a Base) ===");
        while (actual != null) {
            if (actual == tope) {
                System.out.print("  TOPE -> ");
            } else {
                System.out.print("          ");
            }
            System.out.println(actual.toString());
            actual = actual.siguiente;
        }
        System.out.println("============================================");
    }

    /**
     * Extrae (pop) todas las piezas de la pila hasta encontrar la primera que tenga esDefectuosa = true.
     * Imprime el nombre de todas las piezas "buenas" que tuvieron que ser retiradas y descartadas.
     */
    public void limpiarHastaDefecto() {
        if (estaVacia()) {
            System.out.println("La línea está vacía. No hay nada que limpiar.");
            return;
        }

        System.out.println("Iniciando limpieza por pieza defectuosa...");
        boolean encontradaDefectuosa = false;

        while (!estaVacia()) {
            Pieza piezaActual = pop();
            if (piezaActual.esDefectuosa) {
                System.out.println("¡Alerta! Se extrajo la pieza DEFECTUOSA: " + piezaActual.nombrePieza + " (" + piezaActual.numeroSerie + "). Deteniendo limpieza.");
                encontradaDefectuosa = true;
                break;
            } else {
                System.out.println("Descartando pieza buena por bloqueo: " + piezaActual.nombrePieza + " (" + piezaActual.numeroSerie + ")");
            }
        }

        if (!encontradaDefectuosa) {
            System.out.println("Se vació la pila completamente y no se encontraron piezas defectuosas.");
        }
    }
}
