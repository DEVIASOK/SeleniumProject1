package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import constant.Constant;
import elementRepo.HomePage;
import elementRepo.LoginPage;
import utilities.ExcelReadUtility;
public class LoginTestCases extends BaseClass {
  @Test(groups="critical",retryAnalyzer = retry.Retry.class)
    public void verifyLoginWithValidUser() throws IOException { 
	  LoginPage objLoginPage=new LoginPage(driver);
	  objLoginPage.inputUserName(ExcelReadUtility.getStringData(1, 0,"Sheet1")); 
	  objLoginPage.inputPassword(ExcelReadUtility.getStringData(1, 1,"Sheet1")); 
	  objLoginPage.clickLoginButton();
	  
	  HomePage objHomePage=new HomePage(driver);
	  String actual=objHomePage.verifyLoginUser();
	  String expected=Constant.ExpectedValidUserNameonHomepage;
	  Assert.assertEquals(actual, expected, Constant.errorMessageForFailedLogin); 
  }
  @Test(groups="critical",retryAnalyzer = retry.Retry.class) 
  public void verifyIncorrectUsernameandPwd() {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(Constant.inputIncorrectUserName);
		lp.inputPassword(Constant.inputIncorrectPassword); 
		lp.clickLoginButton();
		String actual = driver.getCurrentUrl();
		String expected = Constant.ExpectedUrlForInvalidcredentials;
		Assert.assertEquals(actual, expected, Constant.errorMessageForIncorrectcredentials);
	}
  @Test(groups="critical",retryAnalyzer = retry.Retry.class) 
  public void verifyIncorrectUsernameAndValidPwd() { 
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(Constant.inputIncorrectUserName);
		lp.inputPassword(Constant.inputPassword); 
		lp.clickLoginButton();
		String actual = driver.getCurrentUrl();
		String expected = Constant.ExpectedUrlForInvalidcredentials;
		Assert.assertEquals(actual, expected, Constant.errorMessageForIncorrectcredentials);
	}
  @Test(groups="critical",retryAnalyzer = retry.Retry.class) 
  public void verifyValidUsernameAndInCorrectPwd() {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(Constant.inputUserName);
		lp.inputPassword(Constant.inputIncorrectPassword); 
		lp.clickLoginButton();
		String actual = driver.getCurrentUrl();
		String expected = Constant.ExpectedUrlForInvalidcredentials;
		Assert.assertEquals(actual, expected, Constant.errorMessageForIncorrectcredentials);
	}
}
