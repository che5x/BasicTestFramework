package testCases;

import org.testng.annotations.Test;
import pageObjects.BaseLoginPage;
import testBase.BaseClass;

public class TC01_LoginToBasePage extends BaseClass {
	
	
	@Test(priority = 1)
	public void login() throws InterruptedException {
		System.out.println("1st test");
//		BaseLoginPage blp= new BaseLoginPage(driver);
//		blp.clickGoogleOption();
//		Thread.sleep(10);
//		blp.clickEmailAddress();
		System.out.println("1st test ended");
	}

}
