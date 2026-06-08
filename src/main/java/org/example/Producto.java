package org.example;
/**
 * Clase abstracta que representa un producto genérico dentro del expendedor.
 * Define la estructura básica y el comportamiento común de todos los productos.
 *
 * @author Valentina(arenisca)
 * @author Emiliano(Emi4-4)
 * @version 1.0
 */
import java.awt.Graphics;
public abstract class Producto{
    protected int serie;
    /**
     * Crea una instancia de un producto con un identificador específico.
     *
     * @param serie El número de serie asignado al producto.
     */
    protected int x;
    protected int y;

    public Producto(int serie) {
        this.serie=serie;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void paintComponent(Graphics g, int ancho, int alto);
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