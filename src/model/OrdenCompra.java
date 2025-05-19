package model;

public class OrdenCompra {

    private Cliente cliente;
    private Producto producto;
    private int cantidad;

    public OrdenCompra(Cliente cliente, Producto producto, int cantidad) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "OrdenCompra{" +
               "cliente=" + cliente +
               ", producto=" + producto +
               ", cantidad=" + cantidad +
               '}';
    }
}