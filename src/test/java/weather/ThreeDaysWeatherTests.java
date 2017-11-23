package weather;

public class ThreeDaysWeatherTests {
    private static WeatherRequest request;
    private static ThreeDaysWeather threeDaysWeather;
    private static String threeDaysTemperaturesString;

    /**
    @BeforeClass
    public static void setUpForTest() throws IOException {
        request = new WeatherRequest("Tallinn", "EE");
        threeDaysWeather = new ThreeDaysWeather(request);
        try {
            threeDaysWeather.setJsonObject3DaysWeather(HttpConnection.getWeatherInfoAsJson(
                    "http://api.openweathermap.org/data/2.5/forecast?q=Tallinn,EE&units=" +
                            "metric&APPID=8142ab303ab91d4449a4e5f5685de78d"));
            threeDaysTemperaturesString = threeDaysWeather.get3DaysTemperaturesString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIfWeatherForecastForThreeDaysIsGiven() {
        assertEquals(3, threeDaysWeather.getDayWeathersList().size());
    }

    @Test
    public void testIfWeatherForecastForRightDaysIsGiven() {
        LocalDate today = LocalDate.now();
        String day1 = today.plusDays(1).toString();
        String day2 = today.plusDays(2).toString();
        String day3 = today.plusDays(3).toString();
        assertTrue(threeDaysTemperaturesString.contains(day1)
                && threeDaysTemperaturesString.contains(day2)
                && threeDaysTemperaturesString.contains(day3));
    }


    /**
    @Test
    public void testLowestAndHighestTemperaturesAreGivenForThreeDays() {
        try {
            for (String date: threeDaysWeather.threeDaysMap.keySet()) {
                ArrayList<Double> temperatures = threeDaysWeather.getLowestAndHighestTemperaturesForThatDay(date);
                assertEquals(2, temperatures.size());
            }
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }
    **/
}
