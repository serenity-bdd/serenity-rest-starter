package starter;

public enum WebServiceEndPoints {
    STATUS("http://localhost:8080/api/status"),
    TRADE("http://localhost:8080/api/trade");

    private final String url;

    WebServiceEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
