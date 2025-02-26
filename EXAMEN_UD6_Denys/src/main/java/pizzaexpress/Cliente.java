package pizzaexpress;

public class Cliente extends PizzaExpress implements AccionesPedido{
    private static final int DESCUENTO_DEF = 20;

    private String nombre;
    private int descuento;

    public Cliente(String nombre, int descuento){
        this.nombre = nombre;
        this.descuento = descuento;
    }

    public Cliente(String nombre){
        this.nombre = nombre;
        descuento = DESCUENTO_DEF;
    }

    public void pedir(){}

    public void pagar(){}

    public void recoger(){}

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void obtenerDetalles(){
        System.out.println("Nombre del cliente: " + nombre + ", tiene un descuento de " + descuento + "%");
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setEstadoPedido(Estado.CANCELADO);
        System.out.println("Pedido Cancelado");
    }
}
