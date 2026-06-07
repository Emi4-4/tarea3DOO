package org.example;
/**
 * Excepción lanzada cuando no es posible entregar un producto.
 * Se utiliza principalmente en dos escenarios:
 * 1. El depósito del producto solicitado está vacío.
 * 2. El código de producto ingresado no corresponde a ninguna categoría válida.
 * @author Lenin(Chamo0312)
 * @version 1.0
 */
public class NoHayProductoException extends Exception{
    /**
     * Construye una nueva excepción con un mensaje sobre el error.
     *
     * @param msg Mensaje que describe la causa de la falla.
     */
    public NoHayProductoException(String msg) {
        super(msg);
    }
}
