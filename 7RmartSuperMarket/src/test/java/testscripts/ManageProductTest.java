package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageProductPage;
import utilities.ExcelUtility;

public class ManageProductTest extends Base {
	@Test(groups = {
			"Regression" }, retryAnalyzer = retry.Retry.class, description = "This test case is to verify if a product can be searched")
	public void verifyIfProductCanBeSearched() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String title = ExcelUtility.getString(1, 0, "ManageProductPage");
		String url = ExcelUtility.getString(1, 1, "ManageProductPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSignIn();
		loginpage.naviagteToAPage(url);
		ManageProductPage managepage = new ManageProductPage(driver);
		managepage.clickingSearchIconToLoadSearchPage().enteringTextToBeSearched(title)
				.clickingSearchButtonToExecuteSearch();
		boolean isSearchResultDisplayed = managepage.isSearchResultDisplayed();
		Assert.assertTrue(isSearchResultDisplayed, "Search result is not displayed.");
	}
}
