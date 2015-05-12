import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class FlappyViewer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyViewer
{
    private JFrame frame;
    //private JPanel panel;
    private FlappyComponent flappy;
    
    public static void main(String[] args)
    {
        FlappyViewer view = new FlappyViewer();
    }
    /**
     * Default constructor for objects of class FlappyViewer
     */
    public FlappyViewer()
    {
        flappy = new FlappyComponent();
        //panel = new JPanel();
        //panel.add(flappy);
        frame = new JFrame();
        frame.add(flappy);
        frame.addKeyListener(flappy);
        frame.setTitle("Flappy Bird Remake!");
        frame.setSize(480,320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        flappy.repaint();
    }

}
