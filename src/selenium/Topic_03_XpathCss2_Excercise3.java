package selenium;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;



@Test
public class Topic_03_XpathCss2_Excercise3 {
	WebDriver driver;
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("http://live.guru99.com/");
	  }
 @Test
  public void TC_01_EmailandPasswordEmpty() {
	  
	  driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	  driver.findElement(By.id("email")).sendKeys("");
	  driver.findElement(By.name("login[password]")).sendKeys("");
	  driver.findElement(By.xpath("//button[@class='button']")).click();
	  String emailRequire = driver.findElement(By.id("advice-required-entry-email")).getText();
	  Assert.assertTrue(emailRequire.equals("This is a required field."));
	  Assert.assertFalse(emailRequire.equals("This is a required field.!@#$%^&*()"));
	  Assert.assertEquals(emailRequire,"This is a required field.");
	  String passRequire = driver.findElement(By.id("advice-required-entry-pass")).getText();
	  Assert.assertEquals(passRequire,"This is a required field.");}
@Test
	  public void TC_02_LoginWithEmailInvalid() {
	  driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	  driver.findElement(By.id("email")).sendKeys("123434234@12312.123123");
	  driver.findElement(By.name("login[password]")).sendKeys("123123");
	  driver.findElement(By.xpath("//button[@class='button']")).click();
	  String emailInvalid = driver.findElement(By.id("advice-validate-email-email")).getText();
	  Assert.assertEquals(emailInvalid,"Please enter a valid email address. For example johndoe@domain.com.");
}

@Test
      public void TC_03_LoginWithPasswordLessThanSixCharacter() {
	  driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	  driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
	  driver.findElement(By.name("login[password]")).sendKeys("123");
	  driver.findElement(By.xpath("//button[@class='button']")).click();
	  String passwordLess = driver.findElement(By.id("advice-validate-password-pass")).getText();
	  Assert.assertEquals(passwordLess,"Please enter 6 or more characters without leading or trailing spaces.");
}

@Test
      public void TC_04_LoginWithPasswordIncorrect() {
	  driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	  driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
	  driver.findElement(By.name("login[password]")).sendKeys("123123123");
	  driver.findElement(By.xpath("//button[@class='button']")).click();
	  String passwordLess = driver.findElement(By.xpath("//span[contains(text(),'Invalid login or password.')]")).getText();
	  Assert.assertEquals(passwordLess,"Invalid login or password.");
}
@Test
      public void TC_05_CreateAnAccount() throws InterruptedException {
      driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//span[contains(text(),'Create an Account')]")).click();
      Thread.sleep(2000);
      driver.findElement(By.id("firstname")).sendKeys("nguyen");
      driver.findElement(By.id("middlename")).sendKeys("to");
      driver.findElement(By.id("lastname")).sendKeys("uyen");
      driver.findElement(By.id("email_address")).sendKeys("test"+Math.floor(Math.random()*100)+"@gmail.com");
      driver.findElement(By.id("password")).sendKeys("123ez123");
      driver.findElement(By.id("confirmation")).sendKeys("123ez123");
      driver.findElement(By.id("is_subscribed")).click();
      driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();
      Thread.sleep(3000);
      String successMsg = driver.findElement(By.xpath("//li[@class=\"success-msg\"]")).getText();
      Assert.assertEquals(successMsg,"Thank you for registering with Main Website Store.");
      //Logout
      driver.findElement(By.xpath("//span[@class='label'][contains(text(),'Account')]")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath("//a[@title='Log Out']")).click();
      Thread.sleep(5000);
      String currentUrl = driver.getCurrentUrl();
      Assert.assertEquals(currentUrl,"http://live.guru99.com/index.php/");

}
@AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
