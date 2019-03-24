package selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class Topic05_Radio_Checkbox_Alert_Handle {
	WebDriver driver;
	
	  @BeforeTest
	  public void beforeTest() {
		  driver=new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  
		 
	  }
	  
	  
	  @Test
	  public void TC01_JSExecutor() throws InterruptedException {		
		  System.out.println("Excecise1:");
		  driver.get("http://live.guru99.com/");
		  JavascriptExecutor js= (JavascriptExecutor)driver;
		  js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")));
		  Assert.assertEquals(driver.getCurrentUrl(), "http://live.guru99.com/index.php/customer/account/login/");
		  js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Create an Account']")));
		  Assert.assertEquals(driver.getCurrentUrl(), "http://live.guru99.com/index.php/customer/account/create/");
	  }
		  
	  
	  @Test
	  public void TC02_handleCheckbox() throws InterruptedException {		
		  System.out.println("Excecise2:");
		  driver.get("http://demos.telerik.com/kendo-ui/styling/checkboxes");
		  driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']")).click();
		  Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input")).isSelected());
		  driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']")).click();
		  driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']")).click();
	  }
	  
	  @Test
	  public void TC03_handleRadio() throws InterruptedException {		
		  System.out.println("Excecise3:");
		  driver.get("https://demos.telerik.com/kendo-ui/styling/radios");
		  driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']")).click();
	//	  Assert.assertTrue(driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input")).isSelected());
		  if(!driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input")).isEnabled()) {
			  driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']")).click(); 
		  }
	  }
	  
	  @Test
	  public void TC04_handleJsAlert() throws InterruptedException {		
		  System.out.println("Excecise4:");
		  driver.get("https://daominhdam.github.io/basic-form/index.html");
		  driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		  Alert alert= driver.switchTo().alert();
		  Assert.assertEquals(alert.getText(), "I am a JS Alert");
		  alert.accept();
		  Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked an alert successfully");
		  
		  System.out.println("Excecise5:");
		  driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		   alert= driver.switchTo().alert();
		  Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		  alert.dismiss();
		  Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");
		  
		  System.out.println("Excecise6:");
		  driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		   alert= driver.switchTo().alert();
		  Assert.assertEquals(alert.getText(), "I am a JS prompt");
		  alert.sendKeys("daominhdam");
		  alert.accept();
		  Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: daominhdam");
	  }
	  
	  
	  @Test
	  public void TC07_handleAuthenAlert() throws InterruptedException {		
		  System.out.println("Excecise7:");
		  driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		  WebDriverWait wait=new WebDriverWait(driver,5);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'Congratulations!')]")));
	  }
}
