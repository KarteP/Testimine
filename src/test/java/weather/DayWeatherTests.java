package weather;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DayWeatherTests {
    private static final String DATE = "06.12.2017";
    private static final double MIN_TEMP = -1.0;
    private static final double MAX_TEMP = 1.0;

    private static DayWeather dayWeather;

    @Before
    public void setUpBeforeTests() {
        dayWeather = new DayWeather(DATE, MIN_TEMP, MAX_TEMP);
    }

    @Test
    public void testGetDate() {
        assertEquals(DATE, dayWeather.date);
    }

    @Test
    public void testGetMinTemp() {
        assertEquals(MIN_TEMP, dayWeather.minTemp, 0.001);
    }

    @Test
    public void testGetMaxTemp() {
        assertEquals(MAX_TEMP, dayWeather.maxTemp, 0.001);
    }
}
