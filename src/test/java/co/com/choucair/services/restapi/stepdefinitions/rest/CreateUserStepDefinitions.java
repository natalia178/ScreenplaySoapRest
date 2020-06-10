package co.com.choucair.services.restapi.stepdefinitions.rest;

import co.com.choucair.services.restapi.model.builder.UserBuilder;
import co.com.choucair.services.restapi.questions.LastResponseStatusCode;
import co.com.choucair.services.restapi.task.CreateUser;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateUserStepDefinitions {

    @When("^creas un usuario$")
    public void youCreateAnUser() throws Exception {
        theActorInTheSpotlight().attemptsTo(
                CreateUser.createUser(
                UserBuilder.withName("Nataly Camargo")
                .andJob("QA Testing")
                )
        );
    }

    @Then("^Deberia ver a la usuaria creada$")
    public void iShouldSeeTheUserCreated() throws Exception {
        theActorInTheSpotlight().should(seeThat("el ultimo codigo de estado de respuesta es 201" , LastResponseStatusCode.is(201)));
    }

}
