package interfaz;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private PanelComprador comprador;
    private PanelExpendedor expendedor;

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

    public void paintComponent (Graphics grafica){
        super.paintComponent(grafica);
        comprador.repaint();
        expendedor.repaint();
    }
}
