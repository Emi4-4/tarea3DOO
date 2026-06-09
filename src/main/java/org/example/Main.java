package org.example;
import interfaz.Ventana;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args){
        int DineroInicial = 5000;
        try {
            String input = JOptionPane.showInputDialog(
                    null, "Ingrese el monto inicial del monedero",
                    "Configuracion del monedero",
                    JOptionPane.QUESTION_MESSAGE);
            if (input != null){
                DineroInicial = Integer.parseInt(input);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null,"Valor invalido introducido, se usara el monto 5000");
        }
        new Ventana(DineroInicial);
    }
}