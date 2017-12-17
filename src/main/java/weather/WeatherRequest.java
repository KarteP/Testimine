package weather;

public class WeatherRequest {
    public String city;
    public String countryCode;

    public WeatherRequest(String city, String countryCode) {
        this.city = city;
        this.countryCode = countryCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountryCode() {
        return countryCode;
    }
}

