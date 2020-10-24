package com.org.learningMaven.myMavenProject2;
//Verify whether the user can Change Location in PickUp order

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class FWA_151 {
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
  public void ChangeLocationInPickupOrder() throws InterruptedException {   
		//Log in user
	    driver.findElement(By.xpath("//span[contains(text(),'Log in/Sign up')]")).click();
	    Thread.sleep(5000);
	    
	    //Enter Email and password
	    driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("testfreshii@abbuzz.com");
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("sample@123");
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//button[contains(text(),'login')]")).click();
	    Thread.sleep(5000);
	    
	    //placing a new order for Baja Burritos
	    driver.findElement(By.xpath("//button[contains(text(),'Order now')]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//body/app-root[1]/ng-component[1]/div[1]/main[1]/ng-component[1]/ng-component[1]/div[1]/div[2]/location-list[1]/article[2]/location-item[1]/div[2]/div[2]/button[1]")).click();
	    Thread.sleep(3000);  
	    driver.findElement(By.xpath("//menu-body/div[1]/items-group[2]/div[1]/div[1]/div[2]/item[1]/a[1]/div[2]/div[1]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[contains(text(),'ADD TO BAG')]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[contains(text(),'no, thanks')]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[contains(text(),'DONE')]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
	    Thread.sleep(3000);
	 
	/*
	    //Placing a later order
	    driver.findElement(By.xpath("//button[contains(text(),'LATER')]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[contains(text(),'ok')]")).click();
	    Thread.sleep(3000);
	 */
	    
	    //Change location in pickup order
	    driver.findElement(By.xpath("//button[contains(text(),'Change location')]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//body/app-root[1]/ng-component[1]/div[1]/main[1]/ng-component[1]"
	    		+ "/ng-component[1]/div[1]/wo-halfs[1]/div[2]/animation[1]/div[1]/ng-component[1]/div"
	    		+ "[1]/div[3]/div[1]/div[1]/button[1]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//body/app-root[1]/ng-component[1]/div[1]/main[1]/ng-component[1]/ng-component[1]/div[1]/div[2]/location-list[1]/article[1]/location-item[1]/div[2]/div[2]/button[1]")).click();
	    Thread.sleep(3000);
	    
	    //reordering Fiesta Salad since location is changed
	    driver.findElement(By.xpath("//menu-body/div[1]/items-group[1]/div[1]/div[1]/div[2]/item[1]/a[1]/div[2]/div[1]")).click();
	    Thread.sleep(3000); 
	    driver.findElement(By.xpath("//button[contains(text(),'ADD TO BAG')]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[contains(text(),'no, thanks')]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[contains(text(),'DONE')]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
	    Thread.sleep(3000);
	    
	    System.out.println("user can Change Location in PickUp order");
	    
  	} 
   
	 @AfterTest
	 //Quit the app
	  public void quitFreshiiApp() {
		  driver.quit();
		  System.out.println("Finished Freshii Test On Chrome Browser");
	 }
	
  }