package corte3.pilas.Ejercicio5;

public class PilaEstaciones {
    private Estacion tope;
    private int tamanio;

    public PilaEstaciones() {
        this.tope = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void push(Estacion nueva) {
        nueva.siguiente = tope;
        tope = nueva;
        tamanio++;
    }

    public Estacion pop() {
        if (estaVacia()) {
            return null;
        }
        Estacion aux = tope;
        tope = tope.siguiente;
        tamanio--;
        aux.siguiente = null; // Limpiar referencia
        return aux;
    }

    public Estacion peek() {
        return tope;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("No hay estaciones registradas. (Equipo en la superficie).");
            return;
        }
        Estacion actual = tope;
        System.out.println("=== RUTA DE CUEVA (De Más Profundo a Entrada) ===");
        while (actual != null) {
            if (actual == tope) {
                System.out.print("  ACTUAL (MÁS PROFUNDO) -> ");
            } else {
                System.out.print("                           ");
            }
            System.out.println(actual.toString());
            actual = actual.siguiente;
        }
        System.out.println("=================================================");
    }

    /**
     * Extrae y muestra el nombre de cada estación a medida que se desapila.
     * Si el nivel de oxígeno es inferior a 18%, imprime alerta.
     */
    public void retrocederASuperficie() {
        if (estaVacia()) {
            System.out.println("Ya te encuentras en la superficie.");
            return;
        }

        System.out.println("Iniciando retroceso a la superficie...");
        
        while (!estaVacia()) {
            Estacion estacionActual = pop();
            System.out.println("\nPasando por estación: " + estacionActual.nombrePunto + " a " + estacionActual.profundidad + "m");
            
            if (estacionActual.nivelOxigeno < 18.0) {
                System.out.println("   [!] ALERTA CRÍTICA: Nivel de O2 en " + estacionActual.nivelOxigeno + "%. USO DE TANQUE DE EMERGENCIA REQUERIDO.");
            } else {
                System.out.println("   [OK] Nivel de O2 estable (" + estacionActual.nivelOxigeno + "%).");
            }
        }
        
        System.out.println("\n¡El equipo ha llegado a la superficie a salvo!");
    }
}
