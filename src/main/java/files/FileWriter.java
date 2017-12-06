package files;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriter {

    public String pathString = "src/main/java/files/";

    public void writeToFile(String text, String fileName) {
        pathString += fileName;
        Path path = Paths.get("src/main/java/files/" + fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(text);
        } catch (IOException e) {
            System.out.println("IOException:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
