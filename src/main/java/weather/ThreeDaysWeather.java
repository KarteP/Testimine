package weather;

import java.util.*;

public class ThreeDaysWeather extends CurrentWeather {
    public Map<String, ArrayList<Double>> threeDaysMap = new HashMap();

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
}
