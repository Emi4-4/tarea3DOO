package org.example;
/**
 * Excepción lanzada cuando el monto de la moneda ingresada es menor al precio del producto.
 * Permite al sistema identificar que la transacción no puede completarse por falta de dinero
 * y continuar con la devolución de la moneda.
 * @author Lenin(Chamo0312)
 * @version 1.0
 */
public class PagoInsuficienteException extends Exception {
    /**
     * Construye una nueva excepción con un mensaje que detalla la falta de dinero.
     *
     * @param msg Texto que describe el error,indicando que el dinero no es suficiente.
     */
    public PagoInsuficienteException(String msg) {
        super(msg);
    }
}
