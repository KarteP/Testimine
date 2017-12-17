package weather;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeatherTests {
    private static final String CITY_NAME = "Tallinn";
    private static final String COUNTRY_CODE = "EE";

    @Test
    public void testWeatherReport() {
        WeatherRequest request = new WeatherRequest(CITY_NAME, COUNTRY_CODE);
        assertEquals(CITY_NAME, request.city);
        assertEquals(COUNTRY_CODE, request.countryCode);
    }
}
