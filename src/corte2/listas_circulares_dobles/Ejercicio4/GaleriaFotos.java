package corte2.listas_circulares_dobles.Ejercicio4;

public class GaleriaFotos {
    Foto cabeza;
    Foto cola;
    Foto actual;

    public GaleriaFotos() {
        this.cabeza = null;
        this.cola = null;
        this.actual = null;
    }

    public void agregarFoto(String titulo, String fecha) {
        Foto nueva = new Foto(titulo, fecha);
        if (cabeza == null) {
            cabeza = nueva;
            cola = nueva;
            nueva.siguiente = nueva;
            nueva.anterior = nueva;
            actual = nueva;
        } else {
            cola.siguiente = nueva;
            nueva.anterior = cola;
            nueva.siguiente = cabeza;
            cabeza.anterior = nueva;
            cola = nueva;
        }
        System.out.println("Foto '" + titulo + "' agregada al álbum.");
    }

    public void siguiente() {
        if (actual != null) {
            actual = actual.siguiente;
            System.out.println("\n>>> Deslizando a la siguiente foto: " + actual.titulo);
        }
    }

    public void anterior() {
        if (actual != null) {
            actual = actual.anterior;
            System.out.println("\n<<< Regresando a la foto anterior: " + actual.titulo);
        }
    }

    public void toggleFavorita() {
        if (actual != null) {
            actual.esFavorita = !actual.esFavorita;
            String estado = actual.esFavorita ? "marcada como FAVORITA" : "quitada de FAVORITAS";
            System.out.println("\nFoto '" + actual.titulo + "' " + estado);
        }
    }

    public void eliminarActual() {
        if (actual == null) {
            System.out.println("¡¡No hay fotos en la galería para eliminar.!!");
            return;
        }

        System.out.println("Eliminando foto actual: " + actual.titulo);

        // Caso: Única foto (Tip #5)
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
            actual = null;
        } else {
            Foto aEliminar = actual;

            // Mover el puntero ANTES de desconectar (Tip #3)
            actual = actual.siguiente;

            // Desconectar en O(1) (Tip #1)
            aEliminar.anterior.siguiente = aEliminar.siguiente;
            aEliminar.siguiente.anterior = aEliminar.anterior;

            // Actualizar cabeza/cola (Tip #2)
            if (aEliminar == cabeza) {
                cabeza = aEliminar.siguiente;
            }
            if (aEliminar == cola) {
                cola = aEliminar.anterior;
            }
        }
        System.out.println("¡¡Foto eliminada. Galería posicionada en la siguiente imagen disponible!!");
    }

    public void mostrarGaleria() {
        System.out.println("\n" + "=".repeat(65));
        System.out.println("GALERÍA DE FOTOS - ÁLBUM DIGITAL");
        System.out.println("=".repeat(65));
        System.out.printf("%-5s | %-5s | %-25s | %-15s%n", "Ver", "Fav", "Título", "Fecha");
        System.out.println("-".repeat(65));

        if (cabeza == null) {
            System.out.println("La galería está vacía.");
        } else {
            Foto temp = cabeza;
            do {
                String marcaActual = (temp == actual) ? "[▶]" : "   ";
                String marcaFav = temp.esFavorita ? "[★]" : "[ ]";
                System.out.printf("%-5s | %-5s | %-25s | %-15s%n", 
                    marcaActual, marcaFav, temp.titulo, temp.fecha);
                temp = temp.siguiente;
            } while (temp != cabeza);
        }
        System.out.println("=".repeat(65) + "\n");
    }
}
