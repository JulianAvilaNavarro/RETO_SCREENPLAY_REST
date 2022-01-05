package co.com.sofka;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.log4j.PropertyConfigurator;

import java.util.HashMap;

public class ServiceSetup {

    protected static final String URL_BASE_REQRES= "https://reqres.in";
    protected static final String RESOURCE_REQRES= "/api/users/2";

    protected static final String URL_BASE_JSONPLACEHOLDER= "https://jsonplaceholder.typicode.com";
    protected static final String RESOURCE_JSONPLACEHOLDER= "/posts/1";
    protected final Actor actor = new Actor("Julian");

    protected void setupREQRES(){
        PropertyConfigurator.configure("C:\\Users\\Julian\\Desktop\\RETO_SCREEN_PLAY_SOAP\\src\\test\\resources\\log4j\\log4j.properties");
        actorCanREQRES();
    }
    protected void setupJSONPLACEHOLDER(){
        PropertyConfigurator.configure("C:\\Users\\Julian\\Desktop\\RETO_SCREEN_PLAY_SOAP\\src\\test\\resources\\log4j\\log4j.properties");

        actorCanJSONPLACEHOLDER();
    }

    private void actorCanREQRES(){
        actor.can(CallAnApi.at(URL_BASE_REQRES));
    }

    private void actorCanJSONPLACEHOLDER(){
        actor.can(CallAnApi.at(URL_BASE_JSONPLACEHOLDER));
    }



}
