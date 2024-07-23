package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import pages.LoginPage;



public class LoginTest extends Base {

	@Test
	public void verifyWhetherTheUserIsAbleToLoginWithCorrectUserNameAndCorrectPassword()
	{
		
		String username="admin";
        String password="admin";
        LoginPage loginpage=new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username);
        loginpage.enterPasswordOnPasswordField(password);
        loginpage.clickOnSignIn();
        boolean dashboardelement=loginpage.isDashboardDisplayed();
        assertTrue(dashboardelement,"Login sucessful with wrong credentials");
        
		
	}
	@Test
	public void verifyWhetherTheUserIsAbleToLoginWithWrongUserNameAndWrongPassword()
	{
		
		String username="nitya";
        String password="nitya";
        LoginPage loginpage=new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username);
        loginpage.enterPasswordOnPasswordField(password);
        loginpage.clickOnSignIn();
        boolean alertstatus=loginpage.isAlertBoxDisplayed();
        assertTrue(alertstatus," User is unable to login sucessful with correct credentials");
		
	}
	@Test
	public void verifyWhetherTheUserIsAbleToLoginWithWrongUserNameAndCorrectPassword()
	{
		
		String username="nitya";
        String password="admin";
        LoginPage loginpage=new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignIn();
        boolean alertstatus=loginpage.isAlertBoxDisplayed();
        assertTrue(alertstatus," User is unable to login sucessful with correct credentials");
		
	}
	@Test
	public void verifyWhetherTheUserIsAbleToLoginWithCorrectUserNameAndWrongPassword()
	{
		
		String username="admin";
        String password="nitya";
        LoginPage loginpage=new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username);
        loginpage.enterPasswordOnPasswordField(password);
        loginpage.clickOnSignIn();
        assertTrue(loginpage.isAlertBoxDisplayed(),"Login sucessful with wrong credentials");
		
	}
}

	
	
