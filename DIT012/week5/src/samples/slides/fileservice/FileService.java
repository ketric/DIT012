package samples.slides.fileservice;

import javafx.scene.image.Image;

import java.io.*;
import java.net.URL;

/*
   Separating out a technical service from the application
   This has no logical impact on the program (like the GUI)
   It's just a service to the application

    Pure static class (a collection of methods, no state)

    For usage: See Main

 */
public class FileService {

    // Can't instantiate
    private FileService(){}

    public static Image getImage(String fileName, double requestedWidth, double requestedHeight) {
        URL url = FileService.class.getResource("icons/" + fileName);
        return new Image(url.toString(), requestedWidth, requestedHeight, true, true);
    }

    public static String[] getFileNames() {
        URL url = FileService.class.getResource("icons");
        File folder = new File(url.getPath());
        File[] listOfFiles = folder.listFiles();
        String[] names = new String[listOfFiles.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = listOfFiles[i].getName();
        }
        return names;
    }

}
