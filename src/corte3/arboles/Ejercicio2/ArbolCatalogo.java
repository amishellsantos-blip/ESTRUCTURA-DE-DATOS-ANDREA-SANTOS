package corte3.arboles.Ejercicio2;

public class ArbolCatalogo {
    Libro raiz;

    public ArbolCatalogo() {
        this.raiz = null;
    }

    public void insertar(long isbn, String titulo, String autor, int anioPublicacion) {
        Libro nuevo = new Libro(isbn, titulo, autor, anioPublicacion);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            insertarRecursivo(raiz, nuevo);
        }
    }

    private void insertarRecursivo(Libro actual, Libro nuevo) {
        if (nuevo.isbn < actual.isbn) {
            if (actual.izq == null) {
                actual.izq = nuevo;
            } else {
                insertarRecursivo(actual.izq, nuevo);
            }
        } else if (nuevo.isbn > actual.isbn) { 
            // En caso de que sea mayor. Si fuera igual, no se hace nada (evita duplicados)
            if (actual.der == null) {
                actual.der = nuevo;
            } else {
                insertarRecursivo(actual.der, nuevo);
            }
        }
    }

    public void imprimirCatalogo() {
        if (raiz == null) {
            System.out.println("El catálogo está vacío.");
        } else {
            imprimirCatalogoRecursivo(raiz);
        }
    }

    private void imprimirCatalogoRecursivo(Libro actual) {
        if (actual != null) {
            imprimirCatalogoRecursivo(actual.izq);
            // El reto pide imprimir: isbn - titulo - autor
            System.out.println(actual.isbn + " - " + actual.titulo + " - " + actual.autor);
            imprimirCatalogoRecursivo(actual.der);
        }
    }

    public boolean existeISBN(long isbn) {
        return existeISBNRecursivo(raiz, isbn);
    }

    private boolean existeISBNRecursivo(Libro actual, long isbn) {
        if (actual == null) {
            return false; // Llegó al final y no lo encontró
        }

        if (isbn == actual.isbn) {
            return true; // ¡Lo encontró!
        } else if (isbn < actual.isbn) {
            return existeISBNRecursivo(actual.izq, isbn); // Buscar en la izquierda
        } else {
            return existeISBNRecursivo(actual.der, isbn); // Buscar en la derecha
        }
    }
}
