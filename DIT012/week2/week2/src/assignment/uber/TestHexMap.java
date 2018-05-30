package assignment.uber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Math.*;

/**
 *  Program to test generation of hex maps (for games)
 *  Using HexMap and Hex
 */
public class TestHexMap extends JPanel implements ActionListener {

    public static void main(String[] args) {
        new TestHexMap().program();
    }

    final int width = 400;
    final int height = 400;
    Hex[] hs1;
    Hex[] hs2;
    Hex[] hs3;
    Hex[] hs4;
    Timer t = new Timer(2000, this);

    void program() {
        generateMaps();
        initGraphics();
        t.setDelay(500);
        t.start();
    }

    // This method is called automatically by Java2d
    // All drawing should be done here
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        //g2.drawRect(50, 50, 300, 300);
        drawFilledHexes(g2, hs1, Color.RED);
        drawFilledHexes(g2, hs2, Color.BLUE);
        drawFilledHexes(g2, hs3, Color.ORANGE);
        drawFilledHexes(g2, hs4, Color.GREEN);

        /*drawFilledHex(g2, hs1[0], Color.BLACK);
        drawFilledHex(g2, hs2[0], Color.BLACK);
        drawFilledHex(g2, hs3[0], Color.BLACK);
        drawFilledHex(g2, hs4[0], Color.BLACK);


        drawFilledHex(g2, hs1[i], Color.RED);
        drawFilledHex(g2, hs2[i], Color.BLUE);
        drawFilledHex(g2, hs3[i], Color.ORANGE);
        drawFilledHex(g2, hs4[i], Color.GREEN);*/
       // i++;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        generateMaps();
        repaint();
    }

    void generateMaps() {
        HexMap hm = new HexMap();
        hs1 = hm.randomWalkHexes(100, 100, 10, 30);
        hs2 = hm.randomWalkHexes(300, 100, 10, 30);
        hs3 = hm.randomWalkHexes(100, 300, 10, 30);
        hs4 = hm.randomWalkHexes(300, 300, 10, 30);
    }

    void drawFilledHexes(Graphics2D g2, Hex[] hexes, Color color) {
        drawFilledHex(g2, hexes[0], Color.BLACK);
        for (int i = 1; i < hexes.length; i++) {
            drawFilledHex(g2, hexes[i], color);
        }
    }

    void drawFilledHex(Graphics2D g2, Hex hex, Color color) {
        int xi = round(hex.x);  // Must have round
        int yi = round(hex.y);
        int in = round(hex.innerRadius);
        int out = round(hex.outerRadius);
        int halfOut = round(hex.outerRadius / 2);

        int[] xs = {xi, xi + in, xi + in, xi, xi - in, xi - in, xi};
        int[] ys = {height - yi + out, height - yi + halfOut, height - yi - halfOut,
                height - yi - out, height - yi - halfOut, height - yi + halfOut};
        Color old = g2.getColor();
        g2.setColor(color);
        g2.fillPolygon(xs, ys, 6);
        g2.setColor(old);
    }

    void drawHexes(Graphics2D g2, Hex[] hexes) {
        g2.setColor(Color.RED);
        drawHex(g2, hexes[0]);
        g2.setColor(Color.BLACK);
        for (int i = 0; i < hexes.length; i++) {
            drawHex(g2, hexes[i]);
        }
    }

    void drawHex(Graphics2D g2, Hex hex) {
        int xi = (int) hex.x;
        int yi = (int) hex.y;
        int in = (int) hex.innerRadius;
        int out = (int) hex.outerRadius;
        int halfOut = (int) round(hex.outerRadius / 2);

        int[] xs = {xi, xi + in, xi + in, xi, xi - in, xi - in, xi};
        int[] ys = {height - yi + out, height - yi + halfOut, height - yi - halfOut,
                height - yi - out, height - yi - halfOut, height - yi + halfOut};
        g2.drawPolygon(xs, ys, 6);
    }

    void initGraphics() {
        setPreferredSize(new Dimension(width, height));
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(this);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
