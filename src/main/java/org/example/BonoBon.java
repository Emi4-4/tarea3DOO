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
        // Definir proporciones
        int margenH = ancho / 4;
        int margenV = alto / 4;
        int cuerpoAncho = ancho - (2 * margenH);
        int cuerpoAlto = alto - (2 * margenV);

        g.setColor(new Color(120, 90, 0));
        int[] xIzq = {x + 2, x + margenH + 2, x + 2};
        int[] yIzq = {y + alto/2 - 17, y + alto/2, y + alto/2 + 17};
        g.fillPolygon(xIzq, yIzq, 3);

        int[] xDer = {x + ancho - 2, x + ancho - margenH - 2, x + ancho - 2};
        int[] yDer = {y + alto/2 - 17, y + alto/2, y + alto/2 + 17};
        g.fillPolygon(xDer, yDer, 3);

        // 2. Extremos del envoltorio
        g.setColor(new Color(244, 208, 63));
        int[] xIzqFin = {x, x + margenH, x};
        int[] yIzqFin = {y + alto/2 - 15, y + alto/2, y + alto/2 + 15};
        g.fillPolygon(xIzqFin, yIzqFin, 3);

        int[] xDerFin = {x + ancho, x + ancho - margenH, x + ancho};
        int[] yDerFin = {y + alto/2 - 15, y + alto/2, y + alto/2 + 15};
        g.fillPolygon(xDerFin, yDerFin, 3);

        // 3. Cuerpo central

        g.setColor(new Color(180, 150, 0));
        g.fillRoundRect(x + margenH, y + margenV, cuerpoAncho, cuerpoAlto, 25, 25);

        // Cuerpo principal
        g.setColor(new Color(255, 220, 80));
        g.fillRoundRect(x + margenH + 2, y + margenV + 2, cuerpoAncho - 4, cuerpoAlto - 4, 25, 25);

        // 4. Detalle de luz
        g.setColor(new Color(255, 255, 255, 180));
        g.fillOval(x + margenH + 10, y + margenV + 8, cuerpoAncho / 3, cuerpoAlto / 2);

        // 5. Logo central
        g.setColor(new Color(150, 0, 0)); // Sombra del logo
        g.fillOval(x + (ancho / 2) - 4, y + (alto / 2) - 3, 10, 10);
        g.setColor(new Color(220, 0, 0)); // Color principal del logo
        g.fillOval(x + (ancho / 2) - 5, y + (alto / 2) - 5, 10, 10);

        // 6. Contornos
        g.setColor(new Color(160, 120, 0));
        g.drawRoundRect(x + margenH, y + margenV, cuerpoAncho, cuerpoAlto, 25, 25);
        g.drawPolygon(xIzqFin, yIzqFin, 3);
        g.drawPolygon(xDerFin, yDerFin, 3);
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
