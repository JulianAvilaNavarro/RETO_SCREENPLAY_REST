package co.com.sofka.questions;


import co.com.sofka.models.PutModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetUserQuestionsJsonPlaceH implements Question {

    @Override
    public PutModel answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(PutModel.class);
    }
}

