package org.example;

import java.awt.*;

/**
 * Clase que representa una bebida tipo fanta.
 * Heredada de la clase Bebida.
 * @author Valentina(arenisca)
 * @version 1.0
 */
public class Fanta extends Bebida{
    /**
     * Constructor para crear una instancia de fanta.
     *
     * @param serie Número de serie del producto.
     */
    public Fanta(int serie){
        super(serie);
    }

    @Override
    public void paintComponent(Graphics g, int ancho, int alto) {

        g.setColor(new Color(242, 103, 34));
        g.fillRect(x, y, ancho, alto);


        g.setColor(new Color(0, 40, 135));
        g.fillRect(x + 4, y + 2, ancho - 8, 3);


        g.setColor(Color.BLACK);
        g.drawRect(x, y, ancho, alto);
    }

    /**
     * Entrega el nombre de la bebida al ser consumida.
     *
     * @return Una cadena de texto con el nombre "fanta".
     */
    @Override
    public String consumir() {
        return "glupglup Fanta";
    }
}
