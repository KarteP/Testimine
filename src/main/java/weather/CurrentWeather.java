package weather;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import connection.HttpConnection;

import java.io.IOException;

public class CurrentWeather extends WeatherReport {
    private final String degrees = "\u00b0C";

    private String coordinates;
    private JsonObject jsonObjectCurrentWeather;

    public CurrentWeather(WeatherRequest request) throws IOException {
        super(request);
        JsonObject currentWeatherInfo = HttpConnection.getWeatherInfoAsJson(createCurrentWeatherApiUrl());
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

    public String getCurrentTemperature() {
        JsonObject jsonObject = (JsonObject) jsonObjectCurrentWeather.get("main");
        JsonElement jsonTemp = jsonObject.getAsJsonObject().get("temp");
        return "Current temperature: " + jsonTemp + degrees;
    }

    public String createCurrentWeatherApiUrl() {
        return "http://api.openweathermap.org/data/2.5/weather?q="+city+","+countryCode+"" +
                "&units=metric&APPID=8142ab303ab91d4449a4e5f5685de78d";
    }
}
