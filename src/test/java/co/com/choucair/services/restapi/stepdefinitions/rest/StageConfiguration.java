package co.com.choucair.services.restapi.stepdefinitions.rest;

import co.com.choucair.services.restapi.util.RestService;
import cucumber.api.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class StageConfiguration {
    private static final String NATTY = "Natty";

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(NATTY).whoCan(CallAnApi.at(RestService.BASE_URL.toString()));
    }
}
