package com.org.learningMaven.myMavenProject2;
//Verify - Cancel order placed for later - before Printing

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FWA_139 {
	//The credit card details did not work for https://uatfreshiiorder.tacitdev.ca/ca/lang/en so i used this website 
	public String baseUrl = "https://freshii.tacitdev.ca/";
	public ChromeDriver driver;

  @BeforeTest
  public void openFreshiiBrowser() {
	System.out.println("Launching Chrome browser..");
	System.setProperty("webdriver.chrome.driver", "./Resource\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(baseUrl);
	driver.manage().window().maximize();
	}

 
  @BeforeMethod
  public void checkTitleMatch() {
	  	Assert.assertEquals("Freshii", driver.getTitle());
	  	System.out.println("Logged in successfully");
	}

  @Test
  public void cancelOrderForLater() throws InterruptedException {   
		//Log in user
	    driver.findElement(By.xpath("//span[contains(text(),'Log in/Sign up')]")).click();
	    Thread.sleep(5000);
	    
	    //Enter Email and password
	    driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("testfreshii@abbuzz.com");
	    driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("sample@123");
	    driver.findElement(By.xpath("//button[contains(text(),'login')]")).click();
	    Thread.sleep(5000);
	    
	    //Click on the Drop down for options
	    driver.findElement(By.xpath("//header/div[2]/div[2]/div[1]/button[1]/i[1]")).click();
	    Thread.sleep(5000);
	    
	    //Select 'My History' from option to view past orders
	    driver.findElement(By.xpath("//span[contains(text(),'My History')]")).click();
	    Thread.sleep(5000);
	
	    // Click on Cancel order
	    driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
	    Thread.sleep(5000);
	    System.out.println("Later order is cancelled!"); 
  	} 
   
	 @AfterTest
	 //Quit the app
	  public void quitFreshiiApp() {
		  driver.quit();
		  System.out.println("Finished Freshii Test On Chrome Browser");
	 }
	 

  }