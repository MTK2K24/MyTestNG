package testscripts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenshotUtility;
import utilities.WaitUtility;

public class Base {
		public WebDriver driver;	
		public ScreenshotUtility screenshot;

	@BeforeMethod (alwaysRun=true)
	@Parameters("browser")
		public void initalizeBrowser(String browser) throws Exception
		{
		
		if(browser.equalsIgnoreCase("Chrome")) 
		{
			driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			driver= new EdgeDriver();
		}
		else
		{
			throw new Exception("Browser is not correct");
		}
		
		driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));
		driver.manage().window().maximize();
		}
	@AfterMethod(alwaysRun = true)
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			screenshot = new ScreenshotUtility();
			screenshot.getScreenShot(driver, iTestResult.getName());
		}

		driver.quit();
	}
		
			
		}

