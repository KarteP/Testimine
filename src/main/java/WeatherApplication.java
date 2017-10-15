

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import connection.HttpConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class WeatherApplication {

    public static void main(String[] args) throws Exception {
        String url = "http://api.openweathermap.org/data/2.5/forecast?id=588409&APPID=8142ab303ab91d4449a4e5f5685de78d";
        HttpURLConnection connection = HttpConnection.makeUrlConnection(url);

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
        JsonElement jsonElement = jsonObject.get("city");
        JsonElement o = jsonObject.get("city");
        System.out.println(o.getAsJsonObject().get("country"));



    }
}
