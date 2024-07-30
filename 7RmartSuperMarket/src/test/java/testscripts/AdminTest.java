package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;


import pages.AdminPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminTest extends Base {

    @Test
    public void verifyIfAnAdminUserCanBeAdded() {
        
    	String username= ExcelUtility.getString(1, 0, "LoginPage");
        String password=ExcelUtility.getString(1, 1, "LoginPage");
       
        String adminurl = "https://groceryapp.uniqassosiates.com/admin/list-admin";
        String newusername = ExcelUtility.getString(1, 0, "AdminPage");
        String newpassword = ExcelUtility.getString(1, 1, "AdminPage");
        String dropdownvisibletext = ExcelUtility.getString(1, 2, "AdminPage");
               
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignIn();
        loginpage.navigateToAdminPage(adminurl);
        
        AdminPage adminpage = new AdminPage(driver);
        adminpage.clickingNewButtonToLoadAdminUserInformationPage().enteringTextInUsernameField(newusername).enteringTextInPasswordField(newpassword).choosingUserTypeFieldByVisibleTextMethod(dropdownvisibletext).clickingOnSaveButton();
    
        boolean successAlertDisplay = adminpage.getSuccessMessage().contains("Admin created successfully");
        Assert.assertTrue(successAlertDisplay,"Admin user was not created succesfully");

       
    }
}
