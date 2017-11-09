import connection.HttpConnection;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import weather.CurrentWeather;
import weather.WeatherRequest;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CurrentWeatherTests {
    private static WeatherRequest request;
    private static CurrentWeather currentWeather;

    @BeforeClass
    public static void setUpForForAllTests() throws IOException {
        request = new WeatherRequest("Tallinn", "EE");
        currentWeather = new CurrentWeather(request);
    }

    @Before
    public void setUpForTest() {

    }

    public void testApiOutputInRightFormat() {

    }

    @Test
    public void testCityNameInRightFormat() {
        try {
            assertEquals(request.city, "Tallinn");
        } catch (Exception e) {
            fail("Failure cause:  " + e.getMessage());
        }
    }

    @Test
    public void testCityCoordinatesInRightFormat() {
        try {
            currentWeather.setJsonObjectCurrentWeather(HttpConnection.getWeatherInfoAsJson("http://api." +
                    "openweathermap.org/data/2.5/weather?q=Tallinn," +
                    "EE&units=metric&APPID=8142ab303ab91d4449a4e5f5685de78d"));
            currentWeather.setCoordinates();
            assertEquals("24.75:59.44", currentWeather.getCoordinates());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    public void testIfWeatherForecastIsForRightCity() {
        try {
            assertEquals(currentWeather.city, request.city);
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    /**
    @Test
    public void testIfTemperatureInRightFormat() {
        try {
            CurrentWeather currentWeather = new CurrentWeather(request);
            //assertTrue(currentWeather.getCurrentTemperature() instanceof double);
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
        WeatherAdvirsor advisorMock = mock(WeatherAdvisor.class);
        when(advisorMock.getCurrenttemp()).thenReturn(1.5);
    }

    @Test
    public void testSomething() {
        List mockedList = mock(List.class);

        mockedList.add("one");
        mockedList.clear();

        verify(mockedList).add("one");
        verify(mockedList).clear();
    }
    **/
}
