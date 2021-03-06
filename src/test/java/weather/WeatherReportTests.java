package weather;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherReportTests {

    private static final String CITY = "Tallinn";
    private static final String COORDINATES = "24.75:59.44";
    private static final String CURRENT_TEMP_STRING = "Current temperature: 1.0°C";
    private static final String THREE_DAYS_TEMP_STRING = "2017-12-07\n" +
            "Minimum temperature: -0.14°C\n" +
            "Maximum temperature: 2.02°C\n" +
            "2017-12-08\n" +
            "Minimum temperature: 4.02°C\n" +
            "Maximum temperature: 5.1°C\n" +
            "2017-12-09\n" +
            "Minimum temperature: 1.15°C\n" +
            "Maximum temperature: 4.34°C\n";
    private static final String WEATHER_INFO_STRING = "City Tallinn\n" +
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
            "Maximum temperature: 4.34°C\n\n";

    private WeatherReport report;

    @Before
    public void setUpForAllTest() {

        WeatherRequest mockedRequest = mock(WeatherRequest.class);
        CurrentWeather mockedCurrentWeather = mock(CurrentWeather.class);
        ThreeDaysWeather mockedThreeDaysWeather = mock(ThreeDaysWeather.class);


        report = new WeatherReport(mockedRequest);
        report.setCurrentAndThreeDaysWeather(mockedCurrentWeather, mockedThreeDaysWeather);

        when(mockedRequest.getCity()).thenReturn(CITY);
        when(mockedCurrentWeather.getCityCoordinates()).thenReturn(COORDINATES);
        when(mockedCurrentWeather.toString()).thenReturn(CURRENT_TEMP_STRING);
        when(mockedThreeDaysWeather.toString()).thenReturn(THREE_DAYS_TEMP_STRING);
    }

    @Test
    public void testSetCurrentAndThreeDaysWeathers() {
        WeatherRequest mockedRequest = mock(WeatherRequest.class);
        CurrentWeather mockedCurrentWeather = mock(CurrentWeather.class);
        ThreeDaysWeather mockedThreeDaysWeather = mock(ThreeDaysWeather.class);

        report = new WeatherReport(mockedRequest);
        report.setCurrentAndThreeDaysWeather(mockedCurrentWeather, mockedThreeDaysWeather);
        assertEquals(mockedCurrentWeather, report.currentWeather);
        assertEquals(mockedThreeDaysWeather, report.threeDaysWeather);
    }

    @Test
    public void testToString() throws IOException {
        assertEquals(WEATHER_INFO_STRING, report.toString());
    }

    @Test (expected = Exception.class)
    public void testSetCurrentWeather() throws IOException {
        report.setCurrentWeather();
    }

    @Test (expected = Exception.class)
    public void testSetThreeDaysWeather() throws IOException {
        report.setThreeDaysWeather();
    }
}
