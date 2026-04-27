package corte2.listas_circulares.Ejercicio3;

public class Planificador {
    Proceso cabeza;
    Proceso cola;

    public Planificador() {
        this.cabeza = null;
        this.cola = null;
    }

    public void agregarProceso(String nombre, int pid, int tiempo, int prioridad) {
        Proceso nuevo = new Proceso(nombre, pid, tiempo, prioridad);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = cabeza;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
            cola.siguiente = cabeza;
        }
    }

    public void ejecutar(int quantum) {
        if (cabeza == null) {
            System.out.println("¡¡No hay procesos en la cola de ejecución.!!");
            return;
        }

        System.out.println("\n>>> INICIANDO PLANIFICACIÓN ROUND ROBIN (Quantum: " + quantum + "ms) <<<");
        StringBuilder ordenTerminados = new StringBuilder();
        int turno = 1;

        Proceso actual = cabeza;
        Proceso anterior = cola;

        while (cabeza != null) {
            System.out.println("\n[Turno " + (turno++) + "] Ejecutando: " + actual.nombre + " (PID: " + actual.pid + ")");
            
            // Simular ejecución descontando el quantum
            actual.tiempoRestante -= quantum;

            if (actual.tiempoRestante <= 0) {
                System.out.println("¡¡PROCESO FINALIZADO: " + actual.nombre + "!!");
                ordenTerminados.append("- ").append(actual.nombre).append(" (PID: ").append(actual.pid).append(")\n");

                // ELIMINAR PROCESO DE LA LISTA CIRCULAR
                if (cabeza == cola) {
                    // Era el único proceso
                    cabeza = null;
                    cola = null;
                    break; // Salimos del bucle principal
                } else {
                    // Reconectamos anterior con el siguiente del que termina
                    anterior.siguiente = actual.siguiente;
                    
                    if (actual == cabeza) {
                        cabeza = actual.siguiente;
                    }
                    if (actual == cola) {
                        cola = anterior;
                    }
                    // El siguiente a ejecutar es el que sigue al que terminó
                    actual = actual.siguiente;
                }
            } else {
                System.out.println("Tiempo restante: " + actual.tiempoRestante + "ms. Volviendo a la cola...");
                // Avanzamos normalmente
                anterior = actual;
                actual = actual.siguiente;
            }

            try { Thread.sleep(300); } catch (InterruptedException e) {} // Pausa estética
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.println("ORDEN DE FINALIZACIÓN DE PROCESOS");
        System.out.println("=".repeat(50));
        System.out.println(ordenTerminados.toString());
        System.out.println("=".repeat(50));
    }

    public void mostrarCola() {
        System.out.println("\n" + "=".repeat(65));
        System.out.println("COLA DE PROCESOS (SISTEMA OPERATIVO)");
        System.out.println("=".repeat(65));
        System.out.printf("%-15s | %-10s | %-15s | %-10s%n", "Nombre", "PID", "T. Restante", "Prioridad");
        System.out.println("-".repeat(65));

        if (cabeza == null) {
            System.out.println("No hay procesos pendientes.");
        } else {
            Proceso temp = cabeza;
            do {
                System.out.printf("%-15s | %-10d | %-15d | %-10d%n", 
                    temp.nombre, temp.pid, temp.tiempoRestante, temp.prioridad);
                temp = temp.siguiente;
            } while (temp != cabeza);
        }
        System.out.println("=".repeat(65) + "\n");
    }
}
