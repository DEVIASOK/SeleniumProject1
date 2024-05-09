package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import constant.Constant;
import elementRepo.ClientPage;
import elementRepo.LoginPage;

public class ClientPageTestCases extends BaseClass {
	@Test(groups = "medium", retryAnalyzer = retry.Retry.class)
	public void VerifyClientNameAndClientIDFieldIsEmptyOnReset() {   
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(Constant.inputUserName);
		lp.inputPassword(Constant.inputPassword);
		lp.clickLoginButton();
		ClientPage cp = new ClientPage(driver);
		cp.navigateToClientTab();
		cp.inputClientName(Constant.inputClientName);
		cp.inputClientID(Constant.inputClientID);
		cp.clickOnClientResetButton();
		boolean actual = cp.getTextFromClientNameIDTextBoxsAndCheckEmptyAfterReset();
		boolean expected = true;
		Assert.assertEquals(actual, expected, Constant.errorMessageForFailedResetOnClientPage);
	}

	@Test(groups = "medium", retryAnalyzer = retry.Retry.class)
	public void VerifySearchedClientListingInTable() {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(Constant.inputUserName);
		lp.inputPassword(Constant.inputPassword);
		lp.clickLoginButton();
		ClientPage cp = new ClientPage(driver);
		cp.navigateToClientTab();
		cp.inputClientName(Constant.inputClientName);
		cp.inputClientID(Constant.inputClientID);
		cp.clickOnClientSearchButton();
		String actual = cp.getTextFromFirstClientNameFromTable();
		String expected = Constant.inputClientName;
		Assert.assertEquals(actual, expected, Constant.errorMessageForFailedClientSearch);
	}
	@Test(groups = "medium", retryAnalyzer = retry.Retry.class)
	public void VerifyClientDetailsPageOpensUsingViewButton() {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(Constant.inputUserName);
		lp.inputPassword(Constant.inputPassword);
		lp.clickLoginButton();
		ClientPage cp = new ClientPage(driver);
		cp.navigateToClientTab();
		cp.clickOnClientViewButton();
		String actual = driver.getCurrentUrl();
		String expected = Constant.ExpectedUrlForFirstClientsClientDetailPageUsingView;
		Assert.assertEquals(actual, expected, Constant.errorMessageForNotLaunchingClientDetailPageUsingView);
	}

	@Test(groups = "medium", retryAnalyzer = retry.Retry.class)  
	public void VerifyClientNameInClientDetailsPageUsingViewButton() {   
		LoginPage lp = new LoginPage(driver); 
		lp.inputUserName(Constant.inputUserName);  
		lp.inputPassword(Constant.inputPassword);
		lp.clickLoginButton();
		ClientPage cp = new ClientPage(driver);
		cp.navigateToClientTab();
		cp.clickOnClientViewButton();
		String actual = cp.getTextFromClientNameFromClientDetailsTableUsingViewButton();
		String expected = (Constant.inputClientName);
		Assert.assertEquals(actual, expected, Constant.errorMessageForFailedTitleFromClientDetailsPage);

	}

	
 
	@Test(groups = "medium", retryAnalyzer = retry.Retry.class)
	public void VerifyClientNameOnTitleAfterClikingOnViewButton() {   
		LoginPage lp = new LoginPage(driver); 
		lp.inputUserName(Constant.inputUserName);
		lp.inputPassword(Constant.inputPassword); 
		lp.clickLoginButton();
		ClientPage cp = new ClientPage(driver);
		cp.navigateToClientTab();
		cp.clickOnClientViewButton();  
		String actual = cp.clientDetailsPageTitle();
		String expected = (Constant.inputClientName.toUpperCase()); 
		Assert.assertEquals(actual, expected,Constant.errorMessageForNotShowingClientInTitle);

	}

}
