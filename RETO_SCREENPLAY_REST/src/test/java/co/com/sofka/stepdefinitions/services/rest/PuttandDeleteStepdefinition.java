package co.com.sofka.stepdefinitions.services.rest;

import co.com.sofka.ServiceSetup;
import co.com.sofka.models.ModelReqres;
import co.com.sofka.questions.GetUserQuestionsReqres;
import co.com.sofka.questions.ReturnRestServicesResponse;
import co.com.sofka.utils.service.rest.BodysForPut;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.hamcrest.CoreMatchers;

import static co.com.sofka.tasks.DoDelete.doDelete;
import static co.com.sofka.tasks.DoPut.doPut;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.assertj.core.api.Assertions.assertThat;

public class PuttandDeleteStepdefinition extends ServiceSetup {
    private static final Logger LOGGER = Logger.getLogger(PuttandDeleteStepdefinition.class);

    //scenario 1
    @Given("el usuario esta en la pagina de busqueda y desea actualizar la informacion de una persona")
    public void elUsuarioEstaEnLaPaginaDeBusquedaYDeseaActualizarLaInformacionDeUnaPersona() {

        try {
            LOGGER.info("Se inicializa las configuraciones");
            super.setupREQRES();

        }catch (Exception e){
            LOGGER.info("Error en la configuración general");
        }

    }

    @When("el usuario actualiza el recurso que desea y obtiene una respuesta")
    public void elUsuarioActualizaElRecursoQueDeseaYObtieneUnaRespuesta() {


            try {
                LOGGER.info("Se realiza la actualizacion");

                actor.attemptsTo(doPut()
                        .withTheResource(RESOURCE_REQRES)
                        .andTheBodyRequest(BodysForPut.BODY_FOR_PUT_REQRES.getValue()));

            }catch (Exception e){
                LOGGER.info("Error en la actualizacion");
            }


    }
    @Then("el usuario podra ver la confirmacion de la actualizacion")
    public void elUsuarioPodraVerLaConfirmacionDeLaActualizacion() {


            LOGGER.info("Se comparan los resultados de la actualizacion");
            try {

                ModelReqres user = new GetUserQuestionsReqres().answeredBy(actor);
                actor.should(seeThat("El codigo de respuesta", ReturnRestServicesResponse.was(), CoreMatchers.equalTo(HttpStatus.SC_OK)),
                        seeThat("El nombre de la persona es: ", p -> user.getName(), CoreMatchers.equalTo("morpheus")));

            }catch (Exception e){
                LOGGER.info("Error en la comparacion");
            }



    }
 // scenario 2
    @Given("el usuario esta en la pagina y desea borrar un registro")
    public void elUsuarioEstaEnLaPaginaYDeseaBorrarUnRegistro() {
        try {
            LOGGER.info("Se inicializa las configuraciones");
            super.setupREQRES();

        }catch (Exception e){
            LOGGER.info("Error en la configuración general");
        }

    }

    @When("el usuario escribe la instruccion de borrar el registro")
    public void elUsuarioEscribeLaInstruccionDeBorrarElRegistro() {
        try {
            LOGGER.info("Se realiza el borrado");

            actor.attemptsTo(doDelete().withTheResource(RESOURCE_REQRES));


        }catch (Exception e){
            LOGGER.info("Error en el borrado");
        }

    }
    @Then("el usuario obtiene una la respuesta de borrado")
    public void elUsuarioObtieneUnaLaRespuestaDeBorrado() {

        try {
            LOGGER.info("Se evalua que el estatu corresponda un delete");

            actor.should(seeThat("El codigo de respuesta", ReturnRestServicesResponse.was(), CoreMatchers.equalTo(HttpStatus.SC_NO_CONTENT)));


        }catch (Exception e){
            LOGGER.info("Error en la comprobacion");
        }


    }





}
