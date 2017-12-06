package weather;

public class DayWeather {

    public String date;
    public double minTemp;
    public double maxTemp;

    DayWeather(String date, double minTemp, double maxTemp) {
        this.date = date;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }
}
