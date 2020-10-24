package com.org.learningMaven.myMavenProject2;
//Verify the process - Refer a Friend

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FWA_133 {
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
  public void referAfriend() throws InterruptedException {   
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
    
    //If Page asks for additional details
    //After log in details are entered, a sign up page popped up. Entered postal code, then clicked on SIGN UP before page opened
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
    
    //Select free food from option
    driver.findElement(By.xpath("//header/div[2]/div[2]/div[1]/button[1]/i[1]")).click();
    Thread.sleep(5000);
    
    //Click on free food
    driver.findElement(By.xpath("//span[contains(text(),'Free Food')]")).click();
    Thread.sleep(5000);  
    
    //Sharing Option is copied. User will have to paste the code copied into their preferred communication mode
    driver.findElement(By.xpath("//body/app-root[1]/ng-component[1]/div[1]/main[1]/ng-component[1]/section[1]/div[1]/button[1]/img[1]")).click();
    Thread.sleep(5000);
    System.out.println("Referred a friend successfully");
    
    
  } 
  
	 @AfterTest
	 //Quit the app
	  public void quitFreshiiApp() {
		  driver.quit();
		  System.out.println("Finished Freshii Test On Chrome Browser");
	 }
	 

  }