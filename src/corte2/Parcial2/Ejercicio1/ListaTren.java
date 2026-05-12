package corte2.Parcial2.Ejercicio1;

public class ListaTren {
    Vagon cabeza;

    public ListaTren() {
        this.cabeza = null;
    }

    public void engancharVagon(int id, String contenido, double pesoToneladas) {
        Vagon nuevoVagon = new Vagon(id, contenido, pesoToneladas);

        if (cabeza == null) {
            cabeza = nuevoVagon;
        } else {
            Vagon actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoVagon;
        }
    }

    public double calcularPesoTotal() {
        double pesoTotal = 0.0;
        Vagon actual = cabeza;

        while (actual != null) {
            pesoTotal += actual.pesoToneladas;
            actual = actual.siguiente;
        }
        return pesoTotal;
    }

    public void estadoTren() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("TABLA DE VAGONES DEL TREN");
        System.out.println("=".repeat(80));
        System.out.printf("%-25s | %-15s | %-15s | %-15s%n", "ID", "Contenido", "Peso (ton)");
        System.out.println("-".repeat(80));

        Vagon actual = cabeza;

        while (actual != null) {
            System.out.printf("%-25s | %-15.2f | %-15s | %-15s%n",
                    actual.id, actual.contenido, actual.pesoToneladas);
            actual = actual.siguiente;
        }

        System.out.println("=".repeat(80));
        System.out.printf("PESO TOTAL DEL TREN: %.2f toneladas%n", calcularPesoTotal());
        System.out.println("=".repeat(80) + "\n");
    }
}
