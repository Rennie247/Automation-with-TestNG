package com.org.learningMaven.myMavenProject2;
//Verify whether the user can Review the PickUp Order when Offers and Rewards are not available

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class FWA_149 {
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
  public void reviewPickUpOrderWhenOffersAndRewardsAreNotAvailable() throws InterruptedException {   
		//Log in user
	    driver.findElement(By.xpath("//span[contains(text(),'Log in/Sign up')]")).click();
	    Thread.sleep(3000);
	    
	    //Enter Email and password
	    driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("testfreshii@abbuzz.com");
	    driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("sample@123");
	    driver.findElement(By.xpath("//button[contains(text(),'login')]")).click();
	    Thread.sleep(3000);
	    
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
	    System.out.println("Menu added to cart");
	    
	    //Selecting available rewards and offers
	    driver.findElement(By.xpath("//button[contains(text(),'View all rewards & offers')]")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/ng-component[1]/div[1]/main[1]/ng-component"
	    		+ "[1]/ng-component[1]/div[1]/wo-halfs[1]/div[2]/animation[1]/animation"
	    		+ "[1]/div[1]/offers-list[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/span[1]/button[1]/img[1]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/ng-component[1]/div[1]/main[1]/ng-component[1]/ng-component"
	    		+ "[1]/div[1]/wo-halfs[1]/div[2]/animation[1]/animation[1]/div[1]/offers-list[1]/div[1]/wo-column-header[1]/button[1]/img[1]")).click();
	    Thread.sleep(3000);
	    System.out.println("Select rewards and offers");
	    
	    //Placing a later order
	    driver.findElement(By.xpath("//button[contains(text(),'LATER')]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[contains(text(),'ok')]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[contains(text(),'PLACE ORDER')]")).click();
	    Thread.sleep(7000);
	    
	    System.out.println("The user can Review the PickUp Order when Offers and Rewards are not available");
	    
  	} 
   
	 @AfterTest
	 //Quit the app
	  public void quitFreshiiApp() {
		  driver.quit();
		  System.out.println("Finished Freshii Test On Chrome Browser");
	 }
	
  }