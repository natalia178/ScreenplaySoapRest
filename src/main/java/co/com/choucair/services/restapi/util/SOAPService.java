package co.com.choucair.services.restapi.util;

public enum SOAPService {
    BASE_URL("http://www.dneonline.com/calculator.asmx"),
    ADD("/Add");
    private String uri;
    SOAPService(String uri) {
        this.uri = uri;
    }
    @Override
    public String toString() {
        return uri;
    }
}
