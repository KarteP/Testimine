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
        String currentWeatherInfo = currentWeather.getCurrentTemperature();
        System.out.println(currentWeatherInfo);

        ThreeDaysWeather threeDaysWeather = new ThreeDaysWeather(request);
        String threeDaysWeatherInfo = threeDaysWeather.get3DaysTemperatures();
        System.out.println(threeDaysWeatherInfo);

        FileWriter fileWriter = new FileWriter();
        fileWriter.writeToFile(cityName, "input.txt");

        String cityWeatherInfo = cityName + "\n" + currentWeatherInfo + "\n" + threeDaysWeatherInfo + "\n";
        fileWriter.writeToFile(cityWeatherInfo, cityName + ".txt");
    }
}
