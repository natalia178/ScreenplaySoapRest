package co.com.choucair.services.restapi.task;

import co.com.choucair.services.restapi.util.RestService;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultTheUsers implements Task {

    private String consultUsers;

    public ConsultTheUsers(int page) {
        this.consultUsers = String.format(RestService.CONSULT_USERS.toString(), page);
    }

    @Override
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                Get.resource(consultUsers)
        );
    }

    public static ConsultTheUsers ofTheSecondGroup() {
        return instrumented(ConsultTheUsers.class, 2);
    }
}
