package cucumberTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 *  
 * @author jiteshkumar.patel
 *
 */

// ,dryRun=true  --> will validate all the required stepDefinition are implemented
// ,monochrome=true --> display console output in more readable format
// ,format={"pretty", "junit:junitoutput/cucumber.xml"} --> different ways it generate reports/output
// features = "Feature/LogIn_WithData_Test.feature" --> this will run only this feature file
// features = "Feature" --> this will run all the feature files in the folder

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature/LogIn_WithData_Test.feature"
		,glue={"stepDefinition"}
		,monochrome=true
		,format={"pretty", "junit:junitoutput/cucumber.xml", "json:junitoutput/cucumber.json" }
		)
public class TestRunnerLoginWithData {


}
