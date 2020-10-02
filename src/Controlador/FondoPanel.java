
package Controlador;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FondoPanel extends JPanel{
    private Image fondo;
        
    @Override
    public void paint(Graphics g){
        fondo= new ImageIcon(getClass().getResource("/imagen/fondo.jpg")).getImage();
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}
