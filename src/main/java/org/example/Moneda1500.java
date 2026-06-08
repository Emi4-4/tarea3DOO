package org.example;

import java.awt.*;

/**
 * Clase que representa una moneda de 1500.
 * Extiende la clase abstracta Moneda para heredar su comportamiento y
 * capacidades de comparación.
 *
 * @author Valentina (arenisca)
 * @version 1.0
 */
public class Moneda1500 extends Moneda {
    /**
     * Constructor por defecto para la Moneda de 1500.
     */
    public Moneda1500(){
    }
    /**
     * Devuelve el valor de esta moneda.
     *
     * @return El valor entero 1500.
     */
    @Override
    public int getValor() {
        return 1500;
    }
    public void paintComponent(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillOval(x, y, 20, 20);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, 20, 20);
        g.drawString("100", x + 5, y + 14);
    }
}
