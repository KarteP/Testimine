import connection.HttpConnection;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class HttpConnectionTests {
    private static int HTTP_CODE_SUCCESS = 200;
    static HttpURLConnection connection;
    static String url;

    @BeforeClass
    public static void setUpForTests() {
        url = "http://api.openweathermap.org/data/2.5/forecast?q=Tallinn,EE&units=metric&APPID=8142ab303ab91d4449a4e5f5685de78d";
        connection = HttpConnection.makeUrlConnection(url);
    }

    @Test
    public void testSuccessfulHttpConnection() {
        try {
            assertEquals(connection.getResponseCode(), HTTP_CODE_SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTempUnitIsCelsius() {
        assertTrue(url.contains("metric"));
    }
}
