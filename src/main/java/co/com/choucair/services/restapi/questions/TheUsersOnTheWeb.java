package co.com.choucair.services.restapi.questions;

import co.com.choucair.services.restapi.model.SummaryUsers;
import co.com.choucair.services.restapi.util.ConverterJson;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static co.com.choucair.services.restapi.userinterfaces.ReqresPage.USERS_IN_JSON_FORMAT;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

@Subject("The users on the web correspond to those of the service")
public class TheUsersOnTheWeb implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        SummaryUsers summaryUsersWeb = ConverterJson.fromJson(USERS_IN_JSON_FORMAT.resolveFor(actor).getText(), SummaryUsers.class);
        SummaryUsers summaryUsersService = lastResponse().body().as(SummaryUsers.class);

        return summaryUsersWeb.toString().equals(summaryUsersService.toString());
    }

    public static TheUsersOnTheWeb correspondToThoseOfTheService(){
        return new TheUsersOnTheWeb();
    }
}
