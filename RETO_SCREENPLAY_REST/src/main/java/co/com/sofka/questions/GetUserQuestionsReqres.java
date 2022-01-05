package co.com.sofka.questions;


import co.com.sofka.models.ModelReqres;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetUserQuestionsReqres implements Question {

    @Override
    public ModelReqres answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(ModelReqres.class);
    }
}

