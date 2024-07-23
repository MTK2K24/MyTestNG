package testscripts;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageProductPage;

public class ManageProductTest extends Base {

    @Test
    public void verifyIfAProductCanBeSearchedUsingItsTitle() {
    	String username = "admin";
        String password = "admin";
        String title = "Pomegranate";
        String url="https://groceryapp.uniqassosiates.com/admin/list-product";
             
        LoginPage loginpage=new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignIn();
        loginpage.naviagteToAPage(url);
    
        ManageProductPage managepage = new ManageProductPage(driver);
        managepage.clickingSearchIconToLoadSearchPage().enteringTextToBeSearched(title).clickingSearchButtonToExecuteSearch();      
    }
}
