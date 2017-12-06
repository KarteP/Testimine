package weather;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import connection.HttpConnection;
import connection.WeatherApiUrl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class ThreeDaysWeather extends Weather {
    private static final String degrees = "\u00b0C";

    public ArrayList<DayWeather> dayWeathers = new ArrayList<>();
    private JsonObject jsonObject3DaysWeather;
    private WeatherApiUrl weatherApiUrl;

    public ThreeDaysWeather(WeatherRequest request) throws IOException {
        super(request);
        this.weatherApiUrl = new WeatherApiUrl(request);
        HttpConnection connection = new HttpConnection();
        JsonObject currentWeatherInfo = connection.getWeatherInfoAsJson(this.weatherApiUrl.getThreeDaysWeatherApiUrl());
        //JsonObject currentWeatherInfo = HttpConnection.getWeatherInfoAsJson(weatherApiUrl.getThreeDaysWeatherApiUrl());
        setJsonObject3DaysWeather(currentWeatherInfo);
    }

    public void setJsonObject3DaysWeather(JsonObject jsonObject3DaysWeather) {
        this.jsonObject3DaysWeather = jsonObject3DaysWeather;
    }

    public String get3DaysTemperaturesString() {
        putDayWeathersInList();
        String result = "";

        for (DayWeather dayWeather : dayWeathers) {
            result += dayWeather.date + "\n";
            result += "Minimum temperature: " + dayWeather.minTemp + degrees + "\n";
            result += "Maximum temperature: " + dayWeather.maxTemp + degrees + "\n";
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
}
