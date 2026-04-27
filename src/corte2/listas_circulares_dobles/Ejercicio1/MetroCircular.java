package corte2.listas_circulares_dobles.Ejercicio1;

public class MetroCircular {
    Estacion cabeza;
    Estacion cola;

    public MetroCircular() {
        this.cabeza = null;
        this.cola = null;
    }

    public void agregarEstacion(String nombre, int zona, int pasajeros) {
        Estacion nueva = new Estacion(nombre, zona, pasajeros);
        if (cabeza == null) {
            cabeza = nueva;
            cola = nueva;
            nueva.siguiente = nueva;
            nueva.anterior = nueva;
        } else {
            cola.siguiente = nueva;
            nueva.anterior = cola;
            nueva.siguiente = cabeza;
            cabeza.anterior = nueva;
            cola = nueva;
        }
    }

    public void rutaMasCorta(String nombreOrigen, String nombreDestino) {
        if (cabeza == null) {
            System.out.println("¡¡No hay estaciones registradas en la línea de metro.!!");
            return;
        }

        // 1. Buscar la estación de origen
        Estacion origen = buscarEstacion(nombreOrigen);
        Estacion destino = buscarEstacion(nombreDestino);

        if (origen == null || destino == null) {
            System.out.println("¡¡Error: Una o ambas estaciones no existen en la red.!!");
            return;
        }

        if (origen == destino) {
            System.out.println("¡¡Ya te encuentras en la estación de destino.!!");
            return;
        }

        // 2. Contar hacia adelante (siguiente) - Tip #4
        int paradasAdelante = 0;
        StringBuilder rutaAdelante = new StringBuilder();
        Estacion temp = origen;
        do {
            rutaAdelante.append(temp.nombre).append(" -> ");
            temp = temp.siguiente;
            paradasAdelante++;
        } while (temp != destino);
        rutaAdelante.append(destino.nombre);

        // 3. Contar hacia atrás (anterior) - Tip #4
        int paradasAtras = 0;
        StringBuilder rutaAtras = new StringBuilder();
        temp = origen;
        do {
            rutaAtras.append(temp.nombre).append(" <- ");
            temp = temp.anterior;
            paradasAtras++;
        } while (temp != destino);
        rutaAtras.append(destino.nombre);

        // 4. Resultados
        System.out.println("\n" + "=".repeat(60));
        System.out.println("PLANIFICADOR DE RUTA: " + nombreOrigen.toUpperCase() + " a " + nombreDestino.toUpperCase());
        System.out.println("=".repeat(60));
        System.out.println("RUTA SIGUIENTE (Sentido Horario):");
        System.out.println("Trayecto: " + rutaAdelante.toString());
        System.out.println("Total paradas: " + paradasAdelante);
        
        System.out.println("\nRUTA ANTERIOR (Sentido Anti-horario):");
        System.out.println("Trayecto: " + rutaAtras.toString());
        System.out.println("Total paradas: " + paradasAtras);
        System.out.println("-".repeat(60));

        if (paradasAdelante < paradasAtras) {
            System.out.println("¡¡LA RUTA MÁS CORTA ES HACIA ADELANTE (" + paradasAdelante + " paradas)!!");
        } else if (paradasAtras < paradasAdelante) {
            System.out.println("¡¡LA RUTA MÁS CORTA ES HACIA ATRÁS (" + paradasAtras + " paradas)!!");
        } else {
            System.out.println("¡¡AMBAS RUTAS TIENEN LA MISMA DISTANCIA (" + paradasAdelante + " paradas)!!");
        }
        System.out.println("=".repeat(60));
    }

    private Estacion buscarEstacion(String nombre) {
        if (cabeza == null) return null;
        Estacion temp = cabeza;
        do {
            if (temp.nombre.equalsIgnoreCase(nombre)) return temp;
            temp = temp.siguiente;
        } while (temp != cabeza);
        return null;
    }

    public void mostrarEstaciones() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("LÍNEA DE METRO CIRCULAR - MAPA DE RED");
        System.out.println("=".repeat(70));
        System.out.printf("%-25s | %-10s | %-20s%n", "Estación", "Zona", "Pasajeros Diarios");
        System.out.println("-".repeat(70));

        if (cabeza == null) {
            System.out.println("No hay estaciones registradas.");
        } else {
            Estacion temp = cabeza;
            do {
                System.out.printf("%-25s | %-10d | %-20d%n", 
                    temp.nombre, temp.zona, temp.pasajerosDiarios);
                temp = temp.siguiente;
            } while (temp != cabeza);
        }
        System.out.println("=".repeat(70) + "\n");
    }
}
