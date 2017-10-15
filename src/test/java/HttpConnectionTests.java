import connection.HttpConnection;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HttpConnectionTests {
    private static int HTTP_CODE_SUCCESS = 200;
    static HttpURLConnection connection;

    @BeforeClass
    public static void setUpForTests() {
        String url = "http://api.openweathermap.org/data/2.5/forecast?id=588409&APPID=8142ab303ab91d4449a4e5f5685de78d";
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
}
