package console;

import java.util.Scanner;

public class ConsoleReader {

    public String getCityNameFromUserInput() {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String cityName = "";
        Scanner scanner = new Scanner(System.in);
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
