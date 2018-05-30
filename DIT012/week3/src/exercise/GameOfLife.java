package exercise;

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
import static java.lang.System.exit;
import static java.lang.System.nanoTime;

/**
 * Conway's game of life is a cellular automaton devised by the
 * mathematician John Conway.
 * See https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
 */
public class GameOfLife extends Application {

    // Set this to true if you would like to run test only, see method test() below
    final boolean doTest = false;

    // Anything in this method will be run if doTest (above) is true
    void test() {

    }

    // Enum (reference) type for state of Cells
    enum Cell {
        DEAD, ALIVE;
    }

    final Random rand = new Random();
    // Hard coded for testing (later you generate world)
    Cell[][] world;


    Cell[][] initWorld() {
        // TODO
        // Hard coded for now, you should generate the world
        Cell[][] w = {
                {Cell.ALIVE, Cell.ALIVE, Cell.DEAD},
                {Cell.ALIVE, Cell.DEAD, Cell.DEAD},
                {Cell.DEAD, Cell.DEAD, Cell.ALIVE},

        };
        return w;
    }

    // Method called by the timer
    void updateWorld() {
        world = nextGeneration(world);
    }



    // Avoid instance variables
    Cell[][] nextGeneration(Cell[][] world) {
        // TODO change the world
        return world;
    }


    // TODO add methods here

    // ---- Utilities to use if oyu like
    Cell[][] toMatrix(Cell[] arr) {
        int size = (int) round(sqrt(arr.length));
        Cell[][] matrix = new Cell[size][size];
        for (int i = 0; i < arr.length; i++) {
            matrix[i / size][i % size] = arr[i];
        }
        return matrix;
    }

    // Random shuffling of any reference type array
    <T> void shuffle(T[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i);
            T c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
        }
    }

    // -------- Below is JavaFX nothing to do --------------
    final int width = 400;
    final int height = 400;
    final int delay = 1000;

    public void drawWorld(GraphicsContext g) {

        int size = world.length;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int x = 10 * col + 50;
                int y = 10 * row + 50;
                drawCell(g, x, y, world[row][col]);
            }
        }

    }

    void drawCell(GraphicsContext g, int x, int y, Cell cell) {
        if (cell == Cell.ALIVE) {
            g.setFill(Color.RED);
        } else {
            g.setFill(Color.WHITE);
        }
        g.fillOval(x, y, 10, 10);
    }

    long previousTime = nanoTime();
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
                if (elapsedNanos > 400000000) {
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

}
