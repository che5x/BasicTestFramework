package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AdminPage extends BasePage{
	WebDriver driver;
	
	public AdminPage(WebDriver driver) {
		super(driver);
	}
	
	//locators:
	@FindBy(xpath="//span[text()='Access Type']/following::select")
	WebElement selectAccessType;
	
	@FindBy(xpath="//button[contains(text(),'Add Team Member')]")
	WebElement addTeamMemberButton;

	@FindBy(xpath="//span[text()='Name']/following::input[1]")
	WebElement inputTeamMemberName;
	
	@FindBy(xpath="//span[text()='Email']/following::input[1]")
	WebElement inputTeamMemberEmail;
	
	@FindBy(xpath="//span[text()='Title']/following::input[1]")
	WebElement inputTeamMemberTitle;
	
	@FindBy(xpath="//button[text()='Cancel']//following-sibling::button")
	WebElement addButton;

	@FindBy(xpath="//tr/following::td[text()='backupofche@gl.com']")
	WebElement verifyAddedEmail;
	
	@FindBy(xpath="//tr/following::td[text()='backupofche@gl.com']/preceding-sibling::td[2]")
	WebElement verifyName;
	
	//Methods/Actions:
	public String verifyName() {
		return verifyName.getText();
	}
	public String verifyAddedEmail() {
		return verifyAddedEmail.getText();
	}
	public void clickAddButton() {
		addButton.click();
	}
	public void clickAddTeamMemberButton() throws InterruptedException {
		addTeamMemberButton.click();
	}
	
	public void inputTeamMemberName() {
		inputTeamMemberName.sendKeys(name);
	}
	
	public void inputTeamMemberEmail() {
		inputTeamMemberEmail.sendKeys(email);
	}
	
	public void inputTeamMemberTitle() {
		inputTeamMemberTitle.sendKeys(title);
	}
	
	public void selectAccessType() {
		Select accessType = new Select(selectAccessType);
		accessType.selectByVisibleText(accessRole);
	}
	
	//variables:
	public String name="che3";
	public String email="backupofche@gl.com";
	String title="testTitle";
	String accessRole = "User Access";


}
