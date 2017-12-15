package weather;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CurrentWeatherTests {
    private static final double CURRENT_TEMP = 1.0;
    private static final String CURRENT_TEMP_STRING = "Current temperature: 1.0°C";
    private static final String CITY = "Tallinn";
    private static final String COORDINATES = "24.75:59.44";

    private static WeatherRequest mockedRequest;
    private static Path path  = Paths.get("src/main/java/files/currentWeatherJson.txt");
    private static CurrentWeather currentWeather;

    @BeforeClass
    public static void setUpForForAllTests() throws IOException {
        mockedRequest = mock(WeatherRequest.class);
        when(mockedRequest.getCity()).thenReturn(CITY);

        JsonParser parser = new JsonParser();
        String jsonString = Files.readAllLines(path).get(0);
        JsonObject jsonObjectCurrentWeather = parser.parse(jsonString).getAsJsonObject();
        currentWeather = new CurrentWeather(mockedRequest, jsonObjectCurrentWeather);
    }

    @Test
    public void testIfWeatherForecastIsForRightCity() {
        assertEquals(mockedRequest.getCity(), currentWeather.city);
    }

    @Test
    public void testGetCityCoordinates() {
        assertEquals(COORDINATES, currentWeather.getCityCoordinates());
    }

    @Test
    public void testGetCurrentTemperature() {
        assertEquals(CURRENT_TEMP, currentWeather.getCurrentTemp(), 0.001);
    }

    @Test
    public void testToString() {
        assertEquals(CURRENT_TEMP_STRING, currentWeather.toString());
    }

}
