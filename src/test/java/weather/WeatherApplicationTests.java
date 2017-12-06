package weather;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherApplicationTests {
    private static final String CITY_NAME = "Tallinn";
    private static final String INPUT_FILE = "inputTest.txt";
    private static final String WEATHER_INFO_STRING = "Tallinn\n" +
            "Coordinates 24.75:59.44\n" +
            "Current temperature: 1.0°C\n" +
            "2017-12-07\n" +
            "Minimum temperature: -0.14°C\n" +
            "Maximum temperature: 2.02°C\n" +
            "2017-12-08\n" +
            "Minimum temperature: 4.02°C\n" +
            "Maximum temperature: 5.1°C\n" +
            "2017-12-09\n" +
            "Minimum temperature: 1.15°C\n" +
            "Maximum temperature: 4.34°C\n";

    private static WeatherReport mockedReport;
    private static WeatherApplication application;

    @BeforeClass
    public static void setUpForTests() throws IOException {
        mockedReport = mock(WeatherReport.class);
        application = new WeatherApplication(mockedReport);

        when(mockedReport.getWeatherInfoString(CITY_NAME)).thenReturn(WEATHER_INFO_STRING);
    }

    @Test
    public void testWriteWeatherInfoForCitiesInFileToDifferentFiles() throws IOException {
        application.writeWeatherInfoForCitiesInFileToDifferentFiles(INPUT_FILE);
    }

    /**
    @Test
    public void testGetWeatherInfoFromConsoleInput() throws IOException {
        Scanner scanner = new Scanner(CITY_NAME);
        application.getWeatherInfoFromConsoleInput(scanner);
    }
    **/
}
