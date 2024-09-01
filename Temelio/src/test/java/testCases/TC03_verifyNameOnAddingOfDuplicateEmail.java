package testCases;

import java.text.SimpleDateFormat;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AdminPage;
import pageObjects.DashboardPage;
import testBase.BaseClass;

public class TC03_verifyNameOnAddingOfDuplicateEmail extends BaseClass {

	@Test(priority = 3)
	public void test2() {

		try {
			logger.info("**** 3rd testCase started... ****");
			DashboardPage dashboard = new DashboardPage(driver);
			AdminPage ap = new AdminPage(driver);
			Thread.sleep(9000);
			dashboard.clickarrowButton();
			dashboard.clickadminSettingsButton();

			ap.clickAddTeamMemberButton();

			// updating ap.name of this testcase
			String existingName = ap.verifyName();
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
			ap.name = ap.name + timeStamp;

			// adding values in Add member popup
			ap.inputTeamMemberName();
			ap.inputTeamMemberEmail();
			ap.inputTeamMemberTitle();
			ap.selectAccessType();
			ap.clickAddButton();
			Thread.sleep(2000);
			// Validating if name is updated/lost on existing email
			logger.info("Validating if name is updated/lost on existing email-");
			Assert.assertEquals(ap.verifyName(), existingName);
		} catch (AssertionError e) {
			logger.info("* TC03 Finished! *");
			logger.info("error:"+e);
			org.testng.Assert.fail();
		}catch (Exception e) {
			logger.info("***** TC03 Finished! *****");
			logger.error("Test Failed");
			logger.debug("Debug logs..");
			org.testng.Assert.fail();
		}
		logger.info("*** TC03 Finished! ***");
	}

}
