package corte2.listas_enlazadas_simples.Ejercicio4;

public class Monitoreo {
    Lectura cabeza;

    public Monitoreo() {
        this.cabeza = null;
    }

    public void agregarLectura(int idSensor, double temperatura, double presion, String hora) {
        Lectura nuevaLectura = new Lectura(idSensor, temperatura, presion, hora);
        nuevaLectura.siguiente = cabeza;
        cabeza = nuevaLectura;
    }

    public void obtenerTemperaturaAlta() {
        if (cabeza == null) {
            System.out.println("¡¡No hay lecturas registradas.!!");
            return;
        }

        Lectura max = cabeza;
        Lectura actual = cabeza.siguiente;

        while (actual != null) {
            if (actual.temperatura > max.temperatura) {
                max = actual;
            }
            actual = actual.siguiente;
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.println("LECTURA CON TEMPERATURA MÁS ALTA");
        System.out.println("=".repeat(50));
        System.out.printf("ID Sensor: %d%n", max.idSensor);
        System.out.printf("Temperatura: %.2f °C%n", max.temperatura);
        System.out.printf("Presión: %.2f PSI%n", max.presion);
        System.out.printf("Hora: %s%n", max.hora);
        System.out.println("=".repeat(50));
    }

    public void mostrarHistorial() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("HISTORIAL DE MONITOREO INDUSTRIAL (Más reciente primero)");
        System.out.println("=".repeat(70));
        System.out.printf("%-10s | %-15s | %-15s | %-10s%n", "Sensor", "Temperatura", "Presión", "Hora");
        System.out.println("-".repeat(70));

        Lectura actual = cabeza;
        if (actual == null) {
            System.out.println("No hay datos en el historial.");
        } else {
            while (actual != null) {
                System.out.printf("%-10d | %-15.2f | %-15.2f | %-10s%n",
                        actual.idSensor, actual.temperatura, actual.presion, actual.hora);
                actual = actual.siguiente;
            }
        }
        System.out.println("=".repeat(70) + "\n");
    }
}
