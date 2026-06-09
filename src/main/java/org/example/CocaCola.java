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
        // 1. Sombra base
        g.setColor(new Color(150, 0, 0));
        g.fillRoundRect(x, y, ancho, alto, 15, 15);

        // 2. Cuerpo principal (
        g.setColor(new Color(220, 0, 0));
        g.fillRoundRect(x + 2, y, ancho - 4, alto, 15, 15);


        g.setColor(new Color(255, 255, 255, 60));
        g.fillRoundRect(x + 5, y + 5, ancho / 3, alto - 10, 10, 10);

        // 4. Sombra interior lateral
        g.setColor(new Color(0, 0, 0, 50));
        g.fillRoundRect(x + ancho - 8, y, 8, alto, 15, 15);

        // 5. Etiqueta
        g.setColor(Color.WHITE);
        g.fillRect(x, y + alto/3, ancho, alto/4);

        g.setColor(new Color(200, 0, 0, 100));
        g.fillRect(x, y + alto/3 + (alto/8)/2, ancho, 2);

        // 6. Burbujas
        g.setColor(new Color(255, 255, 255, 100));
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < 8; i++) {
            int posX = x + 10 + rand.nextInt(ancho - 25);
            int posY = y + alto/3 + rand.nextInt(alto/4);
            g.fillOval(posX, posY, 3, 3);
        }

        // 7. Tapa y Borde final
        g.setColor(new Color(30, 30, 30));
        g.fillRect(x + ancho/4, y, ancho/2, 5);

        g.setColor(new Color(100, 0, 0)); // Borde oscuro
        g.drawRoundRect(x, y, ancho, alto, 15, 15);
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
