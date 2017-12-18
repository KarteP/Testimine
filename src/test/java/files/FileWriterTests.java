package files;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FileWriterTests {
    private static final String TEST_TEXT = "Test";
    private static final String TEST_FILE_NAME = "test.txt";
    private static final String EMPTY_TEXT = "";

    @Test
    public void testFileIsCreated() {
        FileWriter writer = new FileWriter();

        writer.writeToFile(TEST_TEXT, TEST_FILE_NAME);
        Path path = Paths.get(writer.pathString);
        assertTrue(Files.exists(path));
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDataIsWrittenToFile() throws IOException {
        FileWriter writer = new FileWriter();

        writer.writeToFile(TEST_TEXT, TEST_FILE_NAME);
        Path path = Paths.get(writer.pathString);
        String data = Files.readAllLines(path).get(0);
        assertEquals(TEST_TEXT, data);

        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test (expected = Exception.class)
    public void testExceptionIsThrown() throws IOException {
        FileWriter writer = new FileWriter();

        writer.writeToFile(EMPTY_TEXT, TEST_FILE_NAME);
        Path path = Paths.get(writer.pathString);
        String data = Files.readAllLines(path).get(0);
        assertEquals(TEST_TEXT, data);
    }
}
