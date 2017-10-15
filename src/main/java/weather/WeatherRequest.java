package weather;

public class WeatherRequest {
    private String city;
    private double coordinates;

    public WeatherRequest(String city, double coordinates) {
        this.city = city;
        this.coordinates = coordinates;
    }

    public String getCity() {
        return this.city;
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
