package weather;

import console.ConsoleReader;
import files.FileReader;
import files.FileWriter;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class WeatherApplication {

    private WeatherReport report;


    public WeatherApplication(WeatherReport report) {
        this.report = report;
    }

    public void weatherInfoFromConsoleInput(Scanner scanner) throws IOException {
        ConsoleReader consoleReader = new ConsoleReader();
        String cityName = consoleReader.getCityNameFromUserInput(scanner);
        FileWriter fileWriter = new FileWriter();

        String cityWeatherInfo = report.getWeatherInfoString(cityName);
        System.out.println(cityWeatherInfo);
        fileWriter.writeToFile(cityWeatherInfo, cityName + ".txt");
    }

    public void writeWeatherInfoForCitiesInFileToDifferentFiles(String fileName) throws IOException {
        FileReader reader = new FileReader();
        FileWriter writer = new FileWriter();
        List<String> cities = reader.readFromFile(fileName);
        for (String city : cities) {
            String weatherInfo = report.getWeatherInfoString(city);
            writer.writeToFile(weatherInfo,city + ".txt");
        }
    }
}
