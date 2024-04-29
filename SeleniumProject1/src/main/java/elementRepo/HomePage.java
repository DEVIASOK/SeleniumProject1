package elementRepo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class HomePage {
	WebDriver driver; 
	GeneralUtilities objutilities=new GeneralUtilities();

	public HomePage(WebDriver driver) // Constructor is pointing driver from LoginTestcase class
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}

	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	WebElement loginUser;// with PageFactory

	public String verifyLoginUser() {

		//String userText = loginUser.getText();// with pagefactory
		//return userText;
		return objutilities.getTextForAnElement(loginUser); 
	}

}
