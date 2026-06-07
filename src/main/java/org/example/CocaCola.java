package org.example;
/**
 * Clase que representa una bebida tipo CocaCola.
 * Heredada de la clase Bebida.
 * @author Valentina(arenisca)
 * @version 1.0
 */
public class CocaCola extends Bebida {
    /**
     * Constructor para crear una instancia de CocaCola.
     *
     * @param serie Número de serie del producto.
     */
    public CocaCola(int serie) {
        super(serie);
    }
    /**
     * Entrega el nombre de la bebida al ser consumida.
     *
     * @return Una cadena de texto con el nombre "cocacola".
     */
    @Override
    public String consumir() {
        return "cocacola";
    }
}
