package samples.slides.catchtherain;

import javafx.geometry.BoundingBox;
import javafx.scene.paint.Color;

/**
 * Class for a raindrop
 */


public class RainDrop {
    private final double x;     // x and y for center
    private double y;
    private final double dy;    // Speed
    private final double radius;
    private final Color color;  // Must remember color

    public RainDrop(double x, double y, double radius, double dy, Color color) {
        this.x = x;
        this.y = y;
        this.dy = dy;
        this.radius = radius;
        this.color = color;
    }

    public void move() {
        y -= dy;
    }

    public BoundingBox getBoundingBox(int screenHeight) {
        int x = (int) (this.x - radius);
        int y = (int) (screenHeight - (this.y + radius)); // Conversion to screen
        int h = (int) (2 * radius);
        int w = (int) (2 * radius);
        return new BoundingBox(x, y, w, h);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDy() {
        return dy;
    }

    public double getRadius() {
        return radius;
    }

    public Color getColor() {
        return color;
    }
}