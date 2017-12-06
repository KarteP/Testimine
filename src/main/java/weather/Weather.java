package weather;

import files.FileReader;

public class Weather {
    public String city;
    public String countryCode;
    public String coordinates;

    public Weather(WeatherRequest request) {
        this.city = request.city;
        this.countryCode = request.countryCode;
    }

    public void writeWeatherForCitiesInFileToFiles() {
        FileReader reader = new FileReader();

    }
}
