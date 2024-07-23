package testscripts;

import java.awt.AWTException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;

public class ManageCategoryTest extends Base 
{
	@Test
	public void verifyIfANewCategoryCanBeAdded() throws AWTException 
	{
        String username = "admin";
        String password = "admin";
        
        String managecategoryurl = "https://groceryapp.uniqassosiates.com/admin/list-category";
        String newcategoryname = "Lentils";
        
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignIn();
        loginpage.navigateToAdminPage(managecategoryurl);
        
        ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
        managecategorypage.clickingNewButtonToLoadAddCategoryPage().enteringTextInCategoryField(newcategoryname).choosingDiscountGroup();
        managecategorypage.choosingFiletoUpload().clickOnSaveButton();
        
        	}   
        

}
