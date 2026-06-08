package org.example;

import java.awt.*;

/**
 * Clase que representa una bebida tipo sprite.
 * Heredada de la clase Bebida.
 * @author Valentina(arenisca)
 * @version 1.0
 */
public class Sprite extends Bebida {
    /**
     * Constructor para crear una instancia de sprite.
     *
     * @param serie Número de serie del producto.
     */
    public Sprite(int serie) {
        super(serie);
    }

    @Override
    public void paintComponent(Graphics g, int ancho, int alto) {

        g.setColor(new Color(0, 150, 57));
        g.fillRect(x, y, ancho, alto);


        g.setColor(new Color(255, 221, 0));
        g.fillRect(x + 6, y + (alto / 2) - 2, 6, 4);


        g.setColor(Color.BLACK);
        g.drawRect(x, y, ancho, alto);
    }
    /**
     * Entrega el nombre de la bebida al ser consumida.
     *
     * @return Una cadena de texto con el nombre "sprite".
     */
    public String consumir() {
        return "sprite";
    }
}