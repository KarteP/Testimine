package files;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FileReaderTests {

    @Test
    public void testDataIsReadFromFile() {
        FileReader mockedFileReader = mock(FileReader.class);
        String fileName = "input.txt";
        mockedFileReader.readFromFile(fileName);
        verify(mockedFileReader).readFromFile(fileName);
    }
}
