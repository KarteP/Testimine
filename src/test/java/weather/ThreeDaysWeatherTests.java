package weather;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ThreeDaysWeatherTests {
    private static final String THREE_DAYS_TEMP_STRING = "2017-12-07\n" +
            "Minimum temperature: -0.12°C\n" +
            "Maximum temperature: 0.98°C\n" +
            "2017-12-08\n" +
            "Minimum temperature: 2.02°C\n" +
            "Maximum temperature: 5.1°C\n" +
            "2017-12-09\n" +
            "Minimum temperature: 1.69°C\n" +
            "Maximum temperature: 4.34°C\n";
    private static final String CITY = "Tallinn";
    private static final int NR_OF_DAY_WEATHERS_IN_LIST = 3;

    private WeatherRequest mockedRequest;
    private Path path  = Paths.get("src/main/java/files/threeDaysWeatherJson.txt");
    private ThreeDaysWeather threeDaysWeather;

    @Before
    public void setUpBeforeTest() throws IOException {
        mockedRequest = mock(WeatherRequest.class);
        when(mockedRequest.getCity()).thenReturn(CITY);

        JsonParser parser = new JsonParser();
        List<String> jsonList = Files.readAllLines(path);
        String jsonString = "";
        for (String line: jsonList) {
            jsonString += line;
        }
        JsonObject jsonObjectThreeDaysWeather = parser.parse(jsonString).getAsJsonObject();
        threeDaysWeather = new ThreeDaysWeather(mockedRequest, jsonObjectThreeDaysWeather);
    }

    @Test
    public void testIfWeatherForecastIsForRightCity() {
        assertEquals(mockedRequest.getCity(), threeDaysWeather.city);
    }

    @Test
    public void testIfWeatherForecastForThreeDaysIsGiven() {
        assertEquals(NR_OF_DAY_WEATHERS_IN_LIST, threeDaysWeather.dayWeathers.size());
    }

    @Test
    public void testToString() {
        System.out.println(threeDaysWeather.toString());
        assertEquals(THREE_DAYS_TEMP_STRING, threeDaysWeather.toString());
    }

    @Test
    public void testIfWeatherForecastForRightDaysIsGiven() {
        LocalDate today = LocalDate.of(2017, 12, 6);
        String day1 = today.plusDays(1).toString();
        String day2 = today.plusDays(2).toString();
        String day3 = today.plusDays(3).toString();
        String tempString = threeDaysWeather.toString();

        assertTrue(tempString.contains(day1)
                && tempString.contains(day2)
                && tempString.contains(day3));
    }
}
