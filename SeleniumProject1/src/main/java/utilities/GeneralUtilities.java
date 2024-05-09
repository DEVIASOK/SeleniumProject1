package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	int i, j;
	String locator = null;
	WaitUtility waitutility = new WaitUtility();

	public String getTextForAnElement(WebElement element) {
		String stringText = element.getText();
		return stringText;

	}

	public void sendTextForAnElement(WebElement element, String value) {
		element.sendKeys(value);
		;

	}

	public String getTextForAnElementFromDropDown(WebElement element, int value) {
		Select objWorkersTitle = new Select(element);
		objWorkersTitle.selectByIndex(value);

		String currentTitle = objWorkersTitle.getFirstSelectedOption().getText();
		return currentTitle;
	}

	public String getstylePropertyValues(WebElement element, String propertyType) {
		String cssValue = element.getCssValue(propertyType);
		return cssValue;

	}

	public String getAttributeValue(WebElement element, String attribute) {
		String attributeValue = element.getAttribute(attribute);
		return attributeValue;
	}

	public int getDynamicTableValue(List<WebElement> element, String name) {
		for (i = 0; i < element.size(); i++) {
			if (element.get(i).getText().equals(name)) {
				break;
			}
		}
		return i;
	}

	public boolean getAllHeaders(List<WebElement> element, List<String> titles) {
		for (i = 0; i < element.size(); i++) {
			for (j = 0; j < titles.size(); j++) {
				if (element.get(i).getText().equals(titles.get(j))) {
					System.out.println(titles.get(j));
					return true;
				}
			}
		}
		return false;
	}

	public void scrollToTopUsingJavaScriptExecutor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350);");
	}

	public void scrollToBottomUsingJavaScriptExecutor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 250);");

	}
	/*
	 * public void clickOnElementUsingJavaScriptExecutor(WebDriver driver,
	 * WebElement element) { JavascriptExecutor js = (JavascriptExecutor) driver;
	 * js.executeScript("arguments[0].click();", element); }
	 */

	public void scrollUntilTheElementInViewUsingJavaScriptExecutor(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public boolean getAllValuesFromFirstRowOfATableAndCompareWithGivenValue(String value, WebDriver driver) {

		locator = "//table[@class='table table-striped table-bordered']//tbody//tr[1]//td";
		List<WebElement> element = driver.findElements(By.xpath(locator));
		for (int i = 0; i < element.size() - 1; i++) {
			System.out.println(element.get(i).getText());
			if (element.get(i).getText().equals(value)) {
				return true;
			}
		} 
		return false;
	}

	public void mediumDelay() throws InterruptedException {
		Thread.sleep(2000);
	}
}
