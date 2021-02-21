package teststCases;

import static org.junit.Assert.assertTrue;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import testPages.LiferayForm;

public class CorrectSubmit {
	
	public static void main(String [] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://forms.liferay.com/web/forms/shared/-/form/122548?p_p_state=pop_up&p_p_auth=m9TZZJmA&_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_languageId=pt_BR");	
        driver.manage().window().maximize();
		LiferayForm form = new LiferayForm(driver);
	
		form.languageChange();
		
		
		form.enterUsername("Teszt Elek Elemer");
		form.enterUserExplanationField("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
		form.enterBirthDate("01092011");
		form.submitForm();
		
		System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Information sent')]")).getText());
		assertTrue((driver.findElement(By.xpath("//h1[contains(text(),'Information sent')]")).getText().equals(form.successfulSubmit)));
	
		driver.quit();
	}
}
