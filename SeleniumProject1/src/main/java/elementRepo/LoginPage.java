package elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) // pointing driver in LoginTestcase class
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}

	@FindBy(id = "loginform-username") // with page factory=findby is used
	WebElement username;// with page factory=findby is used
	
	@FindBy(id = "loginform-password")
	WebElement password;
 
	@FindBy(xpath = "//button[@name='login-button']")
	WebElement loginButton;

	public void inputUserName(String name) {

		username.sendKeys(name);
	}

	public void inputPassword(String password1) {

		password.sendKeys(password1);
	}

	public void clickLoginButton() {

		loginButton.click();
	}
	
}
