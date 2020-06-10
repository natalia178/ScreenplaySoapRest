package co.com.choucair.services.restapi.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static co.com.choucair.services.restapi.util.SOAPService.ADD;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Addition implements Task {
    private int intA;
    private int intB;
    public Addition(int intA, int intB) {
        this.intA = intA;
        this.intB = intB;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(ADD.toString())
                        .with(request -> request
                                .header("Content-Type", "application/soap+xml;charset=UTF-8")
                                .header("Accept-Encoding", "gzip,deflate")
                                .body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n" +
                                        "   <soapenv:Header/>\n" +
                                        "   <soapenv:Body>\n" +
                                        "      <tem:Add>\n" +
                                        "         <tem:intA>"+intA +"</tem:intA>\n" +
                                        "         <tem:intB>"+intB +"</tem:intB>\n" +
                                        "      </tem:Add>\n" +
                                        "   </soapenv:Body>\n" +
                                        "</soapenv:Envelope>")
                        )
        );
    }
    public static Addition towValues(int intA , int  intB) {
        return instrumented(Addition.class, intA , intB);
    }
}
