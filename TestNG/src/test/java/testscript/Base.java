package testscript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

	public WebDriver driver;
@BeforeMethod
	public void initalizeBrowser()
	{
	driver= new ChromeDriver();
	driver.get("https://selenium.qabible.in/"); 
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	}
@AfterMethod
	
	public void driverQuitAndClose()
	{
		//driver.close(); //closes only parent window
		//driver.quit();
	}
	
		
	}



