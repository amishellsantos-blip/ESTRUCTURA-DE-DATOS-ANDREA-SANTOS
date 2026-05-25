package corte3.colas.Ejercicio2;

public class ColaPacientes {
    private Paciente salida; // Frente de la cola (dequeue)
    private Paciente entrada; // Final de la cola (enqueue)
    private int tamanio;

    public ColaPacientes() {
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

    public void enqueue(Paciente nuevo) {
        if (estaVacia()) {
            salida = nuevo;
            entrada = nuevo;
        } else {
            entrada.siguiente = nuevo;
            entrada = nuevo;
        }
        tamanio++;
    }

    public Paciente dequeue() {
        if (estaVacia()) {
            return null;
        }
        Paciente aux = salida;
        salida = salida.siguiente;
        tamanio--;
        
        if (salida == null) {
            entrada = null;
        }
        
        aux.siguiente = null;
        return aux;
    }

    public Paciente peek() {
        return salida;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("No hay pacientes en la fila de espera.");
            return;
        }
        Paciente actual = salida;
        System.out.print("SALIDA (Próximo en atender) -> ");
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
     * Reto: Extrae a cada paciente uno a uno, imprime su información e imprime el total procesados al final.
     */
    public void atenderTodos() {
        if (estaVacia()) {
            System.out.println("No hay pacientes para atender. El turno ha finalizado.");
            return;
        }
        
        System.out.println("\n--- INICIANDO ATENCIÓN DE TODOS LOS PACIENTES ---");
        int contador = 0;
        
        while (!estaVacia()) {
            Paciente pacienteAtendido = dequeue();
            contador++;
            System.out.println("Atendiendo paciente #" + contador + ": " + pacienteAtendido);
        }
        
        System.out.println("-------------------------------------------------");
        System.out.println("Turno finalizado. Total de pacientes procesados: " + contador);
    }
}
