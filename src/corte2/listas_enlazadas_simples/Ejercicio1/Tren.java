package corte2.listas_enlazadas_simples.Ejercicio1;

public class Tren {
    Vagon cabeza;

    public Tren() {
        this.cabeza = null;
    }

    public void engancharVagon(String contenido, double pesoToneladas, String origen, String destino) {
        Vagon nuevoVagon = new Vagon(contenido, pesoToneladas, origen, destino);

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

    public void mostrarTabla() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("TABLA DE VAGONES DEL TREN");
        System.out.println("=".repeat(80));
        System.out.printf("%-25s | %-15s | %-15s | %-15s%n", "Contenido", "Peso (ton)", "Origen", "Destino");
        System.out.println("-".repeat(80));

        Vagon actual = cabeza;
        
        while (actual != null) {
            System.out.printf("%-25s | %-15.2f | %-15s | %-15s%n", 
                actual.contenido, actual.pesoToneladas, actual.origen, actual.destino);
            actual = actual.siguiente;
        }
        
        System.out.println("=".repeat(80));
        System.out.printf("PESO TOTAL DEL TREN: %.2f toneladas%n", calcularPesoTotal());
        System.out.println("=".repeat(80) + "\n");
    }
}
