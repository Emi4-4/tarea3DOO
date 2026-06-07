package interfaz;

import javax.swing.*;
import java.awt.*;
import org.example.Expendedor;

public class PanelComprador extends JPanel {
    private PanelExpendedor expendedor;


    public PanelComprador() {
        super();
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill =GridBagConstraints.BOTH;
        c.gridx=0;
        c.gridy=0;
        c.weightx=1;
        c.weighty=1;
        //c.insets =new Insets(20,20,20,20);




    }

    public void clickMouse() {

    }
    public void setExpendedor(PanelExpendedor expendedor){
        this.expendedor=expendedor;
    }
}
