import weather.WeatherApplication;
import weather.WeatherReport;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        WeatherReport report = new WeatherReport();
        WeatherApplication application = new WeatherApplication(report);
        try {
            Scanner scanner = new Scanner(System.in);
            application.weatherInfoFromConsoleInput(scanner);

            //application.writeWeatherInfoForCitiesInFileToDifferentFiles("input.txt");

        } catch (IOException e) {
            System.out.println("Wrong city name.");
        }
    }
}
