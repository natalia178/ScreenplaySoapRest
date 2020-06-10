package co.com.choucair.services.restapi.stepdefinitions.soap;

import co.com.choucair.services.restapi.questions.LastResponseStatusCode;
import co.com.choucair.services.restapi.task.Addition;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import static co.com.choucair.services.restapi.util.SOAPService.BASE_URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class OperationAdditionStepDefinitions {

    private static final String NATTY = "Natty";

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(NATTY).whoCan(CallAnApi.at(BASE_URL.toString()));
    }

    @When("^realizamos las suma con los valores (\\d+) (\\d+)$")
    public void heAdditionWithValues(int intA,  int intB ) throws Exception {
        theActorInTheSpotlight().attemptsTo(
                Addition.towValues(intA,intB)
        );
    }

    @Then("^deberia ver el resultado de la suma$")
    public void youShouldSeeTheResultPlus() throws Exception {
        theActorInTheSpotlight().should(seeThat("last response status code is 200", LastResponseStatusCode.is(200)));
    }

}
