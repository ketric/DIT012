package assignment.uber;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.lang.System.out;

/**
 * Start of a JavaFX GUI
 *
 *
 */
public class JavaFXGUI extends Application {


    private Stage stage;

    // -------- Menu handling -----------------

    private void exit(Event e) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Do you really want to exit?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
        }
    }

    private void open(ActionEvent e) {
        out.println("Open");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {

        }
    }

    private void save(Event e) {
        out.println("Save");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {

        }
    }



    private final int width = 600;
    private final int height = 600;


    @Override
    public void start(final Stage primaryStage) {
        stage = primaryStage;

        // Create different GUI parts
        MenuBar menu = getMenu();
        VBox root = new VBox(); // VBox is single column vertical layout, the root node in the Scene

        // Connect GUI parts
        root.getChildren().addAll(menu);


        // Add GUI to Scene
        Scene scene = new Scene(root, width, height);
        scene.setFill(Color.OLDLACE);

        // Put Scene on stage (not back stage :-))and show it
        primaryStage.setTitle("JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private MenuBar getMenu() {

        // --- Menu File
        Menu menuFile = new Menu("File");
        MenuItem[] menuFileItems = {
                new MenuItemExt("Open", this::open, KeyCode.O, KeyCombination.CONTROL_DOWN),
                new MenuItemExt("Save", this::save),
                new MenuItemExt("Quit", this::exit)
        };
        menuFile.getItems().addAll(menuFileItems);

        // --- Menu Edit
        Menu menuEdit = new Menu("Edit");
        MenuItem[] menuEditItems = {
                new MenuItemExt("Undo", null, KeyCode.Z, KeyCombination.CONTROL_DOWN)
        };
        menuEdit.getItems().addAll(menuEditItems);

        // --- Menu About
        Menu menuAbout = new Menu("About");
        MenuItem[] menuAboutItems = {new MenuItemExt("About", e -> {
        })};
        menuAbout.getItems().addAll(menuAboutItems);

        // -- The bar for all menus
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuFile, menuEdit, menuAbout);
        return menuBar;
    }




    public static void main(String[] args) {
        launch();
    }


    //  Helper class with more useful constructor
    private static class MenuItemExt extends MenuItem {
        public MenuItemExt(String label, EventHandler<ActionEvent> e) {
            super(label);
            setOnAction(e);
        }

        public MenuItemExt(String label, EventHandler<ActionEvent> e, KeyCode keyCode,
                           KeyCombination.Modifier modifier) {
            this(label, e);
            setAccelerator(new KeyCodeCombination(keyCode, modifier));
        }
    }


}
