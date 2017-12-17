package weather;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeatherRequestTests {
    private static final String CITY_NAME = "Tallinn";
    private static final String COUNTRY_CODE = "EE";

    private static WeatherRequest request;

    @BeforeClass
    public static void setUpForTests() {
        request = new WeatherRequest(CITY_NAME, COUNTRY_CODE);
    }

    @Test
    public void testWeatherRequest() {
        assertEquals(CITY_NAME, request.city);
        assertEquals(COUNTRY_CODE, request.countryCode);
    }

    @Test
    public void testGetCity() {
        assertEquals(CITY_NAME, request.getCity());
    }
}
