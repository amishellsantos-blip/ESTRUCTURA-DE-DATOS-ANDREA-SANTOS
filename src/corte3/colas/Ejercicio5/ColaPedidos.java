package corte3.colas.Ejercicio5;

public class ColaPedidos {
    private Pedido salida; // Frente de la cola (dequeue)
    private Pedido entrada; // Final de la cola (enqueue)
    private int tamanio;

    public ColaPedidos() {
        this.salida = null;
        this.entrada = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return salida == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void enqueue(Pedido nuevo) {
        if (estaVacia()) {
            salida = nuevo;
            entrada = nuevo;
        } else {
            entrada.siguiente = nuevo;
            entrada = nuevo;
        }
        tamanio++;
    }

    public Pedido dequeue() {
        if (estaVacia()) {
            return null;
        }
        Pedido aux = salida;
        salida = salida.siguiente;
        tamanio--;
        
        if (salida == null) {
            entrada = null;
        }
        
        aux.siguiente = null;
        return aux;
    }

    public Pedido peek() {
        return salida;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("No hay pedidos en la bodega de espera.");
            return;
        }
        Pedido actual = salida;
        System.out.println("=== COLA DE PEDIDOS (BODEGA) ===");
        while (actual != null) {
            if (actual == salida) {
                System.out.print("  PRÓXIMO -> ");
            } else {
                System.out.print("             ");
            }
            System.out.println(actual.toString());
            actual = actual.siguiente;
        }
        System.out.println("================================");
    }

    /**
     * Reto: Vacía la cola y cuenta los despachados y cancelados.
     */
    public void procesarPedidos() {
        if (estaVacia()) {
            System.out.println("La bodega está vacía. Nada que procesar.");
            return;
        }
        
        System.out.println("\n--- PROCESANDO LOTES DE PEDIDOS ---");
        int countDespachados = 0;
        int countCancelados = 0;
        double totalVendido = 0.0;
        
        while (!estaVacia()) {
            Pedido pedido = dequeue();
            
            if (pedido.cancelado) {
                System.out.println("DESCARTADO: " + pedido);
                countCancelados++;
            } else {
                System.out.println("DESPACHADO: " + pedido);
                countDespachados++;
                totalVendido += pedido.totalPagar;
            }
        }
        
        System.out.println("-----------------------------------");
        System.out.println("RESUMEN DEL PROCESAMIENTO:");
        System.out.println("Pedidos Despachados: " + countDespachados);
        System.out.println("Pedidos Cancelados:  " + countCancelados);
        System.out.println("Ventas Confirmadas:  $" + totalVendido);
    }
}
