package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PanelPrincipal extends JPanel {
    private PanelComprador comprador;
    private PanelExpendedor expendedor;

    public PanelPrincipal() {
        super();
        comprador = new PanelComprador();
        expendedor = new PanelExpendedor(6);
        comprador.setExpendedor(expendedor);
        this.add(comprador);
        this.add(expendedor);
        this.setBackground(new Color(206, 236, 230));
        this.setLayout(new GridLayout(1,2));

    }

    public void paintComponent (Graphics grafica){
        super.paintComponent(grafica);
    }
}
