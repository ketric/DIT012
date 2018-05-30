package samples.basics;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import static java.lang.System.exit;

/**
 * Using key events and a key listener
 *
 * This will have a key delay
 */
public class KeyEvents extends Application {


    final int width = 400;
    final int height = 400;
    final Square s = new Square();


    void handleKeys(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
                s.y++;
                break;
            case DOWN:
                s.y--;
                break;
            case LEFT:
                s.x--;
                break;
            case RIGHT:
                s.x++;
                break;
            default:
                ;
        }
        renderWorld(gc);
    }
    // --------- Trivial class -------------------

    class Square {
        double x = 100;   // Upper left corner x, y
        double y = 100;
        double width = 20;
        double height = 20;
    }

    // Set up JavaFX graphics ---------------------------------
    GraphicsContext gc;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();
        Canvas canvas = new Canvas(width, height);
        root.getChildren().addAll(canvas);
        gc = canvas.getGraphicsContext2D();

        Scene scene = new Scene(root);
        // Set the key handler
        scene.setOnKeyPressed(this::handleKeys);
        primaryStage.setScene(scene);
        primaryStage.setTitle("KeyEvents");
        primaryStage.show();

        renderWorld(gc);

    }

    void renderWorld(GraphicsContext g) {
        g.clearRect(0, 0, width, height);
        g.fillText("Use arrow keys to move me", 10, 10);
        g.fillText("This approach will result in a keyboard delay", 10, 25);
        g.fillRect((int) s.x, (int) (height - s.y), (int) s.width, (int) s.height);
    }

}




