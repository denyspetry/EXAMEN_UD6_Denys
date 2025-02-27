package pizzaexpress;

import java.util.ArrayList;
import java.util.Scanner;

public class AppPizzaExpress {

    static Scanner entrada = new Scanner(System.in);
    static ArrayList<CartaPizzas> cartaPizzas;
    static double totalPedido;
    static String eleccion;

    public static void mostrarCarta(Cliente cliente){
        System.out.println("¿Qué te apetece hoy, " + cliente.getNombre() + "?");
        System.out.println("====== CARTA ======");
        for (CartaPizzas pizza : CartaPizzas.values()){
            System.out.print(pizza + ": ");
            System.out.println(pizza.getPrecio() + "€");
        }
        System.out.println("====================");
    }

    public static void eleccion(){

    }


    public static void main(String[] args) {

        Empleado carlos = new Empleado("Carlos");
        Empleado sabrina = new Empleado("Sabrina");

        System.out.println("*** BIENVENIDO A LA PIZZERÍA POPEYE DE MUTXAMEL ***");
        carlos.obtenerDetalles();
        sabrina.obtenerDetalles();

        System.out.println("Haz tu pedido...¿cómo te llamas?");
        String nombreCliente = entrada.nextLine();
        Cliente cliente = new Cliente(nombreCliente);

        mostrarCarta(cliente);
        eleccion = entrada.nextLine().toUpperCase();

        for (CartaPizzas pizza : CartaPizzas.values()){

            if (eleccion.equals(pizza.name())){

                Pedido pedido = new Pedido(cliente, Estado.RECIBIDO);
                pedido.anyadirPizza(eleccion);
                totalPedido += pizza.getPrecio();

                System.out.println("El precio actual de la cuenta es de " + totalPedido + "€. ¿Quieres añadir otra pizza a tu pedido? [S/N]");
                eleccion = entrada.nextLine();
                if (eleccion.equalsIgnoreCase("S")){

                } else if (eleccion.equalsIgnoreCase("N")) {
                    break;
                } else {
                    System.out.println("No es una eleccion válida");
                    continue;
                }
            }
        }

        System.out.println("Pedido RECIBIDO. Total pedido: " + totalPedido + "€");
        System.out.println("Descuento a aplicar: " + cliente.getDescuento() + "%. Total importe a pagar: " + ((100 - cliente.getDescuento())/100 * totalPedido));
        System.out.println("Pasa por caja para pagar y recoger tu pedido cuando esté listo. Muchas gracias " + cliente.getNombre());

    }
}
