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

    private static WeatherRequest request;
    private static CurrentWeather mockedCurrentWeather;
    private static Path path  = Paths.get("src/main/java/files/currentWeatherJson.txt");
    private static CurrentWeather currentWeather;

    @BeforeClass
    public static void setUpForForAllTests() throws IOException {
        request = new WeatherRequest(CITY, "EE");
        mockedCurrentWeather = mock(CurrentWeather.class);

        JsonParser parser = new JsonParser();
        String jsonString = Files.readAllLines(path).get(0);
        JsonObject jsonObjectCurrentWeather = parser.parse(jsonString).getAsJsonObject();
        currentWeather = new CurrentWeather(request, jsonObjectCurrentWeather);
    }

    @Test
    public void testMockedCurrentWeatherGetCityCoordinates() {
        when(mockedCurrentWeather.getCityCoordinates()).thenReturn(COORDINATES);
        assertEquals(COORDINATES, mockedCurrentWeather.getCityCoordinates());
    }

    @Test
    public void testMockedCurrentWeatherGetCurrentTemperatureString() {
        when(mockedCurrentWeather.getCurrentTemp()).thenReturn(CURRENT_TEMP);
        assertEquals(CURRENT_TEMP, mockedCurrentWeather.getCurrentTemp(), 0.001);
    }

    @Test
    public void testIfWeatherForecastIsForRightCity() {
        assertEquals(request.city, currentWeather.city);
    }

    @Test
    public void testGetCityCoordinates() {
        assertEquals(COORDINATES, currentWeather.getCityCoordinates());
    }

    @Test
    public void testGetCurrentTemperature() {
        assertEquals(1.0, currentWeather.getCurrentTemp(), 0.001);
    }

    @Test
    public void testGetCurrentTemperatureString() {
        assertEquals(CURRENT_TEMP_STRING, currentWeather.toString());
    }
}
