package assignments.basics;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

/**
 * Exercising some graphics primitives from Java 2D
 *
 * Tip: Use some loops in the paint method.
 */
public class ModernArt extends JPanel {

    public static void main(String[] args) {
        new ModernArt().program();
    }

    void program() {
        // All we need to do is call this.
        initGraphics();
    }

    // This is our standard method to paint in graphical programs
    // This method is automagically called by Java. We don't need to call it
    public void paint(Graphics g) {
        // Do some default painting (this statement always first)
        super.paint(g);

        // g2 is your painting toolbox (this statement always second )
        Graphics2D g2 = (Graphics2D) g;

        // Use graphic primitives from toolbox to draw, you try ....!
        g2.setColor(MAGENTA);
        g2.drawLine(0, 100, 300, 200);
        g2.setColor(GREEN);
        g2.drawLine(200, 200, 100, 100);


    }

    // ------- Nothing to below ------------------------------------

    // This is our standard method to start up the graphics
    void initGraphics() {
        int width = 400;
        int height = 400;
        setPreferredSize(new Dimension(width, height));
        JFrame window = new JFrame();
        window.setTitle("Modern art");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(this);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
