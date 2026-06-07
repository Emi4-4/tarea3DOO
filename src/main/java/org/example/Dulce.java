package org.example;
/**
 * Clase abstracta que representa un producto de tipo dulce.
 * Sirve como base para implementar dulces específicos.
 *
 * @author Valentina (arenisca)
 * @author Emiliano (Emi4-4)
 * @version 1.0
 */
abstract class Dulce extends Producto {
    /**
     * Constructor para crear una instancia de Dulce con un número de serie.
     *
     * @param serie Número de serie que identifica al dulce.
     */
    public Dulce (int serie){
        super(serie);
    }
}