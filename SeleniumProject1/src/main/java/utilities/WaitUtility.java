package utilities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final int IMPLICIT_WAIT =10000;
	public static final int EXPLICIT_WAIT=10;

	public void implicitWait(WebDriver driver) { 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT)); 
		
	}

	public void explicitWaitForPresenceOfElement(WebDriver driver, String locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));

	}

	public void explicitAlertToBePresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());
	}
 
	public void explicitWaitUntilDesiredTextAppear(WebDriver driver, WebElement element, String textExpected) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBePresentInElement(element, textExpected));
	}
 
	public void explicitWaitToWaitUntilTheElementIsClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void explicitWaitToWaitUntilTheElementBecomesVisible(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));

	} 
	
}
