package selenium;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import selenium.Topic_03_WebElement_WebBrowser_Exercise;

public class Topic_04_XpathCss2_Excercise5 {
    WebDriver driver;
    String userIDText= "mngr184310"; 
    String passWord = "yqudAra"; 
    String customerName,genDer, dateOfBirthday, address, city, state,email, pin, moblieNo, Password; 
    String CustomerIDValues; 
    String addressEX,cityEX,stateEX,pinEX,emailEX,moblieNoEX; 
    By userIDTextBox = By.xpath("//input[@name=\"uid\"]"); 
    By passWordTextBox= By.xpath("//input[@name=\"password\"]"); 

    By CustomerNameTextBox= By.xpath("//input[@name=\"name\"]"); 
    By genderRadio= By.xpath("//input[@value=\"m\"]"); 
    By dateOfBirthdayTB= By.xpath("//input[@id=\"dob\"]"); 
    By addressTB= By.xpath("//textarea[@name=\"addr\"]"); 
    By cityTB= By.xpath("//input[@name=\"city\"]"); 
    By stateTB= By.xpath("//input[@name=\"state\"]"); 
    By pinTB= By.xpath("//input[@name=\"pinno\"]"); 
    By moblieNoTB= By.xpath("//input[@name=\"telephoneno\"]"); 
    By emailTB= By.xpath("//input[@name=\"emailid\"]"); 
    By PasswordTB= By.xpath("//input[@name=\"password\"]"); 
    By submitButton= By.xpath("//input[@value=\"Submit\"]"); 
     
    	@BeforeTest 
    	  public void beforeTest() { 
    		driver = new FirefoxDriver(); 
    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
    		driver.manage().window().maximize(); 
    		driver.get("http://demo.guru99.com/v4"); 
    	    driver.findElement(userIDTextBox).sendKeys(userIDText); 
   		    driver.findElement(passWordTextBox).sendKeys(passWord); 
    		driver.findElement(By.xpath("//input[@name=\"btnLogin\"]")).click(); 
    		Assert.assertTrue(driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")).isDisplayed()); 
    		 
    		 addressEX="thanh xuan ha noi"; 
    		 cityEX="Ha Noi"; 
    		 stateEX="nguyen trai"; 
    		 pinEX="999999"; 
     		 emailEX="Ivy"+ Topic_03_WebElement_WebBrowser_Exercise.randomNubmer() +"@gmail.com";  
     		 moblieNoEX="0999999999"; 
    	} 
      
     @Test 
      public void TC_01_AddNewCustomer(){ 
   		 driver.findElement(By.xpath("//a[text()=\"New Customer\"]")).click();  
    		 customerName="Uyenntt"; 
    		 genDer="male"; 
   		     dateOfBirthday="1991-04-20"; 
    		 address="123 Address thanh thanh"; 
    		 city="Ho Chi Minh"; 
    		 state="Thu Duc"; 
    		 pin="888888"; 
    		 email="uyennguyen"+ Topic_03_WebElement_WebBrowser_Exercise.randomNubmer() +"@gmail.com";  
     		 moblieNo="03657899766"; 
    		 passWord="123456"; 
     		 driver.findElement(CustomerNameTextBox).sendKeys(customerName); 
    		 driver.findElement(genderRadio).click();; 
    		 driver.findElement(dateOfBirthdayTB).sendKeys(dateOfBirthday); 
    		 driver.findElement(addressTB).sendKeys(address); 
     		 driver.findElement(cityTB).sendKeys(city); 
    		 driver.findElement(stateTB).sendKeys(state); 
    		 driver.findElement(pinTB).sendKeys(pin); 
         	 driver.findElement(moblieNoTB).sendKeys(moblieNo); 
    		 driver.findElement(emailTB).sendKeys(email); 
    		 driver.findElement(passWordTextBox).sendKeys(passWord); 
    		 driver.findElement(submitButton).click(); 
    	  
    		 Assert.assertTrue(driver.findElement(By.xpath("//p[text()=\"Customer Registered Successfully!!!\"]")).isDisplayed());  
    		  
    		 Assert.assertEquals(driver.findElement(By.xpath("//table[@id=\"customer\"]//td[text()=\"Customer Name\"]//following-sibling::td")).getText(), customerName); 
    		 Assert.assertEquals(driver.findElement(By.xpath("//table[@id=\"customer\"]//td[text()=\"Gender\"]//following-sibling::td")).getText(), genDer); 
    		 Assert.assertEquals(driver.findElement(By.xpath("//table[@id=\"customer\"]//td[text()=\"Birthdate\"]//following-sibling::td")).getText(), dateOfBirthday); 
     		 Assert.assertEquals(driver.findElement(By.xpath("//table[@id=\"customer\"]//td[text()=\"Address\"]//following-sibling::td")).getText(), address); 
     		 Assert.assertEquals(driver.findElement(By.xpath("//table[@id=\"customer\"]//td[text()=\"City\"]//following-sibling::td")).getText(), city); 
    		 Assert.assertEquals(driver.findElement(By.xpath("//table[@id=\"customer\"]//td[text()=\"State\"]//following-sibling::td")).getText(), state); 
     		 Assert.assertEquals(driver.findElement(By.xpath("//table[@id=\"customer\"]//td[text()=\"Pin\"]//following-sibling::td")).getText(), pin); 
     		 Assert.assertEquals(driver.findElement(By.xpath("//table[@id=\"customer\"]//td[text()=\"Mobile No.\"]//following-sibling::td")).getText(), moblieNo); 
     		 Assert.assertEquals(driver.findElement(By.xpath("//table[@id=\"customer\"]//td[text()=\"Email\"]//following-sibling::td")).getText(), email); 
     		CustomerIDValues = driver.findElement(By.xpath("//table[@id=\"customer\"]//td[text()=\"Customer ID\"]/following-sibling::td")).getText(); 
     				 
     	 } 
    	  
    	 @Test 
     	  public void TC_02_EditCustomer() throws Exception{ 
     		 CustomerIDValues = driver.findElement(By.xpath("//table[@id=\"customer\"]//td[text()=\"Customer ID\"]/following-sibling::td")).getText(); 
     		 System.out.println(CustomerIDValues); 
              driver.findElement(By.xpath("//a[text()=\"Edit Customer\"]")).click();  
    		 driver.findElement(By.xpath("//input[@name=\"cusid\"]")).sendKeys(CustomerIDValues); 
    		 driver.findElement(By.xpath("//input[@value=\"Submit\"]")).click(); 
    
     
     		 driver.findElement(addressTB).clear(); 
    		 driver.findElement(addressTB).sendKeys(addressEX); 
    		  
     		 driver.findElement(cityTB).clear(); 
    		 driver.findElement(cityTB).sendKeys(cityEX); 
    		  
    		 driver.findElement(stateTB).clear();; 
    		 driver.findElement(stateTB).sendKeys(stateEX); 
    		  
    		 driver.findElement(pinTB).clear();; 
    		 driver.findElement(pinTB).sendKeys(pinEX); 
    		  
    		 driver.findElement(moblieNoTB).clear(); 
    		 driver.findElement(moblieNoTB).sendKeys(moblieNoEX); 
    		  
    		 driver.findElement(emailTB).clear(); 
    		 driver.findElement(emailTB).sendKeys(emailEX); 
     		  
     		 driver.findElement(submitButton).click(); 
     		 Assert.assertTrue(driver.findElement(By.xpath("//p[text()=\"Customer details updated Successfully!!!\"]")).isDisplayed());  
   
     
    	 } 
       @AfterTest 
       public void afterTest() { 
    	  driver.quit();  
      } 
        
    } 
	