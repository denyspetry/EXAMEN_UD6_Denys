package pizzaexpress;

public class PedidoNoListoException extends RuntimeException {
    public PedidoNoListoException(String mensaje) {
        super("Pedido todavía no preparado");
    }
}
