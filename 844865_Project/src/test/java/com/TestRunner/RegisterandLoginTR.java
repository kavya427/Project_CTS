package com.TestRunner;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/resources/Feature/TestCase.feature",
		plugin = {"pretty", "html:reports/cucumber-html-report"},
		tags = {"@tc01_Register","@tc02_Validlogin","@tc03_InvalidLogin","@tc04_MandatoryFields","@tc05_Links"},
		glue = {"com.StepDefinition"},
		monochrome = true
		)
public class RegisterandLoginTR {

}

