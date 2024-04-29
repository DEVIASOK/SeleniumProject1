package elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ClientPage {
	WebDriver driver;
	GeneralUtilities objutilities = new GeneralUtilities();

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

	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tbody//tr[1]//td[6]//span[@class='glyphicon glyphicon-eye-open']")
	WebElement viewButton;

	@FindBy(xpath = "//body//header//h1[text()='Astar Logisticss123']")
	WebElement clientDetailsPageTitle;

	public void navigateToClientTab() {
		
		clientTab.click();
	}

	public void inputClientName(String name) {
		
		clientNameTextBox.sendKeys(name);
	}

	public void inputClientID(String id) {
		
		clientIDTextBox.sendKeys(id);
	}

	public void clickOnClientSearchButton() {
		
		clientSearchButton.click();
	}

	public void clickOnClientResetButton() {
		
		clientResetButton.click();
	}

	public String getTextFromClientNameTextBox() {

		return objutilities.getTextForAnElement(clientNameTextBox);
	}

	public String getTextFromFirstClientNameFromTable() {

		return objutilities.getTextForAnElement(firstClientNameFromTable);

	}

	public void clickOnClientViewButton() {
		
		viewButton.click();
	}

	public String clientDetailsPageTitle() {

		return objutilities.getTextForAnElement(clientDetailsPageTitle);

	}
}
