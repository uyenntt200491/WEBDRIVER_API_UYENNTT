package selenium;  
 
 import java.util.List; 
 import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By; 
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.interactions.Actions; 
import org.testng.Assert; 
import org.testng.annotations.AfterTest; 
import org.testng.annotations.BeforeTest; 
import org.testng.annotations.Test; 


public class Topic07_XpathCss2_Excercise10 {
	WebDriver driver; 
	Actions action; 
	@BeforeTest 
public void beforeTest() { 
	driver = new FirefoxDriver(); 
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.MINUTES); 
	driver.manage().window().maximize(); 
	action = new Actions(driver);  
	} 

	 @Test 
	 public void TC_01_MoveMouseToElement() { 
	 	 driver.get("http://www.myntra.com/"); 
		 //Hover to profile icon 
	 	 WebElement profileICon = driver.findElement(By.xpath("//div[@class='desktop-userIconsContainer']")); 
		 action.moveToElement(profileICon).perform(); 
		 //click login button 
  
	 WebElement LoginE = driver.findElement(By.xpath("//a[@class='desktop-linkButton' and contains(text(),'log in')]")); 
	 action.click(LoginE).perform(); 
 
	 //verify  
	  
	 Assert.assertTrue(driver.findElement(By.xpath("//div[@class='login-box']")).isDisplayed()); 
	 } 
	
	 
 @Test 
	 public void TC_02_MoveMouseToElement() { 
		 driver.get(" http://jqueryui.com/resources/demos/selectable/display-grid.html"); 
	List <WebElement> listNumber =  driver.findElements(By.xpath("//ol[@id='selectable']//li")); 
	 
action.clickAndHold(listNumber.get(0)).moveToElement(listNumber.get(3)).release().perform(); 
		List <WebElement> SelectedlistNumber =  driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee ui-selected']")); 
 	 Assert.assertEquals(SelectedlistNumber.size(),4); 
	} 
	 @Test 
 public void TC_03_DoubleClick() { 
		 driver.get("http://www.seleniumlearn.com/double-click"); 
 	 
		WebElement doubleClickE = driver.findElement(By.xpath("//button[text()='Double-Click Me!']")); 
		action.doubleClick(doubleClickE).perform(); 
	 	Alert alertInfor = driver.switchTo().alert(); 
 	Assert.assertEquals(alertInfor.getText(), "The Button was double-clicked."); 
		alertInfor.accept(); 
	} 
	
	 @Test 
	 public void TC_04_RightClickToElement() throws Exception{ 
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html"); 
		action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform(); 
	 	WebElement quiteE = driver.findElement(By.xpath("//li[contains(@class,'context-menu-visible')]")); 
	 	action.moveToElement(quiteE).perform(); 
		//context-menu-icon-quit context-menu-hover context-menu-visible 
 	Assert.assertTrue(driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit context-menu-hover context-menu-visible')]")).isDisplayed()); 
	    action.click(quiteE).perform(); 
	     
	   Alert alertQuite = driver.switchTo().alert(); 
	   Thread.sleep(3000); 
	   alertQuite.accept(); 
	    
 } 
	
	 
	 @Test 
	  public void TC_05_Drag_And_Drop_Element() { 
		 driver.get("http://demos.telerik.com/kendo-ui/dragdrop/angular"); 
		 WebElement circleBig = driver.findElement(By.xpath("//div[@id='droptarget']")); 
	 	 WebElement circleMall = driver.findElement(By.xpath("//div[@id='draggable']")); 
	 action.dragAndDrop(circleMall, circleBig).perform(); 
	 	 Assert.assertEquals(circleBig.getText(), "You did great!"); 
 } 
  @Test 
	 public void TC_06_RandomMoveMouseToElement() { 
	 	 driver.get(" http://jqueryui.com/resources/demos/selectable/display-grid.html"); 
		List <WebElement> listNumber =  driver.findElements(By.xpath("//ol[@id='selectable']//li")); 
		action.keyDown(Keys.CONTROL).build().perform(); 
	 	action.click(listNumber.get(0)); 
	 	action.click(listNumber.get(3)); 
	 	action.click(listNumber.get(5)); 
		action.click(listNumber.get(7)); 
		action.keyUp(Keys.CONTROL).release().perform(); 
		List <WebElement> SelectedlistNumber =  driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee ui-selected']")); 
	 	 Assert.assertEquals(SelectedlistNumber.size(),4); 
	 } 
	 @AfterTest 
	 public void AfterTest() { 
		driver.quit(); 
	 } 
	} 
