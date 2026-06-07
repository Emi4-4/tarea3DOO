package org.example;
/**
 * Clase que representa una bebida tipo sprite.
 * Heredada de la clase Bebida.
 * @author Valentina(arenisca)
 * @version 1.0
 */
public class Sprite extends Bebida {
    /**
     * Constructor para crear una instancia de sprite.
     *
     * @param serie Número de serie del producto.
     */
    public Sprite(int serie) {
        super(serie);
    }
    /**
     * Entrega el nombre de la bebida al ser consumida.
     *
     * @return Una cadena de texto con el nombre "sprite".
     */
    public String consumir() {
        return "sprite";
    }
}