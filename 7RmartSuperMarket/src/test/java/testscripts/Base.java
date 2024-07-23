package testscripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.WaitUtility;

public class Base {
		public WebDriver driver;		

		
	@BeforeMethod
		public void initalizeBrowser()
		{
		driver= new ChromeDriver();
		driver.get("https://selenium.qabible.in/"); 
		//driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/login");
		driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/list-product");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));
		driver.manage().window().maximize();
		}
	@AfterMethod
		
		public void driverQuitAndClose()
		{
			//driver.close(); //closes only parent window
			//driver.quit();
		}
		
			
		}

