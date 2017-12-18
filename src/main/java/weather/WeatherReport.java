package weather;

import com.google.gson.JsonObject;
import connection.WeatherApiUrl;
import connection.WeatherInfoJson;

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
        WeatherInfoJson weatherInfoJson = new WeatherInfoJson();
        JsonObject jsonObjectCurrentWeather = weatherInfoJson.getWeatherInfoAsJson(weatherApiUrl.getCurrentWeatherApiUrl());
        this.currentWeather = new CurrentWeather(request, jsonObjectCurrentWeather);
    }

    public void setThreeDaysWeather() throws IOException {
        WeatherInfoJson weatherInfo = new WeatherInfoJson();
        JsonObject jsonObject3DaysWeather = weatherInfo.getWeatherInfoAsJson(weatherApiUrl.getThreeDaysWeatherApiUrl());
        threeDaysWeather = new ThreeDaysWeather(request, jsonObject3DaysWeather);
    }

    //Only used in weather report tests.
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
