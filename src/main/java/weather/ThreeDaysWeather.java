package weather;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import connection.HttpConnection;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class ThreeDaysWeather extends WeatherReport {
    private final String degrees = "\u00b0C";

    public Map<String, ArrayList<Double>> threeDaysMap = new HashMap();
    private ArrayList<String> days = new ArrayList<String>();
    private JsonObject jsonObject3DaysWeather;

    public ThreeDaysWeather(WeatherRequest request) throws IOException {
        super(request);
        JsonObject currentWeatherInfo = HttpConnection.getWeatherInfoAsJson(createThreeDaysWeatherApiUrl());
        setJsonObject3DaysWeather(currentWeatherInfo);
    }

    public void setJsonObject3DaysWeather(JsonObject jsonObject3DaysWeather) {
        this.jsonObject3DaysWeather = jsonObject3DaysWeather;

    }

    public ArrayList<Double> getLowestAndHighestTemperaturesForThatDay(String date) {
        return threeDaysMap.get(date);
    }

    private double getLowestTemperature(String date) {
        ArrayList<Double> temperatures = threeDaysMap.get(date);
        return Collections.min(temperatures);
    }

    private double getHighestTemperature(String date) {
        ArrayList<Double> temperatures = threeDaysMap.get(date);
        return Collections.max(temperatures);
    }

    public String get3DaysTemperatures() {
        put3DaysTemperaturesInMap();
        String result = "";
        for (String day : days) {
            result += day + "\n";
            result += "Minimum temperature: " + getLowestTemperature(day) + degrees + "\n";
            result += "Maximum temperature: " + getHighestTemperature(day) + degrees + "\n";
        }
        return result;
    }

    public void put3DaysTemperaturesInMap() {
        JsonArray jsonWeatherArray = jsonObject3DaysWeather.getAsJsonObject().getAsJsonArray("list");
        String currentDate = LocalDate.now().toString();
        double temp_min = 100.0;
        double temp_max = 0.0;
        int currentDaysCount = 0;

        for (int i = 0; i < jsonWeatherArray.size(); i++) {
            String date = jsonWeatherArray.get(i).getAsJsonObject().get("dt_txt").getAsString().split(" ")[0];
            if (date.equals(currentDate)) {
                currentDaysCount++;
            } else {
                //System.out.println(date);
                JsonElement j = jsonWeatherArray.get(i).getAsJsonObject().get("main");
                double temp = j.getAsJsonObject().get("temp").getAsDouble();
                //System.out.println(temp);
                if (temp < temp_min) {
                    temp_min = temp;
                }
                if (temp > temp_max) {
                    temp_max = temp;
                }
                if ((i - currentDaysCount + 1) % 8 == 0) {
                    if (days.size() < 3) {
                        days.add(date);
                    }
                    ArrayList<Double> temperatures = new ArrayList<Double>();
                    temperatures.add(temp_min);
                    temperatures.add(temp_max);
                    threeDaysMap.put(date, temperatures);
                    if (threeDaysMapSizeIsBiggerThan3()) {
                        threeDaysMap.remove(date);
                        break;
                    }
                    temp_min = 100.0;
                    temp_max = 0.0;
                }
            }
        }
    }

    private boolean threeDaysMapSizeIsBiggerThan3() {
        return threeDaysMap.size() > 3;
    }

    public String createThreeDaysWeatherApiUrl() {
        return "http://api.openweathermap.org/data/2.5/forecast?q="+city+","+countryCode+"" +
                "&units=metric&APPID=8142ab303ab91d4449a4e5f5685de78d";
    }
}
