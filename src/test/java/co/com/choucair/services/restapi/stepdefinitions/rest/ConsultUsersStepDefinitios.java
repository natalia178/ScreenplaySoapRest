package co.com.choucair.services.restapi.stepdefinitions.rest;

import co.com.choucair.services.restapi.questions.LastResponseStatusCode;
import co.com.choucair.services.restapi.questions.TheUsersOnTheWeb;
import co.com.choucair.services.restapi.task.ConsultTheUsers;
import co.com.choucair.services.restapi.userinterfaces.ReqresPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultUsersStepDefinitios {

    private ReqresPage reqresPage;

    @When("^consultar al segundo grupo de tres usuarios\\.$")
    public void consultingTheSecondGroupOfThreeUsers() throws Exception {
        theActorInTheSpotlight().attemptsTo(
                ConsultTheUsers.ofTheSecondGroup(),
                Open.browserOn(reqresPage),
                Scroll.to(ReqresPage.USERS_IN_JSON_FORMAT)
        );

    }

    @Then("^Debería ver a las usuarias$")
    public void iShouldSeeTheUsers() throws Exception {
        theActorInTheSpotlight().should(seeThat("El ultimo codigo de estado de respuesta es 200" , LastResponseStatusCode.is(200)));
        theActorInTheSpotlight().should(seeThat(TheUsersOnTheWeb.correspondToThoseOfTheService()));
    }

}
