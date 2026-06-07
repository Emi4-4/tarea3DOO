package org.example;
/**
 * Clase abstracta que representa un producto genérico dentro del expendedor.
 * Define la estructura básica y el comportamiento común de todos los productos.
 *
 * @author Valentina(arenisca)
 * @author Emiliano(Emi4-4)
 * @version 1.0
 */
abstract class Producto{
    protected int serie;
    /**
     * Crea una instancia de un producto con un identificador específico.
     *
     * @param serie El número de serie asignado al producto.
     */
    public Producto(int serie) {
        this.serie=serie;
    }
    /**
     * Método abstracto para consumir el producto.
     * Cada subclase debe implementar este método
     *
     * @return Un String que representa lo que se consumio.
     */
    public abstract String consumir();
    /**
     * Obtiene el número de serie del producto.
     *
     * @return El número de serie entero.
     */
    public int getSerie(){
        return serie;
    }
}