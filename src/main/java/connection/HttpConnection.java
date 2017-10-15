package connection;

import java.net.HttpURLConnection;

public class HttpConnection {
    private String url;

    public HttpConnection(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public static HttpURLConnection makeUrlConnection(String url) {
        return null;
    }
}
