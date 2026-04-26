package corte2.listas_enlazadas_simples.Ejercicio5;

public class Reproductor {
    Cancion cabeza;

    public Reproductor() {
        this.cabeza = null;
    }

    // "A continuación" - Inserta después de la primera canción (si hay una)
    // Si la lista está vacía, se convierte en la cabeza.
    public void agregarSiguiente(String titulo, String artista, int duracion, String genero) {
        Cancion nueva = new Cancion(titulo, artista, duracion, genero);
        if (cabeza == null) {
            cabeza = nueva;
        } else {
            nueva.siguiente = cabeza.siguiente;
            cabeza.siguiente = nueva;
        }
    }

    // "Al final de la cola"
    public void agregarAlFinal(String titulo, String artista, int duracion, String genero) {
        Cancion nueva = new Cancion(titulo, artista, duracion, genero);
        if (cabeza == null) {
            cabeza = nueva;
        } else {
            Cancion actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nueva;
        }
    }

    public void mostrarLista() {
        System.out.println("\n" + "=".repeat(85));
        System.out.println("SPOTIFY LITE - LISTA DE REPRODUCCIÓN");
        System.out.println("=".repeat(85));
        System.out.printf("%-25s | %-20s | %-15s | %-10s%n", "Título", "Artista", "Género", "Duración");
        System.out.println("-".repeat(85));

        Cancion actual = cabeza;
        int totalSegundos = 0;

        if (actual == null) {
            System.out.println("La lista de reproducción está vacía.");
        } else {
            while (actual != null) {
                String duracionFormato = String.format("%02d:%02d", 
                    actual.duracionSegundos / 60, actual.duracionSegundos % 60);
                
                System.out.printf("%-25s | %-20s | %-15s | %-10s%n", 
                    actual.titulo, actual.artista, actual.genero, duracionFormato);
                
                totalSegundos += actual.duracionSegundos;
                actual = actual.siguiente;
            }
        }
        
        System.out.println("-".repeat(85));
        String tiempoTotal = String.format("%02d:%02d", totalSegundos / 60, totalSegundos % 60);
        System.out.println("TIEMPO TOTAL DE REPRODUCCIÓN: " + tiempoTotal);
        System.out.println("=".repeat(85) + "\n");
    }
}
