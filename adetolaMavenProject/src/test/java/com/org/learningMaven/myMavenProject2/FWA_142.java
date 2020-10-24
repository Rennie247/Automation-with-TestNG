package com.org.learningMaven.myMavenProject2;
//Verify if user can View Locations-City

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FWA_142 {
	public String baseUrl = "https://uatfreshiiorder.tacitdev.ca/";
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
  public void userCanViewLocationsByCity() throws InterruptedException {   
		//Log in user
	    driver.findElement(By.xpath("//span[contains(text(),'Log in/Sign up')]")).click();
	    Thread.sleep(3000);
	    
	    //Enter Email and password
	    driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("testing8593@gmail.com");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("sample@123");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[contains(text(),'login')]")).click();
	    Thread.sleep(3000);
	    
	    //If Page asks for additional details
	    //After log in details are entered, a sign up page popped up. Entered postal code, then clicked on SIGN UP before page opened
	    WebDriverWait wait4 = new WebDriverWait(driver, 30);
	    wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-7")));
	    if (!driver.findElement(By.id("mat-input-7")).isSelected() ) {
	        driver.findElement(By.id("mat-input-7")).sendKeys("M9P2S1");
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//button[contains(text(),'SIGN UP')]")).click();
	        Thread.sleep(3000);    
	    } else {
	        //Click on the Profile Drop down for options
	        //To wait for element visible
	        WebDriverWait wait = new WebDriverWait(driver, 60);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Hi, Test')]")));
	        driver.findElement(By.xpath("//header/div[2]/div[2]/div[1]/button[1]/i[1]")).click();
	        Thread.sleep(3000);
	    }
	    
	    //Open to view locations by city
	    driver.findElement(By.xpath("//header/div[2]/div[1]/wo-nav[1]/ul[1]/li[2]/a[1]")).click();
	    Thread.sleep(3000);	
	    driver.findElement(By.tagName("input")).sendKeys("Vancouver");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//body/app-root[1]/ng-component[1]/div[1]/main[1]/ng-component"
	    		+ "[1]/ng-component[1]/div[1]/div[1]/location-search[1]/autocomplete-manual[1]/div[1]/ul[1]/li[1]")).click();
	    Thread.sleep(3000);
	    System.out.println("I can view locations by city"); 
  	} 
   
	 @AfterTest
	 //Quit the app
	  public void quitFreshiiApp() {
		  driver.quit();
		  System.out.println("Finished Freshii Test On Chrome Browser");
	 }
	 

  }