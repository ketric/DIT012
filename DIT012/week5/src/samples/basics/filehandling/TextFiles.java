package samples.basics.filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * File handling with text files
 * Assuming the file isn't "packed" with the application
 */
public class TextFiles {

    public static void main(String[] args) {
        new TextFiles().program();
    }

    private static final String NEW_LINE = System.lineSeparator();

    private void program() {
        String path = "./src/samples/basics/filehandling";
        try {
            copy(path, "junk.txt", path, "copyofjunk,txt");
        } catch (FileNotFoundException e) {
            // Try to recover or inform user
            e.printStackTrace();   // Just for now
        }
    }

    public void copy(String path1, String source, String path2, String dest)
            throws FileNotFoundException {
        String[] content = readFile(path1, source);
        writeFile(path2, dest, content);
    }

    public void writeFile(String path, String fileName, String[] lines)
            throws FileNotFoundException {
        File f = new File(path + File.separator + fileName);
        // Use try with resources to ensure the out is closed
        try (PrintWriter out = new PrintWriter(f)) {
            for (String line : lines) {
                out.println(line);
            }
        }
    }

    public String[] readFile(String path, String fileName)
            throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        File file = new File(path + File.separator + fileName);
        // Use try with resources to ensure the file is closed
        try (Scanner sc = new Scanner(file)) {
            int i = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.length() > 0) {
                    sb.append(line).append(NEW_LINE);
                }
            }
        }
        String delimiter = NEW_LINE;
        return sb.toString().split(delimiter);
    }

}
