package corte2.listas_enlazadas_dobles.Ejercicio3;

public class Navegador {
    Pestana cabeza;
    Pestana cola;

    public Navegador() {
        this.cabeza = null;
        this.cola = null;
    }

    public void abrirPestana(String titulo, String url, String hora) {
        Pestana nueva = new Pestana(titulo, url, hora);
        if (cabeza == null) {
            cabeza = nueva;
            cola = nueva;
        } else {
            cola.siguiente = nueva;
            nueva.anterior = cola;
            cola = nueva;
        }
        System.out.println("Pestaña '" + titulo + "' abierta.");
    }

    public void cerrarPestanaActual(String url) {
        if (cabeza == null) {
            System.out.println("¡¡No hay pestañas abiertas para cerrar.!!");
            return;
        }

        Pestana actual = cabeza;
        while (actual != null) {
            if (actual.url.equalsIgnoreCase(url)) {
                // Caso: Única pestaña
                if (actual == cabeza && actual == cola) {
                    cabeza = null;
                    cola = null;
                }
                // Caso: Es la cabeza
                else if (actual == cabeza) {
                    cabeza = cabeza.siguiente;
                    cabeza.anterior = null;
                }
                // Caso: Es la cola
                else if (actual == cola) {
                    cola = cola.anterior;
                    cola.siguiente = null;
                }
                // Caso: En el medio
                else {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                }
                
                System.out.println("\n¡¡Pestaña [" + actual.tituloPagina + "] cerrada correctamente!!");
                return;
            }
            actual = actual.siguiente;
        }
        System.out.println("¡¡No se encontró ninguna pestaña abierta con la URL: " + url + "!!");
    }

    public void mostrarPestanas() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("NAVEGADOR - PESTAÑAS ABIERTAS");
        System.out.println("=".repeat(80));
        System.out.printf("%-20s | %-30s | %-15s%n", "Título", "URL", "Hora Apertura");
        System.out.println("-".repeat(80));

        Pestana temp = cabeza;
        if (temp == null) {
            System.out.println("No hay pestañas abiertas.");
        } else {
            while (temp != null) {
                System.out.printf("%-20s | %-30s | %-15s%n", 
                    temp.tituloPagina, temp.url, temp.horaApertura);
                temp = temp.siguiente;
            }
        }
        System.out.println("=".repeat(80) + "\n");
    }
}
