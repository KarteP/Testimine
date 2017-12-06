import weather.WeatherApplication;
import weather.WeatherReport;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        WeatherReport report = new WeatherReport();
        WeatherApplication application = new WeatherApplication(report);
        //System.out.println(report.getWeatherInfoString("Tallinn"));

        Scanner scanner = new Scanner(System.in);
        application.getWeatherInfoFromConsoleInput(scanner);

        application.writeWeatherInfoForCitiesInFileToDifferentFiles("input.txt");
    }
}
