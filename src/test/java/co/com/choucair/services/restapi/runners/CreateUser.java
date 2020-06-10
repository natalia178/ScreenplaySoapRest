package co.com.choucair.services.restapi.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static cucumber.api.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/rest/create_user.feature"},
        glue = {"co.com.choucair.services.restapi.stepdefinitions.rest"},
                snippets = CAMELCASE)
public class CreateUser {
}
