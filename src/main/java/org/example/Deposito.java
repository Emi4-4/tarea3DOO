package org.example;

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;
/**
 * Clase genérica que representa un depósito para almacenar objetos de tipo E.
 * Funciona tipo FIFO para retiro.
 *
 * @author Valentina (arenisca)
 * @version 1.0
 * @param <E> El tipo de elementos que se almacenarán en este depósito.
 */
public class Deposito<E> {
    /** Lista interna donde se guardan los productos. */
    private final ArrayList<E> Productos;

    private int x;
    private int y;
    /**
     * Crea un nuevo depósito vacío asignándole su ubicación en la interfaz.
     * * @param x Coordenada X relativa dentro del expendedor.
     * @param y Coordenada Y relativa dentro del expendedor.
     */
    public Deposito(int x, int y) {
        this.Productos = new ArrayList<>();
        this.x = x;
        this.y = y;
    }

    public void addProducto(E producto) {
        Productos.add(producto);
        organizarVistas();
    }
    /**
     * Retira y entrega el primer elemento disponible en el depósito.
     *
     * @return El primer objeto de tipo E en la lista, o null si el depósito está vacío.
     */
    public E getProducto(){
        if (Productos.isEmpty()) {
            return null;
        } else {
            E aux = Productos.remove(0);
            organizarVistas();
            return aux;
        }
    }

    private void organizarVistas() {
        for (int i = 0; i < Productos.size(); i++) {
            E elemento = Productos.get(i);
            int posY = this.y + 5 + (i * 15);

            if (elemento instanceof Producto) {
                ((Producto) elemento).setXY(this.x + 5, posY);
            } else if (elemento instanceof Moneda) {
                ((Moneda) elemento).setXY(this.x + 10, posY);
            }
        }
    }

    public int getArraySize() {
        return Productos.size();
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, 50, 100);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, 50, 100);

        for (E elemento : Productos) {
            if (elemento instanceof Producto) {
                ((Producto) elemento).paintComponent(g, 40, 12);
            } else if (elemento instanceof Moneda) {
                ((Moneda) elemento).paintComponent(g);
            }
        }
    }
}
