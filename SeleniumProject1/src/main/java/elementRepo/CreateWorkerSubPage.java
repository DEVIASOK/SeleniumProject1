package elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class CreateWorkerSubPage {
	WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	GeneralUtilities objutilities = new GeneralUtilities();

	public CreateWorkerSubPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Workers']") 
	WebElement workers;

	@FindBy(xpath = "//button[text()='Reset']")
	WebElement resetbuttonColor;

	@FindBy(xpath = "//a[text()='Create Worker']")
	WebElement createWorkerTab;

	@FindBy(xpath = "//select[@id='worker-title']")
	WebElement createWorkerTabTitleDropDown;

	@FindBy(xpath = "//select[@id='worker-gender']")
	WebElement createWorkerTabGenderDropDown;

	@FindBy(xpath = "//select[@id='worker-branch_id']")
	WebElement createWorkerTabBranchDropDown;

	@FindBy(xpath = "//button[@class='btn btn-success']")
	WebElement createWorkerBankDetailsSubPageSaveButton;

	@FindBy(xpath = "//input[@id='worker-first_name']")
	WebElement createWorkerTabFirstNameTextBox;

	@FindBy(xpath = "//input[@id='worker-middle_name']")
	WebElement createWorkerTabMidNameTextBox;

	@FindBy(xpath = "//input[@id='worker-last_name']")
	WebElement createWorkerTabLastNameTextBox;

	@FindBy(xpath = "//select[@id='worker-division_id']")
	WebElement createWorkerTabDivisionDropDown;

	@FindBy(xpath = "//input[@id='worker-dob']")
	WebElement createWorkerDOBTextBox;

	@FindBy(xpath = "//select[@id='worker-employment_type']")
	WebElement createWorkerEmpTypeDropDown;

	@FindBy(xpath = "//input[@id='worker-known']")
	WebElement createWorkerKnownTextBox;

	@FindBy(xpath = "//input[@id='worker-address1']")
	WebElement createWorkerAddr1TextBox;

	@FindBy(xpath = "//input[@id='worker-address2']")
	WebElement createWorkerAddr2TextBox;

	@FindBy(xpath = "//input[@id='worker-address3']")
	WebElement createWorkerAddr3TextBox;

	@FindBy(xpath = "//select[@id='worker-payslip_method']")
	WebElement createWorkerPaySlipDD;

	@FindBy(xpath = "//input[@id='worker-phone']")
	WebElement createWorkerPhoneTextBox;

	@FindBy(xpath = "//select[@id='worker-engage_status']")
	WebElement createWorkerEngageStatusDropDown;

	@FindBy(xpath = "//input[@id='worker-mobile']")
	WebElement createWorkerMobileTextBox;

	@FindBy(xpath = "//input[@id='worker-ni_number']")
	WebElement createWorkerNiNumTextBox;

	@FindBy(xpath = "//input[@id='worker-email']")
	WebElement createWorkerEmailTextBox;

	@FindBy(xpath = "//div[@class='col-sm-6 page-title']")
	WebElement createWorkerNameTitle;
	String workerNameTitleLocator = "//div[@class='col-sm-6 page-title']";

	@FindBy(xpath = "//input[@id='worker-postcode']")
	WebElement createWorkerPostCodeTextBox;

	@FindBy(xpath = "//input[@id='worker-country']")
	WebElement createWorkerCountryTextBox;

	@FindBy(xpath = "//button[@class='btn btn-success']")
	WebElement createWorkerNextButton;

	@FindBy(xpath = "//a[text()='Bank Details']")
	WebElement createWorkerBankDetailsSubPageTab;

	@FindBy(xpath = "//select[@id='worker-payment_method']")
	WebElement createWorkerBankDetailsSubPagePaymentMethod;

	public void navigateToGenderDropDown() {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, createWorkerTabGenderDropDown);
		objutilities.getTextForAnElementFromDropDown(createWorkerTabGenderDropDown, 1);
	}

	public void navigateToBranchDropDown() {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, createWorkerTabBranchDropDown);
		objutilities.getTextForAnElementFromDropDown(createWorkerTabBranchDropDown, 1);
	}

	public void createWorkerTabFirstNameTextBox(String name) {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, createWorkerTabFirstNameTextBox);
		objutilities.sendTextForAnElement(createWorkerTabFirstNameTextBox, name);
	}

	public void createWorkerTabMidNameTextBox(String name) {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, createWorkerTabMidNameTextBox);
		objutilities.sendTextForAnElement(createWorkerTabMidNameTextBox, name);
	}

	public void createWorkerTabLastNameTextBox(String name) {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, createWorkerTabLastNameTextBox);
		objutilities.sendTextForAnElement(createWorkerTabLastNameTextBox, name);
	}

	public void createWorkerTabDivisionDropDown() {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, createWorkerTabDivisionDropDown);
		objutilities.getTextForAnElementFromDropDown(createWorkerTabDivisionDropDown, 1);
	}

	public void createWorkerDOBTextBox(String date) {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, createWorkerDOBTextBox);
		objutilities.sendTextForAnElement(createWorkerDOBTextBox, date);
	}

	public void createWorkerEmpTypeDropDown() {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, createWorkerEmpTypeDropDown);
		objutilities.getTextForAnElementFromDropDown(createWorkerEmpTypeDropDown, 1);
	}

	public void createWorkerKnownTextBox(String knownName) {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, createWorkerKnownTextBox);
		objutilities.sendTextForAnElement(createWorkerKnownTextBox, knownName);
	}

	public void createWorkerAddr1TextBox(String addr1) {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, createWorkerAddr1TextBox);
		objutilities.sendTextForAnElement(createWorkerAddr1TextBox, addr1);
	}

	public void createWorkerAddr2TextBox(String addr2) {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, createWorkerAddr2TextBox);
		objutilities.sendTextForAnElement(createWorkerAddr2TextBox, addr2);
	}

	public void createWorkerAddr3TextBox(String addr3) {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, createWorkerAddr3TextBox);
		createWorkerAddr3TextBox.sendKeys(addr3);
	}

	public void createWorkerPaySlipDD() {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, createWorkerPaySlipDD);
		objutilities.getTextForAnElementFromDropDown(createWorkerPaySlipDD, 2);
	}

	public void createWorkerPhoneTextBox(String phone) {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, createWorkerPhoneTextBox);
		objutilities.sendTextForAnElement(createWorkerPhoneTextBox, phone);
	}

	public void createWorkerEngageStatusDropDown() {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, createWorkerEngageStatusDropDown);
		objutilities.getTextForAnElementFromDropDown(createWorkerEngageStatusDropDown, 1);
	}

	public void createWorkerMobileTextBox(String mob) {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, createWorkerMobileTextBox);
		objutilities.sendTextForAnElement(createWorkerMobileTextBox, mob);

	}

	public void createWorkerNiNumTextBox(String niNum) {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, createWorkerNiNumTextBox);
		objutilities.sendTextForAnElement(createWorkerNiNumTextBox, niNum);
	}

	public void createWorkerEmailTextBox(String email) {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, createWorkerEmailTextBox);
		objutilities.sendTextForAnElement(createWorkerEmailTextBox, email);
	}

	public void createWorkerPostCodeTextBox(String postcode) {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, createWorkerPostCodeTextBox);
		objutilities.sendTextForAnElement(createWorkerPostCodeTextBox, postcode);
	}

	public void createWorkerCountryTextBox(String country) {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, createWorkerCountryTextBox);
		createWorkerCountryTextBox.clear();
		objutilities.sendTextForAnElement(createWorkerCountryTextBox, country);
	}

	public void createWorkerNextButton() {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, createWorkerNextButton);
		createWorkerNextButton.click();
	}

	public void scrollToBottomUsingJavaScriptExecutor(WebDriver driver) {
		objutilities.scrollToBottomUsingJavaScriptExecutor(driver);
	}

	public String createWorkerNameTitle() {
		waitutility.explicitWaitToWaitUntilTheElementBecomesVisible(driver, workerNameTitleLocator);
		return objutilities.getTextForAnElement(createWorkerNameTitle);
	}

	public void createWorkerBankDetailsSubPagePaymentMethod() {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, createWorkerBankDetailsSubPagePaymentMethod);
		objutilities.getTextForAnElementFromDropDown(createWorkerBankDetailsSubPagePaymentMethod, 1);
	}

	public void createWorkerBankDetailsSubPageSaveButton() {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, createWorkerBankDetailsSubPageSaveButton);
		createWorkerBankDetailsSubPageSaveButton.click();
	}
}
