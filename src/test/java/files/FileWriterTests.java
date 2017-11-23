package files;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FileWriterTests {

    @Test
    public void testDataIsWrittenToFile() {
        FileWriter mockedFileWriter = mock(FileWriter.class);
        mockedFileWriter.writeToFile("Tallinn", "userinput.txt");
        verify(mockedFileWriter).writeToFile("Tallinn", "userinput.txt");
    }
}
