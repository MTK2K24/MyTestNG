package testscripts;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageProductPage;
import utilities.ExcelUtility;

public class ManageProductTest extends Base {

    @Test
    public void verifyIfAProductCanBeSearchedUsingItsTitle() {
		String username= ExcelUtility.getString(1, 0, "LoginPage");
        String password=ExcelUtility.getString(1, 1, "LoginPage");
        String title = ExcelUtility.getString(1, 0, "ManageProductPage");
        String url="https://groceryapp.uniqassosiates.com/admin/list-product";
             
        LoginPage loginpage=new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignIn();
        loginpage.naviagteToAPage(url);
    
        ManageProductPage managepage = new ManageProductPage(driver);
        managepage.clickingSearchIconToLoadSearchPage().enteringTextToBeSearched(title).clickingSearchButtonToExecuteSearch();      
    }
}
