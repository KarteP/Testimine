

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApplication {

    public static void main(String[] args) throws Exception {
        //HttpConnection connection = new HttpConnection("http://api.openweathermap.org/data/2.5" +
        //        "/forecast?id=524901&APPID=8142ab303ab91d4449a4e5f5685de78d");

        HttpURLConnection connection = null;
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5" +
                    "/forecast?id=588409&APPID=8142ab303ab91d4449a4e5f5685de78d");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
        } catch (Exception e) {
            System.out.println(e);
        }


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        String content = "";
        while ((line = bufferedReader.readLine()) != null) {

            content += line;
        }
        bufferedReader.close();
        connection.disconnect();

        // Get Json object.
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject)jsonParser.parse(content);
        System.out.println(jsonObject);

        System.out.println(jsonObject.get("city"));
        System.out.println(jsonObject.get("main"));
    }
}
