package com.org.learningMaven.myMavenProject2;

//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

public class testing{
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testFWA128() throws Exception {
    driver.get("https://uatfreshiiorder.tacitdev.ca/ca/en");
    driver.findElement(By.xpath("//button[@type='button']")).click();
    driver.findElement(By.xpath("//div[@id='cdk-overlay-0']/ng-component/div[2]/div/div/div/div[2]/div/div/div/wo-log-in/div/form/fieldset/mat-form-field/div/div/div")).click();
    driver.findElement(By.id("mat-input-0")).clear();
    driver.findElement(By.id("mat-input-0")).sendKeys("testing8593@gmail.com");
    driver.findElement(By.id("mat-input-1")).clear();
    driver.findElement(By.id("mat-input-1")).sendKeys("sample@123");
    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    driver.findElement(By.xpath("//i")).click();
    driver.findElement(By.xpath("//wo-account-nav/ul/li[4]/a/span")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
    
    driver.findElement(By.xpath("(//label[contains(text(),'Name on Card')]")).click();
    driver.findElement(By.xpath("input[@id='CardHoldersName1603077813366']")).click();
  
    driver.findElement(By.id("Pan1603076617960")).click();
    driver.findElement(By.id("ExpDate1603076617961")).click();
    driver.findElement(By.id("ExpDate1603076617961")).clear();
    driver.findElement(By.id("ExpDate1603076617961")).sendKeys("01/22");
    driver.findElement(By.id("CVD1603076617962")).click();
    driver.findElement(By.id("CVD1603076617962")).clear();
    driver.findElement(By.id("CVD1603076617962")).sendKeys("244");
    driver.findElement(By.id("PostalCode1603076617962")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[9]")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
