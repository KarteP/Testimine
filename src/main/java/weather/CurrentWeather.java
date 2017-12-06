package weather;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class CurrentWeather extends Weather {
    private static final String DEGREES = "\u00b0C";

    public String coordinates;
    private JsonObject jsonObjectCurrentWeather;
    private double currentTemp;

    public CurrentWeather(WeatherRequest request, JsonObject jsonObjectCurrentWeather) {
        super(request);
        this.jsonObjectCurrentWeather = jsonObjectCurrentWeather;
        setCoordinates();
        setCurrentTemp();
    }

    private void setCoordinates() {
        JsonObject jsonCoordinates = (JsonObject)jsonObjectCurrentWeather.get("coord");
        String xCoordinate = jsonCoordinates.get("lon").toString();
        String yCoordinate = jsonCoordinates.get("lat").toString();
        this.coordinates = xCoordinate + ":" + yCoordinate;
    }

    private void setCurrentTemp() {
        JsonObject jsonObject = (JsonObject) jsonObjectCurrentWeather.get("main");
        JsonElement jsonTemp = jsonObject.getAsJsonObject().get("temp");
        this.currentTemp = jsonTemp.getAsDouble();
    }

    public String getCityCoordinates() {
        return this.coordinates;
    }

    public double getCurrentTemp() {
        return this.currentTemp;
    }

    @Override
    public String toString() {
        return "Current temperature: " + getCurrentTemp() + DEGREES;
    }
}
