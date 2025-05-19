package customExceptions;

/**
 * Excepción personalizada para indicar que un producto no fue encontrado en la base de datos.
 * Esta excepción se lanza cuando se intenta buscar un producto que no existe.
 * Se propaga desde el controlador al ejecutable en el controller en search product, infoproduct, ordenar compra hasta el procesar compra en el exxecutabl.
 */
public class ProductoNoEncontradoException extends Exception {
    public ProductoNoEncontradoException() {
        super("El producto no fue encontrado en la base de datos.");
    }
    
}
