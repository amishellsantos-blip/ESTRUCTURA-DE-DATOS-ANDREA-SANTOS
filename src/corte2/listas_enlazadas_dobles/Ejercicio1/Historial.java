package corte2.listas_enlazadas_dobles.Ejercicio1;

public class Historial {
    Cambio cabeza;
    Cambio cola;
    Cambio actual; // El puntero que se mueve con Undo/Redo

    public Historial() {
        this.cabeza = null;
        this.cola = null;
        this.actual = null;
    }

    public void agregarCambio(String texto, String tipoOperacion) {
        Cambio nuevo = new Cambio(texto, tipoOperacion);
        
        // Si el puntero actual no está al final (se hizo Undo), 
        // eliminamos el historial "adelantado" para crear una nueva rama
        if (actual != null && actual.siguiente != null) {
            actual.siguiente = null;
            cola = actual;
        }

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
        actual = cola; // El cursor siempre queda en el cambio más reciente
    }

    public void deshacer() {
        if (actual == null) {
            System.out.println("¡¡No hay cambios para deshacer.!!");
            return;
        }

        if (actual.anterior == null) {
            System.out.println("¡¡Ya estás en el estado inicial. No puedes deshacer más.!!");
            return;
        }

        actual = actual.anterior;
        System.out.println("\n¡¡Deshecho!! Operación actual: " + actual.tipoOperacion + " - " + actual.texto);
    }

    public void rehacer() {
        if (actual == null || actual.siguiente == null) {
            System.out.println("¡¡No hay cambios para rehacer.!!");
            return;
        }

        actual = actual.siguiente;
        System.out.println("\n¡¡Rehecho!! Operación actual: " + actual.tipoOperacion + " - " + actual.texto);
    }

    public void mostrarHistorial() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("HISTORIAL DE CAMBIOS (EDITOR DE TEXTO)");
        System.out.println("=".repeat(60));
        System.out.printf("%-15s | %-30s%n", "Operación", "Contenido");
        System.out.println("-".repeat(60));

        Cambio temp = cabeza;
        if (temp == null) {
            System.out.println("Historial vacío.");
        } else {
            while (temp != null) {
                String marca = (temp == actual) ? " <--- [ACTUAL]" : "";
                System.out.printf("%-15s | %-30s%s%n", 
                    temp.tipoOperacion, temp.texto, marca);
                temp = temp.siguiente;
            }
        }
        System.out.println("=".repeat(60) + "\n");
    }
}
