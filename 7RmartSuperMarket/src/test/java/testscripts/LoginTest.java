package testscripts;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import pages.LoginPage;
import utilities.ExcelUtility;



public class LoginTest extends Base {

	@Test(groups= {"Regression"},retryAnalyzer=retry.Retry.class,description="This test case is for correct login")
	public void verifyWhetherTheUserIsAbleToLoginWithCorrectUserNameAndCorrectPassword()
	{
		
		String username= ExcelUtility.getString(1, 0, "LoginPage");
        String password=ExcelUtility.getString(1, 1, "LoginPage");
        LoginPage loginpage=new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username);
        loginpage.enterPasswordOnPasswordField(password);
        loginpage.clickOnSignIn();
        boolean dashboardelement=loginpage.isDashboardDisplayed();
        assertTrue(dashboardelement,"Login sucessful with wrong credentials");
        
		
	}
	@Test(groups= {"Smoke"},retryAnalyzer=retry.Retry.class,description="This test case is for incorrect login")
	public void verifyWhetherTheUserIsAbleToLoginWithWrongUserNameAndWrongPassword()
	{
		
		String username= ExcelUtility.getString(1, 2, "LoginPage");
        String password=ExcelUtility.getString(1, 3, "LoginPage");
        LoginPage loginpage=new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username);
        loginpage.enterPasswordOnPasswordField(password);
        loginpage.clickOnSignIn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean alertstatus=loginpage.isAlertBoxDisplayed();
        assertTrue(alertstatus," User is unable to login sucessful with correct credentials");
	}
	@Test(groups= {"Regression"},retryAnalyzer=retry.Retry.class,description="This test case is for incorrect login")
	public void verifyWhetherTheUserIsAbleToLoginWithWrongUserNameAndCorrectPassword()
	{
		
		String username= ExcelUtility.getString(1, 2, "LoginPage");
        String password=ExcelUtility.getString(1, 1, "LoginPage");
        LoginPage loginpage=new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignIn();
        boolean alertstatus=loginpage.isAlertBoxDisplayed();
        assertTrue(alertstatus," User is unable to login sucessful with correct credentials");
		
	}
	@Test(groups= {"Regression"},retryAnalyzer=retry.Retry.class,description="This test case is for incorrect login")
	public void verifyWhetherTheUserIsAbleToLoginWithCorrectUserNameAndWrongPassword()
	{
		
		String username= ExcelUtility.getString(1, 0, "LoginPage");
        String password=ExcelUtility.getString(1, 3, "LoginPage");
        LoginPage loginpage=new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username);
        loginpage.enterPasswordOnPasswordField(password);
        loginpage.clickOnSignIn();
        assertTrue(loginpage.isAlertBoxDisplayed(),"Login sucessful with wrong credentials");
		
	}
}

	
	
