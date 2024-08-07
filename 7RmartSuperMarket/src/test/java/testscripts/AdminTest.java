package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;


import pages.AdminPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminTest extends Base {

    @Test(groups= {"Regression"},retryAnalyzer=retry.Retry.class,description="This test case is to verify if a new admin user can be added")
    public void verifyIfAnAdminUserCanBeAdded() {
        
    	String username= ExcelUtility.getString(1, 0, "LoginPage");
        String password=ExcelUtility.getString(1, 1, "LoginPage");
       
        String adminurl = ExcelUtility.getString(1, 3, "AdminPage");
        String newusername = ExcelUtility.getString(1, 0, "AdminPage");
        String newpassword = ExcelUtility.getString(1, 1, "AdminPage");
        String dropdownvisibletext = ExcelUtility.getString(1, 2, "AdminPage");
               
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignIn();
        loginpage.navigateToAdminPage(adminurl);
        
        AdminPage adminpage = new AdminPage(driver);
        adminpage.clickingNewButtonToLoadAdminUserInformationPage().enteringTextInUsernameField(newusername).enteringTextInPasswordField(newpassword).choosingUserTypeFieldByVisibleTextMethod(dropdownvisibletext).clickingOnSaveButton();
    
        boolean successAlertDisplay = adminpage.getSuccessMessage().contains("User created successfully");
        Assert.assertTrue(successAlertDisplay,"User was not created succesfully");

           }
    
    @Test(groups= {"Regression"},retryAnalyzer=retry.Retry.class,description="This test case is to verify if an existing user can be searched")
    public void verifyIfAUserCanBeSearched()
    {
    
        String username = ExcelUtility.getString(1, 0, "LoginPage");
        String password = ExcelUtility.getString(1, 1, "LoginPage");
        String adminurl = ExcelUtility.getString(1, 3, "AdminPage");
        
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignIn();
        loginpage.navigateToAdminPage(adminurl);
        AdminPage adminpage = new AdminPage(driver);
        adminpage.clickSearchIcon().enteringTextToBeSearched(adminurl).clickingSearchButtonToExecuteSearch();
        Assert.assertTrue(adminpage.isSearchResultDisplayed(), "Search result was not displayed");
    }
}
