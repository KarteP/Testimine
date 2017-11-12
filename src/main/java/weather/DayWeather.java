package weather;

public class DayWeather {
    private String date;
    private double minTemp;
    private double maxTemp;

    DayWeather(String date, double minTemp, double maxTemp) {
        this.date = date;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public String getDate() {
        return date;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }
}
