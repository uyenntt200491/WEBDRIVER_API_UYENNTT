package selenium;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;


@Test
public class Topic_02_XpathCss {
	WebDriver driver;
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("http://live.guru99.com/index.php/customer/account/login/");
	  }
  public void TC_01_() throws Exception {
	  System.out.println("1-Sendkey to Email textbox by ID:");
	  driver.findElement(By.id("email")).sendKeys("id@gmail.com");
	  driver.findElement(By.id("email")).clear();
	  Thread.sleep(3000);
	  
	  System.out.println("2 - Sendkey to Email textbos by Class:");
	  driver.findElement(By.className("validate-email")).sendKeys("class@gmail.com");
	  driver.findElement(By.id("email")).clear();
	  
	  
  }
  public void TC_02_() {
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
