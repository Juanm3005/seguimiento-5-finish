package customExceptions;

 /*Excepción personalizada para indicar que el precio de un producto es inválido.
 * Esta excepción se lanza cuando el precio es menor o igual a cero.
 * se propaga desde el controler de registrar producto hasta el executable registrar producto
 * devuelve al menu*/ 
public class PrecioInvalidoException extends IllegalArgumentException{
    public PrecioInvalidoException() {
        super("El precio no puede ser menor o igual a cero. Por favor, ingrese un precio válido.");
    }
}
