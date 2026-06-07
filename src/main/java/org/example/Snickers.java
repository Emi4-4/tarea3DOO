package org.example;
/**
 * Clase que representa un dulce del tipo snickers.
 * Heredada de la clase Dulce.
 * @author Valentina(arenisca)
 * @version 1.0
 */
public class Snickers extends Dulce{
    /**
     * Constructor para crear un snickers con un número de serie.
     *
     * @param serie Número de serie único para identificar el producto.
     */
    public Snickers(int serie){
        super(serie);
    }
    /**
     * Realiza la acción de consumir el dulce.
     *
     * @return Una cadena de texto que describe que el dulce consumido fue un snickers.
     */
    @Override
    public String consumir() {
        return "mmm snickers";
    }
}
