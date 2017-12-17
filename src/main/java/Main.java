import weather.WeatherApplication;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        WeatherApplication application = new WeatherApplication();
        try {
            Scanner scanner = new Scanner(System.in);
            application.weatherInfoFromConsoleInput(scanner);

            application.writeWeatherInfoForCitiesInFileToDifferentFiles("input.txt");

        } catch (IOException e) {
            System.out.println("Something went wrong.");
            System.out.println(e.getMessage());
        }
    }
}
