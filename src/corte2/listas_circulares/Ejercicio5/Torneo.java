package corte2.listas_circulares.Ejercicio5;

import java.util.Random;

public class Torneo {
    Equipo cabeza;
    Equipo cola;
    int contadorEquipos;

    public Torneo() {
        this.cabeza = null;
        this.cola = null;
        this.contadorEquipos = 0;
    }

    public void agregarEquipo(String nombre, String ciudad) {
        Equipo nuevo = new Equipo(nombre, ciudad);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = cabeza;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
            cola.siguiente = cabeza;
        }
        contadorEquipos++;
    }

    // Método para obtener un nodo en una posición específica (0-indexado)
    private Equipo obtenerEquipo(int posicion) {
        if (cabeza == null) return null;
        Equipo actual = cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual;
    }

    public void generarFixture() {
        if (contadorEquipos < 2 || contadorEquipos % 2 != 0) {
            System.out.println("¡¡Se necesita un número par de equipos para el fixture.!!");
            return;
        }

        System.out.println("\n>>> GENERANDO FIXTURE CIRCULAR (Round Robin) <<<");
        Random random = new Random();
        int rondas = contadorEquipos - 1;

        for (int r = 0; r < rondas; r++) {
            System.out.println("\n" + "-".repeat(40));
            System.out.println("JORNADA #" + (r + 1));
            System.out.println("-".repeat(40));

            // Emparejamos equipos (0 con N-1, 1 con N-2, etc.)
            for (int i = 0; i < contadorEquipos / 2; i++) {
                Equipo local = obtenerEquipo(i);
                Equipo visitante = obtenerEquipo(contadorEquipos - 1 - i);

                int gL = random.nextInt(5);
                int gV = random.nextInt(5);

                System.out.printf("%-15s [%d] vs [%d] %-15s%n", 
                    local.nombre, gL, gV, visitante.nombre);

                local.golesFavor += gL;
                visitante.golesFavor += gV;

                if (gL > gV) { local.puntos += 3; }
                else if (gL < gV) { visitante.puntos += 3; }
                else { local.puntos += 1; visitante.puntos += 1; }
            }

            // ROTACIÓN CIRCULAR (Tip 1):
            // La cabeza se queda fija. El último elemento pasa a ser el segundo.
            // Esto rota todos los demás una posición.
            rotarEquipos();
        }
        System.out.println("\n>>> TORNEO FINALIZADO <<<");
    }

    private void rotarEquipos() {
        if (contadorEquipos <= 2) return;

        // 1. Encontrar el penúltimo para desconectar la cola
        Equipo penultimo = cabeza;
        while (penultimo.siguiente != cola) {
            penultimo = penultimo.siguiente;
        }

        // 2. El último (cola) se moverá a la segunda posición (después de cabeza)
        Equipo ultimo = cola;
        
        // Desconectamos el último del final
        penultimo.siguiente = cabeza;
        cola = penultimo;

        // Insertamos el que era último después de la cabeza
        ultimo.siguiente = cabeza.siguiente;
        cabeza.siguiente = ultimo;
    }

    public void mostrarTablaPosiciones() {
        if (cabeza == null) return;

        // Pasamos a un visor para ordenar sin destruir el círculo
        Equipo[] visor = new Equipo[contadorEquipos];
        Equipo actual = cabeza;
        int i = 0;
        do {
            visor[i++] = actual;
            actual = actual.siguiente;
        } while (actual != cabeza); // Cumple Tip 2 de parada

        // Ordenamiento por puntos (Burbuja)
        for (int k = 0; k < visor.length - 1; k++) {
            for (int j = 0; j < visor.length - k - 1; j++) {
                if (visor[j].puntos < visor[j+1].puntos) {
                    Equipo temp = visor[j];
                    visor[j] = visor[j+1];
                    visor[j+1] = temp;
                }
            }
        }

        System.out.println("\n" + "=".repeat(60));
        System.out.println("TABLA DE POSICIONES");
        System.out.println("=".repeat(60));
        System.out.printf("%-5s | %-20s | %-10s | %-10s%n", "Pos", "Equipo", "Puntos", "Goles");
        System.out.println("-".repeat(60));
        for (int k = 0; k < visor.length; k++) {
            System.out.printf("%-5d | %-20s | %-10d | %-10d%n", 
                (k+1), visor[k].nombre, visor[k].puntos, visor[k].golesFavor);
        }
    }
}
