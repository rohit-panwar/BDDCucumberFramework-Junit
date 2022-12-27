package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"@target/failedrerun.txt"},
		glue = {"stepdefinations", "apphooks"},
		plugin = {"pretty",
				"rerun:target/failedrerun.txt"},
		monochrome = true,
		publish = true
		)

public class RerunRunner {

}
