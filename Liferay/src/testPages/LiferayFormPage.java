package testPages;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LiferayFormPage {

	WebDriver driver;
	WebDriverWait wait;

	// With this String I can select the whole fields so I
	String selectAll = Keys.chord(Keys.CONTROL, "a");
	String currentURL;
	public String brasilURL = "https://forms.liferay.com/web/forms/shared/-/form/122548?p_p_state=pop_up&p_p_auth=Zysfdqzs&_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_languageId=pt_BR";
	public String englishURL = "https://forms.liferay.com/web/forms/shared/-/form/122548?p_p_state=pop_up&p_p_auth=JnTd80dQ&_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_languageId=en_US";

	public LiferayFormPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	By languageIcon = By.tagName("button");

	By otherLanguage = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[2]");

	By userName = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

	By userExplanationField = By.tagName("textarea");

	By userBirthDate = By.cssSelector(".form-control.input-group-inset.input-group-inset-after");

	By firstDateOfDatePicker = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]");

	By submit = By.xpath("//*[text()='Submit']");

	By userNameError = By.xpath(
			("//body/div[@id='senna_surface1-default']/div[@id='main-content']/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));

	By birthDateError = By.xpath(
			"//body/div[@id='senna_surface1-default']/div[@id='main-content']/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]");

	By userExplanationError = By.xpath(
			"//body/div[@id='senna_surface1-default']/div[@id='main-content']/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]");

	public By informationSent = By.xpath("//*[contains(text(), 'Information sent')]");

	public By errorText = By.xpath("//*[contains(text(), 'This field is required.')]");

	// Change language and refresh page so selenium can use actual id's again for elements
	public void languageChange() {

		driver.findElement(languageIcon).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(otherLanguage));
		driver.findElement(otherLanguage).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(submit));
		driver.navigate().refresh();
	}

	public void enterUsername(String name) {

		driver.findElement(submit).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(userNameError));
		driver.findElement(userName).sendKeys(name);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(userNameError));
	}

	public void enterUserExplanationField(String testExperience) {
		driver.findElement(userExplanationField).click();
		driver.findElement(userExplanationField).sendKeys(testExperience);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(userExplanationError));
	}

	public void enterBirthDate(String date) {

		driver.findElement(userBirthDate).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstDateOfDatePicker));
		driver.findElement(firstDateOfDatePicker).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(birthDateError));
	}

	public void submitForm() {
		driver.findElement(submit).click();
	}

	public void deleteUserExplanationFieldContent() {

		driver.findElement(userExplanationField).click();
		driver.findElement(userExplanationField).sendKeys(selectAll);
		driver.findElement(userExplanationField).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.visibilityOfElementLocated(userExplanationError));
	}

	public void deleteBirthDateContent() {

		driver.findElement(userBirthDate).click();
		driver.findElement(userBirthDate).sendKeys(selectAll);
		driver.findElement(userBirthDate).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.visibilityOfElementLocated(birthDateError));
	}

	public void deleteUserNameFieldContent() {

		driver.findElement(userName).click();
		driver.findElement(userName).sendKeys(selectAll);
		driver.findElement(userName).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.visibilityOfElementLocated(userNameError));
	}

	// Check if the URL is changed to US
	public boolean isLanguageChangeSuccessful() {

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(submit));
			currentURL = driver.getCurrentUrl();
			if (currentURL != brasilURL)
				return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.print("The language is not changed");
		}
		return false;
	}

	// Check if there is any error message present
	public boolean isErrorMessagePresent() {
		
		try {
			if (driver.findElement(errorText).isDisplayed())
				return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.print("Error message was not present");
		}
		return false;
	}

	// Check if submit button is still visible or not
	public boolean isSubmitSuccessful() {

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(submit));
			driver.findElement(submit);
			return false;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.print("The submit was not successful");
		}
		return true;
	}

}