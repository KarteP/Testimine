package httpconnection;

import connection.WeatherApiUrl;
import org.junit.BeforeClass;
import org.junit.Test;
import weather.WeatherRequest;

import static org.junit.Assert.assertEquals;

public class WeatherApiUrlTests {
    private static WeatherRequest request;
    private static WeatherApiUrl weatherApiUrl;

    @BeforeClass
    public static void setUpForTests() {
        request = new WeatherRequest("Tallinn", "EE");
        weatherApiUrl = new WeatherApiUrl(request);
    }

    @Test
    public void testGetCurrentWeatherApiUrl() {
        assertEquals("http://api.openweathermap.org/data/2.5/weather?q=Tallinn,EE" +
                "&units=metric&APPID=8142ab303ab91d4449a4e5f5685de78d", weatherApiUrl.getCurrentWeatherApiUrl());
    }

    @Test
    public void testGetThreeDaysWeatherApiUrl() {
        assertEquals("http://api.openweathermap.org/data/2.5/forecast?q=Tallinn,EE" +
                "&units=metric&APPID=8142ab303ab91d4449a4e5f5685de78d", weatherApiUrl.getThreeDaysWeatherApiUrl());
    }
}
