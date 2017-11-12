package connection;

import weather.WeatherRequest;

public class WeatherApiUrl {
    private static final String COUNTRY_CODE = "EE";
    private static final String UNITS = "metric";

    private WeatherRequest weatherRequest;

    public WeatherApiUrl(WeatherRequest weatherRequest) {
        this.weatherRequest = weatherRequest;
    }

    public String getCurrentWeatherApiUrl() {
        return "http://api.openweathermap.org/data/2.5/weather?q=" + weatherRequest.city + "," + COUNTRY_CODE +
                "&units=" + UNITS + "&APPID=8142ab303ab91d4449a4e5f5685de78d";
    }

    public String getThreeDaysWeatherApiUrl() {
        return "http://api.openweathermap.org/data/2.5/forecast?q=" + weatherRequest.city + "," + COUNTRY_CODE +
                "&units=" + UNITS + "&APPID=8142ab303ab91d4449a4e5f5685de78d";
    }
}
