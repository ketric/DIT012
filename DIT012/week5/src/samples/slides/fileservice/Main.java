package samples.slides.fileservice;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static java.lang.System.out;

/**
 * This will use the file service
 * NOTE: Depends on JavaFX MUST run like JavaFX application
 */
public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        String[] names = FileService.getFileNames();

        out.println(names.length == 11);  // 11 files in icons directory

        Image image = FileService.getImage("bike.gif", 100, 100);
        out.println(image != null);
    }
}
