package com.org.learningMaven.myMavenProject2;
//Verify  - Refund Placed Order

import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
///import io.appium.java_client.MobileElement;
///import io.appium.java_client.android.AndroidDriver;


public class testing2 {
	public String baseUrl = "https://uatfreshiiorder.tacitdev.ca/";
    WebDriver driver;
    
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set android deviceName desired capability. Set your device name.
        capabilities.setCapability("deviceName", "Galaxy S6");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
        capabilities.setCapability(CapabilityType.VERSION, "7.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.example.app");
        capabilities.setCapability("appActivity", "com.example.app.Activity");
    ///    driver = new WebDriver (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void testPressButton() throws InterruptedException {
        driver.findElements(By.xpath("//android.widget.Button")).get(0).click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

    @AfterClass
    public void End() {
        driver.quit();
    }
}

	
//	driver = webdriver.Remote(desired_capabilities=DesiredCapabilities.ANDROID)
//	driver.get("https://uatfreshiiorder.tacitdev.ca/ca/en")

 /* @BeforeTest
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
    driver.findElement(By.id("mat-input-7")).sendKeys("M9P2S1");
    Thread.sleep(5000);
    driver.findElement(By.xpath("//button[contains(text(),'SIGN UP')]")).click();
    Thread.sleep(5000);    
  
    
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
	 
*/
  