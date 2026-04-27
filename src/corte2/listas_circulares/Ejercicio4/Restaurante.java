package corte2.listas_circulares.Ejercicio4;

public class Restaurante {
    Grupo cabeza;
    Grupo cola;

    public Restaurante() {
        this.cabeza = null;
        this.cola = null;
    }

    public void agregarGrupo(String nombre, int personas, boolean vip, int minutos) {
        Grupo nuevo = new Grupo(nombre, personas, vip, minutos);
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

    public void atenderSiguiente() {
        if (cabeza == null) {
            System.out.println("¡¡No hay grupos en la lista de espera.!!");
            return;
        }

        Grupo atendido = cabeza;
        System.out.println("\n" + "=".repeat(40));
        System.out.println("ATENDIENDO AHORA");
        System.out.println("=".repeat(40));
        System.out.println("Grupo: " + atendido.nombreReserva);
        System.out.println("Personas: " + atendido.numeroPersonas);
        System.out.println("VIP: " + (atendido.esVip ? "SÍ" : "NO"));
        System.out.println("Tiempo de espera: " + atendido.minutosEsperando + " min");
        System.out.println("=".repeat(40));

        if (atendido.esVip) {
            System.out.println("¡¡CLIENTE VIP!! Reinsertando al final de la rotación para nueva atención.");
            // En una lista circular, para mover la cabeza al final solo movemos los punteros
            cola = cabeza;
            cabeza = cabeza.siguiente;
        } else {
            System.out.println("Cliente atendido y retirado de la lista.");
            // Eliminamos la cabeza
            if (cabeza == cola) {
                cabeza = null;
                cola = null;
            } else {
                cabeza = cabeza.siguiente;
                cola.siguiente = cabeza;
            }
        }
        mostrarLista();
    }

    public void mostrarLista() {
        System.out.println("\n" + "=".repeat(65));
        System.out.println("LISTA DE ESPERA ACTUAL");
        System.out.println("=".repeat(65));
        System.out.printf("%-20s | %-10s | %-10s | %-10s%n", "Reserva", "Personas", "Es VIP", "Eespera");
        System.out.println("-".repeat(65));

        if (cabeza == null) {
            System.out.println("Lista de espera vacía.");
        } else {
            Grupo temp = cabeza;
            do {
                System.out.printf("%-20s | %-10d | %-10s | %-10d%n", 
                    temp.nombreReserva, temp.numeroPersonas, (temp.esVip ? "SÍ" : "NO"), temp.minutosEsperando);
                temp = temp.siguiente;
            } while (temp != cabeza);
        }
        System.out.println("=".repeat(65) + "\n");
    }
}
