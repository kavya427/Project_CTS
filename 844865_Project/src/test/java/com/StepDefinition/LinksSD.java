package com.StepDefinition;

import com.Pages.Links;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LinksSD {
	Links Link=new Links();
	@Given("^the application opens$")
	public void the_application_opens() throws Throwable {
		Link.url("chrome");
	}

	@When("^the user login to the application$")
	public void the_user_login_to_the_application() throws Throwable {
		Link.HomePage();
	}

	@Then("^the homepage opens$")
	public void the_homepage_opens() throws Throwable {
		Link.login();
	}

	@Then("^get all the links in that page$")
	public void get_all_the_links_in_that_page() throws Throwable {
		Link.Screenshot("E:\\Eclipse\\844865_Project\\ScreenShot\\homepage.png");
		Link.Linksinthepage();
	}
}
