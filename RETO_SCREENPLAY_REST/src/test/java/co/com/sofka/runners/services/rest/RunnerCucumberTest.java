package co.com.sofka.runners.services.rest;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/services/rest/putanddelete/putanddelete.feature",
                "src/test/resources/features/services/rest/putandget/putandget.feature"},
        glue = {"co.com.sofka.stepdefinitions.services.rest"}
)


public class RunnerCucumberTest {
}
