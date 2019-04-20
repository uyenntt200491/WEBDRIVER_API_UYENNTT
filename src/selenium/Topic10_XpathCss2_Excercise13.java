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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class Topic10_XpathCss2_Excercise13 {
	WebDriver driver; 
	 	 Actions action; 
	 	 JavascriptExecutor js; 
	 @BeforeTest 
	 public void beforeTest() { 
	 	 driver = new FirefoxDriver(); 
		 js =  (JavascriptExecutor) driver; 
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.MINUTES); 
	 	 driver.manage().window().maximize(); 
	 	 action = new Actions(driver);  
	 } 
	 @Test 
	 public void Test_Script_01() { 
	 	/* Vừa hander popup - vừa handle iframe 
	 	 * Popup: 
	 	 * Case 01 - Nếu nó xuất hiện thì phải check lại được dispaled- close đi-> qua step tiếp theo 
	 	 *         => Đang chạy test script: refressh 1 vài lần cho nó hiện ra 
	 	 * Case 02 - Nếu nó ko hiện thì qua step tiếp theo luôn 
	 	 *  
	 	 * Iframe: 
	 	*/ 
	 	 
	 	/*Issuses: 
 	 * 01 - NoSuchElementException: Unable to locate element: {"method":"xpath","selector",:"//iframe[@id='vizury-notification-template']"} 
		 * */ 
		 
	 	driver.get("http://www.hdfcbank.com/"); 
	 	// Khai bao notificationIframe 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	 	List <WebElement> notificationIframe = driver.findElements(By.xpath("//iframe[@id='vizury-notification-template']")); 
	 	int notificationIframeSize = notificationIframe.size(); 
	 	System.out.println("Notification iframe displayed = "+notificationIframeSize); 
	 	if(notificationIframeSize>0) { 
	 		 driver.switchTo().frame(notificationIframe.get(0)); 
			 Assert.assertTrue(driver.findElement(By.xpath("//div[@id='container-div']/img")).isDisplayed()); 
			 driver.findElement(By.xpath("//div[@id='container-div']/img")).click(); 
	 		Assert.assertTrue(driver.findElement(By.xpath("//span[@id=\"messageText\" and text()='What are you looking for?']")).isDisplayed()); 
			 //Close popup đó 
			js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@id='div-close']"))); 
			System.out.println("Close popup success"); 
	 		driver.switchTo().defaultContent(); 
	 	} 
		System.out.println("Pass handel popup"); 
	 
	 
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	  //Switch qua iframe chứa text 
	   
	  Assert.assertTrue(driver.findElement(By.xpath("//span[@id='messageText' and text()='What are you looking for?']")).isDisplayed()); 
	 driver.switchTo().defaultContent(); 
	 
	 
 WebElement slidingBannersIframe = driver.findElement(By.xpath("//div[@class='slidingbanners']//iframe")); 
	driver.switchTo().frame(slidingBannersIframe); 
	 List<WebElement> bannerImages = driver.findElements(By.xpath("//img[@class='bannerimage']")); 
	 System.out.println("banner Image are " + bannerImages.size()); 
	 Assert.assertEquals(bannerImages.size(), 6); 
	 for (WebElement image : bannerImages) { 
	 	Assert.assertTrue(isImageLoadedSuccess(image)); 
	 } 
	 
	 
	 driver.switchTo().defaultContent(); 
	
	 
	 List<WebElement> flipBannerImages = driver.findElements(By.xpath("//div[@class='flipBanner']//img[@class='front icon']")); 
	 System.out.println("flip Image are " + flipBannerImages.size()); 
	 Assert.assertEquals(flipBannerImages.size(), 8); 
	 Assert.assertEquals(flipBannerImages.size(), 8); 
	 
	 
	 for (WebElement image : flipBannerImages) { 
	 	Assert.assertTrue(isImageLoadedSuccess(image)); 
	 	Assert.assertTrue(image.isDisplayed()); 
 } 
	 } 
	
	 
 public boolean isImageLoadedSuccess(WebElement element) { 
		return (boolean) js.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element); 
	 } 
	
	 
	 @AfterTest 
	 public void afterTest() { 
		driver.close(); 
	 	} 
	 } 
