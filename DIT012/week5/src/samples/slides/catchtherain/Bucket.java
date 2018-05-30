package samples.slides.catchtherain;

import javafx.geometry.BoundingBox;
import javafx.scene.paint.Color;

/**
 * Class for a bucket
 */


public class Bucket {
    private final Color color;
    private final double width;
    private final double height;
    private double dx;
    private double x;   // Left
    private final double y;   // Top

    public Bucket(double x, double y, double width, double height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;

    }

    public void move() {
        x += dx;
    }

    public void setSpeed(int dx) {
        this.dx = dx;
    }

    // Using javafx
    public BoundingBox getBoundingBox(int screenHeight) {
        int x = (int) (this.x);
        int y = (int) (screenHeight - this.y);  // Conversion to screen
        int h = (int) height;
        int w = (int) width;
        return new BoundingBox(x, y, w, h);
    }

    public Color getColor() {
        return color;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getDx() {
        return dx;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
