package samples.slides;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
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
 * Basic animation (bit crude not so smooth ... but simple )
 * Created by hajo
 */
public class Animation extends Application {


    final int width = 400;
    final int height = 400;
    final Random rand = new Random();
    MovingBlock block;

    void initWorld() {
        block = createMovingBlock();
    }

    void updateWorld() {
        if (isInsideWorld()) {
            block.move();
        } else {
            block = createMovingBlock();
        }
    }

    boolean isInsideWorld() {
        return inSideX() && insideY();

    }

    boolean inSideX(){
        return 0 < block.x && block.x + block.width < width;
    }

    boolean insideY(){
        return 0 < block.y - block.height && block.y < height;
    }

    // Utility
    MovingBlock createMovingBlock() {
        return new MovingBlock(rand.nextInt(width / 2), rand.nextInt(height / 2),
                rand.nextInt(50) + 20, rand.nextInt(50) + 20, Color.rgb(rand.nextInt(255),
                rand.nextInt(255), rand.nextInt(255)));
    }

    // ------ Handle keyboard ----------------

    void handleKeysPressed(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
                block.setVelocity(0, 1);
                break;
            case DOWN:
                block.setVelocity(0, -1);
                break;
            case RIGHT:
                block.setVelocity(1, 0);
                break;
            case LEFT:
                block.setVelocity(-1, 0);
                break;
            default:
                ;
        }
    }

    void handleKeysReleased(KeyEvent event) {
        block.setVelocity(0, 0);
    }

    // ---------- Class for moving blocks ----------------

    class MovingBlock {
        final Color color;
        double[] vel = {0, 0};  // Velocity, dx, dy
        double x;     // Top
        double y;     // Left
        double width;
        double height;

        MovingBlock(double x, double y, double width, double height, Color color) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;

            this.color = color;
        }

        // Assume user normalize and < maxSpeed
        void setVelocity(double dx, double dy) {
            vel[0] = dx;
            vel[1] = dy;
        }

        // Move using velocity
        void move() {
            x += vel[0];     // x = x + vel[0];
            y += vel[1];
        }
    }

    // -----Below is just initialization and graphics ----------------------

    @Override
    public void start(Stage primaryStage) throws Exception {

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
        primaryStage.setTitle("Animation");
        primaryStage.show();
    }


    public void renderWorld(GraphicsContext g) {
        g.clearRect(0, 0, width, height);
        drawBlock(g, block);
    }

    void drawBlock(GraphicsContext g, MovingBlock b) {
        g.fillText("x: " + b.x + " y: " + b.y, 10, 10);
        Paint old = g.getFill();
        g.setFill(b.color);
        g.fillRect(b.x, height - b.y, b.width, b.height);
        g.setFill(old);
    }
}




