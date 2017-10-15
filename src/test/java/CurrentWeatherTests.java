import connection.HttpConnection;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import weather.CurrentWeather;
import weather.WeatherRequest;

import java.io.IOException;
import java.net.HttpURLConnection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CurrentWeatherTests {
    private static int HTTP_CODE_SUCCESS = 200;

    @BeforeClass
    void setUpForForAllTests(){

    }

    @Before
    void setUpForTest() {

    }

    public void testApiOutputInRightFormat() {

    }

    @Test
    public void testSuccessfulHttpConnection() {
        try {
            String url = "";
            HttpURLConnection connection = HttpConnection.makeUrlConnection(url);
            assertEquals(connection.getResponseCode(), HTTP_CODE_SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCityNameInRightFormat() {
        try {
            WeatherRequest request = new WeatherRequest("Tallinn", 1.00);
            assertEquals(request.getCity(), "Tallinn");
            assertTrue(request.getCity() instanceof String);
        } catch (Exception e) {
            fail("Failure cause:  " + e.getMessage());
        }
    }

    @Test
    public void testCityCoordinatesForRightCity() {
        try {
            WeatherRequest request = new WeatherRequest("Tallinn", 1.0);
            CurrentWeather currentWeather = new CurrentWeather(request);
            assertEquals(currentWeather.getCoordinates(), request.getCoordinates());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    public void testIfWeatherForecastIsForRightCity() {
        try {
            WeatherRequest request = new WeatherRequest("Tallinn", 1.0);
            CurrentWeather currentWeather = new CurrentWeather(request);
            assertEquals(currentWeather.getCity(), request.getCity());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    public void testIfTemperatureInRightFormat() {
        try {
            WeatherRequest request = new WeatherRequest("Tallinn", 1.0);
            CurrentWeather currentWeather = new CurrentWeather(request);
            // assertTrue(currentWeather.getTemperature() instanceof double);
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    public void testIfWeatherForecastForThisTimeIsGiven() {
        try {
            WeatherRequest request = new WeatherRequest("Tallinn", 1.0);
            CurrentWeather currentWeather = new CurrentWeather(request);
            assertEquals(currentWeather.getCurrentDate(), request.getCurrentDate());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }
}
