package org.example;

import java.awt.*;
import java.util.Random;

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
        // 1. Sombra base
        g.setColor(new Color(0, 100, 30));
        g.fillRoundRect(x, y, ancho, alto, 15, 15);

        // 2. Cuerpo principal
        g.setColor(new Color(0, 180, 70));
        g.fillRoundRect(x + 2, y, ancho - 4, alto, 15, 15);

        // 3. REFLEJO LUMINOSO
        g.setColor(new Color(255, 255, 255, 70));
        g.fillRoundRect(x + 5, y + 5, ancho / 3, alto - 10, 10, 10);

        // 4. Sombra interior lateral
        g.setColor(new Color(0, 0, 0, 40));
        g.fillRoundRect(x + ancho - 8, y, 8, alto, 15, 15);

        // 5. Logotipo
        g.setColor(new Color(255, 230, 0));
        g.fillOval(x + 10, y + alto/3, ancho - 20, alto/5);

        // 6. Burbujas
        g.setColor(new Color(255, 255, 255, 150));
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < 12; i++) {
            int posX = x + 10 + rand.nextInt(ancho - 25);
            int posY = y + alto/3 + rand.nextInt(alto/3);
            int tam = 2 + rand.nextInt(4);
            g.fillOval(posX, posY, tam, tam);
        }

        // 7. Tapa y Borde
        g.setColor(new Color(50, 50, 50));
        g.fillRect(x + ancho/4, y, ancho/2, 5);

        g.setColor(new Color(0, 80, 40));
        g.drawRoundRect(x, y, ancho, alto, 15, 15);
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