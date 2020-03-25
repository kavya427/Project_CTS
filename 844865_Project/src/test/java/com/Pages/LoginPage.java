package com.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import ExcelUtility.ExcelPage;

public class LoginPage {
	WebDriver driver;
	By Myaccount=By.linkText("My Account");
	By login=By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a");
	By Email=By.id("input-email");
	By password=By.id("input-password");
	By loginbtn=By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
	public void url(String browser) //  launching the application using multiple browsers
	{ 
		try {
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
		}
			catch(WebDriverException e) // this block is executed and message is printed when browser cannot be launched
			{
				System.out.println("browser not launching");
			}
		
		driver.manage().window().maximize();  // maximizes the browser
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); // providing waiting time
		
	}
	public void HomePage() //using webdriver get visting the testing website
	{
		driver.get("https://demo.opencart.com/"); // takes us to the homepage of the application
		System.out.println(driver.getTitle()); //displays title of the page
	}
	public void Login(int a) throws IOException 
	{
		driver.findElement(Myaccount).click();
		WebElement link =driver.findElement(Myaccount); 
		WebElement link2=driver.findElement(login);
		Actions action = new Actions(driver); // Actions class to perform mouse actions
		action.moveToElement(link);
		action.moveToElement(link2).click().perform();
		ExcelPage excel= new ExcelPage(); // creating object for excel page
		driver.findElement(Email).sendKeys(excel.excel_Email(a)); // getting email data from the excel sheet
		driver.findElement(password).sendKeys(excel.excel_password(a)); // getting passwords from the excel sheet
		driver.findElement(loginbtn).click();
		
	}
	public void check() throws InterruptedException
	{
		
		String store=driver.findElement(By.linkText("Your Store")).getText();
		Assert.assertEquals("Your Store", store); // comparing actual and expected result
		Thread.sleep(1000); // providing wait time
		driver.close(); // close the browser
	}
}
