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
        java.awt.Shape clipOriginal = g.getClip();
        g.clipRect(x, y, ancho, alto);


        g.setColor(new Color(0, 0, 0, 80));
        g.fillRect(x + 2, y + 2, ancho, alto);

        g.setColor(new Color(20, 20, 20));
        g.fillRect(x, y, ancho, alto);


        g.setColor(new Color(70, 70, 70));
        int altoBorde = Math.max(2, alto / 10);
        for (int i = x; i < x + ancho; i += 3) {
            g.drawLine(i, y, i, y + altoBorde);
            g.drawLine(i, y + alto - altoBorde, i, y + alto);
        }


        g.setColor(new Color(255, 255, 255, 40));
        g.fillRect(x + 2, y + altoBorde, ancho / 6, alto - (2 * altoBorde));


        int nestleSize = Math.min(ancho / 2, alto / 4);
        int nestleX = x + (ancho - nestleSize) / 2;
        int nestleY = y + altoBorde + 2;

        g.setColor(new Color(220, 0, 0));
        g.fillOval(nestleX, nestleY, nestleSize, nestleSize);

        g.setColor(Color.WHITE);
        int fontNSize = Math.max(nestleSize / 2, 6);
        g.setFont(new Font("Arial", Font.BOLD, fontNSize));
        FontMetrics fmN = g.getFontMetrics();

        g.drawString("N", nestleX + (nestleSize - fmN.stringWidth("N")) / 2, nestleY + (nestleSize + fmN.getAscent()) / 2 - 1);

        String texto = "S8";
        int tamanoFuente = (ancho / 2) + 2;
        if (tamanoFuente < 10) tamanoFuente = 10;

        g.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, tamanoFuente));
        FontMetrics fm = g.getFontMetrics();


        int textoX = x + (ancho - fm.stringWidth(texto)) / 2;
        int espacioYRestante = (alto - altoBorde) - (nestleY - y + nestleSize);
        int textoY = nestleY + nestleSize + (espacioYRestante / 2) + (fm.getAscent() / 3);

        g.setColor(Color.BLACK);
        g.drawString(texto, textoX - 1, textoY - 1);
        g.drawString(texto, textoX + 1, textoY + 1);

        g.setColor(new Color(220, 0, 0));
        g.drawString(texto, textoX, textoY + 1);

        g.setColor(new Color(255, 230, 0));
        g.drawString(texto, textoX, textoY);


        g.setClip(clipOriginal);

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
