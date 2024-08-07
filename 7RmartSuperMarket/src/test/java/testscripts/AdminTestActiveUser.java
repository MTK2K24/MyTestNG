package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminActiveUserPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminTestActiveUser extends Base {
	@Test(groups= {"Regression"},retryAnalyzer=retry.Retry.class,description="This test case is to verify if a locked user can be unlocked")
	 public void verifyIfAnAdminUserCanBeUnlocked() {
	        
	    	String username= ExcelUtility.getString(1, 0, "LoginPage");
	        String password=ExcelUtility.getString(1, 1, "LoginPage");
	        String adminurl =ExcelUtility.getString(1, 0, "AdminActiveUser"); 
	        String name=ExcelUtility.getString(1, 1, "AdminActiveUser"); 
	       
	      	               
	        LoginPage loginpage = new LoginPage(driver);
	        loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignIn();
	        loginpage.navigateToAdminPage(adminurl);
	        
	        AdminActiveUserPage adminactiveuserpage = new AdminActiveUserPage(driver);
	        adminactiveuserpage.clickSearchIcon().enteringTextToBeSearched(name).clickingSearchButtonToExecuteSearch();
	        adminactiveuserpage.isSearchResultDisplayed();
	        adminactiveuserpage.clickOnLockIcon().showSuccessMessage();
	        
	        boolean successAlertDisplay = adminactiveuserpage.showSuccessMessage().contains("User Status Changed Successfully");
	        Assert.assertTrue(successAlertDisplay,"User Status Already Active");

	           }
	    
}
