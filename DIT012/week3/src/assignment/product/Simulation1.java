package assignment.product;

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

/*
 * A Simulation
 *
 * See : http://nifty.stanford.edu/2014/mccown-schelling-model-segregation/
 *
 * NOTE: This uses JavaFX so application structure a bit different
 * The program starts in method start() far below.
 *
 */
// Extends Application because of JavaFX (just accept)
public class Simulation1 extends Application {

    /*
    // Set this to true if you would like to run test only, see method test() below
    final boolean doTest = false;

    // Anything in this method will be run if doTest (above) is true
    void test() {
        double th = 0.5;   // Simple threshold for testing
        // TODO add tests as needed
    }
    */

    // Enumeration (reference) type for the Actors
    enum Actor {
        BLUE, NONE, RED
    }

    // Enumeration (reference) type for the state of an Actor
    enum State {
        UNSATISFIED,
        NA,        // Not applicable (NA), used for NONEs
        SATISFIED
    }

    // Below are the only accepted instance variables
    // Result (terminating?) is very depending on % empty and threshold, experiment!
    // % of surrounding neighbours that are like me
    double threshold = 0.7;
    Actor[][] world;   // Matrix for all Actors (i.e. the world)
    State[][] state;   // Matrix for the state of all Actors (i.e. the world)
    boolean toggle = true;  // Used in updateWorld

    // **** This is the method called by the timer to update the world ****
    // MUST be like this
    void updateWorld() {
        if (toggle) {
            state = getUnsatisfied(world, threshold);
        } else {
            world = moveUnsatisfied(state, world);
        }
        toggle = !toggle;
    }

    // TODO Create an matrix of Actors (i.e. the world)
    // Called in start() method you don't need to call it. world = initWorld();
    Actor[][] initWorld() {
        //TODO %-distribution of RED,  BLUE, EMPTY
        double[] distribution = {0.25, 0.25, 0.50};

        // TODO Number of elements in world (matrix) must be a square
        int nElements = 900; //Number of cells for the matrix

        Actor[][] w = {
                {Actor.RED, Actor.RED, Actor.NONE},
                {Actor.NONE, Actor.BLUE, Actor.NONE},
                {Actor.RED, Actor.NONE, Actor.BLUE}
        };
        return w;
    }

    //WHICH AGENTS THAT ARE UNSATISFIED
    //TODO Get a matrix indicating which elements are unsatisfied
    State[][] getUnsatisfied(Actor[][] world, double threshold) {
        // TODO
        // This is hard code to avoid exceptions should be replaced
        State[][] s = {
                {State.NA, State.NA, State.NA},
                {State.NA, State.NA, State.NA},
                {State.NA, State.NA, State.NA}
        };
        return s;
    }
    // MOVE UNSATISFIED
    // Update world using state of all Actors
    Actor[][] moveUnsatisfied(State[][] state, Actor[][] world) {
        // TODO
        // Must modify world
        return world;
    }


    // TODO add your methods here

    // TODO CREATE MATRIX OF ACTORS USING nElements and distribution


    // ------- Methods possible to use if you like  -------------

    // Conversion utility
    Actor[][] toMatrix(Actor[] arr) {
        int size = (int) round(sqrt(arr.length));
        Actor[][] matrix = new Actor[size][size];
        for (int i = 0; i < arr.length; i++) {
            matrix[i / size][i % size] = arr[i];
        }
        return matrix;
    }

    // Random shuffling of any reference type array
    <T> void shuffle(T[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i+1);
            T k = arr[i];
            arr[i] = arr[j];
            arr[j] = k;
        }
    }

    // ***** NOTHING to do below this row (you don't need to understand it, it's JavaFX) ***************

    final int width = 400;   // Size for window
    final int height = 400;
    long previousTime = nanoTime();

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create the world
        world = initWorld();

        // Run tests if needed
        //if (doTest) {
        //    test();
         //   exit(0);
        //}


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
                if (elapsedNanos > 250000000) {
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
}
