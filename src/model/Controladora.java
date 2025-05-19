package model;

import customExceptions.PrecioInvalidoException;
import customExceptions.ProductoNoEncontradoException;
import customExceptions.StockInsuficienteException;
import java.util.ArrayList;

public class Controladora {

    private ArrayList<Producto> productos;
    private ArrayList<Cliente> clientes;

    public void registrarCliente(String id, String nombre) {

        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                
                return;
            }
        }
        Cliente cliente = new Cliente(id, nombre);
        clientes.add(cliente);
    }

    public Controladora() {
        clientes = new ArrayList<>();
        productos = new ArrayList<>();
    }

    /**
     * Registra un nuevo producto en el inventario.
     *
     * @param
     * @throws PrecioInvalidoException si el precio del producto es negativo
     * pre condiciones: el precio es mayor a cero
     * post condiciones: se registra el producto
     * 
     */
    public void registrarProducto(String id, String nombre, int cantidad, Double precio) throws PrecioInvalidoException {

        Producto producto = new Producto(id, nombre, precio, cantidad);
        productos.add(producto);

        if (precio < 0) {
            throw new PrecioInvalidoException();
        }
    }

    /**
     * Busca un producto por su identificador.
     *
     * @param id identificador del producto
     * @return el objeto Producto
     * @throws ProductoNoEncontradoException si no existe un producto con ese id
     * pre condiciones: el producto existe
     * post condiciones: se devuelve el producto
     */
    public Producto searchProducto(String id) throws ProductoNoEncontradoException {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        return null;
    }

    public String infoProducto(String id) throws ProductoNoEncontradoException {
        Producto producto = searchProducto(id);
        if (producto == null) {
            throw new ProductoNoEncontradoException();
        }
        return producto.toString();

    }

    public String ordenarCompra(String id, int cantidad, String idCliente) throws ProductoNoEncontradoException, StockInsuficienteException {
        Producto producto = searchProducto(id);
        if (producto == null) {
            throw new ProductoNoEncontradoException();
        }
        descontarStock(producto, cantidad);
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getId().equals(idCliente)) {
                cliente = c;
                break;
            }
        }

        OrdenCompra orden = new OrdenCompra(cliente, producto, cantidad);

        return generarRecibo(cliente, producto, cantidad);
    }

    /**
     * Descuenta el stock de un producto según la cantidad comprada.
     *
     * @param producto el producto a descontar stock 
     * @param cantidad cantidad a descontar 
     * @throws StockInsuficienteException si el stock es menor que la cantidad a descontar
     * @throws ProductoNoEncontradoException si el producto no fue encontrado
     * pre condiciones: el producto existe y el stock es suficiente
     * post condiciones: el stock del producto se ha descontado
     */
    public void descontarStock(Producto producto, int cantidad) throws StockInsuficienteException, ProductoNoEncontradoException {

        if (producto.getStock() < cantidad) {
            throw new StockInsuficienteException();
        } else {
            producto.setStock(producto.getStock() - cantidad);
        }

    }

    public String generarRecibo(Cliente cliente, Producto producto, int cantidad) {
        String RecibString = "Recibo de compra\n";
        RecibString += "Cliente: " + cliente.getNombre() + "\n";
        RecibString += "Producto: " + producto.getNombre() + "\n";
        RecibString += "Cantidad: " + cantidad + "\n";
        RecibString += "Precio unitario: " + producto.getPrecio() + "\n";
        RecibString += "Total: " + (producto.getPrecio() * cantidad) + "\n";
        RecibString += "Gracias por su compra!\n";
        return RecibString;
    }

}
