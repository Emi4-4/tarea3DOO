package org.example;
/**
 * Clase que representa una bebida tipo fanta.
 * Heredada de la clase Bebida.
 * @author Valentina(arenisca)
 * @version 1.0
 */
public class Fanta extends Bebida{
    /**
     * Constructor para crear una instancia de fanta.
     *
     * @param serie Número de serie del producto.
     */
    public Fanta(int serie){
        super(serie);
    }
    /**
     * Entrega el nombre de la bebida al ser consumida.
     *
     * @return Una cadena de texto con el nombre "fanta".
     */
    @Override
    public String consumir() {
        return "glupglup Fanta";
    }
}
