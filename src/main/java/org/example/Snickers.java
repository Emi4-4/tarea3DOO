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
        java.awt.Shape clipOriginal = g.getClip();
        g.clipRect(x, y, ancho, alto);


        g.setColor(new Color(0, 0, 0, 80));
        g.fillRect(x + 2, y + 2, ancho, alto);


        g.setColor(new Color(60, 35, 10));
        g.fillRect(x, y, ancho, alto);


        g.setColor(new Color(40, 20, 5));
        int altoBorde = Math.max(2, alto / 12);
        for (int i = x; i < x + ancho; i += 3) {
            g.drawLine(i, y, i, y + altoBorde);
            g.drawLine(i, y + alto - altoBorde, i, y + alto);
        }


        g.setColor(new Color(255, 255, 255, 40));
        g.fillRect(x + 3, y + altoBorde, ancho / 6, alto - (2 * altoBorde));

        int logoAncho = (int) (ancho * 0.8);
        int logoAlto = alto / 3;
        int logoX = x + (ancho - logoAncho) / 2;
        int logoY = y + (alto - logoAlto) / 2;

        g.setColor(new Color(200, 0, 0));
        g.fillRect(logoX, logoY, logoAncho, logoAlto);


        g.setColor(Color.WHITE);
        g.fillRect(logoX + 2, logoY + 2, logoAncho - 4, logoAlto - 4);


        g.setColor(new Color(0, 45, 150));
        String texto = "SN";
        int tamanoFuente = Math.max(9, logoAncho / 2); // Código limpio y reducido

        g.setFont(new Font("Arial Black", Font.BOLD, tamanoFuente));
        FontMetrics fm = g.getFontMetrics();

        int textoX = logoX + (logoAncho - fm.stringWidth(texto)) / 2;
        int textoY = logoY + (logoAlto / 2) + (fm.getAscent() / 3);
        g.drawString(texto, textoX, textoY);

        g.setClip(clipOriginal);

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
