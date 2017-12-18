package httpconnection;

import connection.HttpConnection;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HttpConnectionTests {
    private static final int HTTP_CODE_SUCCESS = 200;
    private static final String URL = "http://api.openweathermap.org/data/2.5/forecast?q=Tallinn,EE&units=metric&APPID=8142ab303ab91d4449a4e5f5685de78d";

    @Test
    public void testSuccessfulHttpConnection() {
        try {
            assertEquals(HttpConnection.makeUrlConnection(URL).getResponseCode(), HTTP_CODE_SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTempUnitIsCelsius() {
        assertTrue(URL.contains("metric"));
    }

    @Test
    public void testMakeHttpUrlConnectionDoesNotReturnNull() {
        assertTrue(HttpConnection.makeUrlConnection(URL) != null);
    }
}
