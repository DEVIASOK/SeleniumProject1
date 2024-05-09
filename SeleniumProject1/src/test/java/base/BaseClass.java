package base;
import utilities.CaptureScreenshotOnFailureUtility;
import utilities.WaitUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	public WebDriver driver;
	
	public static Properties prop;//prop is the ref variable of class Properties
	public static void testBasic() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
		System.getProperty("user.dir") + "//src//main//resources//Config.properties");
		prop.load(ip);
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void beforeMethod(String name) throws IOException {
		testBasic();
		if (name.equals("chrome")) {
			this.driver = new ChromeDriver();
		} else if (name.equals("firefox")) {
			this.driver = new FirefoxDriver();

		} 
		this.driver.get(prop.getProperty("baseUrl"));
		this.driver.manage().window().maximize();
		WaitUtility waitutility=new WaitUtility(); 
		waitutility.implicitWait(driver);  
		//this.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	}

	@AfterMethod(alwaysRun = true)

	public void afterMethod(ITestResult iTestResult) throws IOException {//ItestResult is an Interface.
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			CaptureScreenshotOnFailureUtility object = new CaptureScreenshotOnFailureUtility();
			object.captureScreenShotForFailedTestcase(this.driver, iTestResult.getName());
		} 
  		this.driver.close(); 

	}

}
