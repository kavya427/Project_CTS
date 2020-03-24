package com.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RegisterPage {
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
	public void url() //  launch the chrome
	{ 
		System.setProperty("webdriver.chrome.driver", "E:\\Eclipse\\844865_Project\\Driver\\chromedriver.exe\\");
		driver = new ChromeDriver();
		driver.manage().window().maximize();// maximizes the browser
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); // providing waiting time
		
	}
	public void HomePage() //using webdriver get visting the testing website
	{
		driver.get("https://demo.opencart.com/"); // takes us to the homepage of the application
		System.out.println(driver.getTitle()); //displays title of the page
	}
	public void Register() throws IOException
	{
		driver.findElement(Myaccount).click();
		WebElement link =driver.findElement(Myaccount); // move to  element by creating object
		WebElement link2=driver.findElement(Register); 
		Actions action = new Actions(driver); // To perform Mouse over moments we need to use Actions class
		action.moveToElement(link);
		action.moveToElement(link2).click().perform();
		driver.findElement(FirstName).sendKeys("kavya"); // passing the vaild mail
		driver.findElement(LastName).sendKeys("dondeti");
		driver.findElement(email).sendKeys("dondetikavya427@gmail.com");
		driver.findElement(telephone).sendKeys("9876543210");
		driver.findElement(pwd).sendKeys("kavya123");
		driver.findElement(cpwd).sendKeys("kavya123");
		driver.findElement(terms).click();
	}
	public void submitbutton() throws InterruptedException
	{
		driver.findElement(cont).click();
		System.out.println("Successfully registered");
		Thread.sleep(1000); // providing wait time
		driver.close();// closing browser
	}
}
