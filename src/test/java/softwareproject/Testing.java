package softwareproject;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:/Users/asus/eclipse-workspace/softwareProject1/src/test/resources/use_cases",

        plugin = {"html:target/cucumber/wikipedia.html"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {"softwareproject"},
        tags = "@shahd"

)

	public class Testing {
	 
	}