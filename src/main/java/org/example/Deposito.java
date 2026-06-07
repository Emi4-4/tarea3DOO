package org.example;

import java.util.ArrayList;
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
    /**
     * Crea un nuevo depósito vacío.
     */
    public Deposito() {
        Productos=new ArrayList<>();
    }
    /**
     * Agrega un elemento al final del depósito.
     *
     * @param producto El objeto de tipo E que se desea guardar.
     */
    public void addProducto(E producto) {
        Productos.add(producto);
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
            return Productos.remove(0);
        }
    }
}
