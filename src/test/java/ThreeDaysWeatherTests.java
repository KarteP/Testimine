import connection.HttpConnection;
import org.junit.BeforeClass;
import org.junit.Test;
import weather.ThreeDaysWeather;
import weather.WeatherRequest;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ThreeDaysWeatherTests {
    private static WeatherRequest request;
    private static ThreeDaysWeather threeDaysWeather;
    private static String threeDaysTemperatures;

    @BeforeClass
    public static void setUpForTest() throws IOException {
        request = new WeatherRequest("Tallinn", "EE");
        threeDaysWeather = new ThreeDaysWeather(request);
        try {
            threeDaysWeather.setJsonObject3DaysWeather(HttpConnection.getWeatherInfoAsJson(
                    "http://api.openweathermap.org/data/2.5/forecast?q=Tallinn,EE&units=" +
                            "metric&APPID=8142ab303ab91d4449a4e5f5685de78d"));
            threeDaysTemperatures = threeDaysWeather.get3DaysTemperatures();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIfWeatherForecastForThreeDaysIsGiven() {
        assertEquals(3, threeDaysWeather.threeDaysMap.size());
    }

    @Test
    public void testIfWeatherForecastForRightDaysIsGiven() {
        LocalDate today = LocalDate.now();
        String day1 = today.plusDays(1).toString();
        String day2 = today.plusDays(2).toString();
        String day3 = today.plusDays(3).toString();
        assertTrue(threeDaysTemperatures.contains(day1)
                && threeDaysTemperatures.contains(day2)
                && threeDaysTemperatures.contains(day3));
    }

    @Test
    public void testLowestAndHighestTemperaturesAreGivenForThreeDays() {
        try {
            for (String date: threeDaysWeather.threeDaysMap.keySet()) {
                ArrayList<Double> temperatures = threeDaysWeather.getLowestAndHighestTemperaturesForThatDay(date);
                assertEquals(2, temperatures.size());
            }
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }
}
