package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	//locators:
	//@FindBy(xpath="//*[@id=\'menu-button-:r1u:\']/span/div/svg[2]")
	//@FindBy(xpath="//button[@id='menu-button-:Rcpjbonl6H1:']/span/div/*[name()='svg']/*[name()='path']")
	@FindBy(xpath="//button[@id='menu-button-:Rcpjbonl6H1:']")
	WebElement arrowButton;
	@FindBy(xpath="//a[contains(@id,'menu-list-:Rcpjbonl6H1:-menuitem-:')]")
	WebElement adminSettingsButton;

	
	//Methods/Actions:
	public void clickarrowButton() {
		arrowButton.click();
	}
	
	public void clickadminSettingsButton() {
		System.out.println("adminSettingsButton:-"+adminSettingsButton);
		adminSettingsButton.click();
		System.out.println("admin button clicked");
	}

}
