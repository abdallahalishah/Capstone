import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends JPanel
{
    private int movement;
    private ImageIcon icon;
    private Image bg;
    public Background()
    {
        movement = 0;
        icon = new ImageIcon("bg1.png");
        BufferedImage img = new BufferedImage(icon.getIconWidth(),icon.getIconHeight(),
                                            BufferedImage.TYPE_INT_RGB);
        Graphics g = (Graphics)img.createGraphics();
        bg = icon.getImage();
        g.drawImage(bg,0,0,null);
        bg = img;
    }
    
    public void move()
    {
        movement++;
        if (movement % bg.getWidth(null) == 0)
        {
            movement = 0;
        }
    }
    
    public void draw(Graphics g)
    {
        g.drawImage(bg,0-movement,0,null);
        g.drawImage(bg,0-movement+bg.getWidth(null),0,null); 
    }
    


}
