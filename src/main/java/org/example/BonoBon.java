package org.example;

import java.awt.*;

/**
 * Clase que representa un dulce del tipo BonoBon.
 * Heredada de la clase Dulce.
 * @author Valentina(arenisca)
 * @version 1.0
 */
public class BonoBon extends Dulce{
    /**
     * Constructor para crear un BonoBon con un número de serie.
     *
     * @param serie Número de serie único para identificar el producto.
     */
    public BonoBon(int serie) {
        super(serie);
    }

    @Override
    public void paintComponent(Graphics g, int ancho, int alto) {
        g.setColor(new Color(244, 208, 63)); // Amarillo/Oro
        g.fillRect(x, y, ancho, alto);

        g.setColor(Color.RED);
        g.fillOval(x + (ancho / 2) - 4, y + (alto / 2) - 4, 8, 8);

        g.setColor(Color.BLACK);
        g.drawRect(x, y, ancho, alto);
    }
    /**
     * Realiza la acción de consumir el dulce.
     *
     * @return Una cadena de texto que describe que el dulce consumido fue un bonobon.
     */
    @Override
    public String consumir() {
        return "mmm bonobon";
    }
}
