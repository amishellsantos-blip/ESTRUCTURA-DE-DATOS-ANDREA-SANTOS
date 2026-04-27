package corte2.listas_circulares.Ejercicio1;

import java.util.Random;

public class Ruleta {
    Participante cabeza;
    Participante cola;

    public Ruleta() {
        this.cabeza = null;
        this.cola = null;
    }

    public void registrarParticipante(String nombre, int numero, String ciudad) {
        Participante nuevo = new Participante(nombre, numero, ciudad);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = cabeza; // Apunta a sí mismo
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
            cola.siguiente = cabeza; // Mantiene el ciclo
        }
    }

    public void realizarSorteo(int pasos) {
        if (cabeza == null) {
            System.out.println("¡¡No hay participantes registrados para el sorteo.!!");
            return;
        }

        System.out.println("\n>>> GIRANDO LA RULETA (" + pasos + " pasos) <<<");
        
        Participante anterior = cola;
        Participante actual = cabeza;

        // Avanzamos 'pasos' veces
        for (int i = 0; i < pasos; i++) {
            anterior = actual;
            actual = actual.siguiente;
        }

        // Ganador encontrado
        System.out.println("=".repeat(50));
        System.out.println("¡¡¡GANADOR ENCONTRADO!!!");
        System.out.println("=".repeat(50));
        System.out.println("Nombre: " + actual.nombre);
        System.out.println("Boleta: #" + actual.numeroBoleta);
        System.out.println("Ciudad: " + actual.ciudad);
        System.out.println("=".repeat(50));

        // ELIMINAR AL GANADOR
        if (cabeza == cola && cabeza == actual) {
            // Caso: Solo había un participante
            cabeza = null;
            cola = null;
        } else {
            // Caso general: Reconectamos el anterior con el siguiente del ganador
            anterior.siguiente = actual.siguiente;
            
            if (actual == cabeza) {
                cabeza = actual.siguiente;
            }
            if (actual == cola) {
                cola = anterior;
            }
        }
        System.out.println("¡¡El ganador ha sido retirado de la ruleta para la siguiente ronda.!!");
    }

    public void mostrarParticipantes() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("PARTICIPANTES EN LA RULETA (LISTA CIRCULAR)");
        System.out.println("=".repeat(60));
        System.out.printf("%-20s | %-10s | %-20s%n", "Nombre", "Boleta", "Ciudad");
        System.out.println("-".repeat(60));

        if (cabeza == null) {
            System.out.println("La ruleta está vacía.");
        } else {
            Participante temp = cabeza;
            do {
                System.out.printf("%-20s | %-10d | %-20s%n", 
                    temp.nombre, temp.numeroBoleta, temp.ciudad);
                temp = temp.siguiente;
            } while (temp != cabeza);
        }
        System.out.println("=".repeat(60) + "\n");
    }
}
