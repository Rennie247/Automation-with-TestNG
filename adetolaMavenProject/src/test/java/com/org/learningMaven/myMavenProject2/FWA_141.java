package com.org.learningMaven.myMavenProject2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FWA_141 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("https://uatfreshiiorder.tacitdev.ca");
		
		
		
		driver.close();

	}

}
