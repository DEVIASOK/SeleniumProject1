package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import elementRepo.CreateWorkerSubPage;
import elementRepo.LoginPage;
import elementRepo.WorkersPage;
import utilities.ExcelReadUtility;
import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class CreateWorkerSubPageTestCases extends BaseClass {
	String a = "WORKER BANK DETAILS:";

	@Test(groups = "medium", retryAnalyzer = retry.Retry.class)
	public void verifyAddingNewWorkerIsnavigatingToBankDetailsPageOnClickNext()
			throws IOException, InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(ExcelReadUtility.getStringData(1, 0, "Sheet1"));
		lp.inputPassword(ExcelReadUtility.getStringData(1, 1, "Sheet1"));
		lp.clickLoginButton();
		CreateWorkerSubPage wp = new CreateWorkerSubPage(driver);
		WorkersPage wp1 = new WorkersPage(driver);
		wp1.navigateToWorkersTab();
		wp1.clickonCreateWorker();
		wp1.navigateToTitleDropDown();
		wp.navigateToGenderDropDown();
		wp.navigateToBranchDropDown();
		wp.createWorkerDOBTextBox(ExcelReadUtility.getIntegerData(1, 5, "CreateWorkersPage"));
		wp.createWorkerTabFirstNameTextBox(ExcelReadUtility.getStringData(1, 2, "CreateWorkersPage"));
		wp.createWorkerTabMidNameTextBox(ExcelReadUtility.getStringData(1, 3, "CreateWorkersPage"));
		wp.createWorkerTabLastNameTextBox(ExcelReadUtility.getStringData(1, 4, "CreateWorkersPage"));
		wp.createWorkerTabDivisionDropDown();
		wp.createWorkerEmpTypeDropDown();
		wp.createWorkerKnownTextBox(ExcelReadUtility.getStringData(1, 6, "CreateWorkersPage"));
		wp.createWorkerAddr1TextBox(ExcelReadUtility.getStringData(1, 7, "CreateWorkersPage"));
		wp.createWorkerAddr2TextBox(ExcelReadUtility.getStringData(1, 9, "CreateWorkersPage"));
		wp.createWorkerAddr3TextBox(ExcelReadUtility.getStringData(1, 11, "CreateWorkersPage"));
		wp.createWorkerPaySlipDD();
		wp.createWorkerPhoneTextBox(ExcelReadUtility.getIntegerData(1, 8, "CreateWorkersPage"));
		wp.createWorkerMobileTextBox(ExcelReadUtility.getIntegerData(1, 10, "CreateWorkersPage"));
		wp.createWorkerNiNumTextBox(ExcelReadUtility.getIntegerData(1, 12, "CreateWorkersPage"));
		wp.createWorkerEmailTextBox(ExcelReadUtility.getStringData(1, 13, "CreateWorkersPage"));
		wp.createWorkerPostCodeTextBox(ExcelReadUtility.getStringData(1, 14, "CreateWorkersPage"));
		wp.createWorkerCountryTextBox(ExcelReadUtility.getStringData(1, 15, "CreateWorkersPage"));
		wp.createWorkerEngageStatusDropDown();
		wp.scrollToBottomUsingJavaScriptExecutor(driver);
		wp.createWorkerNextButton();
		GeneralUtilities objutilities = new GeneralUtilities();
		objutilities.mediumDelay();
		String actual = wp.createWorkerNameTitle();
		System.out.println(actual);
		String expected = a + " " + ExcelReadUtility.getStringData(1, 6, "CreateWorkersPage").toUpperCase();
		System.out.println(expected);
		Assert.assertEquals(actual, expected, "Failed");
	}

	@Test(groups = "medium", retryAnalyzer = retry.Retry.class)
	public void verifyNewWorkerIsListingInWorkerpageTable() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(ExcelReadUtility.getStringData(1, 0, "Sheet1"));
		lp.inputPassword(ExcelReadUtility.getStringData(1, 1, "Sheet1"));
		lp.clickLoginButton();
		CreateWorkerSubPage wp = new CreateWorkerSubPage(driver);
		WorkersPage wp1 = new WorkersPage(driver);
		wp1.navigateToWorkersTab();
		wp1.clickonCreateWorker();
		wp1.navigateToTitleDropDown();
		wp.navigateToGenderDropDown();
		wp.navigateToBranchDropDown();
		wp.createWorkerDOBTextBox(ExcelReadUtility.getIntegerData(1, 5, "CreateWorkersPage"));
		wp.createWorkerTabFirstNameTextBox(ExcelReadUtility.getStringData(1, 2, "CreateWorkersPage"));
		wp.createWorkerTabMidNameTextBox(ExcelReadUtility.getStringData(1, 3, "CreateWorkersPage"));
		wp.createWorkerTabLastNameTextBox(ExcelReadUtility.getStringData(1, 4, "CreateWorkersPage"));
		wp.createWorkerTabDivisionDropDown();
		wp.createWorkerEmpTypeDropDown();
		wp.createWorkerKnownTextBox(ExcelReadUtility.getStringData(1, 6, "CreateWorkersPage"));
		wp.createWorkerAddr1TextBox(ExcelReadUtility.getStringData(1, 7, "CreateWorkersPage"));
		wp.createWorkerAddr2TextBox(ExcelReadUtility.getStringData(1, 9, "CreateWorkersPage"));
		wp.createWorkerAddr3TextBox(ExcelReadUtility.getStringData(1, 11, "CreateWorkersPage"));
		wp.createWorkerPaySlipDD();
		wp.createWorkerPhoneTextBox(ExcelReadUtility.getIntegerData(1, 8, "CreateWorkersPage"));
		wp.createWorkerMobileTextBox(ExcelReadUtility.getIntegerData(1, 10, "CreateWorkersPage"));
		wp.createWorkerNiNumTextBox(ExcelReadUtility.getIntegerData(1, 12, "CreateWorkersPage"));
		wp.createWorkerEmailTextBox(ExcelReadUtility.getStringData(1, 13, "CreateWorkersPage"));
		wp.createWorkerPostCodeTextBox(ExcelReadUtility.getStringData(1, 14, "CreateWorkersPage"));
		wp.createWorkerCountryTextBox(ExcelReadUtility.getStringData(1, 15, "CreateWorkersPage"));
		wp.createWorkerEngageStatusDropDown();
		wp.scrollToBottomUsingJavaScriptExecutor(driver);
		wp.createWorkerNextButton();
		wp.createWorkerBankDetailsSubPagePaymentMethod();
		wp.createWorkerBankDetailsSubPageSaveButton();
		GeneralUtilities objutilities = new GeneralUtilities();
		objutilities.mediumDelay();
		wp1.navigateToWorkersTab();
		wp1.workerSearchFirstNameTextBox(ExcelReadUtility.getStringData(1, 6, "CreateWorkersPage"));
		wp1.clickonSearchButton();
		boolean actual = wp1.getAllValuesFromFirstRowOfATable(ExcelReadUtility.getStringData(1, 6, "CreateWorkersPage"));
		boolean expected = true;
		Assert.assertEquals(actual, expected, "Failed");
	}

}
