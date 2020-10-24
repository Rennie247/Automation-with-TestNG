package com.org.learningMaven.myMavenProject2;
//Verify whether default Gift Card on Sign Up is generated for the user

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class FWA_132{
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
  public void defaultGiftCardSignUpIsGenerated() throws InterruptedException    {  
	  	//Signing up new user
	    driver.findElement(By.xpath("//span[contains(text(),'Log in/Sign up')]")).click();	
	    Thread.sleep(3000);	    
	    driver.findElement(By.xpath("//button[contains(text(),'SIGN UP')]")).click();	
	    Thread.sleep(3000);	    
	    driver.findElement(By.xpath("//input[@id='mat-input-2']")).sendKeys("Test");	
	    Thread.sleep(3000);	    
	    driver.findElement(By.xpath("//input[@id='mat-input-3']")).sendKeys("Sample");	
	    Thread.sleep(3000);	    
	    driver.findElement(By.xpath("//input[@id='mat-input-4']")).sendKeys("testfreshii3@abbuzz.com");	
	    Thread.sleep(3000);	    
	    driver.findElement(By.linkText("Month and Year Picker")).click();	
	    Thread.sleep(3000);	    
	    driver.findElement(By.xpath("//button[contains(text(),'July')]")).click();	
	    Thread.sleep(3000);	    
	    driver.findElement(By.xpath("//body/div[4]/div[3]/div[1]/mat-dialog-container[1]/div[1]/ul[1]/li[1]/button[1]")).click();	
	    Thread.sleep(3000);	    	    
	    driver.findElement(By.linkText("Month and Year Picker")).click();	
	    Thread.sleep(3000);	    
	    driver.findElement(By.xpath("//input[@id='mat-input-7']")).sendKeys("M4P 1R5");	
	    Thread.sleep(3000);	    
	    driver.findElement(By.xpath("//input[@id='mat-input-8']")).sendKeys("sample@123");	
	    Thread.sleep(3000);	    
	    driver.findElement(By.xpath("//input[@id='mat-input-9']")).sendKeys("sample@123");	
	    Thread.sleep(3000);	  
	    driver.findElement(By.xpath("//button[contains(text(),'SIGN UP')]")).submit();	
	    Thread.sleep(3000);
	    System.out.println("Signed up successfully");
	    
	    //Web does not have barcode
	  	  
  }
    
	 @AfterTest
	  public void quitFreshiiApp() {
		  driver.quit();
		  System.out.println("Finished Freshii Test On Chrome Browser");
	 }	 
}
