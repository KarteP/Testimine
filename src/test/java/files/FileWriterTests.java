package files;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FileWriterTests {
    private static final String TEST_TEXT = "Test";
    private static final String TEST_FILE_NAME = "test.txt";

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

    @Test
    public void testWriteToFileIsInvoked() {
        FileWriter mockedFileWriter = mock(FileWriter.class);
        mockedFileWriter.writeToFile("Tallinn", "test.txt");
        verify(mockedFileWriter).writeToFile("Tallinn", "test.txt");
    }
}
