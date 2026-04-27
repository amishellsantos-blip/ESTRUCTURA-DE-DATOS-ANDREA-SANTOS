package corte2.listas_circulares.Ejercicio2;

public class Pantalla {
    Anuncio cabeza;
    Anuncio cola;

    public Pantalla() {
        this.cabeza = null;
        this.cola = null;
    }

    public void agregarAnuncio(String titulo, int duracion, String categoria) {
        Anuncio nuevo = new Anuncio(titulo, duracion, categoria);
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

    public void reproducir(int ciclos) {
        if (cabeza == null) {
            System.out.println("¡¡No hay anuncios cargados en la pantalla.!!");
            return;
        }

        System.out.println("\n>>> INICIANDO REPRODUCCIÓN DIGITAL (" + ciclos + " ciclos completos) <<<");
        int tiempoTotal = 0;
        Anuncio actual = cabeza;
        
        // Contamos cuántos anuncios hay para saber cuántos pasos son los ciclos
        int totalAnuncios = 0;
        Anuncio tempContar = cabeza;
        do {
            totalAnuncios++;
            tempContar = tempContar.siguiente;
        } while (tempContar != cabeza);

        int totalPasos = ciclos * totalAnuncios;

        for (int i = 1; i <= totalPasos; i++) {
            System.out.println("[" + i + "] Mostrando: " + actual.titulo + " (" + actual.duracionSegundos + "s) - Categoria: " + actual.categoria);
            actual.vecesRepetido++;
            tiempoTotal += actual.duracionSegundos;
            actual = actual.siguiente;
        }

        System.out.println("\n>>> REPRODUCCIÓN FINALIZADA <<<");
        mostrarResumen(tiempoTotal);
    }

    private void mostrarResumen(int tiempoTotal) {
        if (cabeza == null) return;

        Anuncio masRepetido = cabeza;
        Anuncio temp = cabeza.siguiente;
        
        // Buscamos el más repetido
        do {
            if (temp.vecesRepetido > masRepetido.vecesRepetido) {
                masRepetido = temp;
            }
            temp = temp.siguiente;
        } while (temp != cabeza);

        System.out.println("\n" + "=".repeat(50));
        System.out.println("ESTADÍSTICAS DE LA PANTALLA");
        System.out.println("=".repeat(50));
        System.out.println("Tiempo total encendida: " + tiempoTotal + " segundos");
        System.out.println("Anuncio más repetido: " + masRepetido.titulo + " (" + masRepetido.vecesRepetido + " veces)");
        System.out.println("=".repeat(50));
    }

    public void mostrarAnuncios() {
        System.out.println("\n" + "=".repeat(75));
        System.out.println("LISTA DE ANUNCIOS EN ROTACIÓN");
        System.out.println("=".repeat(75));
        System.out.printf("%-20s | %-15s | %-15s | %-10s%n", "Título", "Duración (s)", "Categoría", "Repeticiones");
        System.out.println("-".repeat(75));

        if (cabeza == null) {
            System.out.println("La pantalla no tiene anuncios.");
        } else {
            Anuncio temp = cabeza;
            do {
                System.out.printf("%-20s | %-15d | %-15s | %-10d%n", 
                    temp.titulo, temp.duracionSegundos, temp.categoria, temp.vecesRepetido);
                temp = temp.siguiente;
            } while (temp != cabeza);
        }
        System.out.println("=".repeat(75) + "\n");
    }
}
