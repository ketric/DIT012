package samples.slides.catchtherain;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.BoundingBox;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.Random;

import static java.lang.System.exit;

/**
 * Catching raindrops in bucket (possibly a game?)
 */
public class CatchTheRain extends Application {


    // Set this to true if you would like to run test only, see method test() below
    private final boolean doTest = false;

    private final int width = 500;
    private final int height = 500;

    private final Random rand = new Random();
    private final Bucket bucket = new Bucket(width / 2, 40, 40, 40, Color.BLUE);
    private final RainDrop[] drops = new RainDrop[10];
    private int points = 0;

    private void test() {
        // Testing
        /*Bucket b = new Bucket(15, 15 , 10 , 10 , 0 , null);
        RainDrop d = new RainDrop(10, 10 , 10 , 0 , null);
        Rectangle bb = b.getBoundingBox();
        Rectangle db = d.getBoundingBox();
        out.println( bb.intersects(db));*/
    }

    // ---- Game logic ---------
    private void initWorld() {
        for (int i = 0; i < drops.length; i++) {
            drops[i] = createRainDrop();
        }
    }


    private void updateWorld() {
        for (int i = 0; i < drops.length; i++) {
            if (drops[i] != null) {
                drops[i].move();
                if (hitFloor(drops[i])) {
                    drops[i] = createRainDrop();
                }
                if (hitBucket(bucket, drops[i])) {
                    drops[i] = createRainDrop();
                    points++;
                }
            }
        }
        bucket.move();
    }

    // Not a perfect collision
    private boolean hitBucket(Bucket b, RainDrop d) {
        BoundingBox br = b.getBoundingBox(height);
        BoundingBox dr = d.getBoundingBox(height);
        return br.intersects(dr);
    }

    private boolean hitFloor(RainDrop d) {
        //out.println("hit floor");
        return d.getBoundingBox(height).getMinY() > height;
    }


    private void handleKeysPressed(KeyEvent event) {
        switch (event.getCode()) {
            case LEFT:
                bucket.setSpeed(speed(-2, 0 < bucket.getX()));
                break;
            case RIGHT:
                bucket.setSpeed(speed(2, bucket.getX() + bucket.getWidth() < width));
                break;
            default:
                ;
        }
    }

    private void handleKeysReleased(KeyEvent event) {
        bucket.setSpeed(0);
    }

    // -- Utilities -----------------------

    private RainDrop createRainDrop() {
        Color c = Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
        return new RainDrop(rand.nextInt(width), height - 20,
                rand.nextInt(10) + 2, rand.nextInt(3) + 1, c);
    }

    private int speed(int s, boolean b) {
        if (b) {
            return s;
        } else {
            return 0;
        }
    }

    // ****  Below is JavaFX, graphics and timer, nothing to do ****

    @Override
    public void start(Stage primaryStage) throws Exception {

        if (doTest) {
            test();
            exit(0);
        }

        initWorld();

        Group root = new Group();
        Canvas canvas = new Canvas(width, height);
        root.getChildren().addAll(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        new AnimationTimer() {
            // Param not used
            public void handle(long currentNanoTime) {
                updateWorld();
                renderWorld(gc);

            }
        }.start();

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(this::handleKeysPressed);
        scene.setOnKeyReleased(this::handleKeysReleased);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Catch the Rain");
        primaryStage.show();
    }


    private void renderWorld(GraphicsContext g) {
        g.clearRect(0, 0, width, height);
        g.fillText("Points: " + points, 10, 20);
        drawBucket(g, bucket);
        drawRainDrops(g, drops);
    }

    // Draw all drops
    private void drawRainDrops(GraphicsContext g, RainDrop[] drops) {
        for (int i = 0; i < drops.length; i++) {
            if (drops[i] != null) {
                drawRainDrop(g, drops[i]);
            }
        }
    }

    // A single drop
    private void drawRainDrop(GraphicsContext g, RainDrop d) {
        Paint old = g.getFill();
        g.setFill(d.getColor());
        g.fillOval((int) (d.getX() - d.getRadius()), (int) (height - (d.getY() + d.getRadius())),
                (int) (2 * d.getRadius()), (int) (2 * d.getRadius()));
        g.setFill(old);
    }

    private void drawBucket(GraphicsContext g, Bucket b) {
        Paint old = g.getFill();
        g.setFill(b.getColor());
        g.fillRect((int) (b.getX()), (int) (height - (b.getY())),
                (int) (b.getWidth()), (int) (b.getHeight()));
        g.setFill(old);
    }

}
