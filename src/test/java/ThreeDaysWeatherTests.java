import connection.HttpConnection;
import org.junit.Before;
import org.junit.Test;
import weather.ThreeDaysWeather;
import weather.Weather;
import weather.WeatherRequest;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ThreeDaysWeatherTests {
    WeatherRequest request;
    ThreeDaysWeather threeDaysWeather;

    @Before
    public void setUpForTest() {
        request = new WeatherRequest("Tallinn", "EE");
        threeDaysWeather = new ThreeDaysWeather(request);
    }


    @Test
    public void testIfWeatherForecastForThreeDaysIsGiven() {
        try {
            threeDaysWeather.setJsonObject3DaysWeather(HttpConnection.getWeatherInfoAsJson("http://api.openweat" +
                    "hermap.org/data/2.5/forecast?q=Tallinn,EE&units=metric&APPID=8142ab303ab91d4449a4e5f5685de78d"));
            threeDaysWeather.put3DaysTemperaturesInMap();
            assertEquals(3, threeDaysWeather.threeDaysMap.size());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    /**
    @Test
    public void testIfWeatherForecastForRightDaysIsGiven() {
        try {
            WeatherRequest request = new WeatherRequest("Tallinn", "EE");
            ThreeDaysWeather threeDaysWeather = new ThreeDaysWeather(request);
            assertEquals(3, threeDaysWeather.threeDaysMap.size());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }
     **/

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
