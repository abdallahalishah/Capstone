import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class FlappyComponent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyComponent extends JComponent implements ActionListener,KeyListener
{
    private Background back;
    private Bird bird;
    private Pipe pipe1;
    private Pipe pipe2;
    private Pipe pipe3;
    private Score score;
    private Timer tm = new Timer(15,this);
    private Graphics g;
    private int birdVelocity = 1;
    private int birdCount = 1;
    private int scoreCount = 1;
    /**
     * Default constructor for objects of class FlappyComponent
     */
    public FlappyComponent()
    {
        super.paintComponent(g);
        bird = new Bird();
        back = new Background();
        score = new Score();
        pipe1 = new Pipe(240+480/2-20);
        pipe2 = new Pipe(240+2*(480/2));
        pipe3 = new Pipe(480+3*(480/3));
    }

    public void paintComponent(Graphics g) //throws InterruptedException
    {
        //while (true)
        //Thread t1 = new Thread(this);
        //t1.start();
        back.draw(g);
        pipe1.draw(g);
        pipe2.draw(g);
        //t1.sleep(50);
        if ((!pipe1.checkCollision(bird.getRekt()) && !pipe2.checkCollision(bird.getRekt())))
        {
            if (!bird.leaves())
            {
                //pipe3.draw(g);

                bird.draw(g);
                score.draw(g);
                tm.start();
            }
            else
            {
                score.drawGameOver(g);
            }
        }
        else
        {
            score.drawGameOver(g);
        }

    }

    public void actionPerformed(ActionEvent e)
    {
        if ((!pipe1.checkCollision(bird.getRekt()) && !pipe2.checkCollision(bird.getRekt())))
        {   
            if (!bird.leaves())
            {
                birdCount++;
                scoreCount++;
                if (birdCount % 5 == 0)
                {
                    birdVelocity++;
                    birdCount=1;
                }
                if (scoreCount % (87) == 0)
                {
                    score.update();
                    scoreCount=0;
                }

                back.move();

                bird.move(birdVelocity);
                pipe1.move();
                pipe2.move();
                //score.update();
                //pipe3.move();
            }
        }
        else
        {
            bird.move(5);
        }
        //else 
        {
            //score.drawGameOver(g);
        }

        repaint();
    }

    public void keyPressed(KeyEvent e)
    {
        // if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_UP)
        {
            //    birdVelocity = -15;
        }
    }

    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_UP)
        {
            birdVelocity = -5;
        }

    }

    public void keyTyped(KeyEvent e){}
}
