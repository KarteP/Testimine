import com.google.gson.JsonObject;
import connection.HttpConnection;
import weather.CurrentWeather;
import weather.ThreeDaysWeather;
import weather.WeatherRequest;

public class WeatherApplication {

    public static void main(String[] args) throws Exception {

        String urlCurrentWeather = "http://api.openweathermap.org/data/2.5/weather?q=Tallinn,EE&units=metric&APPID=8142ab303ab91d4449a4e5f5685de78d";
        JsonObject currentWeatherInfo = HttpConnection.getWeatherInfoAsJson(urlCurrentWeather);

        String urlThreeDaysWeather = "http://api.openweathermap.org/data/2.5/forecast?q=Tallinn,EE&units=metric&APPID=8142ab303ab91d4449a4e5f5685de78d";
        JsonObject threeDaysWeatherInfo = HttpConnection.getWeatherInfoAsJson(urlThreeDaysWeather);

        WeatherRequest request = new WeatherRequest("Tallinn", "EE");

        CurrentWeather currentWeather = new CurrentWeather(request);
        currentWeather.setJsonObjectCurrentWeather(currentWeatherInfo);
        currentWeather.getCurrentTemperature();
        currentWeather.getCurrentDate();

        ThreeDaysWeather threeDaysWeather = new ThreeDaysWeather(request);
        threeDaysWeather.setJsonObject3DaysWeather(threeDaysWeatherInfo);
        threeDaysWeather.get3DaysTemperatures();
    }
}
