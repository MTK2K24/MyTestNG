package testscripts;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageCategoryPage;

import utilities.ExcelUtility;
import utilities.RandomUtility;

public class ManageCategoryTest extends Base 
{
	@Test(groups= {"Regression"},retryAnalyzer=retry.Retry.class,description="This test case is to verify if a new category can be added")
	public void verifyIfANewCategoryCanBeAdded() throws AWTException 
	{
		String username= ExcelUtility.getString(1, 0, "LoginPage");
        String password=ExcelUtility.getString(1, 1, "LoginPage");
        String managecategoryurl =ExcelUtility.getString(1, 0, "ManageCategory"); 
       
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
	
	
	@Test(groups= {"Regression"},retryAnalyzer=retry.Retry.class,description="This test case is to verify if an existing category can be updated")
	public void verifyIfAnExistingCategoryCanBeUpdated() 
	{
		String username= ExcelUtility.getString(1, 0, "LoginPage");
        String password=ExcelUtility.getString(1, 1, "LoginPage");
        String managecategoryurl =ExcelUtility.getString(1, 0, "ManageCategory"); 
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignIn();
        loginpage.navigateToAdminPage(managecategoryurl);
        ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
        managecategorypage.clickOnSearchIcon().enterTextInSearchField().clickOnSearchButton();
        managecategorypage.findingEnteredTextInTable();
        managecategorypage.clickingEditIcon();
        managecategorypage.clickOnYesRadioButton();
        managecategorypage.clickOnUpdateButton();
        boolean alertUpdateMessage= managecategorypage.getUpdateMessage().contains("Category Updated Successfully");
        Assert.assertTrue(alertUpdateMessage,"Category was not created succesfully");
	}
        

}
