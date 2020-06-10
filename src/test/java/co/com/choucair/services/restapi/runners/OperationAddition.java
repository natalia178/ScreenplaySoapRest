package co.com.choucair.services.restapi.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static cucumber.api.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/soap/operation_addition.feature"},
        glue = {"co.com.choucair.services.restapi.stepdefinitions.soap"},
        snippets = CAMELCASE)
public class OperationAddition {
}
