import console.ConsoleReader;
import files.FileWriter;
import weather.CurrentWeather;
import weather.ThreeDaysWeather;
import weather.WeatherRequest;

public class WeatherApplication {

    public static void main(String[] args) throws Exception {

        ConsoleReader consoleReader = new ConsoleReader();
        String cityName = consoleReader.getCityNameFromUserInput();

        WeatherRequest request = new WeatherRequest(cityName, "EE");

        CurrentWeather currentWeather = new CurrentWeather(request);
        String cityCoordinates = currentWeather.getCityCoordinatesString();
        String currentWeatherInfo = currentWeather.getCurrentTemperatureString();

        ThreeDaysWeather threeDaysWeather = new ThreeDaysWeather(request);
        String threeDaysWeatherInfo = threeDaysWeather.get3DaysTemperaturesString();

        FileWriter fileWriter = new FileWriter();
        fileWriter.writeToFile(cityName, "userinput.txt");

        String cityWeatherInfo = cityName + "\n"
                + cityCoordinates + "\n"
                + currentWeatherInfo + "\n"
                + threeDaysWeatherInfo + "\n";
        System.out.println(cityWeatherInfo);
        fileWriter.writeToFile(cityWeatherInfo, cityName + ".txt");
    }
}
