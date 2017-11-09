package files;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WeatherDataWriter {

    public void writeCityNameToFile(String cityName) {
        Path path = Paths.get("src/main/java/files/input.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(cityName);
        } catch (IOException e) {
            System.out.println("IOException:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void writeWeatherInfoToFile(String cityName, String currentWeatherInfo, String threeDaysWeatherInfo) {
        Path pathForWeatherInfo = Paths.get("src/main/java/files/" + cityName + ".txt");
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
