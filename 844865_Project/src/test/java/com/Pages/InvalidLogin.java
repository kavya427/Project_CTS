 package com.Pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class InvalidLogin {
		WebDriver driver;
		By Myaccount=By.linkText("My Account");
		By login=By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a");
		By Email=By.id("input-email");
		By password=By.id("input-password");
		By loginbtn=By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
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
		public void InvalidLogin()
		{
			driver.findElement(Myaccount).click();
			WebElement account =driver.findElement(Myaccount); // storing the webelement
			WebElement loginto=driver.findElement(login);
			Actions action = new Actions(driver); // actions class to perform mouse moments
			action.moveToElement(account);
			action.moveToElement(loginto).click().perform();
			driver.findElement(Email).sendKeys("12345");
			driver.findElement(password).sendKeys("kavya3");
		}
		public void Screenshot(String path) throws IOException{
			TakesScreenshot ts =((TakesScreenshot)driver); // To take screenshot of the page 
			File source = ts.getScreenshotAs(OutputType.FILE); 
			FileUtils.copyFile(source,new File(path));
		}
		public void clickLogin() throws InterruptedException
		{
			driver.findElement(loginbtn).click();
			System.out.println("No match for E-Mail Address and/or Password"); // since we are providing wrong credentials 
			Thread.sleep(1000); // waiting time
			driver.close(); // close the browser
		}
}

