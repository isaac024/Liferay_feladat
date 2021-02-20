package teststCases;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import testPages.LiferayForm;

public class CorrectSubmit {

	
	
	public static void main(String [] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://forms.liferay.com/web/forms/shared/-/form/122548?p_p_state=pop_up&p_p_auth=DmwgGHZN&_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_languageId=en_US");	
	
		LiferayForm form = new LiferayForm(driver);
	
	
	form.enterUsername("Teszt");
	
	//driver.quit();
	}
}
