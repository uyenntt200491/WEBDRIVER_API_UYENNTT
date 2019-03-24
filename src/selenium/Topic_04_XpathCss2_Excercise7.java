package selenium; 
 
 
 import java.util.Random; 
import java.util.concurrent.TimeUnit; 
 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.testng.Assert; 
import org.testng.annotations.AfterTest; 
import org.testng.annotations.BeforeTest; 
import org.testng.annotations.Test; 
public class Topic_04_XpathCss2_Excercise7 { 
String name, bithday, addr, city, state, pinnumber, phone, mail, pass; 
String editaddr, editcity, editstate, editpinnumber, editphone, editmail; 
WebDriver driver; 
By UserID = By.xpath("//input[@name='uid']"); 
By Password = By.xpath("//input[@name='password']"); 
By login = By.xpath("//input[@name='btnLogin']"); 
By hompage = By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]"); 
 
// locator of add new customer 
By Customername = By.xpath("//input[@name='name']"); 
By Gender = By.xpath("//input[@name='rad1']"); 
By DateofBirth = By.xpath("//input[@name='dob']"); 
By Address = By.xpath("//textarea[@name='addr']"); 
By City = By.xpath("//input[@name='city']"); 
By State = By.xpath("//input[@name='state']"); 
By PIN = By.xpath("//input[@name='pinno']"); 
By MobileNumber = By.xpath("//input[@name='telephoneno']"); 
By Email = By.xpath("//input[@name='emailid']"); 
By PWD = By.xpath("//input[@name='password']"); 
By Submit = By.xpath("//input[@name='sub']"); 
 // locator of edit customer 
By Gender1 = By.xpath("//input[@name='gender']"); 
 
@BeforeTest 
public void beforeTest() { 
driver = new FirefoxDriver(); 
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
driver.manage().window().maximize(); 
 
		// Init data test for add new customer 
    name = "automation Online"; 
	bithday = "1991-20-04"; 
	addr = "Thanh Xuan"; 
 		city = "Ha Noi"; 
		state = "Viet Nam"; 
		pinnumber = "123456"; 
		phone = "0367163282"; 
 		mail = "automation" + random() + "@gmail.com"; 
 		pass = "123ez123"; 
 
  		// Init data test for edit customer 
 		editaddr = "London"; 
 		editcity = "London";  		
 		editstate = "England"; 
 		editpinnumber = "987653"; 
 		editphone = "1234567345"; 
 		editmail = "selenium" + random() + "@gmail.com"; 
 
  	} 
 
 
 	@Test 
 	public void TC01_handingtextboxt_textarea_addvieweditinfomationcustomer() { 
 		driver.get(" http://demo.guru99.com/v4"); 
 		driver.findElement(UserID).sendKeys("mngr181358 "); 
 		driver.findElement(Password).sendKeys("berydUp "); 
		driver.findElement(login).click(); 
 
 		// verify home page 
 		Assert.assertTrue(driver.findElement(hompage).isDisplayed()); 
 		driver.findElement(By.xpath("//a[text()='New Customer']")).click(); 
 		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Add New Customer']")).isDisplayed()); 

 
		// Enter data test for add new customer 
		driver.findElement(Customername).sendKeys(name);  		
		driver.findElement(Gender).click(); 
        driver.findElement(DateofBirth).sendKeys(bithday); 
        driver.findElement(Address).sendKeys(addr); 
 		driver.findElement(City).sendKeys(city); 
		driver.findElement(State).sendKeys(state); 
		driver.findElement(PIN).sendKeys(pinnumber); 
		driver.findElement(MobileNumber).sendKeys(phone); 
		driver.findElement(Email).sendKeys(mail); 
		driver.findElement(PWD).sendKeys(pass); 
 		driver.findElement(Submit).click(); 
 
 
 		// verify information then sign UP success 
 		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Customer Registered Successfully!!!']")).isDisplayed()); 
 		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), name); 
 		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText(), "male"); 
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), bithday); 
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), addr); 
 		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), city); 
 		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), state); 
 		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), pinnumber); 
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), phone); 
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), mail); 

		// Step 07: Edit information 
 
		// Get text customID 
		String customerID = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText(); 

 
		driver.findElement(By.xpath("//a[text()='Edit Customer']")).click(); 
 		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Edit Customer Form']")).isDisplayed()); 
 		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(customerID); 
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click(); 

 		// Verify edit customer form 
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='heading3' and text()='Edit Customer']")).isDisplayed()); 

  		// verify Customer Name and Address at edit form; true date when create at New Customer 
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='name']")).getAttribute("value"), name); 
 		Assert.assertEquals(driver.findElement(By.xpath("//textarea[@name='addr']")).getText(), addr); 

 
 		System.out.println("Result of check field Disable:"); 
 
 
		// Enter information at edit from 
		Assert.assertFalse(sendkeystring(Customername, "")); 
 		Assert.assertFalse(sendkeystring(Gender1, "")); 
		Assert.assertFalse(sendkeystring(DateofBirth, "")); 
 		Assert.assertTrue(sendkeystring(Address, editaddr)); 
		Assert.assertTrue(sendkeystring(City, editcity)); 
		Assert.assertTrue(sendkeystring(State, editstate)); 
		Assert.assertTrue(sendkeystring(PIN, editpinnumber)); 
		Assert.assertTrue(sendkeystring(MobileNumber, editphone)); 
		Assert.assertTrue(sendkeystring(Email, editmail)); 
		driver.findElement(Submit).click(); 

 
 
	 
	// Verify then edit success 
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='heading3' and  text()='Customer details updated Successfully!!!']")).isDisplayed()); 
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), name); 
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText(), "male"); 
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), bithday); 
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), editaddr); 
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), editcity); 
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), editstate); 
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), editpinnumber); 
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), editphone); 
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), editmail); 
		 
		System.out.println("TC01 done"); 
	} 

  	@AfterTest 
	public void afterTest() { 
 		// driver.quit(); 
	} 

 
	// random function 
	public int random() { 
		Random rd = new Random(); 
		int number = rd.nextInt(100000); 
 		return number; 
	} 

 
 	public boolean checkdisable(By value) { 
		if (driver.findElement(value).isEnabled()) { 
			System.out.println(value + ":enable"); 
			return true; 
		} else { 
			System.out.println(value + ":disable"); 
			return false; 
		} 

 
	} 

 
 	public boolean sendkeystring(By value, String value1) { 
 		if (checkdisable(value)) { 
 			driver.findElement(value).clear(); 
 			driver.findElement(value).sendKeys(value1); 
 			return true; 
 		} else { 
 			System.out.println(value + "cannot edit"); 
			return false; 
		}  
 
	} 
 
  } 
