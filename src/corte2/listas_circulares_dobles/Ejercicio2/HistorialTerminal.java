package corte2.listas_circulares_dobles.Ejercicio2;

public class HistorialTerminal {
    Comando cabeza;
    Comando cola;
    Comando cursor;

    public HistorialTerminal() {
        this.cabeza = null;
        this.cola = null;
        this.cursor = null;
    }

    public void agregarComando(String texto, boolean exitoso, String directorio) {
        Comando nuevo = new Comando(texto, exitoso, directorio);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = nuevo;
            nuevo.anterior = nuevo;
            cursor = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cola = nuevo;
        }
        System.out.println("Comando registrado: " + texto);
    }

    public void arriba() {
        if (cursor != null) {
            cursor = cursor.anterior;
            System.out.println("\n[FLECHA ARRIBA] Cursor en: " + cursor.texto);
        } else {
            System.out.println("Historial vacío.");
        }
    }

    public void abajo() {
        if (cursor != null) {
            cursor = cursor.siguiente;
            System.out.println("\n[FLECHA ABAJO] Cursor en: " + cursor.texto);
        } else {
            System.out.println("Historial vacío.");
        }
    }

    public void mostrarCursor() {
        if (cursor == null) {
            System.out.println("¡¡No hay comandos en el historial.!!");
            return;
        }
        System.out.println("\n--- COMANDO ACTUAL (CURSOR) ---");
        System.out.println("Texto: " + cursor.texto);
        System.out.println("Estado: " + (cursor.exitoso ? "Exitoso" : "Error"));
        System.out.println("Directorio: " + cursor.directorio);
    }

    public void eliminarActual() {
        if (cursor == null) {
            System.out.println("¡¡Nada que eliminar.!!");
            return;
        }

        System.out.println("Eliminando comando: " + cursor.texto);

        // Caso: Un solo nodo (Tip #5)
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
            cursor = null;
        } else {
            Comando aEliminar = cursor;
            
            // Mover cursor ANTES de desconectar (Tip #3)
            cursor = cursor.siguiente;

            // Desconectar en O(1) (Tip #1)
            aEliminar.anterior.siguiente = aEliminar.siguiente;
            aEliminar.siguiente.anterior = aEliminar.anterior;

            // Actualizar cabeza/cola si aplica (Tip #2)
            if (aEliminar == cabeza) {
                cabeza = aEliminar.siguiente;
            }
            if (aEliminar == cola) {
                cola = aEliminar.anterior;
            }
        }
        System.out.println("¡¡Comando eliminado con éxito. Cursor movido al siguiente!!");
    }

    public void mostrarHistorial() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("HISTORIAL DE COMANDOS (TERMINAL)");
        System.out.println("=".repeat(80));
        System.out.printf("%-30s | %-10s | %-25s%n", "Comando", "Estado", "Directorio");
        System.out.println("-".repeat(80));

        if (cabeza == null) {
            System.out.println("Historial vacío.");
        } else {
            Comando temp = cabeza;
            do {
                String marca = (temp == cursor) ? " <--- [CURSOR]" : "";
                System.out.printf("%-30s | %-10s | %-25s%s%n", 
                    temp.texto, (temp.exitoso ? "OK" : "ERR"), temp.directorio, marca);
                temp = temp.siguiente;
            } while (temp != cabeza);
        }
        System.out.println("=".repeat(80) + "\n");
    }
}
