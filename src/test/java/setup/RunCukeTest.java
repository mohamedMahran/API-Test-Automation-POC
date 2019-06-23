package setup;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/features/"},
        glue = {"steps"},
        monochrome = true,
        tags = {"@PostOperationWithBody"},
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"}
		)
public class RunCukeTest { 

}


