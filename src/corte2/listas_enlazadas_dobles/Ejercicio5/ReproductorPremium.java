package corte2.listas_enlazadas_dobles.Ejercicio5;

public class ReproductorPremium {
    Cancion cabeza;
    Cancion cola;
    Cancion actual;

    public ReproductorPremium() {
        this.cabeza = null;
        this.cola = null;
        this.actual = null;
    }

    public void agregarCancion(String titulo, String artista, int duracion) {
        Cancion nueva = new Cancion(titulo, artista, duracion);
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

    public void saltarAdelante() {
        if (actual == null) {
            System.out.println("¡¡La lista de reproducción está vacía.!!");
            return;
        }
        if (actual.siguiente != null) {
            actual = actual.siguiente;
            System.out.println("\n>>> Reproduciendo ahora: " + actual.titulo + " - " + actual.artista);
        } else {
            System.out.println("¡¡Ya estás en la última canción. No hay nada más adelante.!!");
        }
    }

    public void saltarAtras() {
        if (actual == null) {
            System.out.println("¡¡La lista de reproducción está vacía.!!");
            return;
        }
        if (actual.anterior != null) {
            actual = actual.anterior;
            System.out.println("\n<<< Reproduciendo ahora: " + actual.titulo + " - " + actual.artista);
        } else {
            System.out.println("¡¡¡ERROR: Estás en la primera canción. No hay pista anterior.!!!");
        }
    }

    public void mostrarEstadoActual() {
        if (actual == null) {
            System.out.println("¡¡No hay canciones cargadas.!!");
            return;
        }
        String duracionFormato = String.format("%02d:%02d", 
            actual.duracionSegundos / 60, actual.duracionSegundos % 60);
            
        System.out.println("\n" + "=".repeat(40));
        System.out.println("REPRODUCIENDO AHORA");
        System.out.println("=".repeat(40));
        System.out.println("Título: " + actual.titulo);
        System.out.println("Artista: " + actual.artista);
        System.out.println("Duración: " + duracionFormato);
        System.out.println("=".repeat(40));
    }

    public void mostrarLista() {
        System.out.println("\n" + "=".repeat(75));
        System.out.println("LISTA DE REPRODUCCIÓN PREMIUM");
        System.out.println("=".repeat(75));
        System.out.printf("%-25s | %-20s | %-10s%n", "Título", "Artista", "Duración");
        System.out.println("-".repeat(75));

        Cancion temp = cabeza;
        if (temp == null) {
            System.out.println("Lista vacía.");
        } else {
            while (temp != null) {
                String marca = (temp == actual) ? " <--- [PLAY]" : "";
                String duracionFormato = String.format("%02d:%02d", 
                    temp.duracionSegundos / 60, temp.duracionSegundos % 60);
                
                System.out.printf("%-25s | %-20s | %-10s%s%n", 
                    temp.titulo, temp.artista, duracionFormato, marca);
                temp = temp.siguiente;
            }
        }
        System.out.println("=".repeat(75) + "\n");
    }
}
