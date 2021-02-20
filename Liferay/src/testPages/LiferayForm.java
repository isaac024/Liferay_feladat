package testPages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LiferayForm {

	WebDriver driver;
	public LiferayForm (WebDriver driver )  {
		this.driver = driver;
	}
	
	private String errorText = "This field is required.";
	
	By userName = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");
	
	By userExplanationField = By.name("_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_ddm$$WhyDidYouJoinTheTestingArea$cU3rgPQN$0$$en_US");
	
	By userBirthDate = By.cssSelector(".form-control.input-group-inset.input-group-inset-after");
	
	public void enterUsername(String name) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(userName).sendKeys(name);
	}
	
}
