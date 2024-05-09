package elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ClientPage {
	WebDriver driver;
	GeneralUtilities objutilities = new GeneralUtilities();
	WaitUtility waitutility = new WaitUtility();

	public ClientPage(WebDriver driver) // Constructor is pointing driver from Testcase class
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//nav//a[text()='Clients']")
	WebElement clientTab;

	@FindBy(xpath = "//input[@id='clientsearch-client_name']")
	WebElement clientNameTextBox;

	@FindBy(xpath = "//input[@id='clientsearch-id']")
	WebElement clientIDTextBox;

	@FindBy(xpath = "//button[text()='Search']")
	WebElement clientSearchButton;

	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement clientResetButton;

	@FindBy(xpath = "// table[@class='table table-striped table-bordered']//tbody//tr[1]//td[2]")
	WebElement firstClientNameFromTable;
	
	@FindBy(xpath = "// table[@class='table table-striped table-bordered detail-view']//tbody//tr[3]//td[1]")
	WebElement clientNameFromClientDetailsTable;
	

	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tbody//tr[1]//td[6]//span[@class='glyphicon glyphicon-eye-open']")
	WebElement viewButton; 

	@FindBy(xpath = "//body//header//h1[text()='Astar Logisticss123']")
	WebElement clientDetailsPageTitleForFirstClient; 

	public void navigateToClientTab() {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, clientTab);
		// objutilities.clickOnElementUsingJavaScriptExecutor(driver, clientTab);
		clientTab.click();
	}

	public void inputClientName(String name) {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, clientNameTextBox);
		clientNameTextBox.sendKeys(name);
	}

	public void inputClientID(String id) {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, clientIDTextBox);
		clientIDTextBox.sendKeys(id);
	}

	public void clickOnClientSearchButton() {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, clientSearchButton);
		clientSearchButton.click();
	}

	public void clickOnClientResetButton() {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, clientResetButton);
		clientResetButton.click();
	}

	public boolean getTextFromClientNameIDTextBoxsAndCheckEmptyAfterReset() {
		String name = objutilities.getTextForAnElement(clientNameTextBox);
		String id = objutilities.getTextForAnElement(clientIDTextBox);
		if (name.equals("")&&id.equals("")) {
			return true;
		} else {
			return false; 
		}
	}

	public String getTextFromFirstClientNameFromTable() {

		return objutilities.getTextForAnElement(firstClientNameFromTable);  

	}

	public void clickOnClientViewButton() {

		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, viewButton);
		viewButton.click();
	}

	public String clientDetailsPageTitle() {
		
		return objutilities.getTextForAnElement(clientDetailsPageTitleForFirstClient);  
 
	}

	public String getTextFromClientNameFromClientDetailsTableUsingViewButton() {
		
		return objutilities.getTextForAnElement(clientNameFromClientDetailsTable);
		
	}
}
