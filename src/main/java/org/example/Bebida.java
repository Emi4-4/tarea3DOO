package org.example;
/**
 * Clase abstracta que representa un producto del tipo bebida.
 * Sirve como base para productos específicos como CocaCola o Sprite.
 *
 * @author Emiliano(Emi4-4)
 * @author Valentina(arenisca)
 * @version 1.0
 */
abstract class Bebida extends Producto{
    /**
     * Crea una nueva instancia de Bebida con un número de serie.
     *
     * @param serie El número identificador asignado a la bebida.
     */
    public Bebida (int serie){
        super(serie);
    }
}
