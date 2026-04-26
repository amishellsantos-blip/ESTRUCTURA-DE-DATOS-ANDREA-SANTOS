package corte2.listas_enlazadas_dobles.Ejercicio2;

public class Galeria {
    Fotografia cabeza;
    Fotografia cola;
    Fotografia actual;

    public Galeria() {
        this.cabeza = null;
        this.cola = null;
        this.actual = null;
    }

    public void agregarFoto(String nombre, double tamano, String resolucion) {
        Fotografia nueva = new Fotografia(nombre, tamano, resolucion);
        if (cabeza == null) {
            cabeza = nueva;
            cola = nueva;
            actual = nueva;
        } else {
            cola.siguiente = nueva;
            nueva.anterior = cola;
            cola = nueva;
        }
    }

    public void avanzar() {
        if (actual != null && actual.siguiente != null) {
            actual = actual.siguiente;
            System.out.println("\n--- MOSTRANDO SIGUIENTE FOTO ---");
            imprimirDetalles(actual);
        } else {
            System.out.println("¡¡Ya estás en la última foto.!!");
        }
    }

    public void retroceder() {
        if (actual != null && actual.anterior != null) {
            actual = actual.anterior;
            System.out.println("\n--- MOSTRANDO FOTO ANTERIOR ---");
            imprimirDetalles(actual);
        } else {
            System.out.println("¡¡Ya estás en la primera foto.!!");
        }
    }

    public void reproducirGaleria() {
        if (cabeza == null) {
            System.out.println("¡¡La galería está vacía.!!");
            return;
        }

        System.out.println("\n>>> INICIANDO REPRODUCCIÓN COMPLETA (Ida y Vuelta) <<<");
        
        System.out.println("\n--- Recorrido hacia adelante (Cabeza -> Cola) ---");
        Fotografia temp = cabeza;
        while (temp != null) {
            System.out.println("Visualizando: " + temp.nombreArchivo);
            temp = temp.siguiente;
        }

        System.out.println("\n--- Recorrido hacia atrás (Cola -> Cabeza) ---");
        temp = cola;
        while (temp != null) {
            System.out.println("Visualizando: " + temp.nombreArchivo);
            temp = temp.anterior;
        }
        System.out.println("\n>>> REPRODUCCIÓN FINALIZADA <<<");
    }

    public void mostrarActual() {
        if (actual == null) {
            System.out.println("¡¡No hay fotos en la galería.!!");
            return;
        }
        System.out.println("\n--- FOTO ACTUAL EN PANTALLA ---");
        imprimirDetalles(actual);
    }

    private void imprimirDetalles(Fotografia f) {
        System.out.println("Archivo: " + f.nombreArchivo);
        System.out.println("Tamaño: " + f.tamanoMB + " MB");
        System.out.println("Resolución: " + f.resolucion);
    }

    public void mostrarTabla() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("LISTA COMPLETA DE LA GALERÍA");
        System.out.println("=".repeat(70));
        System.out.printf("%-25s | %-15s | %-15s%n", "Nombre Archivo", "Tamaño (MB)", "Resolución");
        System.out.println("-".repeat(70));

        Fotografia temp = cabeza;
        if (temp == null) {
            System.out.println("Galería vacía.");
        } else {
            while (temp != null) {
                String marca = (temp == actual) ? " <--- [PANTALLA]" : "";
                System.out.printf("%-25s | %-15.2f | %-15s%s%n", 
                    temp.nombreArchivo, temp.tamanoMB, temp.resolucion, marca);
                temp = temp.siguiente;
            }
        }
        System.out.println("=".repeat(70) + "\n");
    }
}
