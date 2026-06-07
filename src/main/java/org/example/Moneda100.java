package org.example;
/**
 * Clase que representa una moneda de 100.
 * Extiende la clase abstracta Moneda para heredar su comportamiento y
 * capacidades de comparación.
 *
 * @author Valentina (arenisca)
 * @version 1.0
 */
public class Moneda100 extends Moneda {
    /**
     * Constructor por defecto para la Moneda de 100.
     */
    public Moneda100() {

    }
    /**
     * Devuelve el valor de esta moneda.
     *
     * @return El valor entero 100.
     */
    @Override
    public int getValor() {
        return 100;
    }
}
