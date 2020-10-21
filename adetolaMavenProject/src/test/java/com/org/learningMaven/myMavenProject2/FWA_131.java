package com.org.learningMaven.myMavenProject2;
//Verify Add Payment method while placing an Order

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FWA_131 {
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
  public void addPaymentMethodWhilePlacingOrders() throws InterruptedException {   
    driver.findElement(By.xpath("//span[contains(text(),'Log in/Sign up')]")).click();
    Thread.sleep(6000);
    driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("testing8593@gmail.com");
    Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("sample@123");
    Thread.sleep(3000);
    driver.findElement(By.xpath("//button[contains(text(),'login')]")).click();
    Thread.sleep(6000);
    driver.findElement(By.xpath("//button[contains(text(),'Order now')]")).click();
    Thread.sleep(3000);
    
  //To wait for element visible
    WebDriverWait wait = new WebDriverWait(driver, 15);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/app-root[1]/ng-component[1]/div[1]/main[1]/ng-component[1]/ng-component[1]/div[1]/div[2]/location-list[1]/article[1]/location-item[1]/div[2]/div[2]/button[1]")));
    driver.findElement(By.xpath("//body/app-root[1]/ng-component[1]/div[1]/main[1]/ng-component[1]/ng-component[1]/div[1]/div[2]/location-list[1]/article[1]/location-item[1]/div[2]/div[2]/button[1]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//div[@id='category-btn-67994']")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/ng-component[1]/div[1]/main[1]/ng-component[1]/ng-component[1]/div[1]/menu-body[1]/div[1]/items-group[4]/div[1]/div[1]/div[5]/item[1]/a[1]/div[2]/div[1]/div[1]")).click();
    Thread.sleep(3000);
    
    //Increment quantity of orders
    for (int i = 1; i < 3; i++) {
    	driver.findElement(By.xpath("//button[contains(text(),'+')]")).click();
    	Thread.sleep(3000);
    }
    
    driver.findElement(By.xpath("//button[contains(text(),'DONE')]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
    Thread.sleep(8000);

    
    WebDriverWait wait1 = new WebDriverWait(driver, 60);
    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Change payment')]")));
    driver.findElement(By.xpath("//button[contains(text(),'Change payment')]")).click();	
    Thread.sleep(3000);
  
    driver.findElement(By.xpath("//body/app-root[1]/ng-component[1]/div[1]/main[1]/ng-component[1]/ng-component[1]/div[1]/wo-halfs[1]/div[2]/animation[1]/animation[1]/div[1]/payments-list[1]/div[1]/div[1]/div[2]/button[1]")).click();  
    Thread.sleep(10000);
    driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/ng-component[1]/div[1]/main[1]/ng-component[1]/ng-component[1]/div[1]/wo-halfs[1]/div[2]/animation[1]/animation[1]/animation[1]/div[1]/card-add[1]/div[1]/form[1]/md-input[1]/input[1]")).sendKeys("Mumm Danny");
    Thread.sleep(3000);    
    driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/ng-component[1]/div[1]/main[1]/ng-component[1]/ng-component[1]/div[1]/wo-halfs[1]/div[2]/animation[1]/animation[1]/animation[1]/div[1]/card-add[1]/div[1]/form[1]/md-card[1]/input[1]")).sendKeys("4788250000121443");
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/ng-component[1]/div[1]/main[1]/ng-component[1]/ng-component[1]/div[1]/wo-halfs[1]/div[2]/animation[1]/animation[1]/animation[1]/div[1]/card-add[1]/div[1]/form[1]/div[1]/div[1]/md-card-date[1]/input[1]")).sendKeys("08/24");
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/ng-component[1]/div[1]/main[1]/ng-component[1]/ng-component[1]/div[1]/wo-halfs[1]/div[2]/animation[1]/animation[1]/animation[1]/div[1]/card-add[1]/div[1]/form[1]/div[1]/div[2]/md-cvv[1]/input[1]")).sendKeys("112");
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/ng-component[1]/div[1]/main[1]/ng-component[1]/ng-component[1]/div[1]/wo-halfs[1]/div[2]/animation[1]/animation[1]/animation[1]/div[1]/card-add[1]/div[1]/form[1]/md-input[2]/input[1]")).sendKeys("19406");
    Thread.sleep(3000);
    driver.findElement(By.xpath("//button[contains(text(),'CONFIRM CARD')]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//button[contains(text(),'DONE')]")).click();
    Thread.sleep(3000);   
   
  } 
  
	 @AfterTest
	  public void quitFreshiiApp() {
		  driver.quit();
	 }
	 

  }