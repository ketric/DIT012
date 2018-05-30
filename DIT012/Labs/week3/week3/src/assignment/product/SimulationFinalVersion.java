package assignment.product;

import javafx.application.Application;

/**
 * Created by BenJ on 2016-11-20.
 */

/** Libraries ------**/
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import static java.lang.System.*;

//---------------------------------------------------------
/*
public class SimulationFinalVersion extends Application {

    // JAVA FX
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Run tests if needed
        if (doTest) {
            test();
            exit(0);
        }

        // Create the world
        world = initWorld();

        // JavaFX stuff, don't bother
        Group root = new Group();
        Canvas canvas = new Canvas(width, height);
        root.getChildren().addAll(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Create a timer
        AnimationTimer timer = new AnimationTimer() {
            // This method called by FX supplying the current time
            public void handle(long currentNanoTime) {
                long elapsedNanos = currentNanoTime - previousTime;
                if (elapsedNanos > 25000000) {
                    updateWorld();
                    drawWorld(gc);
                    previousTime = currentNanoTime;
                }
            }
        };
        // Create a scene and connect to the stage
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulation");
        primaryStage.show();

        timer.start();  // Start simulation
    }

    // Paint the state of the world to the screen
    public void drawWorld(GraphicsContext g) {
        int size = world.length;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int x = 10 * col + 50;
                int y = 10 * row + 50;

                if (world[row][col] == Actor.RED) {
                    g.setFill(Color.RED);
                } else if (world[row][col] == Actor.BLUE) {
                    g.setFill(Color.BLUE);
                } else {
                    g.setFill(Color.WHITE);
                }
                g.fillOval(x, y, 10, 10);

            }
        }
    }

    // Test
    void test() {
        double th = 0.5;   // Simple threshold for testing
        // TODO add tests as needed
    }

    //------------------------------------------------------------

    // Final variables
    final boolean doTest = false;
    final int width = 400;   // Size for window
    final int height = 400;
    long previousTime = nanoTime();
    static Random rand = new Random();
    static int indexRow;
    static int indexColumn;

    // Variables for intializing:
    double threshold = 0.85;
    Actor[][] world;
    State[][] state;
    boolean toggle = true;

//------------------------------------------------------------

    // Enumerations:
    enum Actor {BLUE, NONE, RED}
    enum State {UNSATISFIED, SATISFIED, NA} // Not applicable (NA), used for NONEs

    //------------------------------------------------------------
    // Methods:
    // A. Given Methods
    void updateWorld() {
        if (toggle) {
            state = getUnsatisfied(world, threshold);
        } else {
            world = moveUnsatisfied(state, world);
        }
        toggle = !toggle;
    }

    // B. Methods to define:

    //1. Make a map of random colours(3 variations: Red, Blue, None):

    //2. Make a map of states(3 variations: Unsatisfied and satisfied, NA)
    //2.1 Get all the state
    //2.2 Determine the state for each elem by looking at the colours of their neighbors

    //3. Move unstatisdfied elems to an empty spots
    //3.1 Find possible empty spots
}
*/