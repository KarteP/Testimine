package httpconnection;

import connection.HttpConnection;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class HttpConnectionTests {
    private static int HTTP_CODE_SUCCESS = 200;
    private static String url;

    @BeforeClass
    public static void setUpForTests() {
        url = "http://api.openweathermap.org/data/2.5/forecast?q=Tallinn,EE&units=metric&APPID=8142ab303ab91d4449a4e5f5685de78d";
    }

    @Test
    public void testSuccessfulHttpConnection() {
        try {
            assertEquals(HttpConnection.makeUrlConnection(url).getResponseCode(), HTTP_CODE_SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTempUnitIsCelsius() {
        assertTrue(url.contains("metric"));
    }

    @Test
    public void testGetWeatherInfoAsJsonDoesNotReturnNull() {
        try {
            assertNotNull(HttpConnection.getWeatherInfoAsJson(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
