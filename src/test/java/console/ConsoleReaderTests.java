package console;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ConsoleReaderTests {
    private static final String SCANNER_INPUT = "Tallinn";

    @Test
    public void testGetCityNameFromUserInputReturnsRightCity() {
        ConsoleReader reader = new ConsoleReader();
        Scanner scanner = new Scanner(SCANNER_INPUT);
        String cityName = reader.getCityNameFromUserInput(scanner);
        assertEquals("Tallinn", cityName);
    }
}
