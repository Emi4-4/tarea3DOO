package org.example;
/**
 * Clase que representa a un cliente que interactúa con el expendedor.
 * Se encarga de entregar una moneda, recibir el producto y recolectar el vuelto.
 *
 * @author Valentina (arenisca)
 * @author Lenin(Chamo0312)
 * @version 1.0
 */
public class Comprador {
    private String sonido;
    private int vuelto=0;
    /**
     * Constructor que realiza la acción de compra.
     * Intenta obtener un producto y luego retira todo el vuelto disponible en el expendedor.
     *
     * @param moneda La moneda que se utilizará para el pago.
     * @param cualProducto El identificador del producto que se quiere comprar.
     * @param exp La instancia del expendedor donde se hace la compra.
     * @throws NoHayProductoException Si el depósito del producto solicitado está vacío.
     * @throws PagoInsuficienteException Si el valor de la moneda es menor al precio del producto.
     * @throws PagoIncorrectoException Si se intenta comprar con una moneda nula (null).
     */
    public Comprador(Moneda moneda, int cualProducto, Expendedor exp)
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        /*
        Producto p=exp.comprarProducto(moneda,cualProducto);
        Moneda mon=exp.getVuelto();
        while (mon!=null){
            vuelto+= mon.getValor();
            mon = exp.getVuelto();
        }
        if (p!=null){
            sonido=p.consumir();
        } else {
            sonido=null;
        }
    }
    /**
     * Permite saber el monto total de vuelto que el comprador recibió.
     *
     * @return La suma de los valores de todas las monedas recibidas como vuelto.
     *
    public int cuantoVuelto(){
        return vuelto;
    }
    /**
     * Entrega el "sonido" producido al consumir el producto comprado.
     *
     * @return El mensaje del producto consumido (ej: "cocacola") o null si no hubo compra.
     *
    public String queCompraste() {
        return sonido;
    }

    */
}
}
