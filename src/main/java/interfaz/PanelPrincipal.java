package interfaz;

import javax.swing.*;
import java.awt.*;

/**
 * Panel principal de la aplicación.
 * Contiene el panel del comprador y del expendedor, organizados en dos columnas.
 * @author Valentina(arenisca)
 * @author Lenin(Chamo0312)
 * @version 1.0
 */
public class PanelPrincipal extends JPanel {
    private PanelComprador comprador;
    private PanelExpendedor expendedor;

    /**
     * Crea el panel principal y conecta la interfaz del comprador con el expendedor.
     * @param DineroInicial Saldo inicial del monedero del comprador.
     */
    public PanelPrincipal(int DineroInicial) {
        super();
        expendedor = new PanelExpendedor(6);
        comprador = new PanelComprador(DineroInicial);
        comprador.setExpendedor(expendedor);
        this.add(comprador);
        this.add(expendedor);
        this.setBackground(new Color(206, 236, 230));
        this.setLayout(new GridLayout(1,2));

    }

    /**
     * Actualiza la representacion grafica de los componentes en el panel principal.
     * @param grafica contexto grafico utilizado para dibujar.
     */
    public void paintComponent (Graphics grafica){
        super.paintComponent(grafica);
        comprador.repaint();
        expendedor.repaint();
    }
}
