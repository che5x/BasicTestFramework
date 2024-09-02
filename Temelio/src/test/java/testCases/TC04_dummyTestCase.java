package testCases;

import org.testng.annotations.Test;

import testBase.BaseClass;

public class TC04_dummyTestCase extends BaseClass {
	@Test(priority = 5)
	public void login() throws InterruptedException {
		System.out.println("4th testcase started!");
		System.out.println("4th testCase ended!");
	}
}
