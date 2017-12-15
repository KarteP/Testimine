package files;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileReaderTests {
    private static final String TEST_FILE_NAME = "readerTest.txt";
    private static final String DATA = "test";

    @Test
    public void testDataIsReadFromFile() {
        FileReader reader = new FileReader();
        String data = reader.readFromFile(TEST_FILE_NAME).get(0);
        assertEquals(DATA, data);
    }
}
