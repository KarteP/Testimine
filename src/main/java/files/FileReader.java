package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

    public List<String> readFromFile(String fileName) {
        List<String> lines;
        Path path = Paths.get("src/main/java/files/" + fileName);
        try {
            lines = Files.readAllLines(path);
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
