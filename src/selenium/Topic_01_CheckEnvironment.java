package selenium;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_01_CheckEnvironment {
	WebDriver driver;
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("http://live.guru99.com/");
	  }
  @Test
  public void TC_01_CheckUrl() {
	  String homePageUrl = driver.getCurrentUrl();
	  Assert.assertEquals(homePageUrl, "http://live.guru99.com/");
  }
  @Test
  public void TC_01_CheckTitle() {
	  String homePageTitle = driver.getTitle();
	  Assert.assertEquals(homePageTitle, "Home page");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
