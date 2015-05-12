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
import java.awt.Rectangle;
/**
 * Write a description of class Bird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bird
{
    /** description of instance variable x (add comment for each instance variable) */
    private int x;
    private int y;
    private int velY;
    private int movement;
    private ImageIcon icon;
    private Image img;
    /**
     * Default constructor for objects of class Bird
     */
    public Bird()
    {
        icon = new ImageIcon("bird.png");
        img = icon.getImage();
        x = 240 - img.getWidth(null)/2;
        y = 320/2 - img.getHeight(null)/2;
    }

    public void move(int amount)
    {
        velY = amount;
        if (velY > 8){velY=8;}
    }

    public boolean leaves()
    {
        if (y > 320 - img.getWidth(null))
        {
            return true;
        }
        return false;
    }

    public Rectangle getRekt()
    {
        return new Rectangle(x,y,img.getWidth(null),img.getHeight(null));
    }

    public void draw(Graphics g)
    {
        y += velY;
        g.drawImage(img,x,y,null);
    }

}
