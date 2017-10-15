package weather;

public class CurrentWeather implements Weather {
    String city;
    double coordinates;

    public CurrentWeather(WeatherRequest request) {
        this.city = request.getCity();
        this.coordinates = request.getCoordinates();
    }

    public String getCity() {
        return city;
    }

    public double getCoordinates() {
        return this.coordinates;
    }

    public CurrentWeather getCurrentWeather(WeatherRequest request) {
        return null;
    }

    public double getTemperature() {
        return 0.0;
    }

    public String getCurrentDate() {
        return "01.10.2017";
    }
}
