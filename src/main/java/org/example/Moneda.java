package org.example;
/**
 * Clase abstracta que define el comportamiento base de una moneda en el sistema.
 * Implementa la interfaz Comparable para permitir la ordenación y comparación
 * de monedas basada en su valor.
 *
 * @author Valentina (arenisca)
 * @version 1.0
 */
public abstract class Moneda implements Comparable<Moneda> {
    /**
     * Constructor por defecto de la clase Moneda.
     */
    public Moneda() {}
    /**
     * Método abstracto para obtener el valor monetario de la moneda.
     *
     * @return El valor entero de la moneda.
     */
    public abstract int getValor();
    /**
     * Compara esta moneda con otra moneda basándose en sus valores.
     *
     * @param moneda La moneda con la que se va a comparar.
     * @return Un entero negativo, cero o un entero positivo si el valor de esta moneda
     *         es menor, igual o mayor que el de la moneda especificada.
     */
    public int compareTo(Moneda moneda){
        return Integer.compare(this.getValor(), moneda.getValor());
    }

}
