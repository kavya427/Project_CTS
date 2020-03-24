package com.StepDefinition;

import com.Pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSD {
	LoginPage Login= new LoginPage();
	@Given("^the application opens in browser$")
	public void the_application_opens_in_browser() throws Throwable {
		Login.url();
	}

	@When("^the user clicks on Login$")
	public void the_user_clicks_on_Login() throws Throwable {
		Login.HomePage();
	}

	@Then("^the user gives valid credentials$")
	public void the_user_gives_valid_credentials() throws Throwable {
	   for(int i =1;i<4;i++)
		   {
		   Login.Login(i);
		   if(i<3)
		   {
		   Login.url();
		   Login.HomePage();
		   }
		   }
	}

	@Then("^clicks on Login button$")
	public void clicks_on_Login_button() throws Throwable {
	   Login.check();
	}
}
