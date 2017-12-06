package weather;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CurrentWeatherTests {
    private static final String CURRENT_TEMP_STRING = "Current temperature: 1°C";
    private static final String CITY = "Tallinn";
    private static WeatherRequest request;
    private static CurrentWeather mockedCurrentWeather;
    private static Path path  = Paths.get("src/main/java/files/currentWeatherJson.txt");

    private static JsonObject currentWeatherJson;

    @BeforeClass
    public static void setUpForForAllTests() throws IOException {
        request = new WeatherRequest("Tallinn", "EE");

        JsonParser parser = new JsonParser();
        String jsonString = Files.readAllLines(path).get(0);
        currentWeatherJson = parser.parse(jsonString).getAsJsonObject();

        mockedCurrentWeather = mock(CurrentWeather.class);

    }

    @Test
    public void testCityCoordinatesInRightFormat() {
        when(mockedCurrentWeather.getCityCoordinatesString()).thenReturn("24.75:59.44");
        assertEquals("24.75:59.44", mockedCurrentWeather.getCityCoordinatesString());
    }


    @Test
    public void testIfWeatherForecastIsForRightCity() {
        when(mockedCurrentWeather.city).thenReturn(CITY);
        assertEquals(request.city, mockedCurrentWeather.city);
    }

    @Test
    public void testIfTemperatureInRightFormat() {
        when(mockedCurrentWeather.getCurrentTemperatureString()).thenReturn(CURRENT_TEMP_STRING);
        assertEquals(CURRENT_TEMP_STRING, mockedCurrentWeather.getCurrentTemperatureString());
    }
}
