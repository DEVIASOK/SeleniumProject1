package base;
import utilities.CaptureScreenshotOnFailure;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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
			driver = new ChromeDriver();
		} else if (name.equals("edge")) {
			driver = new EdgeDriver();

		}
		driver.get(prop.getProperty("baseUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	}


	@AfterMethod(alwaysRun = true)

	public void afterMethod(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			CaptureScreenshotOnFailure object = new CaptureScreenshotOnFailure();
			object.captureScreenShotForFailedTestcase(driver, iTestResult.getName());
		}

		driver.close();

	}

}
