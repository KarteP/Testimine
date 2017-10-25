package weather;

public class WeatherRequest {
    private String city;
    private String countryCode;

    public WeatherRequest(String city, String countryCode) {
        this.city = city;
        this.countryCode = countryCode;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCurrentDate() {
        return "01.10.2017";
    }

    public CurrentWeather getCurrentWeather() {
        return null;
    }
}
