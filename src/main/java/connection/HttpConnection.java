package connection;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import files.FileWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection {
    /**
    public HttpURLConnection makeUrlConnection(String url) {
        HttpURLConnection connection = null;
        try {
            URL urlStr = new URL(url);
            connection = (HttpURLConnection) urlStr.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    private String getWeatherInfo(String url) throws IOException {
        HttpURLConnection connection = makeUrlConnection(url);
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
    **/

    public static HttpURLConnection makeUrlConnection(String url) {
        HttpURLConnection connection = null;
        try {
            URL urlStr = new URL(url);
            connection = (HttpURLConnection) urlStr.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    private static String getWeatherInfo(String url) throws IOException {
        HttpURLConnection connection = makeUrlConnection(url);
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

    public static JsonObject getWeatherInfoAsJson(String url) throws IOException {
        String weatherInfo = getWeatherInfo(url);

        FileWriter fileWriter = new FileWriter();
        fileWriter.writeToFile(weatherInfo, "output.txt");

        JsonParser jsonParser = new JsonParser();
        return (JsonObject) jsonParser.parse(weatherInfo);
    }

}
