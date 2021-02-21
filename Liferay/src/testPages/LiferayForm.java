package testPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LiferayForm {

	WebDriver driver;
	WebDriverWait wait;
	public String errorText = "This field is required.";
	public String successfulSubmit = "Information sent";
	//String actual1 = driver.findElement(By.id("1")).getText();
	
	public LiferayForm (WebDriver driver)  {
		this.driver = driver;
		wait = new WebDriverWait(driver,10);
	}
	
	By languageIcon = By.tagName("button");
	
	By otherLanguage = By.tagName("a");
	
	By userName = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
	
	By userExplanationField = By.tagName("textarea");
	
	By userBirthDate = By.cssSelector(".form-control.input-group-inset.input-group-inset-after");
	
	By firstDateOfDatePicker = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]");
	
	By submit = By.xpath("//*[text()='Submit']");
	
	public void languageChange() throws InterruptedException {
		
		driver.findElement(languageIcon).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(otherLanguage));
		driver.findElement(otherLanguage).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
	}
	
	public void enterUsername (String name) throws InterruptedException   {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
		driver.findElement(userName).click();
		driver.findElement(userName).sendKeys(name);
		Thread.sleep(1000);
	}
	
	public void enterUserExplanationField (String testExperience) throws InterruptedException   {
		driver.findElement(userExplanationField).click();
		driver.findElement(userExplanationField).sendKeys(testExperience);
		Thread.sleep(1000);
	}
	
	public void enterBirthDate (String date) throws InterruptedException {
		
		driver.findElement(userBirthDate).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstDateOfDatePicker));
		driver.findElement(firstDateOfDatePicker).click();
		Thread.sleep(1000);
	}
	
	public void submitForm () throws InterruptedException {
		driver.findElement(submit).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
	}
	
}
