package org.example;

import java.awt.*;

/**
 * Clase que representa un dulce del tipo snickers.
 * Heredada de la clase Dulce.
 * @author Valentina(arenisca)
 * @version 1.0
 */
public class Snickers extends Dulce{
    /**
     * Constructor para crear un snickers con un número de serie.
     *
     * @param serie Número de serie único para identificar el producto.
     */
    public Snickers(int serie){
        super(serie);
    }

    @Override
    public void paintComponent(Graphics g, int ancho, int alto) {
        g.setColor(new Color(74, 40, 18));
        g.fillRect(x, y, ancho, alto);

        g.setColor(Color.WHITE);
        g.fillRect(x + 4, y + 2, ancho - 8, alto - 4);

        g.setColor(Color.BLUE);
        g.fillRect(x + 6, y + 4, ancho - 12, alto - 8);

        g.setColor(Color.BLACK);
        g.drawRect(x, y, ancho, alto);
    }
    /**
     * Realiza la acción de consumir el dulce.
     *
     * @return Una cadena de texto que describe que el dulce consumido fue un snickers.
     */
    @Override
    public String consumir() {
        return "mmm snickers";
    }
}
