package org.example;

import java.awt.*;

/**
 * Clase que representa un dulce del tipo super8.
 * Heredada de la clase Dulce.
 * @author Valentina(arenisca)
 * @version 1.0
 */
public class Super8 extends Dulce{
    /**
     * Constructor para crear un super8 con un número de serie.
     *
     * @param serie Número de serie único para identificar el producto.
     */
    public Super8(int serie){
        super(serie);
    }

    @Override
    public void paintComponent(Graphics g, int ancho, int alto) {

        g.setColor(new Color(213, 80, 0));
        g.fillRect(x, y, ancho, alto);

        g.setColor(Color.YELLOW);
        g.setFont(new Font("Arial", Font.BOLD, 10));
        g.drawString("8", x + (ancho / 2) - 3, y + alto - 2);

        g.setColor(Color.BLACK);
        g.drawRect(x, y, ancho, alto);
    }
    /**
     * Realiza la acción de consumir el dulce.
     *
     * @return Una cadena de texto que describe que el dulce consumido fue un super8.
     */
    @Override
    public String consumir() {
        return "mmm super8";
    }
}
