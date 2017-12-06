package weather;

import com.google.gson.JsonObject;
import connection.HttpConnection;
import connection.WeatherApiUrl;
import files.FileWriter;

import java.io.IOException;

public class WeatherReport {

    public String getWeatherInfoString(String cityName) throws IOException {
        WeatherRequest request = new WeatherRequest(cityName, "EE");
        WeatherApiUrl weatherApiUrl = new WeatherApiUrl(request);

        JsonObject jsonObjectCurrentWeather = HttpConnection.getWeatherInfoAsJson(weatherApiUrl.getCurrentWeatherApiUrl());
        JsonObject jsonObject3DaysWeather = HttpConnection.getWeatherInfoAsJson(weatherApiUrl.getThreeDaysWeatherApiUrl());

        CurrentWeather currentWeather = new CurrentWeather(request, jsonObjectCurrentWeather);
        String cityCoordinates = "Coordinates " + currentWeather.getCityCoordinates();
        String currentWeatherInfo = currentWeather.toString();

        ThreeDaysWeather threeDaysWeather = new ThreeDaysWeather(request, jsonObject3DaysWeather);
        String threeDaysWeatherInfo = threeDaysWeather.toString();

        FileWriter fileWriter = new FileWriter();

        return cityName + "\n"
                + cityCoordinates + "\n"
                + currentWeatherInfo + "\n"
                + threeDaysWeatherInfo + "\n";
    }
}
