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
	//Here we validate that each field is required to be able to submit
	
	public static void main(String [] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	//WebDriverManager.firefoxdriver().setup();
	//WebDriver driver = new FirefoxDriver();
	
	driver.get("https://forms.liferay.com/web/forms/shared/-/form/122548?p_p_state=pop_up&p_p_auth=94oZtHon&_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_languageId=en_US");	

	LiferayFormPage form = new LiferayFormPage(driver);
    driver.manage().window().maximize();
    
    // Ellenorzom, hogy nem lehet beadni a formot 3 ures mezovel
    form.submitForm();
    assertTrue(form.errorMessageIsPresent());
    
    // Ellenorzom, hogy nem lehet beadni 2 ures mezovel
   	form.enterUsername("Teszt Elek Elemer");
   	form.submitForm();
    assertTrue(form.errorMessageIsPresent());
    
    // Ellenorzom, hogy nem lehet beadni 1 ures mezovel
	form.enterUserExplanationField("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
	form.submitForm();
	assertTrue(form.errorMessageIsPresent());
	
	driver.quit();
	}
}
