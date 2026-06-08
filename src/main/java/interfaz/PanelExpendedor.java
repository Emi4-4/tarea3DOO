package interfaz;

import org.example.*; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelExpendedor extends JPanel {
    private Expendedor expendedor;
    private JPanel botones;
    private JPanel monedas;
//    private JPanel deposito;
//    private JButton botonCocaCola = new JButton();
//    private JButton botonSprite = new JButton();
//    private JButton botonFanta = new JButton();
//    private JButton botonBonobon = new JButton();
//    private JButton botonSuper8 = new JButton();
//    private JButton botonSnicker = new JButton();

    // debe considerar un numero de productos, dulces y bebidas, para la interfaz
    public PanelExpendedor(int numeroProductos){
        super();
        this.expendedor=new Expendedor(numeroProductos);
        this.setLayout(null);
        this.setBackground(new Color(70, 70, 70));
        this.setPreferredSize(new Dimension(500, 600));

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                expendedor.rellenarDepositosVacios();
                repaint();
            }
        });
    }
    public Expendedor getExpendedor() {
        return expendedor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        expendedor.paintComponent(g);
    }

}
