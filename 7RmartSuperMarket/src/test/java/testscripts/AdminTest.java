package testscripts;

import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;

public class AdminTest extends Base {

    @Test
    public void verifyIfAnAdminUserCanBeAdded() {
        
    	String username = "admin";
        String password = "admin";
       
        String adminurl = "https://groceryapp.uniqassosiates.com/admin/list-admin";
        String newusername = "Meenakshi";
        String newpassword = "Meenu@123";
        String visibletext = "Admin";
        
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignIn();
        loginpage.navigateToAdminPage(adminurl);
        
        AdminPage adminpage = new AdminPage(driver);
        adminpage.clickingNewButtonToLoadAdminUserInformationPage().enteringTextInUsernameField(newusername).enteringTextInPasswordField(newpassword).choosingUserTypeFieldByVisibleTextMethod(visibletext).clickingOnSaveButton();
    }
}
