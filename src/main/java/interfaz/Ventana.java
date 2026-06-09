package interfaz;

import javax.swing.*;

public class Ventana extends JFrame {
    public Ventana(){
        super();
        int DineroInicial = 5000;
        String input = JOptionPane.showInputDialog(
                null, "Ingrese el monto inicial en el monedero:",
                "Configuracion del comprador",
                JOptionPane.QUESTION_MESSAGE
        );
        try {
            if (input != null && !input.isEmpty()) {
                DineroInicial = Integer.parseInt(input);}
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null, "Cantidad invalida, se usara $5000"
                );
            }
        setTitle("Expendedor de comida");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1080,1350); // el tamaño puede cambiar

        PanelPrincipal panel = new PanelPrincipal(DineroInicial);
        add(panel);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
