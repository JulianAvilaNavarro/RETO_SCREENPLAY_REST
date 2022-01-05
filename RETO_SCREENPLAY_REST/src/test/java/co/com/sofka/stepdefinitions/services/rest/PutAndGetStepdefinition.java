package co.com.sofka.stepdefinitions.services.rest;

import co.com.sofka.ServiceSetup;
import co.com.sofka.models.PutModel;
import co.com.sofka.questions.GetUserQuestionsJsonPlaceH;
import co.com.sofka.questions.ReturnRestServicesResponse;
import co.com.sofka.utils.service.rest.BodysForPut;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;

import static co.com.sofka.tasks.DoGet.doGet;
import static co.com.sofka.tasks.DoPut.doPut;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PutAndGetStepdefinition extends ServiceSetup {
    private static final Logger LOGGER = Logger.getLogger(PutAndGetStepdefinition.class);
    @Given("el usuario se encuentra en la pagina y desea actualizar su informacion")
    public void elUsuarioSeEncuentraEnLaPaginaYDeseaActualizarSuInformacion() {
        try {
            LOGGER.info("Se inicializa las configuraciones");
            super.setupJSONPLACEHOLDER();

        }catch (Exception e){
            LOGGER.info("Error en la configuración general");
        }


    }

    @When("el usuario utiliza la funcion put")
    public void elUsuarioUtilizaLaFuncionPut() {

        try {
            LOGGER.info("Se realiza a actualizacion");

            actor.attemptsTo(doPut()
                    .withTheResource(RESOURCE_JSONPLACEHOLDER)
                    .andTheBodyRequest(BodysForPut.BODY_FOR_PUT_JSONPLACEHOLDER.getValue()));


        }catch (Exception e){
            LOGGER.info("Error en la actualizacion");
        }


    }
    @Then("el usuario vera que su informacion fue actualizada")
    public void elUsuarioVeraQueSuInformacionFueActualizada() {

        try {
            LOGGER.info("Se realiza la comprobacion de la informacion actualizada");

            PutModel user = new GetUserQuestionsJsonPlaceH().answeredBy(actor);
            actor.should(seeThat("El codigo de respuesta", ReturnRestServicesResponse.was(), equalTo(HttpStatus.SC_OK)),
                    seeThat("El nombre del titulo es: ", p -> user.getTitle(), equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")));



        }catch (Exception e){
            LOGGER.info("Error en la comprobacion");
        }

    }

    //Scenario 2

    @Given("el usuario esta en la pagina y desea ver su informacion")
    public void elUsuarioEstaEnLaPaginaYDeseaVerSuInformacion() {
        try {
            LOGGER.info("Se inicializa las configuraciones");
            super.setupJSONPLACEHOLDER();

        }catch (Exception e){
            LOGGER.info("Error en la configuración general");
        }

    }

    @When("el usuario utiliza la funcion get")
    public void elUsuarioUtilizaLaFuncionGet() {
        try {

            LOGGER.info("Se inicializa la peticion de informacion");

            actor.attemptsTo(doGet().withTheResource(RESOURCE_JSONPLACEHOLDER));


        }catch (Exception e){
            LOGGER.info("Error en la la peticion de informacion");
        }

    }
    @Then("el usuario vera que su informacion")
    public void elUsuarioVeraQueSuInformacion() {
        try {
            LOGGER.info("Se valida que la informacion recibida corresponda");
            LastResponse.received().answeredBy(actor).body().prettyPrint();
            actor.should(seeThat("El codigo de respuesta", ReturnRestServicesResponse.was(), Matchers.equalTo(HttpStatus.SC_OK)));

            PutModel user = new GetUserQuestionsJsonPlaceH().answeredBy(actor);
            actor.should(seeThat("El codigo de respuesta", ReturnRestServicesResponse.was(), equalTo(HttpStatus.SC_OK)),
                    seeThat("El nombre del titulo es: ", poke -> user.getUserId(), equalTo(1)));

        }catch (Exception e){
            LOGGER.info("Error en la validacion");
        }

    }




}
