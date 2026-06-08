package interfaz;

import javax.swing.*;

public class Ventana extends JFrame {
    public Ventana(){
        super();
        setTitle("Expendedor de comida");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1080,1350); // el tamaño puede cambiar

        PanelPrincipal panel = new PanelPrincipal();
        add(panel);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
