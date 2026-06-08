package org.example;

import java.awt.*;

/**
 * Clase que representa una moneda de 500.
 * Extiende la clase abstracta Moneda para heredar su comportamiento y
 * capacidades de comparación.
 *
 * @author Valentina (arenisca)
 * @version 1.0
 */
public class Moneda500 extends Moneda {
    /**
     * Constructor por defecto para la Moneda de 500.
     */
    public Moneda500(){
    }
    /**
     * Devuelve el valor de esta moneda.
     *
     * @return El valor entero 500.
     */
    @Override
    public int getValor() {
        return 500;
    }
    public void paintComponent(Graphics g) {
        g.setColor(Color.PINK);
        g.fillOval(x, y, 20, 20);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, 20, 20);
        g.drawString("100", x + 5, y + 14);
    }
}
