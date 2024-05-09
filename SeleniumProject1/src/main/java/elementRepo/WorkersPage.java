package elementRepo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class WorkersPage {
	WebDriver driver;
	String locator = null;
	GeneralUtilities objutilities = new GeneralUtilities();
	WaitUtility waitutility = new WaitUtility();

	public WorkersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// initializing element
	}

	@FindBy(xpath = "//body//header//a[text()='Workers']")
	WebElement workers;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement searchButton;

	@FindBy(xpath = "//button[text()='Reset']")
	WebElement resetbuttonColor;

	@FindBy(xpath = "//a[text()='Create Worker']")
	WebElement createWorkerTab;

	@FindBy(xpath = "//select[@id='worker-title']")
	WebElement createWorkerTabTitleDropDown;

	@FindBy(xpath = "//a[@title='Delete']")
	WebElement deletebtn;

	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tbody//tr//td[2]")
	List<WebElement> workersNameColumn;

	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//thead//th")
	List<WebElement> workersHeaderRow;

	@FindBy(xpath = "//input[@id='workersearch-first_name']")
	WebElement workerSearchFirstNameTextBox;

	@FindBy(xpath = "//input[@id='workersearch-last_name']")
	WebElement workerSearchSecondNameTextBox;

	@FindBy(xpath = "//input[@id='workersearch-postcode']")
	WebElement workerSearchPostCodeTextBox;

	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tr//td[1]//div[text()='No results found.']")
	WebElement workersNoResultsFound;
	
	public void navigateToWorkersTab() {
		waitutility.explicitWaitToWaitUntilTheElementIsClickable(driver, workers);
		workers.click();
	}

	public void workerSearchFirstNameTextBox(String name) {
		workerSearchFirstNameTextBox.sendKeys(name);
	}

	public void workerSearchSecondNameTextBox(String name) {
		workerSearchSecondNameTextBox.sendKeys(name);
	}

	public void workerSearchPostCodeTextBox(String name) {
		workerSearchPostCodeTextBox.sendKeys(name);
	}

	public String searchText() {

		return objutilities.getTextForAnElement(searchButton);
	}

	public String backgroundColorOfResetBtn() {

		return objutilities.getstylePropertyValues(resetbuttonColor, "background-color");
	}

	public void clickonCreateWorker() {

		createWorkerTab.click();
	}

	public void clickonSearchButton() {

		searchButton.click();
	}

	public String navigateToTitleDropDown() {

		return objutilities.getTextForAnElementFromDropDown(createWorkerTabTitleDropDown, 2);
	}

	public String toolTipValueonDelete() {

		return objutilities.getAttributeValue(deletebtn, "title");
	}

	public String workersDateOfBirth() {
		int i = objutilities.getDynamicTableValue(workersNameColumn, "AAMI");
		locator = "//table[@class='table table-striped table-bordered']//tbody//tr[" + (i + 1) + "]//td[6]";
		WebElement cell = driver.findElement(By.xpath(locator));
		return cell.getText();

	}

	public String workersPostalCode() {
		int i = objutilities.getDynamicTableValue(workersNameColumn, "Dennis Benny");
		locator = "//table[@class='table table-striped table-bordered']//tbody//tr[" + (i + 1) + "]//td[5]";
		WebElement cell = driver.findElement(By.xpath(locator));
		return cell.getText();
	}

	public boolean tableHeaderTitles() {
		List<String> titlesobj = new ArrayList<>();
		titlesobj.add("#");
		titlesobj.add("Name");
		titlesobj.add("Division");
		titlesobj.add("Employment Type");
		titlesobj.add("Postcode");
		titlesobj.add("Date of Birth");
		titlesobj.add("Ni Number");
		titlesobj.add("");
		return objutilities.getAllHeaders(workersHeaderRow, titlesobj);
	} 

	public boolean getAllValuesFromFirstRowOfATable(String niNum) throws InterruptedException { 
		Thread.sleep(3000);   
		return objutilities.getAllValuesFromFirstRowOfATableAndCompareWithGivenValue(niNum,driver);
	} 
 
	public String textFromTableForIncorrectInputOnSearch() {
		return workersNoResultsFound.getText();
	}

}
