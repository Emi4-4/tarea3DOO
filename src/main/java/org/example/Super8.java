package org.example;
/**
 * Clase que representa un dulce del tipo super8.
 * Heredada de la clase Dulce.
 * @author Valentina(arenisca)
 * @version 1.0
 */
public class Super8 extends Dulce{
    /**
     * Constructor para crear un super8 con un número de serie.
     *
     * @param serie Número de serie único para identificar el producto.
     */
    public Super8(int serie){
        super(serie);
    }
    /**
     * Realiza la acción de consumir el dulce.
     *
     * @return Una cadena de texto que describe que el dulce consumido fue un super8.
     */
    @Override
    public String consumir() {
        return "mmm super8";
    }
}
