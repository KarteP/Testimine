package weather;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeatherRequestTests {
    private String CITY_NAME = "Tallinn";
    private String COUNTRY_CODE = "EE";

    @Test
    public void testWeatherRequest() {
        WeatherRequest request = new WeatherRequest(CITY_NAME, COUNTRY_CODE);
        assertEquals(CITY_NAME, request.city);
        assertEquals(COUNTRY_CODE, request.countryCode);
    }
}
