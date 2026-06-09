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
        // 1. Base del cuerpo
        g.setColor(new Color(200, 100, 0));
        g.fillRoundRect(x, y, ancho, alto, 15, 15);

        // 2. Cuerpo principal
        g.setColor(new Color(255, 140, 0));
        g.fillRoundRect(x + 2, y, ancho - 4, alto, 15, 15);

        // 3. REFLEJO LUMINOSO
        g.setColor(new Color(255, 255, 255, 80));
        g.fillRoundRect(x + 5, y + 5, ancho/3, alto - 10, 10, 10);

        // 4. Sombra interior
        g.setColor(new Color(0, 0, 0, 30));
        g.fillRoundRect(x + ancho - 10, y, 10, alto, 15, 15);

        // 5. Etiqueta
        g.setColor(new Color(255, 255, 255, 150));
        g.fillOval(x + 5, y + alto/3, ancho - 10, alto/4);

        // 6. Burbujas
        g.setColor(new Color(255, 255, 255, 180));
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < 15; i++) {
            g.fillOval(x + 10 + rand.nextInt(ancho - 25), y + alto/3 + rand.nextInt(alto/4), 3, 3);
        }

        // 7. Tapa y Borde
        g.setColor(new Color(50, 50, 50));
        g.fillRect(x + ancho/4, y, ancho/2, 5);
        g.setColor(new Color(150, 70, 0));
        g.drawRoundRect(x, y, ancho, alto, 15, 15);
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
