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
        this.setBackground(new Color(220, 220, 220));
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

        // 1. Cuerpo de la máquina (Rojo)
        g.setColor(new Color(200, 0, 0));
        g.fillRect(20, 20, 320, 500);

        // 2. Vidrio de la vitrina
        g.setColor(new Color(200, 220, 255));
        g.fillRect(40, 40, 270, 350);
        g.setColor(Color.BLACK);
        g.drawRect(40, 40, 270, 350);
        g.setColor(new Color(255, 255, 255, 50));
        g.fillRect(45, 45, 150, 340);
        g.setColor(new Color(255, 255, 255, 30));
        g.fillRect(40, 40, 220, 350);

        // 3. Estantes
        g.setColor(Color.GRAY);
        for (int i = 1; i <= 5; i++) {
            g.fillRect(40, 40 + (i * 60), 270, 5);
        }

        // 4. Bandeja de salida
        g.setColor(new Color(150, 150, 150));
        g.fillRect(60, 420, 230, 70);
        g.setColor(Color.BLACK);
        g.drawRect(60, 420, 230, 70);
        g.drawString("PUSH", 160, 460);

        // 5. DIBUJAR PRODUCTOS (Llamamos a nuestra nueva lógica)
        g.setColor(Color.BLACK);
        dibujarFila(g, expendedor.getCocacola(), 50, 50, Color.RED);
        dibujarFila(g, expendedor.getSprite(), 50, 110, Color.GREEN);
        dibujarFila(g, expendedor.getFanta(), 50, 170, Color.ORANGE);
        dibujarFila(g, expendedor.getSuper8(), 50, 230, Color.YELLOW);
        dibujarFila(g, expendedor.getSnickers(), 50, 290, Color.MAGENTA);
        dibujarFila(g, expendedor.getBonobon(), 50, 350, Color.PINK);
    }
    private void dibujarFila(Graphics g, Deposito<Producto> dep, int x, int y, Color color) {
        for (int i =0 ; i < Math.min(dep.getArraySize(), 6); i++) {
            Producto p = dep.getProductoEnPosicion(i);
            p.setXY(x + (i * 45), y);
            p.paintComponent(g, 30, 40);
        }
    }
}
