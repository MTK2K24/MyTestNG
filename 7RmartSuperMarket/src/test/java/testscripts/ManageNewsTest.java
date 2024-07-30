package testscripts;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ManageNewsTest extends Base {

    @Test
    public void verifyIfAProductCanBeSearchedUsingItsTitle() {

        String username = ExcelUtility.getString(1, 0, "LoginPage");
        String password = ExcelUtility.getString(1, 1, "LoginPage");
        String title = ExcelUtility.getString(1, 0, "ManageNewsPage");

        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username)
                 .enterPasswordOnPasswordField(password)
                 .clickOnSignIn();

        ManageNewsPage managenewspage = new ManageNewsPage(driver);
        managenewspage.navigateToManageNewsPage() 
                      .clickingNewButtonInManageNewsPage()
                      .enteringTextInNewsField(title)
                      .clickingSaveButton();
        boolean sucessmessage= managenewspage.getSuccessMessage().contains("News Created Successfully");
        Assert.assertTrue(sucessmessage,"News Created not created succesfully");
    }
}