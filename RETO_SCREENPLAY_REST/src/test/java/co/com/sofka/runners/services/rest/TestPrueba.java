package co.com.sofka.runners.services.rest;

import co.com.sofka.tasks.DoGet;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class TestPrueba {

    private static final String restApiURL="https://reqres.in";

    @Test
    public void getUsers(){
        Actor julian =Actor.named("Julian")
                .whoCan(CallAnApi.at(restApiURL));

        //julian.attemptsTo(Get.resource("/api/users/2"));
        julian.attemptsTo(new DoGet());

        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);


    }
}
