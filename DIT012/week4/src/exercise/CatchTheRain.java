package exercise;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.geometry.BoundingBox;
import javafx.stage.Stage;

import java.util.Random;

import static java.lang.System.*;

/**
 * Catching raindrops in bucket (possibly a game?)
 */
public class CatchTheRain extends Application {


    // Set this to true if you would like to run test only, see method test() below
    final boolean doTest = false;

    final int width = 500;
    final int height = 500;

    final Random rand = new Random();
    Bucket bucket;
    final RainDrop[] drops = new RainDrop[10];
    int points = 0;

    void test() {
        // Testing

    }

    // ---- Game logic ---------
    void initWorld() {
        //TODO bucket = new Bucket(...??...);
        for (int i = 0; i < drops.length; i++) {
            drops[i] = createRainDrop();
        }
    }


    void updateWorld() {
       // TODO
    }

    // - Methods for collisions ----------------------


    // TODO

    // -- Handle keyboard -----------------------

    void handleKeysPressed(KeyEvent event) {
        // TODO
        switch (event.getCode()) {
            case LEFT:
            case RIGHT:
            default:
                ;
        }
    }

    void handleKeysReleased(KeyEvent event) {
       // TODO
    }

    // -- Utilities -----------------------

    RainDrop createRainDrop() {
        Color c = Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
        // TODO return new RainDrop(...???...);
        return null;
    }



    //----- Classes --------------------------------

    class RainDrop {
        // TODO
    }

    class Bucket {
        // TODO
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


    void renderWorld(GraphicsContext g) {
        g.clearRect(0, 0, width, height);
        g.fillText("Points: " + points, 10, 20);
        drawBucket(g, bucket);
        drawRainDrops(g, drops);
    }

    // Draw all drops
    void drawRainDrops(GraphicsContext g, RainDrop[] drops) {
        for (int i = 0; i < drops.length; i++) {
            if (drops[i] != null) {
                drawRainDrop(g, drops[i]);
            }
        }
    }

    // A single drop
    void drawRainDrop(GraphicsContext g, RainDrop d) {
        Paint old = g.getFill();
       // TODO  g.setFill(...???...);
       // TODO  g.fillOval(...???...));
        g.setFill(old);
    }

    void drawBucket(GraphicsContext g, Bucket b) {
        Paint old = g.getFill();
        // TODO g.setFill(...??...);
        // TODO g.fillRect(..???... );
        g.setFill(old);
    }

}
