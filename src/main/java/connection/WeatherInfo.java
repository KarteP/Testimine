package connection;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import files.FileWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Created by Kasutaja on 17.12.2017.
 */
public class WeatherInfo {

    private String getWeatherInfo(String url) throws IOException {
        HttpURLConnection connection = HttpConnection.makeUrlConnection(url);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        String weatherInfo = "";
        while ((line = bufferedReader.readLine()) != null) {
            weatherInfo += line;
        }
        bufferedReader.close();
        connection.disconnect();
        return weatherInfo;
    }

    public JsonObject getWeatherInfoAsJson(String url) throws IOException {
        String weatherInfo = getWeatherInfo(url);

        FileWriter fileWriter = new FileWriter();
        fileWriter.writeToFile(weatherInfo, "output.txt");

        JsonParser jsonParser = new JsonParser();
        return (JsonObject) jsonParser.parse(weatherInfo);
    }
}
