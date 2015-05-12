import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Scanner;
import java.io.*;
/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score
{
    private int current;
    private Font font;
    private Font font2 = new Font("Algerian", Font.BOLD, 76);
    private Font font3 = new Font("Bauhaus 93",Font.BOLD, 32);
    /**
     * Constructor for objects of class Score
     */
    public Score()
    {
        font = new Font(null, Font.BOLD, 24);
    }

    public void draw(Graphics g)
    {
        g.setFont(font);
        String text = ""+current;
        if (text.length() == 1)
        {
            g.drawString(""+current, 480/2-12,40);
        }
        if (text.length() == 2)
        {
            g.drawString(""+current, 480/2-24,40);
        }
        if (text.length() == 3)
        {
            g.drawString(""+current, 480/2-36,40);
        }
    }

    public void update()
    {
        current++;
    }

    public void drawGameOver(Graphics g)
    {
        String text = "You lose";
        g.setFont(font2);
        g.setColor(Color.RED);
        g.drawString(text,38,120);
        g.setFont(font3);
        g.setColor(Color.BLUE);
        g.drawString("Score: "+current,480/2-100,180);
        int high = 0;
        try
        {
            File f = new File("highscore.txt");
        
            Scanner scan = new Scanner(f);
            high = scan.nextInt();
            if(current > high)
            {
                PrintWriter w = new PrintWriter(f);
                w.println(current);
                w.close();
                high = current;
            }
            scan.close();
        }
        catch(Exception e)
        {
           // PrintWriter w = new PrintWriter("highscore.txt");
           // w.println(current);
           // w.close();
           // high = current;
        }
        
        
        g.drawString("High Score: "+high,480/2-100,230);

    }
}
