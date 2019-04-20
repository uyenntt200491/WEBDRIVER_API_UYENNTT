package selenium;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_04_XpathCss2_Excercise6 {
    WebDriver driver;
	String firstName = "Automation";
	String lastName = "Testing";
	String email = "autoonline" + randomNumber() + "gmail.com";
	String password = "123456";

	By emailTextbox = By.xpath("//input[@id='mail']");
	By ageUnder18Radio = By.xpath("//input[@id='under_18']");
	By educationTextArea = By.xpath("//textarea[@id='edu']");
	By jobRoleDroDown = By.xpath("//select[@id='job1']");
	By developmentCheckbox = By.xpath("//input[@id='development']");
	By slider = By.xpath("//input[@id='slider-1']");
	By bioTextArea = By.xpath("//textarea[@id='bio']");
	By disableButton = By.xpath("//button[@id='button-disabled']");

	@BeforeClass
	  public void beforeClass() {
		  driver = new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.manage().window().maximize();

	}

	private String randomNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Test(enabled = false)
	public void TC_01_CheckDisplayed() {

		driver.get("https://daominhdam.github.io/basic-form/index.html");
		if (isElementDisplayed(emailTextbox)) {
			driver.findElement(emailTextbox).sendKeys("Automation Testing");
		}
		if (isElementDisplayed(educationTextArea)) {
			driver.findElement(educationTextArea).sendKeys("Automation Testing");
		}
		if (isElementDisplayed(ageUnder18Radio)) {
			driver.findElement(ageUnder18Radio).click();
		}

	}

	@Test(enabled = false)
	public void TC_02_CheckEnabled() {
		driver.get("https://daominhdam.github.io/basic-form/index.html");
		Assert.assertTrue(isElementEnabled(emailTextbox));
		Assert.assertTrue(isElementEnabled(ageUnder18Radio));
		Assert.assertTrue(isElementEnabled(educationTextArea));
		Assert.assertTrue(isElementEnabled(jobRoleDroDown));
		Assert.assertTrue(isElementEnabled(developmentCheckbox));
		Assert.assertTrue(isElementEnabled(slider));
		Assert.assertFalse(isElementEnabled(bioTextArea));
		Assert.assertFalse(isElementEnabled(disableButton));

	}

	@Test
	public void TC_03_CheckSelected() throws Exception {
		driver.get("https://daominhdam.github.io/basic-form/index.html");

		checkToCheckbox(ageUnder18Radio);
		checkToCheckbox(developmentCheckbox);
		Assert.assertTrue(isElementSelected(ageUnder18Radio));
		Assert.assertTrue(isElementSelected(developmentCheckbox));
		uncheckToCheckbox(developmentCheckbox);
		//Assert.assertFalse(isElementSelected(ageUnder18Radio));
		Assert.assertFalse(isElementSelected(developmentCheckbox));

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int randomNumber1() {
		Random random = new Random();
		int number = random.nextInt(999999);
		System.out.println("Random number = " + number);
		return number;

	}

	public boolean isElementDisplayed(By byValue) {
		if (driver.findElement(byValue).isDisplayed()) {
			System.out.println("Element [" + byValue + "] is displayed!");
			return true;
		} else {
			System.out.println("Element [" + byValue + "] is not displayed!");
			return false;
		}
	}

	public boolean isElementEnabled(By byValue) {
		if (driver.findElement(byValue).isEnabled()) {
			System.out.println("Element [" + byValue + "] is enable!");
			return true;
		} else {
			System.out.println("Element [" + byValue + "] is disable!");
			return false;
		}
	}

	public boolean isElementSelected(By byValue) {
		{
			WebElement element = driver.findElement(byValue);
			if (element.isSelected()) {
				System.out.println("Element [" + byValue + "] is selected!");
				return true;
			} else {

				System.out.println("Element [" + byValue + "] is de-selected!");
				return false;
			}
		}
	}

	public void checkToCheckbox(By byValue) {
		WebElement element = driver.findElement(byValue);
		if (!element.isSelected()) {
			element.click();
			System.out.println("Element [" + byValue + "] is selected!");
		}
	}

	public void uncheckToCheckbox(By byValue) {
		WebElement element = driver.findElement(byValue);
		if (element.isSelected()) {
			element.click();
			System.out.println("Element [" + byValue + "] is de-selected!");
		}
	}
}

	