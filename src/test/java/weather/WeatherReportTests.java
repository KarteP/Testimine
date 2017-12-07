package weather;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherReportTests {

    private static final String CITY = "Tallinn";
    private static final String WEATHER_INFO_STRING = "Tallinn\n" +
            "Coordinates 24.75:59.44\n" +
            "Current temperature: 1.0°C\n" +
            "2017-12-07\n" +
            "Minimum temperature: -0.14°C\n" +
            "Maximum temperature: 2.02°C\n" +
            "2017-12-08\n" +
            "Minimum temperature: 4.02°C\n" +
            "Maximum temperature: 5.1°C\n" +
            "2017-12-09\n" +
            "Minimum temperature: 1.15°C\n" +
            "Maximum temperature: 4.34°C\n";;

    @Test
    public void testGetWeatherInfoString() throws IOException {
        WeatherReport mockedReport = mock(WeatherReport.class);
        when(mockedReport.getWeatherInfoString(CITY)).thenReturn(WEATHER_INFO_STRING);
        assertEquals(WEATHER_INFO_STRING, mockedReport.getWeatherInfoString(CITY));
    }

    @Test (expected = Exception.class)
    public void testGetWeatherInfoStringWithEmptyCityName() throws Exception {
        WeatherReport report = new WeatherReport();
        report.getWeatherInfoString("");
    }
}
