package testscripts;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.Constants;
import utilities.ExcelUtility;
import utilities.RandomUtility;

public class ManageCategoryTest extends Base 
{
	@Test
	public void verifyIfANewCategoryCanBeAdded() throws AWTException 
	{
		String username= ExcelUtility.getString(1, 0, "LoginPage");
        String password=ExcelUtility.getString(1, 1, "LoginPage");
        
        String managecategoryurl = "https://groceryapp.uniqassosiates.com/admin/list-category";
       
        RandomUtility randomUtility = new RandomUtility();
        String newCategoryName = randomUtility.generateRandomCategoryName();
        String filePath= Constants.TESTDATAIMAGE;
            
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignIn();
        loginpage.navigateToAdminPage(managecategoryurl);
        
        ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
        managecategorypage.clickingNewButtonToLoadAddCategoryPage().enteringTextInCategoryField(newCategoryName).choosingDiscountGroup();
        managecategorypage.choosingFiletoUpload(filePath).clickOnRadioButton().clickOnSecondRadioButton().clickOnSaveButton();
        
        boolean sucessmessage= managecategorypage.getSuccessMessage().contains("Category Created Successfully");
       Assert.assertTrue(sucessmessage,"Category was not created succesfully");
        
        	}   
        

}
