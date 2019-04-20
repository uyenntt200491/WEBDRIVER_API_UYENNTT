package selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Topic06_XpathCss2_Excercise9 {
	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	  @BeforeTest
	  public void beforeTest() {
		  driver=new FirefoxDriver();
		  wait=new WebDriverWait(driver,5);
		  act=new Actions(driver);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  
		 
	  }
	  
	  
	  @Test
	  public void TC01_mouseHover() throws InterruptedException {		
		  System.out.println("Excecise1:");
		  driver.get("https://www.myntra.com/");		  
		  act.moveToElement(driver.findElement(By.xpath("//span[text()='Profile']"))).perform();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='log in']")));
		  act.moveToElement(driver.findElement(By.xpath("//a[text()='log in']"))).click().perform();
		  //driver.findElement(By.xpath("//a[text()='log in']")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-box")));
		 
	  }
		  
	  @Test
	  public void TC02_clickAndHold() throws InterruptedException {		
		  
		  System.out.println("Excecise2:");
		  driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");		  
		  List<WebElement> list=driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		  act.moveToElement(list.get(0)).clickAndHold().moveToElement(list.get(3)).release().perform();
		  System.out.println("4 numbers are selected:");
		  Assert.assertEquals(driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee ui-selected']")).size(), 4);
		  Thread.sleep(2000);
		  System.out.println("Excecise3:");
		  act.keyDown(Keys.CONTROL).perform();
		  list.get(4).click();
		  list.get(6).click();
		  list.get(7).click();
		  list.get(9).click();
		  act.keyUp(Keys.CONTROL).perform();
	  }
	  
	  @Test
	  public void TC04_rightClick() throws InterruptedException {		
		  System.out.println("Excecise4:");
		  driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");		  
		  act.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
		  act.moveToElement(driver.findElement(By.xpath("//span[text()='Quit']"))).click().perform();
		  Alert alert=driver.switchTo().alert();
		  alert.accept();
		 
	  }
	  
	  @Test
	  public void TC05_dragAndDrop() throws InterruptedException {		
		  System.out.println("Excecise5:");
		  driver.get("http://demos.telerik.com/kendo-ui/dragdrop/angular");		  
		  act.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droptarget"))).perform();
		  Assert.assertEquals(driver.findElement(By.id("droptarget")).getText(), "You did great!");
	  }
}
