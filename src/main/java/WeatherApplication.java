import weather.CurrentWeather;
import weather.ThreeDaysWeather;
import weather.WeatherRequest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class WeatherApplication {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String cityName = "";
        String currentWeatherInfo = "";
        String threeDaysWeatherInfo = "";

        while (true) {
            System.out.println("Enter city name: ");
            if (scanner.hasNextLine()) {
                cityName = scanner.next();
                System.out.println(cityName);

                WeatherRequest request = new WeatherRequest(cityName, "EE");

                CurrentWeather currentWeather = new CurrentWeather(request);
                currentWeatherInfo = currentWeather.getCurrentTemperature();
                System.out.println(currentWeatherInfo);

                ThreeDaysWeather threeDaysWeather = new ThreeDaysWeather(request);
                threeDaysWeatherInfo = threeDaysWeather.get3DaysTemperatures();
                System.out.println(threeDaysWeatherInfo);
                break;
            } else {
                System.out.println("Enter city name:");
            }
        }
        scanner.close();

        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Path path = Paths.get("src/main/java/weather/input.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(cityName);
        } catch (IOException e) {
            System.out.println("IOException:" + e.getMessage());
            e.printStackTrace();
        }

        Path pathForWeatherInfo = Paths.get("src/main/java/weather/output.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(pathForWeatherInfo)) {
            writer.write(cityName + "\n");
            writer.write(currentWeatherInfo + "\n");
            writer.write(threeDaysWeatherInfo + "\n");
        } catch (IOException e) {
            System.out.println("IOException:" + e.getMessage());
            e.printStackTrace();
        }

    }
}
