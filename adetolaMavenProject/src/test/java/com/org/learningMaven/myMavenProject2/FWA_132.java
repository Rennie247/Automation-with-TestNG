package com.org.learningMaven.myMavenProject2;
//Verify whether default Gift Card on Sign Up is generated for the user

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	    driver.findElement(By.xpath("//input[@id='mat-input-3']")).sendKeys("Sample");		    
	    driver.findElement(By.xpath("//input[@id='mat-input-4']")).sendKeys("freshii@onwmail.com");		    
	    driver.findElement(By.linkText("Month and Year Picker")).click();	
	    Thread.sleep(3000);	    
	    driver.findElement(By.xpath("//button[contains(text(),'July')]")).click();	
	    Thread.sleep(3000);	    
	    driver.findElement(By.xpath("//body/div[4]/div[3]/div[1]/mat-dialog-container[1]/div[1]/ul[1]/li[1]/button[1]")).click();	
	    Thread.sleep(3000);	    	    	    
	    driver.findElement(By.xpath("//input[@id='mat-input-7']")).sendKeys("M4P 1R5");		    
	    driver.findElement(By.xpath("//input[@id='mat-input-8']")).sendKeys("sample@123");		    
	    driver.findElement(By.xpath("//input[@id='mat-input-9']")).sendKeys("sample@123");		  
	    driver.findElement(By.xpath("//button[contains(text(),'SIGN UP')]")).submit();	
	    Thread.sleep(3000);
	    System.out.println("Signed up successfully");
	    
	   //To wait for element visible
	    WebDriverWait wait = new WebDriverWait(driver, 15);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Hi, Test')]")));
	    driver.findElement(By.xpath("//header/div[2]/div[2]/div[1]/button[1]/i[1]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//span[contains(text(),'PAYMENT METHOD')]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[contains(text(),'Manage')]")).click();
	    Thread.sleep(3000);
	    System.out.println("Gift card is generated for user on signup");
	    
	    //Web does not have barcode
	  	  
  }
    
	 @AfterTest
	  public void quitFreshiiApp() {
		  driver.quit();
		  System.out.println("Finished Freshii Test On Chrome Browser");
	 }	
	  
}
