package weather;

public class WeatherReport {
    public String city;
    public String countryCode;
    public String coordinates;

    public WeatherReport(WeatherRequest request) {
        this.city = request.city;
        this.countryCode = request.countryCode;
    }
}
