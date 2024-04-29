package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import constant.Constant;
import elementRepo.ClientPage;
import elementRepo.LoginPage;

public class ClientPageTestCases extends BaseClass {
	@Test(groups = "medium",retryAnalyzer = retry.Retry.class)
	public void VerifyFirstNameAndSecondNamegGetsEmptyOnReset() {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(Constant.inputUserName);
		lp.inputPassword(Constant.inputPassword);
		lp.clickLoginButton();
		ClientPage cp = new ClientPage(driver);
		cp.navigateToClientTab();
		cp.inputClientName("Astar Logisticss123");
		cp.inputClientID("1");
		cp.clickOnClientResetButton();
		String actual = cp.getTextFromClientNameTextBox();
		String expected = "";
		Assert.assertEquals(actual, expected, "Reset field is not empty after reset, test failed");
	}

	@Test(groups = "medium",retryAnalyzer = retry.Retry.class)
	public void VerifySearchedClientListingInTable() {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(Constant.inputUserName);
		lp.inputPassword(Constant.inputPassword);
		lp.clickLoginButton();
		ClientPage cp = new ClientPage(driver);
		cp.navigateToClientTab();
		cp.inputClientName("Astar Logisticss123");
		cp.inputClientID("1");
		cp.clickOnClientSearchButton();
		String actual = cp.getTextFromFirstClientNameFromTable();
		String expected = "Astar Logisticss123";
		Assert.assertEquals(actual, expected, "Client name is not listing in Table after Search, test failed");
	}

	@Test(groups = "medium",retryAnalyzer = retry.Retry.class)
	public void VerifyClientNameIsMatchingInClientDetailsUsingViewButton() {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(Constant.inputUserName);
		lp.inputPassword(Constant.inputPassword);
		lp.clickLoginButton();
		ClientPage cp = new ClientPage(driver);
		cp.navigateToClientTab();
		String actual = cp.getTextFromFirstClientNameFromTable();
		cp.clickOnClientViewButton();
		String expected = ("Astar Logisticss123");
		Assert.assertEquals(actual, expected,
				"Client Name is not Matching In Client Detail's Table after clicking on eye symbol, test failed");
	}
	@Test(groups = "medium",retryAnalyzer = retry.Retry.class)
	public void VerifyClientDetailsPageOpensUsingViewButton() {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(Constant.inputUserName);
		lp.inputPassword(Constant.inputPassword);
		lp.clickLoginButton();
		ClientPage cp = new ClientPage(driver);
		cp.navigateToClientTab();
		cp.clickOnClientViewButton();
		String actual=driver.getCurrentUrl();
		String expected = ("https://www.qabible.in/payrollapp/client/view?id=1");
		Assert.assertEquals(actual, expected,
				"Client details page is not launching after clicking on view button, test failed");
	}
	@Test(groups = "medium",retryAnalyzer = retry.Retry.class)
	public void VerifyClientDetailsPageTitleAfterClikingOnViewButton() {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(Constant.inputUserName);
		lp.inputPassword(Constant.inputPassword);
		lp.clickLoginButton();
		ClientPage cp = new ClientPage(driver);
		cp.navigateToClientTab();
		cp.clickOnClientViewButton();
		String actual=cp.clientDetailsPageTitle();
		String expected = ("Astar Logisticss123".toUpperCase());
		Assert.assertEquals(actual, expected,
				"Client details page title is not showing after clicking on view button, test failed");
		
		
		
	}
	   
	
	
}
