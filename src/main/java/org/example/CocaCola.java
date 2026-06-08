package org.example;

import java.awt.*;

/**
 * Clase que representa una bebida tipo CocaCola.
 * Heredada de la clase Bebida.
 * @author Valentina(arenisca)
 * @version 1.0
 */
public class CocaCola extends Bebida {
    /**
     * Constructor para crear una instancia de CocaCola.
     *
     * @param serie Número de serie del producto.
     */
    public CocaCola(int serie) {
        super(serie);
    }

    @Override
    public void paintComponent(Graphics g, int ancho, int alto) {

        g.setColor(new Color(211, 47, 47));
        g.fillRect(x, y, ancho, alto);

        g.setColor(Color.WHITE);
        g.fillRect(x + 4, y + (alto / 2) - 1, ancho - 8, 2);

        g.setColor(Color.BLACK);
        g.drawRect(x, y, ancho, alto);
    }
    /**
     * Entrega el nombre de la bebida al ser consumida.
     *
     * @return Una cadena de texto con el nombre "cocacola".
     */
    @Override
    public String consumir() {
        return "cocacola";
    }
}
