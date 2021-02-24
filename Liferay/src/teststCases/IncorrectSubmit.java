package teststCases;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import testPages.LiferayFormPage;

import org.openqa.selenium.WebDriver;

public class IncorrectSubmit {
	// Here we validate that each field is required to be able to submit

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

//Need to delete the comment symbols before the 2 row under this row and comment out the 2 row above to run the test on Firefox 	

		// WebDriverManager.firefoxdriver().setup();
		// WebDriver driver = new FirefoxDriver();

		LiferayFormPage form = new LiferayFormPage(driver);

		// Opening the url the making the test fullscreen
		driver.get(form.englishURL);
		driver.manage().window().maximize();

		// Click on submit button so every error message appear under empty fields
		form.submitForm();

		// Check if form is submittable with empty birthday field
		form.enterUsername("Teszt Elek Elemer");
		form.enterUserExplanationField(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
		form.submitForm();
		assertTrue(form.isErrorMessagePresent());

		// Delete the content of Explanation field and fill out the birthDate
		form.deleteUserExplanationFieldContent();
		form.enterBirthDate("01092011");

		// Check if form is submittable with empty user explanation field
		form.submitForm();
		assertTrue(form.isErrorMessagePresent());

		// Delete the content of username field and fill out the explanation field
		form.deleteUserNameFieldContent();
		form.enterUserExplanationField("Text Template");

		// Check if form is submittable with empty user explanation field
		form.submitForm();
		assertTrue(form.isErrorMessagePresent());

		driver.quit();
	}
}