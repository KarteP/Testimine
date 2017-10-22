package weather;

public class WeatherRequest {
    private String city;
    private String countryCode;
    private double coordinates;

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

    public double getCoordinates() {
        return this.coordinates;
    }

    public String getCurrentDate() {
        return "01.10.2017";
    }

    public CurrentWeather getCurrentWeather() {
        return null;
    }
}
