package SystemUnivercity;

import javax.swing.*;
import java.awt.*;

public class image extends JPanel {
   private ImageIcon icon;
    public image()
    {

        this.setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        icon=new ImageIcon(getClass().getResource("..\\images\\image1.jpg"));
        icon.paintIcon(this,g,0,0);
    }
}
