package com.StepDefinition;

import com.Pages.InvalidLogin;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InvalidLoginSD {
	InvalidLogin Invalid= new InvalidLogin();
	@Given("^the application will open in chrome browser$")
	public void the_application_will_open_in_chrome_browser() throws Throwable {
		Invalid.url();
	}  

	@When("^the user clicks on login$")
	public void the_user_clicks_on_login() throws Throwable {
		Invalid.HomePage();
	}

	@Then("^the user tries to login with invalid details$")
	public void the_user_tries_to_login_with_invalid_details() throws Throwable {
		Invalid.InvalidLogin();
	}

	@Then("^click on login button$")
	public void click_on_login_button() throws Throwable {
		Invalid.clickLogin();
		Invalid.Screenshot("E:\\Eclipse\\844865_Project\\ScreenShot\\invalid.png");
	}
}
