package console;

import java.util.Scanner;

public class ConsoleReader {

    public String getCityNameFromUserInput(Scanner scanner) {
        String cityName = "";
        while (true) {
            System.out.println("Enter city name: ");
            if (scanner.hasNextLine()) {
                cityName = scanner.next();
                System.out.println(cityName);

                break;
            } else {
                System.out.println("Enter city name:");
            }
        }
        scanner.close();

        return cityName;
    }
}
