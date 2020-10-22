package com.org.learningMaven.myMavenProject2;
//Verify  - Refund Placed Order

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FWA_138 {
	public String baseUrl = "https://uatfreshiiorder.tacitdev.ca/";
	public ChromeDriver driver;

  @BeforeTest
  public void openFreshiiBrowser() {
	System.out.println("Launching Chrome browser..");
	System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
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
  public void refundPlacedOrder() throws InterruptedException {   
	//Log in user
    driver.findElement(By.xpath("//span[contains(text(),'Log in/Sign up')]")).click();
    Thread.sleep(5000);
    //Enter Email and password
    driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("testing8593@gmail.com");
    Thread.sleep(5000);
    driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("sample@123");
    Thread.sleep(5000);
    driver.findElement(By.xpath("//button[contains(text(),'login')]")).click();
    Thread.sleep(5000);
    //If Page asks for additional details Put if else condition here
    WebDriverWait wait4 = new WebDriverWait(driver, 30);
    wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-7")));
    if (!driver.findElement(By.id("mat-input-7")).isSelected() ) {
        driver.findElement(By.id("mat-input-7")).sendKeys("M9P2S1");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[contains(text(),'SIGN UP')]")).click();
        Thread.sleep(5000);    
    } else {
        //Click on the Profile Drop down for options
        //To wait for element visible
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Hi, Test')]")));
        driver.findElement(By.xpath("//header/div[2]/div[2]/div[1]/button[1]/i[1]")).click();
        Thread.sleep(3000);
    }
    /*driver.findElement(By.id("mat-input-7")).sendKeys("M9P2S1");
    Thread.sleep(5000);
    driver.findElement(By.xpath("//button[contains(text(),'SIGN UP')]")).click();
    Thread.sleep(5000);    
  */
    //Click on the Profile Drop down for options
    //To wait for element visible
    WebDriverWait wait = new WebDriverWait(driver, 60);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Hi, Test')]")));
    driver.findElement(By.xpath("//header/div[2]/div[2]/div[1]/button[1]/i[1]")).click();
    Thread.sleep(3000);
    //Select 'My History' from option to view past orders
    driver.findElement(By.xpath("//span[contains(text(),'My History')]")).click();
    Thread.sleep(5000);
    
    //Click on Help to fill a refund form
    driver.findElement(By.xpath("//button[contains(text(),'Help')]")).click();
    Thread.sleep(5000); 
    
    //Select Missing or Incomplete items
    WebDriverWait wait1 = new WebDriverWait(driver, 60);
    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[3]/div[1]/div[1]/ng-component[1]/div[1]/contact-us[1]/section[1]/mat-list[1]/mat-list-item[8]/div[1]")));
    driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/ng-component[1]/div[1]/contact-us[1]/section[1]/mat-list[1]/mat-list-item[8]/div[1]")).click();	
    Thread.sleep(5000); 
    
    //Fill out the contact us form by Clicking on the Message box frame
    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='webWidget']")));
    
    WebDriverWait wait2 = new WebDriverWait(driver, 30);
    wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("12val-field_1.3.4--input")));
    driver.findElement(By.id("12val-field_1.3.4--input")).sendKeys("This is a testing message.I did not receive chicken.");
    Thread.sleep(5000);
    //Hit the send button
    driver.findElement(By.xpath("//button[contains(text(),'Send')]")).click();
    Thread.sleep(5000);
    WebDriverWait wait3 = new WebDriverWait(driver, 30);
    wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Go Back')]")));
    driver.findElement(By.xpath("//button[contains(text(),'Go Back')]")).click();
    Thread.sleep(5000);
    
    driver.switchTo().defaultContent();
    
    System.out.println("Placed order is refunded!"); 
  	} 
   
	
	 @AfterTest
	 //Quit the app
	  public void quitFreshiiApp() {
		  driver.quit();
		  System.out.println("Finished Freshii Test On Chrome Browser");
	 }
	 

  }