package interfaz;

import org.example.Expendedor;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel {
    private Expendedor expendedor;
    private JPanel botones;
    private JPanel monedas;
    private JPanel deposito;
    private JButton botonCocaCola = new JButton();
    private JButton botonSprite = new JButton();
    private JButton botonFanta = new JButton();
    private JButton botonBonobon = new JButton();
    private JButton botonSuper8 = new JButton();
    private JButton botonSnicker = new JButton();

    // debe considerar un numero de productos, dulces y bebidas, para la interfaz
    public PanelExpendedor(int numeroProductos){
        super();
        expendedor=new Expendedor(numeroProductos);
        this.setLayout(null);

        botones=new JPanel(new GridLayout(4,1));
        botones.setBounds(getX(),100,100,100);
        botones.setVisible(true);
        this.add(botones);

        monedas=new JPanel(new GridLayout());
        monedas.setBounds(50,50,50,50);
        monedas.setBackground(new Color(6, 66, 99));
        this.add(monedas);




    }

}
