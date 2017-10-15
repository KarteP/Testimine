import org.junit.Test;
import weather.ThreeDaysWeather;
import weather.WeatherRequest;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ThreeDaysWeatherTests {

    @Test
    public void testIfWeatherForecastForThreeDaysIsGiven() {
        try {
            WeatherRequest request = new WeatherRequest("Tallinn", 1.00);
            ThreeDaysWeather threeDaysWeather = new ThreeDaysWeather(request);
            assertEquals(3, threeDaysWeather.threeDaysMap.size());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    public void testIfWeatherForecastForRightDaysIsGiven() {
        try {
            WeatherRequest request = new WeatherRequest("Tallinn", 1.0);
            ThreeDaysWeather threeDaysWeather = new ThreeDaysWeather(request);
            assertEquals(3, threeDaysWeather.threeDaysMap.size());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    public void testLowestAndHighestTemperaturesAreGivenForThreeDays() {
        try {
            WeatherRequest request = new WeatherRequest("Tallinn", 1.0);

            ThreeDaysWeather threeDaysWeather = new ThreeDaysWeather(request);
            for (String date: threeDaysWeather.threeDaysMap.keySet()) {
                ArrayList<Double> temperatures = threeDaysWeather.getLowestAndHighestTemperaturesForThatDay(date);
                assertEquals(2, temperatures.size());
            }
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }
}
