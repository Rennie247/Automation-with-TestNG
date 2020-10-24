package com.org.learningMaven.myMavenProject2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class testing {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Resource\\\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://uatfreshiiorder.tacitdev.ca/");
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//header/div[2]/div[1]/a[1]/*[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//body/div[4]/div[2]/div[1]/main-sidenav[1]/div[1]/wo-auth-wrap[1]/div[1]/button[1]/span[1]")).click();
		
	    Thread.sleep(5000);
	    
	    driver.findElement(By.tagName("input")).click();
		driver.findElement(By.tagName("input")).sendKeys("testdata1984@gmail.com");
	    driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("sample@123"); 
	    driver.findElement(By.xpath("//button[contains(text(),'login')]")).click();
	    Thread.sleep(5000);
	   driver.findElement(By.xpath("//body/div[4]/div[2]/div[1]/main-sidenav[1]/div[1]/div[1]/a[1]/img[1]")).click();
	    
	   Thread.sleep(5000);
	   driver.findElement(By.xpath("//a[contains(text(),'FAQ')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.tagName("mat-panel-title")).click();
		Thread.sleep(5000);
		driver.findElement(By.tagName("mat-panel-title")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//header/div[2]/div[1]/a[1]/*[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//body/div[4]/div[2]/div[1]/main-sidenav[1]/div[1]/wo-nav[1]/ul[1]/li[1]/a[1]/span[1]")).click();
		//driver.close();

}
}
