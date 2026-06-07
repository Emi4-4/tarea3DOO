package org.example;
/**
 * Excepción lanzada cuando el pago realizado no es válido para procesar una compra.
 * Se utiliza principalmente cuando el objeto Moneda entregado al expendedor es null.
 * @author Lenin(Chamo0312)
 * @version 1.0
 */
public class PagoIncorrectoException extends Exception {
    /**
     * Construye una nueva excepción con un mensaje que explica el error en el pago.
     *
     * @param msg Texto que indica por qué el pago fue rechazado.
     */
    public PagoIncorrectoException(String msg) {
        super(msg);
    }
}