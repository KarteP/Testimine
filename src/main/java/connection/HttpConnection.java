package connection;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnection {

    public static HttpURLConnection makeUrlConnection(String url) {
        HttpURLConnection connection = null;
        try {
            URL urlStr = new URL(url);
            connection = (HttpURLConnection) urlStr.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }
}
