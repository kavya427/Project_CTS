package com.StepDefinition;

import com.Pages.MandatoryFields;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MandatoryFieldsSD {
	MandatoryFields Mandatory=new MandatoryFields();
	@Given("^the application opens in chrome browser$")
	public void the_application_opens_in_chrome_browser() throws Throwable {
		Mandatory.url("chrome");
	}

	@When("^the user clicks on register button$")
	public void the_user_clicks_on_register_button() throws Throwable {
		Mandatory.HomePage();
	}

	@Then("^the user fills the details by leaving one mandatory field$")
	public void the_user_fills_the_details_by_leaving_one_mandatory_field() throws Throwable {
		Mandatory.MandatoryFields();
	}

	@Then("^clicks on submit button$")
	public void clicks_on_submit_button() throws Throwable {
		Mandatory.submit();
	}
}
