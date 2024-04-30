package testcases;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseClass;
import constant.Constant;
import elementRepo.LoginPage;
import elementRepo.WorkersPage;

public class WorkersPageTestcases extends BaseClass {
 
	@Test(groups = "medium",retryAnalyzer = retry.Retry.class)
	public void verifySearchText() {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(Constant.inputUserName);
		lp.inputPassword(Constant.inputPassword);
		lp.clickLoginButton();
		WorkersPage wp = new WorkersPage(driver);
		wp.navigateToWorkersTab();
		String actualResult = wp.searchText();
		String expectedResult = Constant.ExpectedTextonSearchButton;
		Assert.assertEquals(actualResult, expectedResult, Constant.errorMessageForFailedTextonSearchButton);
	}

	@Test(groups = "medium",retryAnalyzer = retry.Retry.class)
	public void verifyBGColorOfResetBtn() {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(Constant.inputUserName);
		lp.inputPassword(Constant.inputPassword);
		lp.clickLoginButton();
		WorkersPage wp = new WorkersPage(driver);  
		wp.navigateToWorkersTab();
		String hex = Color.fromString(wp.backgroundColorOfResetBtn()).asHex();
		String actual =hex;
		System.out.println(actual);
		String expected =Constant.ExpectedBGColorOnResetButton; 
		Assert.assertEquals(actual, expected, Constant.errorMessageForFailedResetbgcolor);
	}

	@Test(groups = "critical",retryAnalyzer = retry.Retry.class)
	public void verifyValueinWorkersTitleDropdown() {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(Constant.inputUserName);
		lp.inputPassword(Constant.inputPassword);
		lp.clickLoginButton();
		WorkersPage wp = new WorkersPage(driver);
		wp.navigateToWorkersTab();
		wp.clickonCreateWorker();
		String actual = wp.navigateToTitleDropDown();
		String expected = Constant.ExpectedValueFromWorkersTitleDropdown;
		Assert.assertEquals(actual, expected, Constant.errorMessageForFailedTitleSelection);
	}

	@Test(groups = "low",retryAnalyzer = retry.Retry.class)
	public void verifyToolTipValue() {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(Constant.inputUserName);
		lp.inputPassword(Constant.inputPassword);
		lp.clickLoginButton();
		WorkersPage wp = new WorkersPage(driver);
		wp.navigateToWorkersTab();
		String actual = wp.toolTipValueonDelete();
		String expected = Constant.ExpectedToolTipValue;
		Assert.assertEquals(actual, expected, Constant.errorMessageForFailedToolTipValue);
	}

	@Test(groups = "medium",retryAnalyzer = retry.Retry.class)
	public void verifyDateOfBirth() {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(Constant.inputUserName);
		lp.inputPassword(Constant.inputPassword);
		lp.clickLoginButton();
		WorkersPage wp = new WorkersPage(driver);
		wp.navigateToWorkersTab();
		String actual = wp.workersDateOfBirth();
		System.out.println(actual);
		String expected = Constant.ExpectedDOBOfWorker;
		Assert.assertEquals(actual, expected, "DOB is incorrect,testcase failed");
	}

	@Test(groups = "medium",retryAnalyzer = retry.Retry.class)
	public void verifyWorkersPostalCode() {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(Constant.inputUserName);
		lp.inputPassword(Constant.inputPassword);
		lp.clickLoginButton();
		WorkersPage wp = new WorkersPage(driver);
		wp.navigateToWorkersTab();
		String actual = wp.workersPostalCode();
		System.out.println(actual);
		String expected = Constant.ExpectedPostalCode;
		Assert.assertEquals(actual, expected, "PC is incorrect,testcase failed");
	}

	@Test(groups = "medium",retryAnalyzer = retry.Retry.class)
	public void verifyWorkersTitleheaders() {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(Constant.inputUserName); 
		lp.inputPassword(Constant.inputPassword);
		lp.clickLoginButton();
		WorkersPage wp = new WorkersPage(driver);
		wp.navigateToWorkersTab();
		boolean actual = wp.tableHeaderTitles();
		boolean expected = true;
		Assert.assertEquals(actual, expected, "Titles of table are incorrect,testcase failed");
	}
	@Test(groups = "medium",retryAnalyzer = retry.Retry.class)
	public void verifySameWorkersDetailsAreShowingAfterClickOnSearchButton() { 
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(Constant.inputUserName); 
		lp.inputPassword(Constant.inputPassword);
		lp.clickLoginButton();
		WorkersPage wp = new WorkersPage(driver);
		wp.navigateToWorkersTab(); 
		wp.workerSearchFirstNameTextBox("Dennis");
		wp.workerSearchSecondNameTextBox("Benny");
		wp.workerSearchPostCodeTextBox("CN23 5RB"); 
		wp.clickonSearchButton();
        String actual = wp.textFromNiNumColumnAfterClickOnSearchButton();//doubt unable to pass column value here[row is always 1]
		String expected ="6955810";
		Assert.assertEquals(actual, expected, "Given details are not matching with search details ,testcase failed");
	} 
	@Test(groups = "medium",retryAnalyzer = retry.Retry.class) 
	public void verifyNoResultsFoundForIncorrectInputSearch() {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(Constant.inputUserName); 
		lp.inputPassword(Constant.inputPassword);
		lp.clickLoginButton();
		WorkersPage wp = new WorkersPage(driver);
		wp.navigateToWorkersTab(); 
		wp.workerSearchFirstNameTextBox("Devi");
		wp.workerSearchSecondNameTextBox("Asok");
		wp.clickonSearchButton();
		String actual = wp.textFromTableForIncorrectInputOnSearch();   
		String expected ="No results found.";
		Assert.assertEquals(actual, expected, "'No results found' is not showing in Table for Incorrect input ,testcase failed");
	
		
	}
}
