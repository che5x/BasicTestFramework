package testCases;

import org.testng.annotations.Test;

import pageObjects.AdminPage;
import pageObjects.DashboardPage;
import testBase.BaseClass;

public class TC02_AddTeamMember extends BaseClass {

	@Test(priority = 2)
	public void addTeamMember() throws InterruptedException {

		try {
			logger.info("**** 2nd TestCase Started ****");

			System.out.println("2nd test started...");
			DashboardPage dashboard = new DashboardPage(driver);
			AdminPage ap = new AdminPage(driver);
			Thread.sleep(9000);
			dashboard.clickarrowButton();
			dashboard.clickadminSettingsButton();

			// adding values in Add member popup
			ap.clickAddTeamMemberButton();
			logger.info("adding details of Member:");
			ap.inputTeamMemberName();
			ap.inputTeamMemberEmail();
			ap.inputTeamMemberTitle();
			ap.selectAccessType();
			ap.clickAddButton();

			logger.info("Validating email added or not**");
			org.testng.Assert.assertEquals(ap.email, ap.verifyAddedEmail());
		} catch (Exception e) {
			logger.error("Test Failed");
			logger.debug("Debug logs..");
			org.testng.Assert.fail();
		}
		logger.info("***** TC02 Finished! *****");
	}

}
