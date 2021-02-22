package teststCases;

import static org.junit.Assert.assertTrue;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import testPages.LiferayFormPage;

public class CorrectSubmit {
	
	public static void main(String [] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
	//Komment jeleket toroljuk a firefoxhoz, es kommentezzuk ki ehhez hasonloan a fenti 2 sort chrometol	
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new FirefoxDriver();

		//Megnyitjuk az oldalt majd teljes kepernyos modba rakjuk
		driver.get("https://forms.liferay.com/web/forms/shared/-/form/122548?p_p_state=pop_up&p_p_auth=94oZtHon&_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_languageId=pt_BR");	
        driver.manage().window().maximize();
	
        LiferayFormPage form = new LiferayFormPage(driver);
        
        //Kitoltjuk a mezoket majd bekuldjuk az adatainkat
		form.languageChange();
		form.enterUsername("Teszt Elek Elemer");
		form.enterUserExplanationField("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
		form.enterBirthDate("01092011");
		form.submitForm();

		// Ellenorizzuk, hogy eltunt e a submit gomb, tehat sikeres-e az adatbekuldes
		assertTrue(form.successfulSubmit());
	
		driver.quit();
	}
}
