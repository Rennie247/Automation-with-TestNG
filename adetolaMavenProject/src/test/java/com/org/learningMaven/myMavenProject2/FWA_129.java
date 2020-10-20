package com.org.learningMaven.myMavenProject2;
//Verify if user can remove the added Credit Card

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class FWA_129 extends FWA_128{
	public String baseUrl = "https://uatfreshiiorder.tacitdev.ca/";
	public ChromeDriver driver;

  @BeforeTest
  public void openFreshiiBrowser() {
	System.out.println("Launching Chrome browser..");
	System.setProperty("webdriver.chrome.driver", "./Resource\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(baseUrl);
	
	// maximize the browser window
	driver.manage().window().maximize();
	}

   
  @BeforeMethod
  public void checkTitleMatch() {
	  	Assert.assertEquals("Freshii", driver.getTitle());
	  	System.out.println("Logged in successfully");
	}

  @Test
  public void removeCreditCard()    {   
	  
	  
  }
 
  
	 @AfterTest
	  public void quitFreshiiApp() {
		  driver.quit();
		  System.out.println("Finished Freshii Test On Chrome Browser");
		  System.out.println(driver.findElement(By.xpath("//div[contains(text(),'We could not validate your credit card billing pos')]")));
	 }
	 
}