package corte3.colas.Ejercicio4;

public class ColaPeaje {
    private Vehiculo salida; // Frente de la cola (dequeue)
    private Vehiculo entrada; // Final de la cola (enqueue)
    private int tamanio;

    public ColaPeaje() {
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

    public void enqueue(Vehiculo nuevo) {
        if (estaVacia()) {
            salida = nuevo;
            entrada = nuevo;
        } else {
            entrada.siguiente = nuevo;
            entrada = nuevo;
        }
        tamanio++;
    }

    public Vehiculo dequeue() {
        if (estaVacia()) {
            return null;
        }
        Vehiculo aux = salida;
        salida = salida.siguiente;
        tamanio--;
        
        if (salida == null) {
            entrada = null;
        }
        
        aux.siguiente = null;
        return aux;
    }

    public Vehiculo peek() {
        return salida;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("No hay vehículos en la fila del peaje.");
            return;
        }
        Vehiculo actual = salida;
        System.out.print("CABINA DE COBRO -> ");
        while (actual != null) {
            System.out.print(actual.toString());
            if (actual.siguiente != null) {
                System.out.print(" -> ");
            }
            actual = actual.siguiente;
        }
        System.out.println(" -> ENTRADA AL CARRIL");
    }

    /**
     * Reto: Extrae todos los vehículos, acumula tarifa de los no exentos e imprime total.
     */
    public void cerrarTurno() {
        if (estaVacia()) {
            System.out.println("El peaje está vacío. Total recaudado: $0.0");
            return;
        }
        
        System.out.println("\n--- CERRANDO TURNO Y PROCESANDO VEHÍCULOS RESTANTES ---");
        double totalRecaudado = 0.0;
        int procesados = 0;
        
        while (!estaVacia()) {
            Vehiculo vehiculoAtendido = dequeue();
            procesados++;
            
            if (!vehiculoAtendido.esExento) {
                totalRecaudado += vehiculoAtendido.tarifa;
                System.out.println("Cobrando a: " + vehiculoAtendido + " -> +$" + vehiculoAtendido.tarifa);
            } else {
                System.out.println("Paso libre a: " + vehiculoAtendido + " -> EXENTO");
            }
        }
        
        System.out.println("-------------------------------------------------------");
        System.out.println("Vehículos procesados en el cierre: " + procesados);
        System.out.println("TOTAL RECAUDADO EN EL TURNO: $" + totalRecaudado);
    }
}
