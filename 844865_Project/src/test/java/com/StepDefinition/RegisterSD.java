package com.StepDefinition;

import com.Pages.RegisterPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterSD {
	RegisterPage register = new RegisterPage();
	@Given("^the Opencart application opens in chrome browser$")
	public void the_Opencart_application_opens_in_chrome_browser() throws Throwable {
	   register.url("chrome");
	}

	@When("^the user clicks on register$")
	public void the_user_clicks_on_register() throws Throwable {
		register.HomePage();
	}

	@Then("^the user fills all the details$")
	public void the_user_fills_all_the_details() throws Throwable {
	   register.Register();
	}

	@Then("^the user clicks on submit$")
	public void the_user_clicks_on_submit() throws Throwable {
	   register.submitbutton();
	}
}
