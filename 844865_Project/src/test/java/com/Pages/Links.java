package com.Pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium. interactions.Actions;

public class Links {
	WebDriver driver;
	By Myaccount=By.linkText("My Account");
	By login=By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a");
	By Email=By.id("input-email");
	By password=By.id("input-password");
	By loginbtn=By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
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
	public void Screenshot(String path) throws IOException{
		TakesScreenshot ts =((TakesScreenshot)driver);
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,new File(path));
	}
	public void login()
	{
		driver.findElement(Myaccount).click();
		WebElement account =driver.findElement(Myaccount); 
		WebElement loginto=driver.findElement(login);
		Actions action = new Actions(driver);
		action.moveToElement(account);
		action.moveToElement(loginto).click().perform();
		driver.findElement(loginbtn).click();
	}
	public void Linksinthepage() throws InterruptedException
	{
		driver.findElement(Email).sendKeys("dondetikishore@gmail.com");
		driver.findElement(password).sendKeys("kishore123");
		driver.findElement(loginbtn).click();
		Thread.sleep(1000); // waiting time
		List<WebElement> links=driver.findElements(By.tagName("a")); //Links in that page
		System.out.println(links.size());
		for(int i=1;i<links.size();i=i+1)
		{
			System.out.println(links.get(i).getText()); //prints all the links in homepage
		}
		driver.close(); //close the browser
	}
}
