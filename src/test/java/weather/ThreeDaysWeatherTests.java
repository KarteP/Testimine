package weather;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ThreeDaysWeatherTests {
    private static final String THREE_DAYS_TEMP_STRING = "2017-12-08\n" +
            "Minimum temperature: 0.98°C\n" +
            "Maximum temperature: 5.1°C\n" +
            "2017-12-09\n" +
            "Minimum temperature: 1.69°C\n" +
            "Maximum temperature: 4.34°C\n" +
            "2017-12-10\n" +
            "Minimum temperature: 0.73°C\n" +
            "Maximum temperature: 3.17°C\n";
    private static final String CITY = "Tallinn";

    private static WeatherRequest request;
    private static Path path  = Paths.get("src/main/java/files/threeDaysWeatherJson.txt");
    private static ThreeDaysWeather threeDaysWeather;


    @BeforeClass
    public static void setUpForTest() throws IOException {
        request = new WeatherRequest(CITY, "EE");

        JsonParser parser = new JsonParser();
        List<String> jsonList = Files.readAllLines(path);
        String jsonString = "";
        for (String line: jsonList) {
            jsonString += line;
        }
        JsonObject jsonObjectThreeDaysWeather = parser.parse(jsonString).getAsJsonObject();
        threeDaysWeather = new ThreeDaysWeather(request, jsonObjectThreeDaysWeather);

    }

    @Test
    public void testIfWeatherForecastIsForRightCity() {
        assertEquals(request.city, threeDaysWeather.city);
    }

    @Test
    public void testIfWeatherForecastForThreeDaysIsGiven() {
        assertEquals(3, threeDaysWeather.dayWeathers.size());
    }

    @Test
    public void testToString() {
        System.out.println(threeDaysWeather.toString());
        assertEquals(THREE_DAYS_TEMP_STRING, threeDaysWeather.toString());
    }

    @Test
    public void testIfWeatherForecastForRightDaysIsGiven() {
        LocalDate today = LocalDate.now();
        String day1 = today.plusDays(1).toString();
        String day2 = today.plusDays(2).toString();
        String day3 = today.plusDays(3).toString();
        String tempString = threeDaysWeather.toString();
        assertTrue(tempString.contains(day1)
                && tempString.contains(day2)
                && tempString.contains(day3));
    }
}
