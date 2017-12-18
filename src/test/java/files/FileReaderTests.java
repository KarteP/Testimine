package files;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileReaderTests {
    private static final String TEST_FILE_NAME = "readerTest.txt";
    private static final String FILE_THAT_DOES_NOT_EXIST = "noFile.txt";
    private static final String DATA = "test";

    @Test
    public void testDataIsReadFromFile() {
        FileReader reader = new FileReader();
        String data = reader.readFromFile(TEST_FILE_NAME).get(0);
        assertEquals(DATA, data);
    }

    @Test (expected = Exception.class)
    public void testExceptionIsThrown() {
        FileReader reader = new FileReader();
        String data = reader.readFromFile(FILE_THAT_DOES_NOT_EXIST).get(0);
    }
}
