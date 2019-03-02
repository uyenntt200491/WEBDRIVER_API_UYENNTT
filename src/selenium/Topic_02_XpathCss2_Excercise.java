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
public class Topic_02_XpathCss2_Excercise {
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
 @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
