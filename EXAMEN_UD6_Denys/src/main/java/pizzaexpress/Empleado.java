package pizzaexpress;

public class Empleado extends PizzaExpress implements AccionesPedido{
    private static int contadorEmpleado = 0;

    private String idEmpleado;
    private String nombre;

    public Empleado(String nombre){
        this.nombre = nombre;
        generarId();
    }

    private void generarId(){
        contadorEmpleado++;
        this.idEmpleado = "EMP" + Integer.toString(contadorEmpleado);
    }

    public void siguienteEstado(Pedido pedido){

    }

    public void entregarPedido(Pedido pedido){
        System.out.println("El pedido " + pedido + " ha sido entregado");
    }

    @Override
    public void obtenerDetalles(){
        System.out.println("Nombre del empleado: " + nombre + ", ID del empleado: " + idEmpleado);
    }

    @Override
    public void cancelar(Pedido pedido) {
        pedido.setEstadoPedido(Estado.CANCELADO);
        System.out.println("Pedido Cancelado");
    }
}
