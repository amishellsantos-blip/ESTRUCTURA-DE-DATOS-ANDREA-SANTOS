package corte3.colas.Ejercicio5;

public class Pedido {
    String numeroPedido;
    String cliente;
    double totalPagar;
    boolean cancelado;
    Pedido siguiente;

    public Pedido(String numeroPedido, String cliente, double totalPagar, boolean cancelado) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.totalPagar = totalPagar;
        this.cancelado = cancelado;
        this.siguiente = null;
    }

    @Override
    public String toString() {
        String estado = cancelado ? "[CANCELADO]" : "[VIGENTE]";
        return "Pedido #" + numeroPedido + " | Cliente: " + cliente + " | Total: $" + totalPagar + " " + estado;
    }
}
