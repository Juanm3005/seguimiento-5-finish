package customExceptions;

/**
 * Excepción personalizada para indicar que un producto no fue encontrado en la base de datos.
 * Esta excepción se lanza cuando se intenta buscar un producto que no existe.
 * Se propaga desde el controlador al ejecutable en el controller en descontarStock, ordenarcompra hasta el exxecutable en procesar compra.
 */
public class StockInsuficienteException extends Exception{
    public StockInsuficienteException() {
        super("El stock es insuficiente para completar la compra.");
    }
}
