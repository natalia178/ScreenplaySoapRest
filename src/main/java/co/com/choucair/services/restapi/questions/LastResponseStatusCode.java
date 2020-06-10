package co.com.choucair.services.restapi.questions;

import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class LastResponseStatusCode {

    public static Question<Boolean> is(int code){
        return a -> lastResponse().statusCode() == code;
    }
}
