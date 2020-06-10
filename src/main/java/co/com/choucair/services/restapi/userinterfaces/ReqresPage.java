package co.com.choucair.services.restapi.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://reqres.in/")
public class ReqresPage extends PageObject{

    public static final Target USERS_IN_JSON_FORMAT = Target.the("users in json format")
            .locatedBy("//*[@id=\"console\"]/div[2]/div[2]/pre");

}
