package weather;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class CurrentWeather implements Weather {
    private final String degrees = "\u00b0C";

    private String city;
    private String countryCode;
    private String coordinates;
    private JsonObject jsonObjectCurrentWeather;

    public CurrentWeather(WeatherRequest request) {
        this.city = request.getCity();
        this.countryCode = request.getCountryCode();
    }

    public String getCity() {
        return city;
    }

    public String getCountryCode() {
        return this.countryCode;
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

    public void getCurrentTemperature() {
        JsonObject jsonObject = (JsonObject) jsonObjectCurrentWeather.get("main");
        JsonElement jsonTemp = jsonObject.getAsJsonObject().get("temp");
        System.out.println("Current temperature: " + jsonTemp + degrees);
    }

    public String getCurrentDate() {
        return "01.10.2017";
    }

    public void setJsonObjectCurrentWeather(JsonObject jsonObject) {
        this.jsonObjectCurrentWeather = jsonObject;
    }

    public String createCurrentWeatherApiUrl() {
        String url = "http://api.openweathermap.org/data/2.5/weather?q="+getCity()+","+getCountryCode()+"" +
                "&units=metric&APPID=8142ab303ab91d4449a4e5f5685de78d";
        return url;
    }
}
