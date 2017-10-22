package weather;


import com.google.gson.JsonObject;

import java.util.*;

public class ThreeDaysWeather extends CurrentWeather {
    final String degrees = "\u00b0C";
    public Map<String, ArrayList<Double>> threeDaysMap = new HashMap();
    private JsonObject jsonObject3DaysWeather;

    public ThreeDaysWeather(WeatherRequest request) {
        super(request);
    }

    public ArrayList<Double> getLowestAndHighestTemperaturesForThatDay(String date) {
        return threeDaysMap.get(date);
    }

    public double getLowestTemperature(String date) {
        ArrayList<Double> temperatures = threeDaysMap.get(date);
        return Collections.min(temperatures);
    }

    public double getHighestTemperature(String date) {
        ArrayList<Double> temperatures = threeDaysMap.get(date);
        return Collections.max(temperatures);
    }

    public void setJsonObject3DaysWeather(JsonObject jsonObject3DaysWeather) {
        this.jsonObject3DaysWeather = jsonObject3DaysWeather;

    }

    public void get3DaysTemperatures() {

    }
}
