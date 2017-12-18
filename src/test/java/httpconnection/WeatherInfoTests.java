package httpconnection;

import connection.WeatherInfoJson;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by Kasutaja on 17.12.2017.
 */
public class WeatherInfoTests {

    private static final String URL = "http://api.openweathermap.org/data/2.5/forecast?q=Tallinn,EE&units=metric&APPID=8142ab303ab91d4449a4e5f5685de78d";

     @Test
    public void testGetWeatherInfoAsJsonDoesNotReturnNull() {
         WeatherInfoJson weatherInfoJson = new WeatherInfoJson();
         try {
             assertTrue(weatherInfoJson.getWeatherInfoAsJson(URL) != null);
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
}
