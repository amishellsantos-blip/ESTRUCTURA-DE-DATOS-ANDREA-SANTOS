package corte2.listas_enlazadas_simples.Ejercicio3;

public class TorreControl {
    Vuelo cabeza;

    public TorreControl() {
        this.cabeza = null;
    }

    public void insertarVuelo(String numeroVuelo, String aerolinea, int combustible, int pasajeros) {
        Vuelo nuevoVuelo = new Vuelo(numeroVuelo, aerolinea, combustible, pasajeros);

        if (cabeza == null) {
            cabeza = nuevoVuelo;
        } else {
            Vuelo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoVuelo;
        }
    }

    public boolean buscarVuelo(String numeroVuelo) {
        Vuelo actual = cabeza;
        while (actual != null) {
            if (actual.numeroVuelo.equalsIgnoreCase(numeroVuelo)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public void reportarEmergencia(String numeroVuelo) {
        if (cabeza == null) {
            System.out.println("¡¡La cola está vacía.!!");
            return;
        }

        // 1. Buscar el vuelo
        Vuelo actual = cabeza;
        Vuelo anterior = null;
        while (actual != null && !actual.numeroVuelo.equalsIgnoreCase(numeroVuelo)) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual == null) {
            System.out.println("Vuelo " + numeroVuelo + " no encontrado en la cola.");
            return;
        }

        // 2. Verificar combustible
        if (actual.combustibleRestante >= 10) {
            System.out.println("El vuelo " + numeroVuelo + " reportó emergencia, pero tiene combustible suficiente (" + actual.combustibleRestante + "). No se movió de posición.");
            return;
        }

        // 3. Extraer el vuelo de su posición actual
        if (anterior == null) {
            cabeza = actual.siguiente;
        } else {
            anterior.siguiente = actual.siguiente;
        }
        actual.siguiente = null;

        // 4. Insertar ordenadamente por combustible (Menor a Mayor) al inicio
        if (cabeza == null || cabeza.combustibleRestante > actual.combustibleRestante) {
            actual.siguiente = cabeza;
            cabeza = actual;
        } else {
            Vuelo temp = cabeza;
            // Buscamos el lugar correcto dentro de los que tienen combustible < 10
            while (temp.siguiente != null && 
                   temp.siguiente.combustibleRestante < 10 && 
                   temp.siguiente.combustibleRestante < actual.combustibleRestante) {
                temp = temp.siguiente;
            }
            actual.siguiente = temp.siguiente;
            temp.siguiente = actual;
        }
        System.out.println("\n¡¡EMERGENCIA CONFIRMADA!! Vuelo " + numeroVuelo + " posicionado por prioridad de combustible.");
    }

    public void mostrarCola() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("COLA DE ATERRIZAJE - TORRE DE CONTROL");
        System.out.println("=".repeat(80));
        System.out.printf("%-15s | %-20s | %-15s | %-10s%n", "Vuelo", "Aerolínea", "Combustible", "Pasajeros");
        System.out.println("-".repeat(80));

        Vuelo actual = cabeza;
        if (actual == null) {
            System.out.println("No hay vuelos en la cola.");
        } else {
            while (actual != null) {
                System.out.printf("%-15s | %-20s | %-15d | %-10d%n", 
                    actual.numeroVuelo, actual.aerolinea, actual.combustibleRestante, actual.pasajeros);
                actual = actual.siguiente;
            }
        }
        System.out.println("=".repeat(80) + "\n");
    }
}
