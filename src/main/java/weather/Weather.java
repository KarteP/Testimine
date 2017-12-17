package weather;

public class Weather {
    public String city;
    public String countryCode;

    public Weather(WeatherRequest request) {
        this.city = request.getCity();
        this.countryCode = request.countryCode;
    }
}
