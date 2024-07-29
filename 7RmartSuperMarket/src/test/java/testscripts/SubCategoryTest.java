package testscripts;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminPage;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;
import utilities.RandomUtility;


public class SubCategoryTest extends Base 
{
	
	@Test
	
	  public void verifyIfASubCategoryCanBeAdded() throws AWTException
	{
		String username= ExcelUtility.getString(1, 0, "LoginPage");
        String password=ExcelUtility.getString(1, 1, "LoginPage");
        String url="https://groceryapp.uniqassosiates.com/admin/list-sub-category";
        String texttobeenteredinsubcategory= new RandomUtility().generateRandomSubCategoryName();
        String category = "Olives";
        
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignIn();
        
        SubCategoryPage subcategorypage = new SubCategoryPage(driver);
        subcategorypage.navigatingToTheNewPage(url).clickingNewButtonToLoadAddSubCategory().choosingCategoryByVisibleTextMethod(category);
        subcategorypage.enteringDataInSubCategory(texttobeenteredinsubcategory).choosingImageForCategory();
        subcategorypage.clickingSaveButtonToAddASubCategory();
        
        boolean successAlertDisplay = subcategorypage.getSucessMessage().contains("Sub Category Created Successfully");
        Assert.assertTrue(successAlertDisplay,"Sub Category Created was not created succesfully");
	
	}
	
}
