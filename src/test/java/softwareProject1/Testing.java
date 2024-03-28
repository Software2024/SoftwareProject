package softwareProject1;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


	

	@RunWith(Cucumber.class)
	@CucumberOptions(features = "src/test/resources/use_cases", glue ="softwareProject1" )
	public class Testing {
	 
	}