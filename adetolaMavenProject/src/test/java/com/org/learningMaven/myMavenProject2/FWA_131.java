package com.org.learningMaven.myMavenProject2;
//Verify Add Payment method while placing an Order

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FWA_131 {
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
  public void addPaymentMethodWhilePlacingOrders() throws InterruptedException {   
	//Logging in freshii user
    driver.findElement(By.xpath("//span[contains(text(),'Log in/Sign up')]")).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("testing8593@gmail.com");
    driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("sample@123");
    driver.findElement(By.xpath("//button[contains(text(),'login')]")).click();
    Thread.sleep(6000);
    
    //If Page asks for additional details
    //After log in details are entered, a sign up page popped up. Entered postal code, then clicked on SIGN UP before page opened
    WebDriverWait wait4 = new WebDriverWait(driver, 30);
    wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-7")));
    if (!driver.findElement(By.id("mat-input-7")).isSelected() ) {
        driver.findElement(By.id("mat-input-7")).sendKeys("M9P2S1");
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
    
    //placing a new order for Teriyaki Burritos
    driver.findElement(By.xpath("//button[contains(text(),'Order now')]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//body/app-root[1]/ng-component[1]/div[1]/main[1]/ng-component[1]/ng-component[1]/div[1]/div[2]/location-list[1]/article[5]/location-item[1]/div[2]/div[2]/button[1]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//div[@id='category-btn-67994']")).click();
    Thread.sleep(5000);
    System.out.println("Teriyaki Burritos is selected");
    
   
    driver.findElement(By.xpath("//menu-body/div[1]/items-group[4]/div[1]/div[1]/div[4]/item[1]/a[1]/div[1]/div[1]/div[1]")).click();
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

    //Waiting for Change payment to load
    WebDriverWait wait1 = new WebDriverWait(driver, 60);
    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Change payment')]")));
    driver.findElement(By.xpath("//button[contains(text(),'Change payment')]")).click();	
    Thread.sleep(3000);
    System.out.println("Payment method is selected");

    //Entered Credit Card details
    driver.findElement(By.xpath("//body/app-root[1]/ng-component[1]/div[1]/main[1]/ng-component[1]/ng-component[1]/div[1]/wo-halfs[1]/div[2]/animation[1]/animation[1]/div[1]/payments-list[1]/div[1]/div[1]/div[2]/button[1]")).click();  
    Thread.sleep(5000);   
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
    System.out.println("Credit card is successfully changed");
   
  } 
  
	 @AfterTest
	  public void quitFreshiiApp() {
		  driver.quit();
		  System.out.println("Quit Browser");
	 }
	 

  }