package testPages;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LiferayFormPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public LiferayFormPage (WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,10);
	}
	
	By errorText = By.xpath("//*[contains(text(), 'This field is required.')]");
	
	By languageIcon = By.tagName("button");
	
	By otherLanguage = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[2]");
	
	By userName = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
	
	By userExplanationField = By.tagName("textarea");
	
	By userBirthDate = By.cssSelector(".form-control.input-group-inset.input-group-inset-after");
	
	By firstDateOfDatePicker = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]");
	
	By submit = By.xpath("//*[text()='Submit']");
	
	public By informationSent = By.xpath("//*[contains(text(), 'Information sent')]");
	
	
	public void languageChange() throws InterruptedException {
		
		driver.findElement(languageIcon).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(otherLanguage));
		driver.findElement(otherLanguage).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
	}
	
	public void enterUsername (String name) throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
		driver.findElement(userName).click();
		driver.findElement(userName).sendKeys(name);
		//Azert szukseges a Thread.sleep mivel ha tul koran kattint mashova a program az adat bevitele utan, akkor a mezo alatt megjelenik a hibauzenet
		Thread.sleep(1000);
	}
	
	public void enterUserExplanationField (String testExperience) throws InterruptedException {
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
	}
	
	//Ellenorzi, hogy lathato e barhol ures mezo felirat
	public boolean errorMessageIsPresent() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorText));
		 if (driver.findElement(errorText).isDisplayed())
			 return true;
		 else
			 return false;
	}
	
	//Leellenorizzuk, hogy megtalalja e a submit gombot atnavigalas utan
	public boolean successfulSubmit() throws InterruptedException {
			Thread.sleep(1000);
			 try {
			        driver.findElement(submit);
			        return false;
			    } catch (org.openqa.selenium.NoSuchElementException e) {
			        return true;
			    }	
	}
}
	