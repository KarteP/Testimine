import com.google.gson.JsonObject;
import com.sun.org.apache.xpath.internal.SourceTree;
import connection.HttpConnection;
import weather.CurrentWeather;
import weather.ThreeDaysWeather;
import weather.WeatherRequest;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class WeatherApplication {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner("");
        String cityName = "";
        while (true) {
            System.out.println("Enter city name:");
            if (!scanner.hasNextLine()) {
                break;
            }
            if (scanner.hasNextLine()) {
                cityName = scanner.next();
                break;
            }
        }
        System.out.println(cityName);

        WeatherRequest request = new WeatherRequest("Tallinn", "EE");

        CurrentWeather currentWeather = new CurrentWeather(request);
        System.out.println(currentWeather.getCurrentTemperature());


        String urlThreeDaysWeather = "http://api.openweathermap.org/data/2.5/forecast?q=Tallinn,EE&units=metric&APPID=8142ab303ab91d4449a4e5f5685de78d";
        JsonObject threeDaysWeatherInfo = HttpConnection.getWeatherInfoAsJson(urlThreeDaysWeather);

        ThreeDaysWeather threeDaysWeather = new ThreeDaysWeather(request);
        threeDaysWeather.setJsonObject3DaysWeather(threeDaysWeatherInfo);
        System.out.println(threeDaysWeather.get3DaysTemperatures());
    }
}
