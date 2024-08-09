package testscripts;

import java.awt.AWTException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;
import utilities.RandomUtility;

public class SubCategoryTest extends Base {
	@Test(groups = {
			"Regression" }, retryAnalyzer = retry.Retry.class, description = "This test case is verify if a subcategory can be added")
	public void verifyIfASubCategoryCanBeAdded() throws AWTException {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String url = ExcelUtility.getString(1, 0, "SubCategory");
		String texttobeenteredinsubcategory = new RandomUtility().generateRandomSubCategoryName();
		String category = ExcelUtility.getString(1, 1, "SubCategory");
		String sucesstext = ExcelUtility.getString(1, 2, "SubCategory");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignIn();
		SubCategoryPage subcategorypage = new SubCategoryPage(driver);
		subcategorypage.navigatingToTheNewPage(url).clickingNewButtonToLoadAddSubCategory()
				.choosingCategoryByVisibleTextMethod(category);
		subcategorypage.enteringDataInSubCategory(texttobeenteredinsubcategory).choosingImageForCategory();
		subcategorypage.clickingSaveButtonToAddASubCategory();
		boolean successAlertDisplay = subcategorypage.getSucessMessage().contains(sucesstext);
		Assert.assertTrue(successAlertDisplay, "Sub Category Created was not created succesfully");

	}

}
