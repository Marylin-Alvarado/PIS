package controlador.utiles;

import java.awt.Color;
import javax.swing.JPanel;

public class PanelItem extends JPanel {

    /**
     * Metodo de panel item para la grafica
     */
    public PanelItem() {
        setBackground(Color.WHITE);
        setLayout(new WrapLayout(WrapLayout.LEFT, 10, 10));
    }
}
