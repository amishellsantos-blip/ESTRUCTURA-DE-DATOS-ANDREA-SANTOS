package corte3.arboles.Ejercicio4;

public class ArbolRanking {
    Jugador raiz;

    public ArbolRanking() {
        this.raiz = null;
    }

    public void insertar(int elo, String nombreUsuario, String pais, int partidasJugadas) {
        Jugador nuevo = new Jugador(elo, nombreUsuario, pais, partidasJugadas);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            insertarRecursivo(raiz, nuevo);
        }
    }

    private void insertarRecursivo(Jugador actual, Jugador nuevo) {
        if (nuevo.elo < actual.elo) {
            if (actual.izq == null) {
                actual.izq = nuevo;
            } else {
                insertarRecursivo(actual.izq, nuevo);
            }
        } else if (nuevo.elo > actual.elo) {
            if (actual.der == null) {
                actual.der = nuevo;
            } else {
                insertarRecursivo(actual.der, nuevo);
            }
        }
    }

    public void imprimirRanking() {
        if (raiz == null) {
            System.out.println("El ranking está vacío.");
        } else {
            imprimirInOrden(raiz);
        }
    }

    private void imprimirInOrden(Jugador actual) {
        if (actual != null) {
            imprimirInOrden(actual.izq);
            System.out.println(actual);
            imprimirInOrden(actual.der);
        }
    }

    public void listarEnRango(int eloMin, int eloMax) {
        if (raiz == null) {
            System.out.println("El ranking está vacío.");
            return;
        }
        listarEnRangoRecursivo(raiz, eloMin, eloMax);
    }

    private void listarEnRangoRecursivo(Jugador actual, int eloMin, int eloMax) {
        if (actual == null) {
            return;
        }

        // Si el ELO del nodo es mayor al mínimo, PODRÍA haber elementos válidos a la izquierda
        if (actual.elo > eloMin) {
            listarEnRangoRecursivo(actual.izq, eloMin, eloMax);
        }

        // Si está en el rango exacto, se imprime. Al estar entre las dos llamadas recursivas (InOrden),
        // garantizamos que la impresión saldrá ordenada de menor a mayor ELO.
        if (actual.elo >= eloMin && actual.elo <= eloMax) {
            System.out.println(actual);
        }

        // Si el ELO del nodo es menor al máximo, PODRÍA haber elementos válidos a la derecha
        if (actual.elo < eloMax) {
            listarEnRangoRecursivo(actual.der, eloMin, eloMax);
        }
    }
}
