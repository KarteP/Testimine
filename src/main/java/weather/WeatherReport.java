package weather;

import com.google.gson.JsonObject;
import connection.HttpConnection;
import connection.WeatherApiUrl;

import java.io.IOException;

public class WeatherReport {

    public WeatherRequest request;
    public WeatherApiUrl weatherApiUrl;

    public CurrentWeather currentWeather;
    public ThreeDaysWeather threeDaysWeather;

    public WeatherReport(WeatherRequest request) {
        this.request = request;
        this.weatherApiUrl = new WeatherApiUrl(request);
    }

    public void setCurrentWeather() throws IOException {
        JsonObject jsonObjectCurrentWeather = HttpConnection.getWeatherInfoAsJson(weatherApiUrl.getCurrentWeatherApiUrl());
        this.currentWeather = new CurrentWeather(request, jsonObjectCurrentWeather);
    }

    public void setThreeDaysWeather() throws IOException {
        JsonObject jsonObject3DaysWeather = HttpConnection.getWeatherInfoAsJson(weatherApiUrl.getThreeDaysWeatherApiUrl());
        threeDaysWeather = new ThreeDaysWeather(request, jsonObject3DaysWeather);
    }

    public void setCurrentAndThreeDaysWeather(CurrentWeather currentWeather, ThreeDaysWeather threeDaysWeather) {
        this.currentWeather = currentWeather;
        this.threeDaysWeather = threeDaysWeather;
    }

    @Override
    public String toString() {
        return  "City " + request.getCity() + "\n"
                + "Coordinates " + currentWeather.getCityCoordinates() + "\n"
                + currentWeather.toString() + "\n"
                + threeDaysWeather.toString() + "\n";
    }
}
