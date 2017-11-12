package weather;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import connection.HttpConnection;
import connection.WeatherApiUrl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class ThreeDaysWeather extends WeatherReport {
    private static final String degrees = "\u00b0C";

    private ArrayList<DayWeather> dayWeathers = new ArrayList<>();
    private JsonObject jsonObject3DaysWeather;
    private WeatherApiUrl weatherApiUrl;

    public ThreeDaysWeather(WeatherRequest request) throws IOException {
        super(request);
        weatherApiUrl = new WeatherApiUrl(request);
        JsonObject currentWeatherInfo = HttpConnection.getWeatherInfoAsJson(weatherApiUrl.getThreeDaysWeatherApiUrl());
        setJsonObject3DaysWeather(currentWeatherInfo);
    }

    public void setJsonObject3DaysWeather(JsonObject jsonObject3DaysWeather) {
        this.jsonObject3DaysWeather = jsonObject3DaysWeather;

    }

    public String get3DaysTemperatures() {
        putDayWeathersInList();
        String result = "";

        for (DayWeather dayWeather : dayWeathers) {
            result += dayWeather.getDate() + "\n";
            result += "Minimum temperature: " + dayWeather.getMinTemp() + degrees + "\n";
            result += "Maximum temperature: " + dayWeather.getMaxTemp() + degrees + "\n";
        }
        return result;
    }

    public void putDayWeathersInList() {
        JsonArray jsonWeatherArray = jsonObject3DaysWeather.getAsJsonObject().getAsJsonArray("list");
        String currentDate = LocalDate.now().toString();
        double minTemp = 100.0;
        double maxTemp = 0.0;
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
                if (temp < minTemp) {
                    minTemp = temp;
                }
                if (temp > maxTemp) {
                    maxTemp = temp;
                }
                if ((i - currentDaysCount + 1) % 8 == 0) {
                    DayWeather dayWeather = new DayWeather(date, minTemp, maxTemp);
                    dayWeathers.add(dayWeather);

                    if (dayWeathersListSizeIsBiggerThan3()) {
                        dayWeathers.remove(3);
                        break;
                    }
                    minTemp = 100.0;
                    maxTemp = 0.0;
                }
            }
        }
    }

    private boolean dayWeathersListSizeIsBiggerThan3() {
        return dayWeathers.size() > 3;
    }

    public List<DayWeather> getDayWeathersList() {
        return dayWeathers;
    }
}
