package weather;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class CurrentWeather implements Weather {
    final String degrees = "\u00b0C";
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
        JsonObject jsonCoordinates = (JsonObject)jsonObjectCurrentWeather.get("coord");
        String coordinates = jsonCoordinates.toString();
        return coordinates;
    }

    public void getCurrentTemperature() {
        JsonObject jsonObject = (JsonObject) jsonObjectCurrentWeather.get("main");
        JsonElement jsonTemp = jsonObject.getAsJsonObject().get("temp");
        // String temp = jsonTemp.toString();
        System.out.println("Current temperature: " + jsonTemp + degrees);
    }

    public String getCurrentDate() {
        return "01.10.2017";
    }

    public void setJsonObjectCurrentWeather(JsonObject jsonObject) {
        this.jsonObjectCurrentWeather = jsonObject;
    }
}
