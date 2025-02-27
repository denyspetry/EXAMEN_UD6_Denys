package pizzaexpress;

import java.util.ArrayList;

public class Pedido extends PizzaExpress {

    private Cliente cliente;
    private ArrayList<CartaPizzas> listaPizzas;
    private Estado estadoPedido;

    public Pedido(Cliente cliente, Estado estadoPedido){
        this.cliente = cliente;
        listaPizzas = new ArrayList<>();
        setEstadoPedido(estadoPedido);
    }

    public void anyadirPizza(String pizza){
        listaPizzas.add(CartaPizzas.valueOf(pizza));
    }

    @Override
    public void obtenerDetalles() {
        System.out.println("Pedido " + Estado.RECIBIDO );
    }

    public void setEstadoPedido(Estado estadoPedido){
        this.estadoPedido = estadoPedido;
    }

    public void aplicarDescuento(){

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Estado getEstadoPedido() {
        return estadoPedido;
    }
}
