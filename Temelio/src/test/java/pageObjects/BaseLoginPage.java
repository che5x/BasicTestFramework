package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BaseLoginPage extends BasePage{
	WebDriver driver;
	
	public BaseLoginPage(WebDriver driver) {
		super(driver);
	}
	
	//locators:
	@FindBy(xpath="//button[normalize-space()='Continue with Google']")
	WebElement googleOption;
	
	@FindBy(xpath="//div[@data-email='iamcn26@gmail.com']")
	WebElement emailAddress;

	
	//Methods/Actions:
	public void clickGoogleOption() {
		googleOption.click();
	}
	
	public void clickEmailAddress() {
		emailAddress.click();
	}
}
