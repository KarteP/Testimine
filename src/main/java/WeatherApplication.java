import console.ConsoleReader;
import files.FileReader;
import files.FileWriter;
import weather.WeatherReport;
import weather.WeatherRequest;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class WeatherApplication {

    private WeatherReport report;

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

    public String weatherInfoFromConsoleInput(Scanner scanner) throws IOException {
        ConsoleReader consoleReader = new ConsoleReader();
        String cityName = consoleReader.getCityNameFromUserInput(scanner);

        WeatherRequest request = new WeatherRequest(cityName, "EE");
        this.report = new WeatherReport(request);
        report.setCurrentWeather();
        report.setThreeDaysWeather();

        String cityWeatherInfo = report.toString();
        System.out.println(cityWeatherInfo);

        FileWriter fileWriter = new FileWriter();
        fileWriter.writeToFile(cityWeatherInfo, cityName + ".txt");
        return cityWeatherInfo;
    }

    public void writeWeatherInfoForCitiesInFileToDifferentFiles(String inputFileName) throws IOException {
        FileReader reader = new FileReader();
        FileWriter writer = new FileWriter();
        List<String> cities = reader.readFromFile(inputFileName);
        System.out.println(cities);
        for (String city : cities) {
            WeatherRequest request = new WeatherRequest(city, "EE");


            WeatherReport report = new WeatherReport(request);
            report.setCurrentWeather();
            report.setThreeDaysWeather();

            String weatherInfo = LocalDateTime.now().toString() + "\n" + report.toString();
            System.out.println(weatherInfo);
            writer.writeToFile(weatherInfo,city + ".txt");
        }
    }
}
