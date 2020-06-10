package co.com.choucair.services.restapi.task;

import co.com.choucair.services.restapi.model.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static co.com.choucair.services.restapi.util.RestService.CREATE_USER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateUser implements Task {

    private User user;
    public CreateUser(User user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                Post.to(CREATE_USER.toString())
                        .with(request -> request.header("Content-Type", "application/json")
                        .body(user)
                )
        );
    }

    public static CreateUser createUser(User user){
        return instrumented(CreateUser.class, user);
    }
}
