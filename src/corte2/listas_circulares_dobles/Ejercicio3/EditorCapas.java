package corte2.listas_circulares_dobles.Ejercicio3;

public class EditorCapas {
    Capa cabeza;
    Capa cola;
    Capa capaActiva;

    public EditorCapas() {
        this.cabeza = null;
        this.cola = null;
        this.capaActiva = null;
    }

    public void agregarCapa(String nombre, String tipo) {
        Capa nueva = new Capa(nombre, tipo);
        if (cabeza == null) {
            cabeza = nueva;
            cola = nueva;
            nueva.siguiente = nueva;
            nueva.anterior = nueva;
            capaActiva = nueva;
        } else {
            cola.siguiente = nueva;
            nueva.anterior = cola;
            nueva.siguiente = cabeza;
            cabeza.anterior = nueva;
            cola = nueva;
        }
        System.out.println("Capa '" + nombre + "' agregada.");
    }

    public void subirCapa() {
        if (capaActiva != null) {
            capaActiva = capaActiva.siguiente;
            System.out.println("\n>>> Subiendo a capa: " + capaActiva.nombre);
        }
    }

    public void bajarCapa() {
        if (capaActiva != null) {
            capaActiva = capaActiva.anterior;
            System.out.println("\n<<< Bajando a capa: " + capaActiva.nombre);
        }
    }

    public void toggleVisibilidad() {
        if (capaActiva != null) {
            capaActiva.visible = !capaActiva.visible;
            String estado = capaActiva.visible ? "VISIBLE" : "OCULTA";
            System.out.println("\nCapa '" + capaActiva.nombre + "' ahora está " + estado);
        }
    }

    public void eliminarActiva() {
        if (capaActiva == null) {
            System.out.println("¡¡No hay capas para eliminar.!!");
            return;
        }

        System.out.println("Eliminando capa activa: " + capaActiva.nombre);

        // Caso: Única capa (Tip #5)
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
            capaActiva = null;
        } else {
            Capa aEliminar = capaActiva;

            // Mover el foco ANTES de desconectar (Tip #3)
            capaActiva = capaActiva.siguiente;

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
        System.out.println("¡¡Capa eliminada. El foco pasó a la siguiente capa disponible!!");
    }

    public void mostrarCapas() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("EDITOR DE CAPAS - PANEL DE CONTROL");
        System.out.println("=".repeat(60));
        System.out.printf("%-5s | %-20s | %-10s | %-10s%n", "Act", "Nombre", "Tipo", "Visible");
        System.out.println("-".repeat(60));

        if (cabeza == null) {
            System.out.println("No hay capas en el diseño.");
        } else {
            Capa temp = cabeza;
            do {
                String marca = (temp == capaActiva) ? "[✓]" : "   ";
                String vis = temp.visible ? "SÍ" : "NO";
                System.out.printf("%-5s | %-20s | %-10s | %-10s%n", 
                    marca, temp.nombre, temp.tipo, vis);
                temp = temp.siguiente;
            } while (temp != cabeza);
        }
        System.out.println("=".repeat(60) + "\n");
    }
}
