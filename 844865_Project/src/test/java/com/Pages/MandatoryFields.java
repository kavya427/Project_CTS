package com.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MandatoryFields {
		WebDriver driver;
		By Myaccount=By.linkText("My Account");
		By Register=By.linkText("Register");
		By FirstName=By.id("input-firstname");
		By LastName=By.id("input-lastname");
		By email=By.id("input-email");
		By telephone=By.id("input-telephone");
		By pwd=By.id("input-password");
		By cpwd=By.id("input-confirm");
		By terms=By.xpath("//*[@id=\"content\"]/form/div/div/input[1]");
		By cont=By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
		public void url(String browser) //  launching the application using multiple browsers
		{ 
				if(browser.equalsIgnoreCase("chrome")) 
				{
					System.setProperty("webdriver.chrome.driver", "E:\\Eclipse\\844865_Project\\Driver\\chromedriver.exe\\");
					driver = new ChromeDriver(); // to launch the application in chrome browser
				}
				else
				if(browser.equalsIgnoreCase("firefox"))
				{
					System.setProperty("webdriver.gecko.driver", "E:\\Eclipse\\844865_Project\\Driver\\chromedriver.exe\\");
					driver = new FirefoxDriver(); // to launch the application in firefox browser
				}
			
			driver.manage().window().maximize();  // maximizes the browser
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); // providing waiting time
			
		}
		public void HomePage() //using webdriver get visting the testing website
		{
			driver.get("https://demo.opencart.com/"); // takes us to the homepage of the application
			System.out.println(driver.getTitle()); //displays title of the page
		}
		public void MandatoryFields() throws IOException
		{
			driver.findElement(Myaccount).click();
			WebElement link =driver.findElement(Myaccount); // move to element by creating object
			WebElement link2=driver.findElement(Register);
			Actions action = new Actions(driver); // To perform mouse moments
			action.moveToElement(link);
			action.moveToElement(link2).click().perform();
			driver.findElement(FirstName).sendKeys("kavya"); 
			driver.findElement(LastName).sendKeys("d");
			driver.findElement(pwd).sendKeys("kavya12");
			driver.findElement(cpwd).sendKeys("kavya12"); // missed entering Email and phone number
			driver.findElement(terms).click();
			
		}
		public void submit() throws InterruptedException
		{
			driver.findElement(cont).click();// loging button
			Thread.sleep(1000); // providing wait time
			System.out.println("mandatory fields missing");	// prints this message when mandatory fields are missing
			driver.close(); // close the browser
		}
}

