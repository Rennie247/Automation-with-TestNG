package com.org.learningMaven.myMavenProject2;
//Verify if user can remove the added Credit Card

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class FWA_129 {
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
  public void removeCreditCard() throws InterruptedException {   
    driver.findElement(By.xpath("//span[contains(text(),'Log in/Sign up')]")).click();
    driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("testing8593@gmail.com");
    Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("sample@123");
    Thread.sleep(3000);
    driver.findElement(By.xpath("//button[contains(text(),'login')]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//span[contains(text(),'Hi, Test')]")).click();
    driver.findElement(By.xpath("//span[contains(text(),'PAYMENT METHOD')]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//button[contains(text(),'Add payment method')]")).click();  
    Thread.sleep(3000); 
    driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/overlay-payment-methods[1]/div[1]/wo-halfs[1]/div[2]/animation[1]/animation[1]/div[1]/card-add[1]/div[1]/form[1]/md-input[1]/input[1]")).sendKeys("Freshii Corp Card");
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/overlay-payment-methods[1]/div[1]/wo-halfs[1]/div[2]/animation[1]/animation[1]/div[1]/card-add[1]/div[1]/form[1]/md-card[1]/input[1]")).sendKeys("4715360004233694"); 
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/overlay-payment-methods[1]/div[1]/wo-halfs[1]/div[2]/animation[1]/animation[1]/div[1]/card-add[1]/div[1]/form[1]/div[1]/div[1]/md-card-date[1]/input[1]")).sendKeys("01/22");
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/overlay-payment-methods[1]/div[1]/wo-halfs[1]/div[2]/animation[1]/animation[1]/div[1]/card-add[1]/div[1]/form[1]/div[1]/div[2]/md-cvv[1]/input[1]")).sendKeys("244");
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/overlay-payment-methods[1]/div[1]/wo-halfs[1]/div[2]/animation[1]/animation[1]/div[1]/card-add[1]/div[1]/form[1]/md-input[2]/input[1]")).sendKeys("M4W 2L2");
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/overlay-payment-methods[1]/div[1]/wo-halfs[1]/div[2]/animation[1]/animation[1]/div[1]/card-add[1]/div[1]/div[1]/button[1]")).submit();	
    Thread.sleep(3000);
    
  }
 
  
	 @AfterTest
	  public void quitFreshiiApp() {
		  driver.quit();
		  System.out.println("Finished Freshii Test On Chrome Browser");
		  System.out.println(driver.findElement(By.xpath("//div[contains(text(),'We could not validate your credit card billing pos')]")));
	 }
	 
}