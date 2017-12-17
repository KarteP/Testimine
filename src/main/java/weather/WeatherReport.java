package weather;

import com.google.gson.JsonObject;
import connection.HttpConnection;
import connection.WeatherApiUrl;
import connection.WeatherInfo;

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
        WeatherInfo weatherInfo = new WeatherInfo();
        JsonObject jsonObjectCurrentWeather = weatherInfo.getWeatherInfoAsJson(weatherApiUrl.getCurrentWeatherApiUrl());
        this.currentWeather = new CurrentWeather(request, jsonObjectCurrentWeather);
    }

    public void setThreeDaysWeather() throws IOException {
        WeatherInfo weatherInfo = new WeatherInfo();
        JsonObject jsonObject3DaysWeather = weatherInfo.getWeatherInfoAsJson(weatherApiUrl.getThreeDaysWeatherApiUrl());
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
