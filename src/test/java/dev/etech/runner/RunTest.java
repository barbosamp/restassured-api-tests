package dev.etech.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "./src/test/resources/features",
        glue = "/dev/etech/steps",
        //tags = "@regressivo", Executa todos os cenarios do projeto que contem a tag @smokeTest
        //tags = "@cadastro and @regressivo", Executa todos os cenarios que contem as duas tags
        tags = "@regressivo",
        plugin = {"json:target/cucumber/cucumber.json"}
)

public class RunTest {
}
