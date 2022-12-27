package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/AppFeatures"},
		glue = {"stepdefinations", "apphooks"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", // To generate Extent spark report
				"timeline:test-output-thread/", // to display time-line report during parallel execution
				"rerun:target/failedrerun.txt"}, // failed scenario's will display in this file
		monochrome = true,
		publish = true
		//tags = "not @SkipTest" // To skip the feature/scenario
		)

public class JUnitRunner {

}
