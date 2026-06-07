package org.example;
/**
 * Clase que representa un dulce del tipo BonoBon.
 * Heredada de la clase Dulce.
 * @author Valentina(arenisca)
 * @version 1.0
 */
public class BonoBon extends Dulce{
    /**
     * Constructor para crear un BonoBon con un número de serie.
     *
     * @param serie Número de serie único para identificar el producto.
     */
    public BonoBon(int serie) {
        super(serie);
    }
    /**
     * Realiza la acción de consumir el dulce.
     *
     * @return Una cadena de texto que describe que el dulce consumido fue un bonobon.
     */
    @Override
    public String consumir() {
        return "mmm bonobon";
    }
}
