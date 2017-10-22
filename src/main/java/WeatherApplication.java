
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import connection.HttpConnection;
import weather.CurrentWeather;
import weather.WeatherRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WeatherApplication {

    public static void main(String[] args) throws Exception {

        String urlCurrentWeather = "http://api.openweathermap.org/data/2.5/weather?q=Tallinn,EE&units=metric&APPID=8142ab303ab91d4449a4e5f5685de78d";
        HttpURLConnection connection = HttpConnection.makeUrlConnection(urlCurrentWeather);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        String contentCurrentWeather = "";
        while ((line = bufferedReader.readLine()) != null) {
            contentCurrentWeather += line;
        }
        bufferedReader.close();
        connection.disconnect();


        String url = "http://api.openweathermap.org/data/2.5/forecast?q=Tallinn,EE&units=metric&APPID=8142ab303ab91d4449a4e5f5685de78d";
        HttpURLConnection connection2 = HttpConnection.makeUrlConnection(url);

        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(connection2.getInputStream()));
        String line2;
        String content3Days = "";
        while ((line2 = bufferedReader2.readLine()) != null) {
            content3Days += line2;
        }
        bufferedReader2.close();
        connection2.disconnect();


        // Get Json object.
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElementCurrentWeather = jsonParser.parse(contentCurrentWeather);
        JsonObject jsonObjectCurrentWeather = jsonElementCurrentWeather.getAsJsonObject();


        JsonObject jsonObject = (JsonObject)jsonParser.parse(content3Days);
        System.out.println(jsonObject);



        JsonArray jsonWeatherArray = jsonObject.getAsJsonObject().getAsJsonArray("list");
        String currentDate = LocalDate.now().toString();
        double temp_min = 100.0;
        double temp_max = 0.0;
        int forecastsInDay = 8;

        Map<String, ArrayList<Double>> threeDaysMap = new HashMap();

        for (int i = 0; i < 8; i++) {
            String date = jsonWeatherArray.get(i).getAsJsonObject().get("dt_txt").getAsString().split(" ")[0];
            if (date.equals(currentDate)) {
                forecastsInDay++;
            } else {
                System.out.println(date);
                JsonElement j = jsonWeatherArray.get(i).getAsJsonObject().get("main");
                double temp = j.getAsJsonObject().get("temp").getAsDouble();
                System.out.println(temp);
                if (temp < temp_min) {
                    temp_min = temp;
                }
                if (temp > temp_max) {
                    temp_max = temp;
                }
            }
            ArrayList<Double> temperatures = new ArrayList<Double>();
            temperatures.add(temp_min);
            temperatures.add(temp_max);
            threeDaysMap.put(date, temperatures);
        }


        System.out.println("Maximum temperature: " + temp_max);
        System.out.println("Minimum temperature: " + temp_min);

        /**
        WeatherRequest request = new WeatherRequest("Tallinn", "EE");
        CurrentWeather currentWeather = new CurrentWeather(request);
        currentWeather.setJsonObjectCurrentWeather(jsonObjectCurrentWeather);
        currentWeather.getCurrentTemperature();
        **/
    }
}
