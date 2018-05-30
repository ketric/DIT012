package samples.basics.state;


import javafx.application.Application;

import javafx.event.Event;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.URL;
import java.text.DecimalFormat;


/*
 *   This is to show the interaction between application state
 *   and the view of the state in the GUI
 *
 */
// This is the view of the (JavaFX) application
public class LightGUI extends Application {

    // The application
    Light c = new Light();

    // Handle view actions
    private void handleButtons(Event e) {

        // Check which button
        Button button = (Button) e.getTarget();

        // Update application state, get state value back
        Light.State state = c.update((int) button.getUserData());

        // Use state to to display view of application state
        switch (state) {
            case ON:
                view.setViewport(onMask);
                break;
            case OFF:
                view.setViewport(offMask);
                break;
            default:
                throw new IllegalArgumentException("Bad Memory State");
        }
    }

    private void showUpTime(Event e) {
        if( c.getState() == Light.State.OFF ) {
            double d = c.getTotalUpTime();
            // Seems not to work
            DecimalFormat df = new DecimalFormat("0000.00");
            String s = df.format(d);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Total uptime");
            alert.setContentText("Sec =" + s);
            alert.show();
        }
    }

    // --------------  Set up GUI --------------

    ImageView view = new ImageView();
    Rectangle2D offMask = new Rectangle2D(150, 0, 300, 150);
    Rectangle2D onMask = new Rectangle2D(0, 0, 150, 150);

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Handle resources packed with the application
        URL url = getClass().getResource("lightbulb.png");
        Image i = new Image(url.toString());
        view.setImage(i);
        view.setViewport(offMask);

        HBox hb = new HBox();
        Button b = new Button("ON");
        b.setUserData(1);
        b.setOnAction(this::handleButtons);   // Connect button to handler
        hb.getChildren().add(b);
        b = new Button("OFF");
        b.setUserData(0);
        b.setOnAction(this::handleButtons);  // Connect button to handler
        hb.getChildren().add(b);

        b = new Button("Get up time");
        b.setUserData(0);
        b.setOnAction(this::showUpTime);  // Connect button to handler
        hb.getChildren().add(b);

        VBox root = new VBox();
        root.getChildren().addAll(view);
        root.getChildren().addAll(hb);

        Scene scene = new Scene(root, 300, 300);

        primaryStage.setTitle("Light");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
