package ui;

import customExceptions.PrecioInvalidoException;
import customExceptions.ProductoNoEncontradoException;
import customExceptions.StockInsuficienteException;
import java.util.Scanner;
import model.Controladora;

public class Executable {

    private Scanner reader;
    private Controladora cont;
    private static boolean flag;

    private Executable() {
        reader = new Scanner(System.in);
        cont = new Controladora();
    }

    public void run(boolean flag) {
        flag = false;
        while (!flag) {
            System.out.println("\n\nBienvenido al menu de GameZone:\n");
            System.out.println("Opciones:");
            System.out.println("1. Registrar producto");
            System.out.println("2. Procesar orden de compra");
            System.out.println("3. Salir");

            int option = reader.nextInt();
            reader.nextLine();

            switch (option) {
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    procesarOrdenCompra();
                    break;
                case 3:
                    flag = true;
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Por favor ingrese una opcion valida");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Executable app = new Executable();
        app.run(flag);
    }

    public void registrarProducto() {
        try {
            System.out.println("Ingrese el ID del producto:");
            String id = reader.nextLine();
            System.out.println("Ingrese el nombre del producto:");
            String nombre = reader.nextLine();
            System.out.println("Ingrese la cantidad del producto:");
            int cantidad = reader.nextInt();
            reader.nextLine();
            System.out.println("Ingrese el precio del producto:");
            Double precio = reader.nextDouble();
            reader.nextLine();

            cont.registrarProducto(id, nombre, cantidad, precio);

        } catch (PrecioInvalidoException e) {
            System.out.println("Error al registrar el producto: " + e.getMessage());
        }

    }

    public void procesarOrdenCompra() {
        System.out.println("Ingrese el ID del cliente:");
        String idCliente = reader.nextLine();
        System.out.println("Ingrese el nombre del cliente:");
        String nombreCliente = reader.nextLine();
        cont.registrarCliente(idCliente, nombreCliente);

        System.out.println("Ingrese el ID del producto a comprar:");
        String id = reader.nextLine();
        int cantidad = 0;
        try {
            System.out.println("Ingrese la cantidad a comprar:");
            cantidad = reader.nextInt();
            reader.nextLine();
            System.out.println(cont.ordenarCompra(id, cantidad, idCliente));
        } catch (ProductoNoEncontradoException e) {
            System.out.println("Error al procesar la orden de compra: " + e.getMessage());
        } catch (StockInsuficienteException e) {
            System.out.println("Error al procesar la orden de compra: " + e.getMessage());
        }

    }
}
