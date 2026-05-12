package corte3.pilas.Ejercicio3;

public class PilaCamiones {
    private Camion tope;
    private int tamanio;

    public PilaCamiones() {
        this.tope = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void push(Camion nuevo) {
        nuevo.siguiente = tope;
        tope = nuevo;
        tamanio++;
    }

    public Camion pop() {
        if (estaVacia()) {
            return null;
        }
        Camion aux = tope;
        tope = tope.siguiente;
        tamanio--;
        aux.siguiente = null; // Limpiar referencia
        return aux;
    }

    public Camion peek() {
        return tope;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("El callejón está vacío. No hay camiones.");
            return;
        }
        Camion actual = tope;
        System.out.println("=== CALLEJÓN (De Salida a Fondo) ===");
        while (actual != null) {
            if (actual == tope) {
                System.out.print("  SALIDA -> ");
            } else {
                System.out.print("            ");
            }
            System.out.println(actual.toString());
            actual = actual.siguiente;
        }
        System.out.println("====================================");
    }

    /**
     * Calcula la suma total de cargaToneladas usando una pila auxiliar
     * para no destruir los datos permanentemente, cumpliendo las reglas puras de Pila (Stack).
     */
    public double calcularCargaTotal() {
        if (estaVacia()) {
            return 0.0;
        }

        double cargaTotal = 0.0;
        PilaCamiones pilaAuxiliar = new PilaCamiones();

        // 1. Desapilamos para sumar y guardamos en la pila auxiliar
        while (!estaVacia()) {
            Camion camionActual = pop();
            cargaTotal += camionActual.cargaToneladas;
            pilaAuxiliar.push(camionActual);
        }

        // 2. Reconstruimos la pila original pasando de la auxiliar a la principal
        while (!pilaAuxiliar.estaVacia()) {
            push(pilaAuxiliar.pop());
        }

        return cargaTotal;
    }
}
