package pizzaexpress;

import java.util.ArrayList;
import java.util.Scanner;

public class AppPizzaExpress {

    static Scanner entrada = new Scanner(System.in);
    static ArrayList<CartaPizzas> cartaPizzas;

    public static void main(String[] args) {

        Empleado carlos = new Empleado("Carlos");
        Empleado sabrina = new Empleado("Sabrina");

        System.out.println("*** BIENVENIDO A LA PIZZERÍA POPEYE DE MUTXAMEL ***");
        carlos.obtenerDetalles();
        sabrina.obtenerDetalles();

        System.out.println("Haz tu pedido...¿cómo te llamas?");
        String nombreCliente = entrada.nextLine();
        Cliente cliente = new Cliente(nombreCliente);

        System.out.println("¿Qué te apetece hoy, " + cliente.getNombre() + "?");
        System.out.println("====== CARTA ======");
        for (CartaPizzas pizza : CartaPizzas.values()){
            System.out.print(pizza + ": ");
            System.out.println(pizza.getPrecio() + "€");
        }
        System.out.println("====================");
        String eleccion = entrada.nextLine();

        for (CartaPizzas pizza : CartaPizzas.values()){
            if (eleccion.equalsIgnoreCase(pizza.name())){
                Pedido pedido = new Pedido(cliente, Estado.RECIBIDO);
                pedido.anyadirPizza(eleccion);
                pedido.obtenerDetalles();
                cliente.obtenerDetalles();
            }
        }

        System.out.println("Pasa por caja para pagar y recoger tu pedido cuando esté listo. Muchas gracias " + cliente.getNombre());

    }
}
