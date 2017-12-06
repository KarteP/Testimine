package weather;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import connection.HttpConnection;
import connection.WeatherApiUrl;

import java.io.IOException;

public class CurrentWeather extends Weather {
    private final String degrees = "\u00b0C";

    private String coordinates;
    private JsonObject jsonObjectCurrentWeather;
    private WeatherApiUrl weatherApiUrl;

    public CurrentWeather(WeatherRequest request) throws IOException {
        super(request);
        this.weatherApiUrl = new WeatherApiUrl(request);
        JsonObject currentWeatherInfo = HttpConnection.getWeatherInfoAsJson(this.weatherApiUrl.getCurrentWeatherApiUrl());
        setJsonObjectCurrentWeather(currentWeatherInfo);
    }

    public void setJsonObjectCurrentWeather(JsonObject jsonObject) {
        this.jsonObjectCurrentWeather = jsonObject;
    }

    public String getCoordinates() {
        setCoordinates();
        return this.coordinates;
    }

    public void setCoordinates() {
        JsonObject jsonCoordinates = (JsonObject)jsonObjectCurrentWeather.get("coord");
        String xCoordinate = jsonCoordinates.get("lon").toString();
        String yCoordinate = jsonCoordinates.get("lat").toString();
        this.coordinates = xCoordinate + ":" + yCoordinate;
    }

    public String getCurrentTemperatureString() {
        JsonObject jsonObject = (JsonObject) jsonObjectCurrentWeather.get("main");
        JsonElement jsonTemp = jsonObject.getAsJsonObject().get("temp");
        return "Current temperature: " + jsonTemp + degrees;
    }

    public String getCityCoordinatesString() {
        return "Coordinates " + getCoordinates();
    }
}
