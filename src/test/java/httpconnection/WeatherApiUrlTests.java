package httpconnection;

import connection.WeatherApiUrl;
import org.junit.Before;
import org.junit.Test;
import weather.WeatherRequest;

import static org.junit.Assert.assertEquals;

public class WeatherApiUrlTests {
    private static final String CURRENT_WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=Tallinn,EE" +
            "&units=metric&APPID=8142ab303ab91d4449a4e5f5685de78d";
    private static final String THREE_DAYS_WEATHER_URL = "http://api.openweathermap.org/data/2.5/forecast?q=Tallinn,EE" +
            "&units=metric&APPID=8142ab303ab91d4449a4e5f5685de78d";
    private WeatherApiUrl weatherApiUrl;

    @Before
    public void setUpBeforeTest() {
        WeatherRequest request = new WeatherRequest("Tallinn", "EE");
        weatherApiUrl = new WeatherApiUrl(request);
    }

    @Test
    public void testGetCurrentWeatherApiUrl() {
        assertEquals(CURRENT_WEATHER_URL, weatherApiUrl.getCurrentWeatherApiUrl());
    }

    @Test
    public void testGetThreeDaysWeatherApiUrl() {
        assertEquals(THREE_DAYS_WEATHER_URL, weatherApiUrl.getThreeDaysWeatherApiUrl());
    }
}
