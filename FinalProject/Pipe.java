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
import java.util.Random;
import java.awt.Rectangle;

public class Pipe
{
    /** description of instance variable x (add comment for each instance variable) */
    private int x;
    private int y;
    private int ySpeed=3;
    private int num;
    private Random gen;
    private ImageIcon icon1;
    private ImageIcon icon2;
    private Image pipeTop;
    private Image pipeBot;
    /**
     * Default constructor for objects of class Pipe
     */
    public Pipe(int xLoc)
    {
        x = xLoc;
        icon1 = new ImageIcon("top.png");
        icon2 = new ImageIcon("bot.png");
        pipeTop = icon1.getImage();
        pipeBot = icon2.getImage();
        gen = new Random();
        num = gen.nextInt(100);
        y = 0-(pipeTop.getHeight(null)-50)+num;
    }

    public void move()
    {
        x -= 3;
        y += ySpeed;
        if (y < (0-(pipeTop.getHeight(null)-50)))
        {
            ySpeed = 2;
        }
        if (y > (0-(pipeTop.getHeight(null)-50)+pipeTop.getWidth(null)+60))
        {
            ySpeed = -2;
        }
        if (x < (0-pipeTop.getWidth(null)))
        {
            x = 480;
            num = gen.nextInt(100);
            y = 0-(pipeTop.getHeight(null)-50)+num;
        }
    }
    
    public boolean checkCollision(Rectangle bird)
    {
        Rectangle top = new Rectangle(x,y,pipeTop.getWidth(null),pipeTop.getHeight(null));
        Rectangle bot = new Rectangle(x,y+pipeTop.getWidth(null)+300,
                    pipeTop.getWidth(null),pipeTop.getHeight(null));
        return top.intersects(bird) || bot.intersects(bird);
    }

    public int getWidth()
    {
        return pipeTop.getWidth(null);
    }

    public void draw(Graphics g)
    {
        g.drawImage(pipeTop,x,y,null);
        g.drawImage(pipeBot,x,y+pipeTop.getWidth(null)+300,null);
    }

}
